package com.xc.mybatis.v2.executor;

import java.sql.Statement;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-03-03 15:03
 */
public class SimpleExecutor implements Executor{

    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(statement, parameter, pojo);
    }

}
