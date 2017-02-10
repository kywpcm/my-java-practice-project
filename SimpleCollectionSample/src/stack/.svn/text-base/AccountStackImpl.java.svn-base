package stack;

//도메인 클래스
//server..
public class AccountStackImpl implements StackInterface {

	private int increment;  //스택 포인터..
	private Account[] accounts;  //배열을 사용한 스택 구현..
	
	public AccountStackImpl() {
		this(10);
		increment = 0;
	}
	
	public AccountStackImpl(int size) {
		accounts = new Account[size];
		increment = 0;
	}
	
	//인터페이스를 통한 구현..
	@Override
	public void push(Object item) {
		if( !(item instanceof Account) ) {
			System.out.println("Account 객체 아님");
			return;
		}
		else 
			accounts[increment++] = (Account)item;  //후위 연산자..
	}

	@Override
	public Object pop() {
		Account account = accounts[--increment];  //전위 연산자..
		if(increment < 0)
			increment = 0;
		return account;
	}

	@Override
	public int size() {
		if(increment < 0) 
			return 0;
		return increment;  //increment가 size가 된다.
	}

}
