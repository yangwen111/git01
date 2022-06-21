package com.example.srv.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author
 * @DATE 2022/6/21 -10:16
 */
@Configuration
@MapperScan(basePackages = "com.example.srv.dao",sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    private final static String XMLPATH="classpath*:mapper/*.xml";
    private final static String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private final static String USERNAME="root";
    private final static String PASSWORD="123456";
    private final static String DRIVER="com.mysql.cj.jdbc.Driver";

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
//      mybatis内置数据源
        PooledDataSource dataSource=new PooledDataSource();
        dataSource.setUrl(URL);
        dataSource.setDriver(DRIVER);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(XMLPATH));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager getTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 该方法用来细化事物，调用其excute方法包裹需要执行的方法
     * @param manager
     * @return
     */
    @Bean(name="transactionTemplate")
    @Primary
    public TransactionTemplate getTransactionTemplate(@Qualifier("transactionManager") DataSourceTransactionManager manager){
        return new TransactionTemplate(manager);
    }
}
