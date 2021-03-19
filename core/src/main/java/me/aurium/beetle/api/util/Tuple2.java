package me.aurium.beetle.api.util;

import java.util.Objects;

public class Tuple2<A,B> {

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    private final A a;
    private final B b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(a, tuple2.a) && Objects.equals(b, tuple2.b);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    public Tuple2<A,B> update1(A a) {
        return new Tuple2<>(a,this.b);
    }

    public Tuple2<A,B> update2(B b) {
        return new Tuple2<>(a,b);
    }
}
