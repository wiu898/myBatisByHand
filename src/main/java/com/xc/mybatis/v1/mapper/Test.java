package com.xc.mybatis.v1.mapper;

import com.xc.mybatis.v1.MyConfiguration;
import com.xc.mybatis.v1.MyExecutor;
import com.xc.mybatis.v1.MySqlSession;

/**
 * 测试类
 *
 * @author lichao chao.li07@hand-china.com 2021-03-01 11:50
 */
public class Test {

    public static void main(String[] args) {
        //对外开放调用的API
        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(),new MyExecutor() );
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        //此查询方法其实由代理类执行
        Blog blog = blogMapper.selectBlogById(1);
    }

}
