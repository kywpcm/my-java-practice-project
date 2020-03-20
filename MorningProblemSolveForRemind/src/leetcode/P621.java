package leetcode;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/">
 *   https://leetcode.com/problems/task-scheduler/
 * </a><br>
 * Created by Kwon Youngwoo on 2019.07.08 10:20
 */
public class P621 {

  class Solution {

    public int leastInterval(char[] tasks, int n) {
      LinkedList<Character> taskQueue = new LinkedList<>();
      for (char task : tasks) {
        taskQueue.offer(task);
      }

      LinkedList<Character> executionQueue = new LinkedList<>();

      int taskQueuePollCount = 0;
      int taskQueueSize = taskQueue.size();
      boolean isOfferAtLeast = false;
      while (taskQueueSize != 0) {
        Character task = taskQueue.poll();
        taskQueuePollCount++;

        int executionQueueSize = executionQueue.size();
        if (executionQueueSize == 0) { // corner case handling
          executionQueue.offer(task);
        } else {
          boolean isAlreadyExist = false;
          // n times for loop
          int endOfToCompareIndex = executionQueueSize - 1 - n;
          for (int toCompareIndex = executionQueueSize - 1; toCompareIndex > endOfToCompareIndex;
              toCompareIndex--) {
            if (toCompareIndex < 0) break; // corner case handling

            if (task == executionQueue.get(toCompareIndex)) {
              isAlreadyExist = true;
              break;
            }
          }

          if (!isAlreadyExist) {
            executionQueue.offer(task); // input
            isOfferAtLeast = true;
          } else { // or
            taskQueue.offerLast(task);  // for retry
          }
        }

        if (taskQueuePollCount == taskQueueSize) {
          if (taskQueue.size() == 0) { // corner case handling
            taskQueueSize = 0;
            continue;
          }

          if (!isOfferAtLeast) {
            executionQueue.offer('i'); // character represents idle state
          }

          // init
          taskQueuePollCount = 0;
          taskQueueSize = taskQueue.size();
          isOfferAtLeast = false;
        }
      }

      return executionQueue.size();
    }
  }

  @Test
  public void testLeastInterval() {
    Solution sol = new Solution();

//    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//    int n = 2;
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'A', 'A', 'B'};
    int n = 2;
    int interval = sol.leastInterval(tasks, n);

//    Assert.assertEquals(8, interval);
    Assert.assertEquals(13, interval);
  }
}
