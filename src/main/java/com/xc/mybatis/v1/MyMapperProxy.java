package com.xc.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-03-01 12:20
 */
public class MyMapperProxy implements InvocationHandler {

    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /*
     * 通过statementId拿到sql语句，并通过执行器执行
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //此处需要拿到statementId,所以需要通过接口名称以及方法名称拼接获取
        //通过反射拿到接口名称
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return sqlSession.selectOne(statementId ,args[0]);
    }
}
