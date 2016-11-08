package dao;

import java.util.List;

import beans.Coupon;

public interface CouponDAO {
	public void createCompany(Coupon coupon);
	public void deleteCompany(Coupon coupon);
	public void updateCompany(Coupon coupon);
	public Coupon getCompany(long id);
	public List<Coupon> getAllCoupon();
	public List<Coupon> getCouponByType(String CouponType);

}
