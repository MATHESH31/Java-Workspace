package AutomatedTellerMachine;

public class Withdrawal {

	private int id;
	private int amount;
	
	public Withdrawal(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "[id = " + id + ", amount = " + amount + "]";
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
