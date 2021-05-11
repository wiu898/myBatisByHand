package com.xc.mybatis.v2.executor;

/**
 * SQL执行器
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:42
 */
public interface Executor {

    <T> T query(String satement, Object[] parameter, Class pojo);
}
