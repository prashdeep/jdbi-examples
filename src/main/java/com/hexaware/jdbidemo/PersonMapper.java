package com.hexaware.jdbidemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class PersonMapper implements ResultSetMapper<Person> {
  public final Person map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Person(rs.getInt("ID"), rs.getString("Name"),rs.getInt("AGE"));
  }
}