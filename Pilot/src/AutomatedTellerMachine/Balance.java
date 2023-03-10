package AutomatedTellerMachine;

public class Balance {

	private int id;
	private int amount;
	
	public Balance(int id,int amount) {
		this.id = id;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Current balance [id = " + id + ", amount = " + amount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
