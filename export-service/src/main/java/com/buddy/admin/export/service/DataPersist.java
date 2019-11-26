package com.buddy.admin.export.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DataPersist {

	public static int BATCH_SIZE = 200;
	public static String SQL_INSERT = "";

	public static String create(List<ScrapData> list) throws ClassNotFoundException, SQLException {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement dataInsert = conn.prepareStatement(SQL_INSERT);
			conn.setAutoCommit(false); // default true
			int count = 0;
			for (ScrapData data : list) {

				dataInsert.setString(1, data.getState());
				dataInsert.setString(1, "");
				dataInsert.setString(1, "");
				dataInsert.addBatch();
				count++;

				if (count % BATCH_SIZE == 0) {
					int[] rows = dataInsert.executeBatch();
					System.out.println(Arrays.toString(rows));
				}
			}
			dataInsert.executeBatch();
			conn.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "";
	}
}
