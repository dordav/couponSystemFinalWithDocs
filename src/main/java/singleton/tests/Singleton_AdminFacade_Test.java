 package singleton.tests;

import beans.ClientType;
import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.AdminFacade;
import singleton.CouponSystem;
/**
 * 
 * this is the test for the admin facade to see that everything 
 * is working good. 
 *
 */
public class Singleton_AdminFacade_Test {

	public static void main(String[] args) {
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().Login("admin", "1234", ClientType.admin);
		int random=(int)(Math.random()*1001);
		try {
			// customer actions by admin facade;
			//********************************************************************
//			Customer customer = new Customer("tomer"+random, "1234");
			Customer customer = new Customer("test", "test");
			adminFacade.creatCustomer(customer);
			System.out.println("new customer created:  "+adminFacade.getCustomer(customer.getId()));
//			customer.setName("tomtom");
//			// to show that you can't update the name ;
//			customer.setPassword("4343");
//			adminFacade.updateCustomer(customer);
//			System.out.println("the name didn't udated because it not sepoused to:  "+adminFacade.getCustomer(customer.getId()));
//			adminFacade.removeCustomer(customer);
//			System.out.println("all customers is empty because the customer removed: "+adminFacade.getAllCustomers());
//
//			// company actions by admin facade;
//			//********************************************************************
//			Company company = new Company("a company"+random, "1234", "company@gmail.com");
//			adminFacade.createCompany(company);
//			System.out.println(adminFacade.getCompany(company.getId()));
//			company.setEmail("newUdatedMail@allNew.com");
//			company.setPassword("newPassword");
//			company.setName("wilNotChange");
//			// to show that like in customer , company name cannot be change;
//			adminFacade.updateCompany(company);
//			System.out.println("updated company"+adminFacade.getCompany(company.getId()));
//			System.out.println("all companies"+adminFacade.getAllCompanies());
//			adminFacade.removeCompany(company);
//			CouponSystem.getInstance().shutDown();
			
			
			System.out.println(adminFacade.getAllCustomers());
			System.out.println(adminFacade.getAllCompanies());
			
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}
	}
}
