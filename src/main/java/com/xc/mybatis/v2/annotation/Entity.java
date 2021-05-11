package com.xc.mybatis.v2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于注解接口以映射返回的实体类
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
    Class<?> value();
}
