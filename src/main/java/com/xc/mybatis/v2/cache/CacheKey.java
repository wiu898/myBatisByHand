package com.xc.mybatis.v2.cache;

/**
 * 缓存的Key
 *
 * @author lichao chao.li07@hand-china.com 2021-03-03 14:50
 */
public class CacheKey {

    //不大不小的质数,减少hash碰撞
    private static final int DEFAULT_HASHCODE = 17; // 默认哈希值
    private static final int DEFAULT_MULTIPLIER = 37; // 倍数

    private int hashCode;
    private int count;
    private int multiplier;

    public CacheKey() {
        this.hashCode = DEFAULT_HASHCODE;
        this.count = 0;
        this.multiplier = DEFAULT_MULTIPLIER;
    }

    /*
     * 返回CacheKey的值
     */
    public int getCode(){
        return hashCode;
    }

    /*
     * 计算CacheKey中的HashCode
     */
    public void update(Object object){
        int baseHashCode = object == null ? 1 : object.hashCode();
        count ++;
        baseHashCode *= count;
        hashCode = multiplier * hashCode + baseHashCode;
    }

}
