package com.xc.mybatis.v2.plugin;

import com.xc.mybatis.v2.annotation.Intercepts;
import com.xc.mybatis.v2.interceptor.Interceptor;
import com.xc.mybatis.v2.interceptor.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类,用于代理被拦截的对象
 * 同时拱了创建代理类的方法
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 22:23
 */
public class Plugin implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    /*
     * 对被代理对象进行代理,返回代理类
     */
    public static Object wrap(Object obj, Interceptor interceptor){
        Class clazz = obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                new Plugin(obj,interceptor));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //自定义的插件上有@Intercepts注解,指定了拦截的方法
        if(interceptor.getClass().isAnnotationPresent(Intercepts.class)){
            //如果是被拦截的方法,则仅需自定义拦截器的逻辑
            if(method.getName().equals(interceptor.getClass().getAnnotation(Intercepts.class).value())){
                return interceptor.intercept(new Invocation(target,method,args));
            }
        }
        //没有被拦截的方法,执行原有逻辑
        return method.invoke(target,method,args);
    }
}
