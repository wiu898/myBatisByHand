package com.xc.mybatis.v2.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 包装类,对被代理对象进行包装
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 22:01
 */
public class Invocation {

    private Object target;
    private Method method;
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return method.invoke(target,args);
    }

}


