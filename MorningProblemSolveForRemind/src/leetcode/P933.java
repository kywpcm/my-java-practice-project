package leetcode;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/number-of-recent-calls/">
 *   https://leetcode.com/problems/number-of-recent-calls/
 * </a>
 * Created by Kwon Youngwoo on 2019.06.17 09:50
 */
public class P933 {

  class RecentCounter {

    private ArrayList<Integer> pingStorage;

    public RecentCounter() {
      pingStorage = new ArrayList<>();
    }

    public int ping(int t) {
      pingStorage.add(t);

      int startTime = t - 3000;
      if (startTime <= 1)
        return pingStorage.size();

      int count = 0;
      for (int i = pingStorage.size() - 1; i >= 0; i--) {
        int targetTime = pingStorage.get(i);
        if (targetTime < startTime)
          break;
        else count++;
      }

      return count;
    }
  }

  @Test
  public void testPing() {
    RecentCounter obj = new RecentCounter();
    Assert.assertEquals(1, obj.ping(1));
    Assert.assertEquals(2, obj.ping(100));
    Assert.assertEquals(3, obj.ping(3001));
    Assert.assertEquals(3, obj.ping(3002));
    Assert.assertEquals(4, obj.ping(3003));
    Assert.assertEquals(5, obj.ping(3100));
    Assert.assertEquals(5, obj.ping(3101));
  }
}
