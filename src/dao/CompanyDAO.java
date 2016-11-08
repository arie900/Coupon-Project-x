package dao;

import java.util.List;

import beans.Company;
import beans.Coupon;

public interface CompanyDAO {
	public void createCompany(Company company);
	public void deleteCompany(Company company);
	public void updateCompany(Company company);
	public Company getCompany(long id);
	public List<Company> getAllCompanies();
	public List<Coupon> getCoupon();
	public boolean login(String compName,String password);
	
	
}
