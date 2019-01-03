package singleton.tests;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import beans.ClientType;
import beans.Company;
import beans.Coupon;
import beans.CouponType;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import singleton.CouponSystem;
/**
 * 
 * this is the test to the customer facade to see that everything is 
 * working good. 
 *
 */
public class Singleton_CustomerFacade_Test {

	public static void main(String[] args)  {
	//for the customer creation;
	AdminFacade adminFacade=(AdminFacade) CouponSystem.getInstance().Login("admin", "1234", ClientType.admin);
	//for the coupon creation;
	int rand = (int)(Math.random()*1001);
	//settings;
	Customer customer=new Customer("test customer", "1111");
	Customer customer2=new Customer("test customer2", "1111");
	Calendar endDate = new GregorianCalendar(2018, 10, 5);
	Calendar startDate = new GregorianCalendar(2018, 9, 5);
	Coupon coupon=new Coupon("free mcNugets"+rand, new Date(startDate.getTimeInMillis()), new Date(endDate.getTimeInMillis()), 3, CouponType.food, "its free", 15, "a good image");
	Coupon coupon2=new Coupon("free dog"+rand, new Date(startDate.getTimeInMillis()), new Date(endDate.getTimeInMillis()), 3, CouponType.food, "its free", 15, "a good image");
	Company company = new Company("test company", "testing123", "shtrudel@shetrudle.net");
	try {
//		
		adminFacade.creatCustomer(customer);
//		adminFacade.creatCustomer(customer2);
//		adminFacade.createCompany(company);
//		
		CompanyFacade companyFacade =(CompanyFacade) CouponSystem.getInstance().Login("test company", "testing123", ClientType.company);
//		companyFacade.createCoupon(coupon);
//		companyFacade.createCoupon(coupon2);
//		
		CustomerFacade customerFacade=(CustomerFacade) CouponSystem.getInstance().Login("test customer", "1111", ClientType.customer);
		CustomerFacade customerFacade2=(CustomerFacade) CouponSystem.getInstance().Login("test customer2", "1111", ClientType.customer);
// 		customerFacade.purchaseCoupon(coupon);
// 		customerFacade2.purchaseCoupon(coupon2);
// 		
// 		System.out.println("this is a chach that every customer coupons are saved separately"+customerFacade.getAllPurchesedCoupons());
// 		System.out.println("empty because the coupons price is above 12 "+customerFacade.getAllPurchesedCouponsByPrice(12));
// 		System.out.println(customerFacade.getAllPurchesedCouponsByPrice(16));
// 		System.out.println(customerFacade.getAllPurchesedCouponsByType(CouponType.food));
// 		System.out.println("removeing everything because its only a demosration");
// 		
// 		adminFacade.removeCompany(company.getId());
// 		adminFacade.removeCustomer(customer);
// 		adminFacade.removeCustomer(customer2);
// 		
	} catch (CouponSystemException e) {
		e.printStackTrace();
	}
	
	

}
}
