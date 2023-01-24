package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/continuous-subarray-sum/">
 *   https://leetcode.com/problems/continuous-subarray-sum/
 * </a>
 * <br>
 * Created by Kwon Youngwoo on 2022.10.26 1:43 PM
 */
public class P523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 2; i <= n; i++) {
            combination(nums, visited, 0, n, i, list);
        }

        for (List<Integer> subList : list) {
            Integer sum = 0;
            for (Integer num : subList) {
                sum += num;
            }
            if (sum % k == 0) {
                return true;
            }
        }

        return false;
    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    private void combination(int[] arr, boolean[] visited, int start, int n, int r, List<List<Integer>> list) {
        if (r == 0) {
            check(arr, visited, n, list);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, list);
            visited[i] = false;
        }
    }

    // 배열 출력
    private void check(int[] arr, boolean[] visited, int n, List<List<Integer>> list) {
        List<Integer> subList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
                subList.add(arr[i]);
                indexList.add(i);
            }
        }
        System.out.println();

        boolean shouldAdd = true;
        for (int i = 0; i < indexList.size(); i++) {
            if (i == indexList.size() - 1) break;

            int diff =  indexList.get(i + 1) - indexList.get(i);
            if (diff != 1) {
                shouldAdd = false;
                break;
            }
        }
        if (shouldAdd) {
            list.add(subList);
        }
    }

    @Test
    public void testCheckSubarraySum() {
//        int[] nums = {23,2,4,6,7};
        int[] nums = {23,2,6,4,7};
//        int k = 6;
        int k = 13;
        boolean ret = this.checkSubarraySum(nums, k);

        assertThat(ret).isEqualTo(false);
    }
}
