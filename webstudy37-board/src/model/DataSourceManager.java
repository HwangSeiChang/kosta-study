package model;


import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	DataSource datasource;
	private DataSourceManager() {
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@192.168.0.152:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		dbcp.setInitialSize(1000);
		this.datasource = dbcp;
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return datasource;
	}
}
