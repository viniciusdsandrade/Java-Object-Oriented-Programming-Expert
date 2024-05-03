package p1.q1;

public class Q1 {

    static Foo f = new Foo();
    static Foo f2 = new Foo();
    static Bar b = new Bar();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            f2 = getFoo(i);
            f2.react();
        }
    }

    static Foo getFoo(int y) {
        if (y % 2 == 0)
            return f;
        else
            return b;
    }
}

