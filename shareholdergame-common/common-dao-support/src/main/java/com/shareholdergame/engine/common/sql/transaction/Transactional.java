package com.shareholdergame.engine.common.sql.transaction;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Around
@Type(TransactionInterceptor.class)
public @interface Transactional {
}
