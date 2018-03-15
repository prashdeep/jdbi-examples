package com.hexaware.jdbidemo;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.logging.PrintStreamLog;

public class DBConnection {
   public final DBI getConnect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String dbc = "localhost:3306";
      DBI dbi = new DBI("jdbc:mysql://" + dbc + "/training?useSSL=false", "dbuser", "welcome");
      dbi.setSQLLog(new PrintStreamLog());
      return dbi;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
