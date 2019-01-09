package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountMapper;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;

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
}
