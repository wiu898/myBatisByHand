package com.xc.mybatis.v1;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 用户获取代理对象 getMapper
 *
 * @author lichao chao.li07@hand-china.com 2021-03-01 11:54
 */
public class MyConfiguration {

    public static final ResourceBundle sqlMappings;

    //通过静态代码块解析配置文件
    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }

    /*
     * getMapper方法拿到了一个代理对象，代理对象会执行invoke方法触发查询操作
     */
    public <T> T getMapper(Class clazz, MySqlSession sqlSession) {

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MyMapperProxy(sqlSession)
        );
    }


}
