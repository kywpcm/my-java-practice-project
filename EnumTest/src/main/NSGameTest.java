package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.02.24 5:54 오후
 */
public class NSGameTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getPrice() {
    final Integer price = NSGame.getPrice("ZELDA");
    System.out.println(NSGame.ZELDA.name());
    assertEquals("64800", String.valueOf(price));
  }

  @Test
  public void isExistGameTitle() {
    boolean isYn = NSGame.isExistGameTitle("mario ~~~");
    assertTrue(isYn);
    isYn = NSGame.isExistGameTitle("dongkeykong");
    assertFalse(isYn);
  }

  @Test
  public void getHashCode() {
    System.out.println(NSGame.ZELDA.hashCode());
    System.out.println(NSGame.MARIO.getHashCode());
    System.out.println(NSGame.YOSHI.getHashCode());
    System.out.println("===============");
    System.out.println(NSGame.ZELDA.toString());
    System.out.println(NSGame.MARIO);
    System.out.println(NSGame.YOSHI);
  }

  @After
  public void tearDown() throws Exception {
  }
}