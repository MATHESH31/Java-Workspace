package ThreadAndTransaction;

import java.time.LocalDate;


public class Customer {

	private String Name;
	private String Account_id;
	private String Account_type;
	private String Branch;
	private String Pan_id;
	private LocalDate DOB;
	private Long phone;
	private String Address;
	private int Balance;
	

	public Customer(String name, String account_id, String account_type, String branch, String pan_id, LocalDate dOB,
			Long phone, String address, int balance) {
		this.Name = name;
		this.Account_id = account_id;
		this.Account_type = account_type;
		this.Branch = branch;
		this.Pan_id = pan_id;
		this.DOB = dOB;
		this.phone = phone;
		this.Address = address;
		this.Balance = balance;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(String account_id) {
		Account_id = account_id;
	}

	public String getAccount_type() {
		return Account_type;
	}

	public void setAccount_type(String account_type) {
		Account_type = account_type;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getPan_id() {
		return Pan_id;
	}

	public void setPan_id(String pan_id) {
		Pan_id = pan_id;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}
	
	
}
