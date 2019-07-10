package com.shareholdergame.engine.common.sql;

import org.apache.ibatis.session.SqlSessionManager;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDao<M> {

    private final SqlSessionManager sqlSessionManager;

    protected BaseDao(SqlSessionManager sqlSessionManager) {
        this.sqlSessionManager = sqlSessionManager;
    }

    protected M getMapper() {
        return sqlSessionManager.getMapper(getMapperClass());
    }

    private Class<M> getMapperClass() {
        return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
