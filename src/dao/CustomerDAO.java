package dao;

import java.util.List;

import beans.Customer;
import beans.Company;
import beans.Coupon;

public interface CustomerDAO {
	public void createCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Customer getCustomer(long id);
	public List<Company> getAllCustomer();
	public List<Coupon> getCoupon();
	public boolean login(String compName,String password);


}
