package com.hazelcast.springHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Esref Ozturk <esrefozturk93@gmail.com> on 17.07.2014.
 */

public class InitializeDB {
	public static void start() {
		try {
			Class.forName("org.h2.Driver").newInstance();
		} catch (final Exception e) {
			System.out.println(e);
		}
		try {
			final Connection conn = DriverManager.getConnection(
					"jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE",
					new Properties());
			final Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE  CUSTOMER("
					+ "ID VARCHAR(255) PRIMARY KEY NOT NULL,"
					+ "NAME VARCHAR(255) NOT NULL,"
					+ "SURNAME VARCHAR(255) NOT NULL" + ")");
			st.executeUpdate("INSERT INTO CUSTOMER VALUES ('1', 'Name1', 'Surname1')");
			st.executeUpdate("INSERT INTO CUSTOMER VALUES ('2', 'Name2', 'Surname2')");
			st.executeUpdate("INSERT INTO CUSTOMER VALUES ('3', 'Name3', 'Surname3')");
			st.executeUpdate("INSERT INTO CUSTOMER VALUES ('4', 'Name4', 'Surname4')");
		} catch (final SQLException s) {
			System.out.println(s);
		}
	}
}