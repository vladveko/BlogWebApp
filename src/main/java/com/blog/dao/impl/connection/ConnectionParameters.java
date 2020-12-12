package com.blog.dao.impl.connection;

public final class ConnectionParameters {
    private ConnectionParameters() {}

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "db_url";
    public static final String DB_USER = "db_login";
    public static final String DB_PASSWORD = "db_password";
    public static final String DB_POOL_SIZE = "10";
}
