package main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kwon Youngwoo on 2020.03.19 5:45 오후
 */
public class ThreadLocalStopWatcher {

  private AtomicLong time;

  public void start() {
    time.set(System.nanoTime());
  }

  public Long split() {
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time.get());
  }

  public Long stop() {
    Long interval = System.nanoTime() - time.get();
    time.set(0);
    return interval;
  }
}
