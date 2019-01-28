package com.example.androidtest.data;

public class FruitQueryBO {

    private int limit;

    private int offset;

    public FruitQueryBO() {
        this(0);
    }

    public FruitQueryBO(int offset) {
        this(10, offset);
    }

    public FruitQueryBO(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
