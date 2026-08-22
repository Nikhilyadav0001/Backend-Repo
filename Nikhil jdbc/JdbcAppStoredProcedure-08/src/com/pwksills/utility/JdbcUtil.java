package com.pwksills.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcUtil {
	private static Properties properties = null;

	private JdbcUtil() {
	}

	static {
		FileInputStream fis = null;

		String fileInfo = "D:\\pwskillsOctbatch\\JdbcAppStoredProcedure-08\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			if (fis != null) {
				properties = new Properties();
				properties.load(fis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Connection getMySQLDBConection() throws IOException, SQLException {
		// 1. Establishing the Connection
		return DriverManager.getConnection(properties.getProperty("mysql_url"), properties.getProperty("mysql_user"),
				properties.getProperty("mysql_password"));
	}
}
