package com.example.androidtest.data.bo;

import java.util.Objects;

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

    public FruitQueryBo nextQuery(){
        offset = offset + limit;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitQueryBo that = (FruitQueryBo) o;
        return limit == that.limit &&
                offset == that.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset);
    }
}
