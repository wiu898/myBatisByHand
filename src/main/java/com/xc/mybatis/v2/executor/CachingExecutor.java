package com.xc.mybatis.v2.executor;

import com.xc.mybatis.v2.cache.CacheKey;

import java.util.HashMap;
import java.util.Map;

/**
 * 带缓存的执行器,用于装饰基本执行器
 *
 * @author lichao chao.li07@hand-china.com 2021-03-03 11:26
 */
public class CachingExecutor implements Executor{

    private Executor deletate;
    private static final Map<Integer, Object> cache = new HashMap<>();

    public CachingExecutor(Executor deletate){
        this.deletate = deletate;
    }

    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        //计算CacheKey
        CacheKey cacheKey = new CacheKey();
        cacheKey.update(statement);
        cacheKey.update(joinStr(parameter));
        //判断是否存在缓存
        if(cache.containsKey(cacheKey.getCode())){
            //命中缓存
            System.out.println("[命中缓存]");
            return (T)cache.get(cacheKey.getCode());
        }else{
            //没有的话调用被装饰的SimpleExecutor从数据库中查询
            Object obj = deletate.query(statement,parameter,pojo);
            //查询结果存入缓存
            cache.put(cacheKey.getCode(),obj);
            return (T)obj;
        }
    }


    //为了命中缓存,把Object[]转换成逗号拼接的字符串,因为对象的HashCode都不一样
    public String joinStr(Object[] objs){
        StringBuffer sb = new StringBuffer();
        if(objs !=null && objs.length > 0){
            for(Object objStr : objs){
                sb.append(objStr.toString() + ",");
            }
        }
        int len = sb.length();
        if(len > 0){
            sb.deleteCharAt(len - 1);
        }
        return sb.toString();
    }

}
