package com.xc.mybatis.v2.interceptor;

/**
 * 拦截器接口,所有自定义拦截器必须实现此接口
 * 定义了插件的接口规范
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:59
 */
public interface Interceptor {

    /*
     * 插件的核心逻辑实现
     */
    Object intercept(Invocation invocation) throws Throwable;

    /*
     * 对被拦截对象进行处理
     */
    Object plugin(Object target);

}
