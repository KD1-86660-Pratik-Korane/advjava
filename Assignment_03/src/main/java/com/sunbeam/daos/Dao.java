package com.sunbeam.daos;

import java.sql.Connection;

import com.sunbeam.utils.Dbutil;

public abstract class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = Dbutil.getConnection();
	}
	public void close() throws Exception {
		con.close();
	}
}
