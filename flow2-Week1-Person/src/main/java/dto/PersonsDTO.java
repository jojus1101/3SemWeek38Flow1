/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jojus1101
 */
public class PersonsDTO {
    
    List<PersonDTO> all = new ArrayList();

    public PersonsDTO(List<Person> personEntities) {
        personEntities.forEach((p) -> {
            all.add(new PersonDTO(p));
        });
    }

    public PersonsDTO() {}

    public List<PersonDTO> getPersonDTOs() {
        return all;
    }
//
//    public void setPersonDTOs(List<PersonDTO> personDTOs) {
//        this.all = personDTOs;
//    }
    
}
