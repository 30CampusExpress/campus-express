package com.example.errand3.config;

import com.example.errand3.mapper.AdminMapper;
import com.example.errand3.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.errand3.mapper.OrderInfoMapper;
import com.example.errand3.entity.OrderInfo;

@Configuration
public class MyBatisConfig {

    @Bean
    public MapperFactoryBean<AdminMapper> adminMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<AdminMapper> factory = new MapperFactoryBean<>(AdminMapper.class);
        factory.setSqlSessionFactory(sqlSessionFactory);
        return factory;
    }

    @Bean
    public MapperFactoryBean<UserMapper> userMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<UserMapper> factory = new MapperFactoryBean<>(UserMapper.class);
        factory.setSqlSessionFactory(sqlSessionFactory);
        return factory;
    }
    @Bean
    public MapperFactoryBean<OrderInfoMapper> orderInfoMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<OrderInfoMapper> factoryBean = new MapperFactoryBean<>(OrderInfoMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }
}