package com.xc.mybatis.v2.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器链,存放所有拦截器,对代理对象进行循环代理
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 22:14
 */
public class InterceptorChain {

    //存放所有拦截器集合
    private final List<Interceptor> interceptors = new ArrayList<>();

    public void addInterceptor(Interceptor interceptor){
        interceptors.add(interceptor);
    }

    /*
     * 对被拦截对象进行层层代理
     */
    public Object pluginAll(Object target){
        for (Interceptor interceptor : interceptors){
            target = interceptor.plugin(target);
        }
        return target;
    }

    /*
     * 判断是否有插件存在
     */
    public boolean hasPlugin(){
        if(interceptors.size() == 0){
            return false;
        }
        return true;
    }

}
