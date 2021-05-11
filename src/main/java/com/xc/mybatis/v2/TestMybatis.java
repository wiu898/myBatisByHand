package com.xc.mybatis.v2;

import com.xc.mybatis.v2.mapper.Blog;
import com.xc.mybatis.v2.mapper.BlogMapper;
import com.xc.mybatis.v2.sessioin.DefaultSqlSession;
import com.xc.mybatis.v2.sessioin.SqlSessionFactory;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-03-02 21:18
 */
public class TestMybatis {

    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactory();
        DefaultSqlSession sqlSession = factory.build().openSqlSession();
        //获取MapperProxy代理
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlogById(1);

        System.out.println("第一次查询: " + blog);
        System.out.println();
        blog = mapper.selectBlogById(1);
        System.out.println("第二次查询: " + blog);

    }

}
