package me.aurium.beetle.api.util;

import java.util.Objects;

public class Tuple3<A,B,C> {

    public Tuple3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(a, tuple3.a) && Objects.equals(b, tuple3.b) && Objects.equals(c, tuple3.c);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    private final A a;
    private final B b;
    private final C c;

    public Tuple3<A,B,C> update1(A a) {
        return new Tuple3<>(a,b,c);
    }

    public Tuple3<A,B,C> update2(B b) {
        return new Tuple3<>(a,b,c);
    }

    public Tuple3<A,B,C> update3(C c) {
        return new Tuple3<>(a,b,c);
    }

}
