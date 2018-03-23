package com.hexaware.jdbidemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.jdbidemo.PersonDAO;
import com.hexaware.jdbidemo.Person;
import mockit.Verifications;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Tested;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;



@RunWith(JMockit.class)
public class DemoTest {

	@Tested	 
	private Person person = new Person(12, "Pradeep", 32);

	@Test
	public void testInsertMethod(@Mocked final PersonDAO dao){
		new Expectations(){
			{
				dao.save(person); times=1;
			}
		};
		
		new MockUp<Person>(){
		  @Mock
		  PersonDAO dao(){
		  	return dao;
		  }
		};

		Person.insertIntoPersonTable(person);

		new Verifications(){{
			dao.save(person);	times = 1;
		}};

	}

}