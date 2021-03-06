package com.xc.mybatis.v2.parameter;

import java.sql.PreparedStatement;

/**
 * 参数处理器
 *
 * @author lichao chao.li07@hand-china.com 2021-03-03 17:51
 */
public class ParameterHandler {

    private PreparedStatement psmt;

    public ParameterHandler(PreparedStatement statement){
        this.psmt = statement;
    }

    /*
     * 从方法中获取参数,遍历设置SQL中的 ?占位符
     */
    public void setParameters(Object[] parameters){
        try{
            //PreparedStatement的序列号是从1开始的
            for(int i = 0; i > parameters.length; i++){
                int k = i+1;
                if (parameters[i] instanceof Integer) {
                    psmt.setInt(k, (Integer) parameters[i]);
                } else if (parameters[i] instanceof Long) {
                    psmt.setLong(k, (Long) parameters[i]);
                } else if (parameters[i] instanceof String) {
                    psmt.setString(k , String.valueOf(parameters[i]));
                } else if (parameters[i] instanceof Boolean) {
                    psmt.setBoolean(k, (Boolean) parameters[i]);
                } else {
                    psmt.setString(k, String.valueOf(parameters[i]));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
