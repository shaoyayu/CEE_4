package com.root.util;

import org.apache.log4j.Logger;

public class Log4jTest {
    //获取日志实例
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        logger.info("普通的info测试");
        logger.debug("调试debug测试");
        logger.error("error报错信息");
        logger.warn("警告信息");
        logger.fatal("严重错误");
    }

}
