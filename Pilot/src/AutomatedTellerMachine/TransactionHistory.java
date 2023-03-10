package AutomatedTellerMachine;

public class TransactionHistory {

	private int id;
	private String transcation_type;
	private int dep_wid;
	private int amount;
	private String status;
	
	public TransactionHistory(int id,String transaction_type,int dep_wid,int amount,String status) {
		this.id = id;
		this.transcation_type = transaction_type;
		this.dep_wid = dep_wid;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTranscation_type() {
		return transcation_type;
	}
	public void setTranscation_type(String transcation_type) {
		this.transcation_type = transcation_type;
	}
	public int getDep_wid() {
		return dep_wid;
	}
	public void setDep_wid(int dep_wid) {
		this.dep_wid = dep_wid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[id = " + id + ", transcation_type = " + transcation_type + ", dep_wid = " + dep_wid
				+ ", current balance = " + amount + ", status = " + status + "]\n";
	}
}
