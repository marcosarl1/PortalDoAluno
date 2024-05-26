package com.portalaluno.util;

import javax.sql.DataSource;

public interface Provider {
    DataSource getDataSource();
}
