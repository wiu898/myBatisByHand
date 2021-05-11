package com.xc.mybatis.v2.interceptor;

import com.xc.mybatis.v2.annotation.Intercepts;
import com.xc.mybatis.v2.plugin.Plugin;

import java.util.Arrays;

/**
 * 自定义插件
 *
 * @author lichao chao.li07@hand-china.com 2021-03-03 22:07
 */
@Intercepts("query")
public class MyPlugin implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String statement = (String)invocation.getArgs()[0];
        Object[] parameter = (Object[]) invocation.getArgs()[1];
        Class pojo = (Class) invocation.getArgs()[2];
        System.out.println("进入自定义插件:MyPlugin");
        System.out.println("SQL: [" + statement +"]");
        System.out.println("Parameters: " + Arrays.toString(parameter));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
