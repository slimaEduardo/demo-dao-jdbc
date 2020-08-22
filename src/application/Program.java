package application;


import java.util.Date;
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
		
		System.out.println("=== TESTE 1: seller finById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("=== TESTE 2: seller finByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);		
		
		for(Seller obj : list) {
		System.out.println(obj);
		}
		
		System.out.println("=== TESTE 3: seller finByAll ===");
		
		List<Seller> list2 = sellerDao.findAll();		
		
		for(Seller obj : list2) {
		System.out.println(obj);
		}
		
		System.out.println("=== TESTE 4: seller Seller insert ===");
		Seller newSeller = new Seller(null,"Greg Magenta", "greg@gmail.com",new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted1 New Id = " + newSeller.getId());
		
		System.out.println("=== TESTE 5: seller Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Yellow");
		sellerDao.update(seller);
		System.out.println("Update Completed!!!");
		
		System.out.println("=== TESTE 6: seller Seller Update ===");
		System.out.print("Enter id for delete:");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Success!!");
		
		sc.close();
   }
}
