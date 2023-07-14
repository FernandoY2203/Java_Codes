
package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
          
        //--------------------------------------------------------------------//
        
        System.out.println("------------- Test 1: Seller findById -------------");
        
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 2: Seller findByDepartment -------------");
        
        Department dep = new Department(2, null);
        
        List<Seller> list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 3: Seller findAll -------------");
        
        list = sellerDao.findAll();
        list.forEach(System.out::println);
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 4: Seller insert -------------");
        
        Seller sel = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, dep);
        
        sellerDao.insert(sel);
        System.out.println("Inserted!! New Id = " + sel.getId());
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 5: Seller update -------------");
        
        seller = sellerDao.findById(1);
        seller.setName("Laura");
        
        sellerDao.update(seller);
        System.out.println("Update Successful!!");
        
        
        System.out.println("\n");
        
        
        System.out.println("------------- Test 6: Seller deleteById -------------");
        
        System.out.print("Enter the Id for delete test: ");
        int id = sc.nextInt();
        
        sellerDao.deleteById(id);
        System.out.println("Delete Successful!!");
        
        
        sc.close();
    }
}
