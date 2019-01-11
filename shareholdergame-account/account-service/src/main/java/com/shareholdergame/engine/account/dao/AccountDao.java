package com.shareholdergame.engine.account.dao;

import javax.inject.Singleton;

import com.shareholdergame.engine.account.dao.mapper.AccountMapper;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Singleton
public class AccountDao implements AccountMapper {

    private final SqlSessionFactory sqlSessionFactory;

    public AccountDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public AccountWithPassword findByUserNameOrEmail(String userNameOrEmail) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.getMapper(AccountMapper.class).findByUserNameOrEmail(userNameOrEmail);
        }
    }

    @Override
    public Long checkUserExistence(String userNameOrEmail) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.getMapper(AccountMapper.class).checkUserExistence(userNameOrEmail);
        }
    }

    public void insertAccount(AccountWithPassword accountWithPassword) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.getMapper(AccountMapper.class).insertAccount(accountWithPassword);
        }
    }
}
