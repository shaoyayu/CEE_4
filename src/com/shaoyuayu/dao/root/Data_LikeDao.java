package com.shaoyuayu.dao.root;

import com.shaoyuayu.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * 给用户点赞添加数据
 */
public class Data_LikeDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public int addLike(String JSESSIONID,String user_id){
        String sql = "INSERT INTO data_like(JSESSIONID,user_id) VALUES(?,?);";
        int i = template.update(sql,JSESSIONID,user_id);
        return i;
    }

    public int queryMaxLIke(){
        String sql = "SELECT MAX(`like`) FROM data_like;";
        Map<String,Object> map = template.queryForMap(sql);
        return Integer.valueOf(map.get("MAX(`like`)").toString());
    }
}
