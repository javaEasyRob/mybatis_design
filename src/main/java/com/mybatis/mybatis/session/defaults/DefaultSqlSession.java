package com.mybatis.mybatis.session.defaults;

import com.mybatis.mybatis.cfg.SqlMapper;
import com.mybatis.mybatis.proxy.MapperProxy;
import com.mybatis.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Map;

/**
 * 获取Mapper代理对象执行查询
 */
public class DefaultSqlSession implements SqlSession {


   private Map<String, SqlMapper> sqlMappers;

    private Connection connection;

    public DefaultSqlSession(Map<String, SqlMapper> mappers, Connection connection) {
        this.sqlMappers = mappers;
        this.connection = connection;
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(),
                new Class[]{mapperClass},
                new MapperProxy(sqlMappers, connection));
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
