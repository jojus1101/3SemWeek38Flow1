/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Customer2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jojus1101
 */
public class Tester {
    public static void main(String[] args) {
        Customer2 cust = new Customer2("Hans Hansen");
        cust.addHobbie("Fodbold");
        cust.addHobbie("Tennis");
        cust.addHobbie("PingPong");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        //Prints customer out with hobbies
//        em = emf.createEntityManager();
//        Customer2 found = em.find(Customer2.class, cust.getId());
//        System.out.println("Hobbies --> " + found.getHobbies());
    }
}
