package com.xc.mybatis.v1;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-03-01 11:52
 */
public class MySqlSession {

    MyConfiguration configuration;

    MyExecutor executor;

    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /*
     * 拿到需要执行的sql并调用执行器执行
     */
    public <T> T selectOne(String statementId, Object param){
        //根据statementId获取到需要执行的sql语句,sql语句维护在配置文件中，此处为了方便直接使用properties
        String sql = MyConfiguration.sqlMappings.getString(statementId);
        return executor.query(sql,param);
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this );

    }

}
