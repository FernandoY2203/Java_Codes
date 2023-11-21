
package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        //--------------------------------------------------------------------//
        
        System.out.println("------------- Test 1: Department insert -------------");
        
        Department dep = new Department(null, "Technology");
        
        departmentDao.insert(dep);
        System.out.println("Inserted!! New Id = " + dep.getId());
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 2: Department findById -------------");
        
        Department department = departmentDao.findById(4);
        System.out.println("Department: \n" + department);
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 3: Department findAll -------------");
        
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 4: Department deleteById -------------");
        
        System.out.print("Enter the Id for delete test: ");
        int id = sc.nextInt();
        
        departmentDao.deleteById(id);
        System.out.println("Delete Successful!!");
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 5: Department update -------------");
        
        department = departmentDao.findById(1);
        department.setName("Marketing");
        
        departmentDao.update(department);
        System.out.println("Update Successful!!");
        
        
        sc.close();
    }
}
