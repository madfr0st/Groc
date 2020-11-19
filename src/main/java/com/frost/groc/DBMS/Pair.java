package com.frost.groc.DBMS;

public class Pair<U extends Comparable<U>, V extends Comparable<V>>
        implements Comparable<Pair<U,V>>{

    public  U a;
    public  V b;

    public Pair(U a, V b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (!a.equals(pair.a))
            return false;
        return b.equals(pair.b);
    }

    @Override
    public int hashCode() {
        return 31 * a.hashCode() + b.hashCode();
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    @Override
    public int compareTo(Pair<U, V> o) {
        return getU().compareTo(o.getU());
    }
    private U getU() {
        return a;
    }
    private V getV() {
        return b;
    }
}
