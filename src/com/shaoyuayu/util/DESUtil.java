package com.shaoyuayu.util;/**
 * Created by admin on 2019/3/22.
 */



import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName DES
 * @Description TODO
 * @Author admin
 * @Date 2019/3/22 12:47
 * @Version 1.0
 **/
public class DESUtil {

    public static void main(String[] aegs) throws Exception {
        /**
         * 准备明文和token
         * token是一个64位，8个字节、
         */
        String ckearText = "shaoyayu@qq.com";
        String token = "1234567834";
        String cipherText = DESEncript(ckearText,token);
        System.err.println(cipherText);
        String cipherText2 = DESDecript("vhvOnObP0P4iwv8gLQDelw==",token);
        System.err.println(cipherText2);
    }

	/**
	 * 解密模块
	 * @param cipherText
	 * @param token
	 * @return
	 */
    public static String DESDecript(String cipherText, String token){
        Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Key key = getKey(token);
        try {
			cipher.init(Cipher.DECRYPT_MODE,key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] decode = Base64.decode(cipherText);
        byte[] doFinal = null;
        if (decode==null) {
			System.err.println("decode为空");
		}
		try {
			doFinal = cipher.doFinal(decode);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new String(doFinal);
    }

    /**
     *
     * @param ckearText
     * @param token
     * @return
     * @throws NoSuchPaddingException   填充异常（工作模式和填充模式)
     * @throws NoSuchAlgorithmException 没有此算法的异常
     * @throws InvalidKeyException      无效的秘钥异常
     * @throws BadPaddingException 不良的数据块填充异常
     * @throws IllegalBlockSizeException
     */
    public static String DESEncript(String ckearText, String token){
        //获得加密工具类
        Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //对工具初始化    (加密/解密,key)
        SecretKeySpec key = getKey(token);
        try {
			cipher.init(Cipher.ENCRYPT_MODE,key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //用加密工具对明文加密
        byte[] doFinal = null;
		try {
			doFinal = cipher.doFinal(ckearText.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        return new String(doFinal);
       String encode = Base64.encode(doFinal);
        return encode;
    }

    /**
     * 解决秘钥大于八个字节的问题
     * @param token
     * @return
     */
    private static SecretKeySpec getKey(String token) {
        //byte元素的默认初始值为0
        byte[] buffer = new byte[8];
        byte[] tokens = token.getBytes();
        //如果token大于8个字节，只要8个字节 没有超过8个字节，默认初始值填充
        for (int i=0; i<token.length()&& i<8;i++){
            buffer[i] = tokens[i];
        }
        SecretKeySpec key = new SecretKeySpec(buffer,"DES");
        return key;
    }

}
