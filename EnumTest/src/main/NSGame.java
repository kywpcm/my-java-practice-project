package main;

/**
 * Created by Kwon Youngwoo on 2020.02.24 5:05 오후
 */
// enum 클래스 (싱글톤)
public enum NSGame {

  // 상수 필드 (static final)
  // 인스턴스..?
  // static inner class, annonymous class와 비슷한 느낌..
  ZELDA("ZE101", "Legend of Zelda - breath of the wild", 64800) {
    // NSGame abstract 메소드 구현
    @Override
    public int getHashCode() {
      return this.hashCode();
    }
  },
  MARIO("MA101", "mario ~~~", 50000) {
    @Override
    public int getHashCode() {
      return this.hashCode();
    }
  },
  YOSHI("YO101", "yoshi !!!", 34800) {
    @Override
    public int getHashCode() {
      return this.hashCode();
    }
  };

  private String code;
  private String title;
  private Integer price;

  // private 생성자. public 허용 안 함
  NSGame(String code, String title, Integer price) {
    this.code = code;
    this.title = title;
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public String getTitle() {
    return title;
  }

  public Integer getPrice() {
    return price;
  }

  // 상수 정의를 위한 enum 이지만 클래스처럼 public 메소드 제공 가능
  public static Integer getPrice (String name) {
    return NSGame.valueOf(name).getPrice();
  }

  // public 메소드 제공
  public static boolean isExistGameTitle(String title) {
    final NSGame[] games = NSGame.values();
    for (NSGame game : games) {
      if (game.title.equals(title)) return true;
    }
    return false;
  }

  // 심지어 abstract 메소드 선언 가능
  public abstract int getHashCode();
}
