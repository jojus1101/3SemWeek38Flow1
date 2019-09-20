/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jojus1101
 */
public class Facade {
    
    private static Facade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private Facade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static Facade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer createCustomer(String name, String email){
       
            Customer customer = new Customer(name, email);
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(customer);
                em.getTransaction().commit();
                return customer;
            } finally {
                em.close();
            }
    }

    public Customer findCustomer(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers(){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<Customer> customers = em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
            em.getTransaction().commit();
            return customers;
        } finally {
            em.close();
        }
    }

    public ItemType createItemType(String name, String description, int price){
        
            ItemType item = new ItemType(name, description, price);
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(item);
                em.getTransaction().commit();
                return item;
            } finally {
                em.close();
            }
    }

    public Customer addOrderToCustomer(Customer customer, Order order){
        
            customer.addOrder(order);
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(customer);
                em.getTransaction().commit();
                return customer;
            } finally {
                em.close();
            }
    }

    public Order CreateOrderLineToOrder(OrderLine orderLine, Order order){
            order.addOrder(orderLine);
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(order);
                em.getTransaction().commit();
                return order;
            
            } finally {
                em.close();
            }
        }
  
    public ItemType findItemType(long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ItemType item = em.find(ItemType.class, id);
            em.getTransaction().commit();
            return item;
        } finally {
            em.close();
        }
    }

}

