/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tr.gov.ptt.jparelationapp.entity.Department;
import tr.gov.ptt.jparelationapp.entity.Employee;


/**
 *
 * @author Administrator
 */
public class DeptEmp {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        
        Department dept1 =new Department();
        dept1.setId(BigDecimal.ONE);
        dept1.setName("Bilgi");
        
        Employee emp1 = new Employee();
        emp1.setEid(new BigDecimal(1));
        emp1.setEname("Steve");
        emp1.setSalary(new BigDecimal(3000));
        emp1.setDepartment(dept1);
        
        Employee emp2 = new Employee();
        emp2.setEid(new BigDecimal(2));
        emp2.setEname("Bill");
        emp2.setSalary(new BigDecimal(2000));
        emp2.setDepartment(dept1);
        
        List<Employee> empList = new ArrayList();
        
        empList.add(emp1);
        empList.add(emp2);
        
        
        dept1.setEmployeeList(empList);
        
        em.getTransaction().begin();
        
        em.persist(dept1);
        em.persist(emp1);
        em.persist(emp2);
          
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        
    }
    
}
