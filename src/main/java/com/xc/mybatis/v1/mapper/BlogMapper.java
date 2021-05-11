package com.xc.mybatis.v1.mapper;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-03-01 11:46
 */
public interface BlogMapper {

    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

}
