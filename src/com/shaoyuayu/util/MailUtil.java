package com.shaoyuayu.util;

import com.root.util.Log4jTest;
import com.shaoyuayu.entity.Token;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    /**
     * 校验邮箱是不是合法的
     * @param email
     * @return
     */
    public boolean verifyMail(String email){
            // 验证邮箱的正则表达式
            String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
            if (email.matches(regex))
            {
                return true;// 邮箱名合法，返回true
            }
            else
            {
                return false;// 邮箱名不合法，返回false
            }
    }

    /**
     * 通过key的值，取出不同的验证码模板
     * @param key
     * @return
     */
    public String getMailNoteTemplate(int key){
        //注册模板
        String registerTemplate = "尊敬的用户您好：\n\t欢迎你在高考小数据中心【"+DateUtil.getTime()+"】中使用【%s】的电子邮箱注册账号，验证码为【%s】,请不要透露你的验证码，有效时间90s";
        String loginTemplate = "尊敬的用户您好：\n\t你在高考小数据中心【"+DateUtil.getTime()+"】中登录账号【%s】，验证码为【%s】,请不要透露你的验证码，有效时间90s";
        String foulTemplate = "尊敬的用户您好：\n\t你在高考小数据中心的账号为【%s】存在违规操作达到上限，希望你正常使用";
        String maintainTemplate = "尊敬的用户您好：\n\t感谢你这段时间对我们的支持，本服务器正在开始系统的升级和维护，时间从【%s】到【%s】";
        if (key == 0){
            return registerTemplate;
        }else if (key == 1){
            return loginTemplate;
        }else if (key == 2){
            return foulTemplate;
        }else if (key == 3){
            return maintainTemplate;
        }else {
            return null;
        }
    }

    /**
     * 发送验证码
     * @param mail
     * @return
     */
    public String sendToken(String mail, String content, Token token){
//        logger.info("["+mail+"]发送验证码["+content+"]");
        new Thread("发送任务"){
            @Override
            public void run() {
                try {
                    Properties properties = new Properties();
                    properties.put("mail.transport.protocol", "smtp");
                    properties.put("mail.smtp.host", "smtp.qq.com");
                    properties.put("mail.smtp.port", 465);
                    properties.put("mail.smtp.auth", "true");
                    properties.put("mail.smtp.ssl.enable", "true");
                    properties.put("mail.debug", "true");
                    Session session = Session.getInstance(properties);
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("shaoyayu0419@qq.com"));
                    message.setRecipients( MimeMessage.RecipientType.TO, new InternetAddress[] {
                            new InternetAddress(mail)
                    });
                    message.setSubject("邵涯语--高考小数据");
                    message.setText(content);
                    Transport transport = session.getTransport();
                    transport.connect("shaoyayu0419@qq.com", "rzmsuvmbxtgibaea");
                    transport.sendMessage(message, message.getAllRecipients());
                    logger.info("["+mail+"]发送验证码[成功]");
                }catch (Exception e){
                    logger.info("["+mail+"]发送验证码[失败]");
                }
            }
        }.start();
        return "发送成功";
    }

    /**
     * 获取验证码
     * @return
     */
    public String getToken(){
        String token = String.valueOf(System.currentTimeMillis());
        token = token.substring(token.length()-6,token.length());
        System.out.println(token);
        return token;
    }

    @Test
    public void test() {
        sendToken("2416746596@qq.com","测试数据",null);
    }
}
