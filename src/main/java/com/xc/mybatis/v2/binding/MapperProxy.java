package com.xc.mybatis.v2.binding;

import com.xc.mybatis.v2.sessioin.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MapperProxy代理类,用于代理Mapper接口
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:32
 */
public class MapperProxy implements InvocationHandler {

    private DefaultSqlSession sqlSession;
    private Class object;

    public MapperProxy(DefaultSqlSession sqlSession, Class object) {
        this.sqlSession = sqlSession;
        this.object = object;
    }

    /*
     * 所有Mapper接口的方法调用都会走到这里
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        //如果根据接口类型+方法名称能找到映射的SQL,则执行SQL
        if(sqlSession.getConfiguration().hasStatement(statementId)){
            return sqlSession.selectOne(statementId,args,object);
        }
        //否则直接执行被代理对象的原方法
        return method.invoke(proxy,args);
    }
}
