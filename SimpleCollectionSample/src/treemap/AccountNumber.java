package treemap;

import java.util.Comparator;

//도메인 클래스
//server..
//Data Model..
public class AccountNumber implements Comparator {

	String accountNumber;

	public AccountNumber() {}
	
	public AccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public int compare(Object acc1, Object acc2) {
		String tempAccountNumber1 = ((AccountNumber)acc1).getAccountNumber() ;
	    String tempAccountNumber2 = ((AccountNumber)acc2).getAccountNumber() ;
	    //tempAccountNumber1 - tempAccountNumber2과 같다.
	    return tempAccountNumber1.compareTo(tempAccountNumber2);
	}
	
}
