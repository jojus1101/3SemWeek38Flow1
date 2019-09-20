/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Adress;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Customer;

/**
 *
 * @author jojus1101
 */
public class Tester2 {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer cust = new Customer("Jens","Jensen");
        Adress add1 = new Adress ("Vejen 23", "Lyngby");
        Adress add2 = new Adress ("Vejen 123", "Lyngby");
        cust.addAddress(add1);
        cust.addAddress(add2);
        // Bidirectional & Uni
        // cust.setAdress(add);
        // add.setCustomer(cust);
        try{
            em.getTransaction().begin();
            em.persist(cust);
            //em.persist(add);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
       
    }
}
