package com.mybatis.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库连接的配置信息
 */
public class Configuration {
    private String driver;

    private String url;

    private String password;

    private String username;

    private Map<String, SqlMapper> mappers = new HashMap<>();

    public Map<String, SqlMapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, SqlMapper> mappers) {
        this.mappers.putAll(mappers);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
