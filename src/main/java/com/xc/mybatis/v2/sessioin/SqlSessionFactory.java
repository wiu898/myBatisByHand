package com.xc.mybatis.v2.sessioin;

/**
 * 会话工厂类,用于解析配置文件,产生SqlSession
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:37
 */
public class SqlSessionFactory {

    private Configuration configuration;

    /*
     * build方法用于初始化Configuration,解析配置文件的工作在Configuration的构造函数中
     */
    public SqlSessionFactory build(){
        //configuration的构造函数触发配置文件解析
       configuration = new Configuration();
       return this;
    }

    public DefaultSqlSession openSqlSession(){
        return new DefaultSqlSession(configuration);
    }

}
