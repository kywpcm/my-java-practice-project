package codility.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

public class Problem02 {

	public static void main(String[] args) {

		Problem02 p02 = new Problem02();
		String S = "00:01:07,400-234-090\n"
				+ "00:05:01,701-080-080\n"
				+ "00:05:00,400-234-090\n"
				+ "00:02:00,400-234-090\n"
				+ "00:03:00,444-555-666\n"
				+ "00:05:01,123-456-789\n"
				+ "00:08:07,000-000-000";
		System.out.println("final billAmount : " + p02.solution(S));
		
	}

	public int solution(String S) {
		
		// 1. list-map 구조 자료 만들기
		String[] strRows = S.split("\\n");
		String[] strCols = null;
		List<Map<String, Object>> callList = new ArrayList<>();
		Map<String, Object> callItem = null;
		
		for (int i = 0; i < strRows.length; i++) {
			strCols = strRows[i].split(",");
			callItem = new HashMap<>();
			callItem.put("time", this.getTimeToSec(strCols[0]));
			callItem.put("number", strCols[1]);
			callList.add(callItem);
		}
		
		// test
		System.out.println("callList : " + callList);
		
		
		// 2. 번호 기준 group by sum 기능 구현
		List<Map<String, Object>> finalCallList = new ArrayList<>();
		for (int i = 0; i < callList.size(); i++) {
			// 검색할 전화번호 추출
			String phoneNum = (String) callList.get(i).get("number");
			int phoneTime = (int) callList.get(i).get("time");
			
			// phoneTime 누적 나머지 전체 순회
			for (int i2 = i+1; i2 < callList.size(); i2++) {
				if (phoneNum.equals(callList.get(i2).get("number"))) {
					phoneTime += (int) callList.get(i2).get("time");
					// 같은거 삭제
					callList.remove(i2);
					i2--;
				}
			}
			
			Map<String, Object> finalCallItem = new HashMap<>();
			finalCallItem.put("number", phoneNum);
			finalCallItem.put("time", phoneTime);
			finalCallList.add(finalCallItem);
		}
		// test
		System.out.println("finalCallList : " + finalCallList);
		
		
		// 3. 통화 시간이 제일 큰 번호 제외
		//    단, 동률일 경우 제일 번호가 작은 것이 할인 대상
		int longestTime = (int) finalCallList.get(0).get("time");
		int shouldRemoveIndex = 0;
		for (int i = 0; i < finalCallList.size(); i++) {
			int time = (int) finalCallList.get(i).get("time");
			if (longestTime < time) {
				longestTime = time;
				shouldRemoveIndex = i;
			} else if (longestTime == time) {
				String numberOfLongestTime = (String)finalCallList.get(shouldRemoveIndex).get("number");
				String numberOfCurIndex = (String)finalCallList.get(i).get("number");
				if (Integer.parseInt(numberOfLongestTime.replaceAll("-", "")) >  Integer.parseInt(numberOfCurIndex.replaceAll("-", "")))
					shouldRemoveIndex = i;
			}
		}
		finalCallList.remove(shouldRemoveIndex);
		// test
		System.out.println("finalCallList : " + finalCallList);
		
		
		// 최종 리스트의 번호에 대해서 요금 계산
		int rstBillAmount = 0;
		for (Map<String, Object> collRow : finalCallList) {
			rstBillAmount += this.getBillAmount((int)collRow.get("time"));
		}
		
		return rstBillAmount;
	}
	
	private int getTimeToSec(String time) {
		
		int rtnSec = 0;
		String[] timeSnip = time.split(":");
		
		int hour = Integer.parseInt(timeSnip[0]);
		rtnSec += hour * 3600;
		
		int min = Integer.parseInt(timeSnip[1]);
		rtnSec += min * 60;
		
		rtnSec += Integer.parseInt(timeSnip[2]);
		
		return rtnSec;
	}
	
	private int getBillAmount(int time) {
		
		int billAmount = 0;
		
		if (time < 300) {
			billAmount = time * 3;
		} else {
			// 300
			// 301 ~ 360
			// 361 ~ 420
			if (time % 60 == 0)
				billAmount = time / 60 * 150;
			else
				billAmount = (time / 60 + 1) * 150;
		}
		
		return billAmount;
	}
	
}
