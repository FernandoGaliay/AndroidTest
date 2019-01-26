package com.example.androidtest.data;

public class FruitQueryBO {

    private int limit;

    private int offset;

    public FruitQueryBO(int offset) {
        this.offset = offset;
        this.limit = 10;
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
