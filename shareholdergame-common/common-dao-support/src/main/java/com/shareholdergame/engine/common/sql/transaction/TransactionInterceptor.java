package com.shareholdergame.engine.common.sql.transaction;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TransactionInterceptor implements MethodInterceptor<Object, Object> {

    @Inject
    private SqlSessionManager sqlSessionManager;

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        try {
            sqlSessionManager.startManagedSession();
            Object result = context.proceed();
            sqlSessionManager.commit();
            return result;
        } catch (RuntimeException e) {
            sqlSessionManager.rollback();
            throw e;
        } finally {
            sqlSessionManager.close();
        }
    }
}
