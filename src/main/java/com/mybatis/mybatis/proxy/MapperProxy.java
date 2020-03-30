package com.mybatis.mybatis.proxy;


import com.mybatis.mybatis.cfg.Mapper;
import com.mybatis.mybatis.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * 增强Mapper，生成代理对象
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;

    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名和权限名，根据方法名得到Mapper对象
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        Mapper mapper = mappers.get(className + "." + methodName);
        return new Executor().selectList(mapper, connection);
    }
}
