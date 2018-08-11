package goorm._01_bm_problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Problem02 {

	public static void main(String[] args) {
		//		 TODO : system.in input
	}

	public static void solve(List<String> inputLines) {

		// Linked Hashmap 사용으로 iterator 성능 up
		Map<String, SaleProduct> saleMap = new LinkedHashMap<>();

		inputLines.forEach(line -> {
			String[] split = line.split("\\|");
			String dateStr = split[0];
			String prodId = split[1];
			String regionCd = split[2];

			if (isTargetDateRange(dateStr)) {

				if (saleMap.get(prodId) == null) { // insert
					SaleProduct sp = new SaleProduct();
					sp.setProdId(prodId);
					sp.setSaleCount(sp.getSaleCount() + 1);
					Map<String, Integer> regionCountMap = sp.getRegionCountMap();
					regionCountMap.put(regionCd, 1);

					saleMap.put(prodId, sp);
				} else { // update
					SaleProduct sp = saleMap.get(prodId);
					sp.setSaleCount(sp.getSaleCount() + 1);

					Map<String, Integer> regionCountMap = sp.getRegionCountMap();
					if(regionCountMap.containsKey(regionCd)) {
						Integer regionCount = regionCountMap.get(regionCd);
						regionCountMap.put(regionCd, regionCount + 1);
					} else {
						regionCountMap.put(regionCd, 1);
					}
				}
			}
		});

		if (saleMap.isEmpty()) {
			System.out.println("NO RESULT");
			return;
		}

		saleMap.values()
				.stream()
				.sorted()
				.limit(3)
				.forEach(sp -> {
					String prefix = String.format("%s:%d=>", sp.getProdId(), sp.getSaleCount());

					Comparator<Map.Entry<String, Integer>> comparator1 = (e1, e2) -> e1.getValue().compareTo(e2.getValue());
					Comparator<Map.Entry<String, Integer>> comparator2 = (e1, e2) -> e2.getKey().compareTo(e1.getKey());

					List<Map.Entry<String, Integer>> entryList = sp.getRegionCountMap().entrySet().stream()
							.sorted(comparator1.thenComparing(comparator2))
							.limit(3)
							.collect(Collectors.toList());
					Collections.reverse(entryList);
					for (Map.Entry<String, Integer> entry : entryList) {
						prefix += entry.getKey() + ":" + entry.getValue() + ",";
					}

					System.out.println(prefix.substring(0, prefix.length()-1));
				});
	}

	public static boolean isTargetDateRange(String dateStr) {
		String[] split = dateStr.split("-");
		int day = Integer.parseInt(split[2]);
		return 2 <= day && day <= 9;
	}


	@Test
	public void isTargetDateRangeTest() {
		// Integer.parseInt 는 0 등 무효한 숫자 무시
		String date1 = "05";
		System.out.println(Integer.parseInt(date1));

		String dateStr1 = "2018-08-02";
		String dateStr2 = "2018-08-09";
		String dateStr3 = "2018-08-15";
		String dateStr_fail_1 = "2018-08-01";
		String dateStr_fail_2 = "2018-08-10";

		Assert.assertTrue(isTargetDateRange(dateStr1));
		Assert.assertTrue(isTargetDateRange(dateStr2));
		Assert.assertTrue(isTargetDateRange(dateStr3));
		Assert.assertFalse(isTargetDateRange(dateStr_fail_1));
		Assert.assertFalse(isTargetDateRange(dateStr_fail_2));
	}


	@Test
	public void test1() {
		String t1 =
				"2018-08-03|10001|A02\n" +
				"2018-08-01|10004|A09\n" +
				"2018-08-02|10001|A02\n" +
				"2018-08-05|10001|A05\n" +
				"2018-08-09|10001|A07\n" +
				"2018-08-10|10007|A09\n" +
				"2018-08-08|10001|A05\n" +
				"2018-08-08|10001|A02\n" +
				"2018-08-04|10003|A01\n" +
				"2018-08-02|10003|A04\n" +
				"2018-08-04|10003|A01\n" +
				"2018-08-04|10003|A06\n" +
				"2018-08-03|10006|A01\n" +
				"2018-08-02|10006|A02\n" +
				"2018-08-03|10006|A04\n" +
				"2018-08-10|10007|A09";

		String[] lines = t1.split("\n");
		solve(Arrays.asList(lines));
	}

	@Test
	public void test2() {
		String t1 = "2018-08-03|10001|A02\n" +
				"2018-08-01|10004|A09\n" +
				"2018-08-02|10001|A02\n" +
				"2018-08-05|10001|A05\n" +
				"2018-08-09|10001|A07\n" +
				"2018-08-10|10007|A09\n" +
				"2018-08-08|10001|A05\n" +
				"2018-08-08|10001|A02\n" +
				"2018-08-04|10003|A01\n" +
				"2018-08-02|10003|A04\n" +
				"2018-08-04|10003|A01\n" +
				"2018-08-04|10003|A06\n" +
				"2018-08-10|10007|A09\n" +
				"2018-08-08|10001|A05\n" +
				"2018-08-08|10001|A05";

		String[] lines = t1.split("\n");
		solve(Arrays.asList(lines));
	}

	@Test
	public void test3() {
		String t1 = "2018-08-01|10004|A09\n" +
				"2018-08-10|10007|A09\n" +
				"2018-08-01|10007|A04\n" +
				"2018-08-10|10007|A09\n" +
				"2018-08-01|10001|A05";

		String[] lines = t1.split("\n");
		solve(Arrays.asList(lines));
	}


	public static class SaleProduct implements Comparable<SaleProduct> {
		private String prodId;
		private int saleCount = 0;
		private Map<String, Integer> regionCountMap = new LinkedHashMap<>();

		public String getProdId() {
			return prodId;
		}

		public void setProdId(String prodId) {
			this.prodId = prodId;
		}

		public int getSaleCount() {
			return saleCount;
		}

		public void setSaleCount(int saleCount) {
			this.saleCount = saleCount;
		}

		public Map<String, Integer> getRegionCountMap() {
			return regionCountMap;
		}

		public void setRegionCountMap(Map<String, Integer> regionCountMap) {
			this.regionCountMap = regionCountMap;
		}

		@Override
		public int compareTo(SaleProduct o) {
			if (this.saleCount > o.getSaleCount()) {
				return -1;
			} else if (this.saleCount == o.getSaleCount()) {
				return prodId.compareTo(o.getProdId());
			} else {
				return 1;
			}
		}
	}



}
