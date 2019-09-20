/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import entity.Teacher;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jojus1101
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Facade facade = Facade.getFacadeInstance(emf);
       
        //1
        System.out.println("Number of Students: " +facade.getAllStudents().size());
        
        System.out.println("Students With firstname Anders: " +facade.getStudentsByFirstName("Anders").size());
        
        //3
        Student studentNew = facade.addStudent("Kurt", "Wonnegut");
        System.out.println("New Student with id : "+ studentNew.getId());
        
        //4
        facade.assignStudentToSemester(studentNew.getId(),1l);
        
        //7
        System.out.println("Number of Students: " +facade.studentCount());
        
        //8
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLcos-v14e"));
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLdat-a14e"));
        System.out.println("Students on semester CLcos-v14e " +facade.studentCountForSemester("CLcos-v14e"));
        
        //9
        System.out.println("Students assigned to all semesters: "+facade.studentCountAllSemesters());
        
    }

}
