package  com.hexaware.jdbidemo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface PersonDAO  {

  @SqlQuery("SELECT * FROM Person")
  @Mapper(PersonMapper.class)
  List<Person> list();

  @SqlQuery("SELECT * FROM PERSON WHERE ID = :personID")
  @Mapper(PersonMapper.class)
  Person find(@Bind("personID") int personID);

  @SqlUpdate("INSERT INTO PERSON (ID, NAME, AGE) VALUES (:id, :name,:age)")
  void save(@BindBean Person person);

  void close();
}