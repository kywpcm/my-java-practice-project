package stack;

//client..
public class AccountStackTest {

	public static void main(String[] args) {

		Account[] accounts = {
				new Account(15000, "12345_1", "james"),
				new Account(25000, "12345_2", "tomas"),
				new Account(35000, "12345_3", "edward")
		};
		
		AccountStackImpl impl = new AccountStackImpl();
		for(int i = 0; i < accounts.length; i++) {
			impl.push(accounts[i]);
		}
		
		System.out.println("====================");
		
		for(int i = 0; i < accounts.length; i++) {
			Account account = (Account)impl.pop();
			System.out.println(account);
		}
		
	}

}
