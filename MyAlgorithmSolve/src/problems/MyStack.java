package problems;

/*
 * 스택
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	16968	6609	5189	40.520%
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

예제 출력
2
2
0
2
1
-1
0
1
-1
0
3

힌트
출처
문제를 만든 사람: baekjoon
문제의 오타를 찾은 사람: hshtop123
알고리즘 분류
스택
 *
 * @author kywpcm
 *
 */
public class MyStack {

	private final int MAX_SIZE = 10000;
	
	private int[] mData = null; // 스택 데이터
	private int mStackPtr;		// 스택 포인터
	
	public MyStack () {
		// 스택 size 초기화
		mData = new int[MAX_SIZE];
		mStackPtr = -1;
	}
	
	public void push(int numData) {
		
		if(mStackPtr < MAX_SIZE) {
			mStackPtr++;
			mData[mStackPtr] = numData;
		} else if (mStackPtr >= MAX_SIZE) {
			System.out.println("Stack Overflow");
		}
	}
	
	public int pop() {
		
		// 스택 언더플로우 체크
		if (mStackPtr < 0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int popData = mData[mStackPtr];
		
		mData[mStackPtr] = 0; // int 배열은 어차피 다 0으로 초기화 되니까..
		mStackPtr--;
		
		return popData;
	}
	
	public int size() {
		
		int size;
		if (mStackPtr < 0) {
			size = 0;
		} else {
			size = mStackPtr + 1;
		}
		
		return size;
	}
	
	public int empty() {
		
		if (mStackPtr < 0) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public int top() {
		
		if (mStackPtr < 0) {
			return -1;
		} else {
			return mData[mStackPtr];
		}
		
	}
	
}
