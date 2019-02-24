package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.common.exception.ApplicationException;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;

@Factory
public class SessionFactory {

    private DataSource dataSource;

    public SessionFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*@Context
    public SqlSessionFactory sessionFactory() {
        try {
            String resource = "mybatis-config.xml";

            Reader configReader = Resources.getResourceAsReader(resource);

            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment.Builder("default")
                    .dataSource(dataSource)
                    .transactionFactory(transactionFactory)
                    .build();

            XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(configReader);

            Configuration configuration = xmlConfigBuilder.parse();
            configuration.setEnvironment(environment);

            return new SqlSessionFactoryBuilder().build(configuration);
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }*/

    @Context
    public SqlSessionManager sessionManager() {
        try {
            String resource = "mybatis-config.xml";

            Reader configReader = Resources.getResourceAsReader(resource);

            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment.Builder("default")
                    .dataSource(dataSource)
                    .transactionFactory(transactionFactory)
                    .build();

            XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(configReader);

            Configuration configuration = xmlConfigBuilder.parse();
            configuration.setEnvironment(environment);

            return SqlSessionManager.newInstance(new SqlSessionFactoryBuilder().build(configuration));
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}
