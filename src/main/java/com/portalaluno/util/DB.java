package com.portalaluno.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DB {

    private static final Provider PROVIDER = new DS();
    
    private DB(){}
    
    public static Connection getConnection() throws SQLException {
        return PROVIDER.getDataSource().getConnection();
    }
}
