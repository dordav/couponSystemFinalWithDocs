package singleton.tests;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import beans.ClientType;
import beans.Company;
import beans.Coupon;
import beans.CouponType;
import exceptions.CouponSystemException;
import facade.AdminFacade;
import facade.CompanyFacade;
import singleton.CouponSystem;
public class Singleton_CompanyFacade_Test {
/**
 * 
 * this is a test of the company facade to see that everything is working good . 
 */
	public static void main(String[] args) {
		//preparations;
	Calendar endDate = new GregorianCalendar(2019, 9, 9);
	Calendar startDate = new GregorianCalendar(2017, 7, 7);
	int rand=(int)(Math.random()*1001);
	Coupon coupon=new Coupon("beigale "+rand, new Date(startDate.getTimeInMillis()), new Date(endDate.getTimeInMillis()), 3, CouponType.food, "eat one", 15, " image");
	Company company = new Company("test company"+rand, "test", "test@testing.net");
	Company company2 = new Company("test", "test", "test@testing.net");
	AdminFacade adminFacade= (AdminFacade) CouponSystem.getInstance().Login("admin", "1234", ClientType.admin);
	try {
	adminFacade.createCompany(company);
		adminFacade.createCompany(company2);
	CompanyFacade companyFacade=(CompanyFacade) CouponSystem.getInstance().Login("test company"+rand, "test", ClientType.company);
//		companyFacade.createCoupon(coupon);
	companyFacade.getAllCoupons();	
//		System.out.println(companyFacade.getCompany(company.getId()));
//		System.out.println("empty because the date is wrong"+companyFacade.getCouponByEndDate(new Date(System.currentTimeMillis())));
//		System.out.println(companyFacade.getCouponByEndDate(new Date(endDate.getTimeInMillis())));
//		System.out.println("empty because the price is wrong"+companyFacade.getCouponByPrice(5));
//		System.out.println(companyFacade.getCouponByPrice(15));
//		System.out.println("empty because the type is wrong"+companyFacade.getCouponByType(CouponType.hobby));
//		System.out.println(companyFacade.getCouponByType(CouponType.food));
//		Coupon couponUpdated=companyFacade.getCoupon(coupon.getId());
//		Calendar updatEndDate = new GregorianCalendar(2019, 11, 11);
//		couponUpdated.setEnd_date(new Date(updatEndDate.getTimeInMillis()));
//		couponUpdated.setPrice(7);
//		companyFacade.updateCoupon(couponUpdated);
//		System.out.println(companyFacade.getCoupon(couponUpdated.getId()));
//		companyFacade.removeCoupon(couponUpdated);
//		System.out.println("empty because the coupon removed:   "+companyFacade.getCoupon(couponUpdated.getId()));
//		CouponSystem.getInstance().shutDown();
	} catch (CouponSystemException e) {
		e.printStackTrace();
	}
}




}
