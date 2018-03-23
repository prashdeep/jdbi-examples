package com.hexaware.jdbidemo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.jdbidemo.PersonDAO;
import com.hexaware.jdbidemo.Person;
import mockit.Verifications;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import mockit.Expectations;
import mockit.Tested;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class PersonTest{

    @Tested
    private Person person = new Person(1, "Vinay", 32);

    @Test
    public void testPersonFindAll(@Mocked final PersonDAO dao){
      new Expectations(){
        {
         dao.list();
         result =  null;
        }
      };

      new MockUp<Person>(){
		  @Mock
		  PersonDAO dao(){
		  	return dao;
		  }
		};

     List<Person> listOfPerson = Person.listAllPerson();
     assertNull(listOfPerson);
     new Verifications(){
         {
             dao.list(); times = 1;
         }
     };
    }

    @Test
    public void testPersonFindAllWithResults(@Mocked final PersonDAO dao){
      new Expectations(){
        {
            List<Person> list = new ArrayList<Person>();
            list.add(new Person(23, "Kiran", 56));
            list.add(new Person(24, "Vinay", 43));
            list.add(new Person(25, "Hari", 32));
            list.add(new Person(26, "Krishna", 26));
            list.add(new Person(27, "Harish", 52));
         dao.list();
         result =  list;
        }
      };

      new MockUp<Person>(){
		  @Mock
		  PersonDAO dao(){
		  	return dao;
		  }
		};

     List<Person> listOfPerson = Person.listAllPerson();
     assertNotNull(listOfPerson);
     assertEquals(listOfPerson.size() , 5);
     assertTrue(listOfPerson.get(0).getId() == 23);
     new Verifications(){
         {
             dao.list(); times = 1;
         }
     };
    }   

    @Test
    public void testPersonFindInmvalidPerson(@Mocked final PersonDAO dao){
      new Expectations(){
        {
         dao.find(anyInt);
         result =  new Person(23, "Pradeep", 32);
        }
      };

      new MockUp<Person>(){
		  @Mock
		  PersonDAO dao(){
		  	return dao;
		  }
		};

     Person person = Person.findPersonById(23);
     assertNotNull(person);
     assertEquals(person.getId(), 23);
     assertEquals(person.getName(), "Pradeep");
     new Verifications(){
         {
             dao.find(23); times = 1;
         }
     };
    }         
}