package com.shaoyuayu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Statement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 初始化连接池
     */
    private static DataSource ds;
    static {
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭资源 statement和connection对象
     * @param stmt
     * @param connection
     */
    public static void close(Statement stmt, Connection connection){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源 ResultSet,Statement，Connection
     * @param rs
     * @param stmt
     * @param connection
     */
    public static void close(ResultSet rs, Statement stmt, Connection connection){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt,connection);
    }

    /**
     * 获取一个连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

}
