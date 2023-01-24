package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">
 *   https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * </a>
 * <br>
 * Created by Kwon Youngwoo on 2022.11.20 2:51 PM
 */
public class P1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum = this.maxNum(candies);

        List<Boolean> retList = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= maxNum)
                retList.add(Boolean.TRUE);
            else
                retList.add(Boolean.FALSE);
        }

        return retList;
    }

    private int maxNum(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }

    @Test
    public void testKidsWithCandies() {
//        int[] candies = {2,3,5,1,3};
//        int extraCandies = 3;

//        int[] candies = {4,2,1,1,2};
//        int extraCandies = 1;

        int[] candies = {12,1,12};
        int extraCandies = 10;

//        Assertions.assertThat(kidsWithCandies(candies, extraCandies)).isEqualTo(Arrays.asList(true,true,true,false,true));
//        Assertions.assertThat(kidsWithCandies(candies, extraCandies)).isEqualTo(Arrays.asList(true,false,false,false,false));
        Assertions.assertThat(kidsWithCandies(candies, extraCandies)).isEqualTo(Arrays.asList(true,false,true));
    }
}
