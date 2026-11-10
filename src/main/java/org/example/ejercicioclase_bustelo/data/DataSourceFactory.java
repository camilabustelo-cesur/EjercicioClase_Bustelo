package org.example.ejercicioclase_bustelo.data;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {
    private static String url = "jdbc:mysql://localhost:3311/ad";
    private static String username = System.getenv("USER");
    private static String password = System.getenv("PASSWORD");
    private static DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            if (username == null || password == null) {
                throw new RuntimeException("Username and/or password are not set");
            }
            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL(url);
            ds.setUser(username);
            ds.setPassword(password);
            dataSource=ds;
        }
        return dataSource;
    }
}
