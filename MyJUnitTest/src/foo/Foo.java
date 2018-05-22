package foo;

public class Foo {

    private String foo;

    public Foo() {
        System.out.println("Foo 클래서 생성");
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "foo='" + foo + '\'' +
                '}';
    }

}
