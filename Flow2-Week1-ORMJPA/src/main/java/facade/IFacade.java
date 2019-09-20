/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import entities.ItemType;
import entities.Order;
import java.util.List;
/**
 *
 * @author jojus1101
 */
public interface IFacade {

    public Customer createCustomer(String name, String email);  
    public Customer findCustomer(Long id);
    public List<Customer> getAllCustomers();
    public ItemType createItemType(String name, String description, int price);
    public ItemType findItemType(long id);
    public Customer addOrderToCustomer(Customer customer, Order order);
}
