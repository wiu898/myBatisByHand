package com.xc.mybatis.v2.binding;

import com.xc.mybatis.v1.MyMapperProxy;
import com.xc.mybatis.v2.sessioin.DefaultSqlSession;

import java.lang.reflect.Proxy;

/**
 * 用于产生MapperProxy代理类
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 23:00
 */
public class MapperProxyFactory<T> {

    private Class<T> mapperInterface;
    private Class object;

    public MapperProxyFactory(Class<T> mapperInterface, Class object) {
        this.mapperInterface = mapperInterface;
        this.object = object;
    }

    public T newInstance(DefaultSqlSession sqlSession){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},
                new MapperProxy(sqlSession,object));
    }
}
