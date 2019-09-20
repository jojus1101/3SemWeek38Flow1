/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.ElementCollection;
/**
 *
 * @author jojus1101
 */
@Entity
public class Customer2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Customer2(String name) {
        this.name = name;
    }

    public Customer2() {
    }
    @ElementCollection
    private List<String> hobbies = new ArrayList();
    
    public void addHobbie(String hobby){
        hobbies.add(hobby);
    }
    
    public String getHobbies(){
        return String.join(",", hobbies);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
