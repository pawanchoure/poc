package com.pawan.choure.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0017J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lcom/pawan/choure/config/PersistenceConfig;", "", "()V", "dataSource", "Ljavax/sql/DataSource;", "sqlSessionFactory", "Lorg/apache/ibatis/session/SqlSessionFactory;", "Kotlin-Gradle-SpringBoot-Integration"})
@org.mybatis.spring.annotation.MapperScan(value = {"com.pawan.choure.mapper"})
@org.springframework.context.annotation.Configuration
public class PersistenceConfig {
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.context.annotation.Bean
    public javax.sql.DataSource dataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.context.annotation.Bean
    public org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory() throws java.lang.Exception {
        return null;
    }
    
    public PersistenceConfig() {
        super();
    }
}