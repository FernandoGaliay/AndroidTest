package com.example.androidtest.data.bo;

public class FruitQueryBo {

    private int limit;

    private int offset;

    public FruitQueryBo() {
        this(0);
    }

    public FruitQueryBo(int offset) {
        this(10, offset);
    }

    public FruitQueryBo(int limit, int offset) {
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
