package com.mybatis.mybatis.session.defaults;

import com.mybatis.mybatis.cfg.Mapper;
import com.mybatis.mybatis.proxy.MapperProxy;
import com.mybatis.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Map;

/**
 * 获取Mapper代理对象执行查询
 */
public class DefaultSqlSession implements SqlSession {


   private Map<String, Mapper> mappers;

    private Connection connection;

    public DefaultSqlSession(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(),
                new Class[]{mapperClass},
                new MapperProxy(mappers, connection));
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
