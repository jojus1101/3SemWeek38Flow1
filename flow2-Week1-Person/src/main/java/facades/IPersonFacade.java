/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.Person;
import exceptions.PersonNotFoundException;
import java.util.List;
/**
 *
 * @author jojus1101
 */


public interface IPersonFacade {
  public Person addPerson(String fName, String lName, String phone);  
  public Person deletePerson(long id) throws PersonNotFoundException;  
  public Person getPerson(long id) throws PersonNotFoundException;  
  public List<Person> getAllPersons();  
  public Person editPerson(Person p) throws PersonNotFoundException;  
}
