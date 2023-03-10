package AutomatedTellerMachine;

public class CustomerCreation {
		private int id;
		private String name;
		private String pass;
		private int balance;
		
		public CustomerCreation(int id,String name,String pass,int balance) {
			this.id = id;
			this.name = name;
			this.pass = pass;
			this.balance = balance;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public int getBalance() {
			return balance;
		}
		
		public void setBalance(int balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "[id = " + id + ", name = " + name + ", pass = " + pass + "]";
		}

}
