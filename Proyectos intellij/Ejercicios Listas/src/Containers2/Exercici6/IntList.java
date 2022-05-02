package Containers2.Exercici6;

import java.util.AbstractList;

public class IntList extends AbstractList {
    private int[] data;

    public IntList(int[] data) {
        this.data = data;
    }

    @Override
    public Object get(int i) {
        if (i < this.data.length && i >= 0) return data[i];
        return null;
    }

    @Override
    public int size() {
        return this.data.length;
    }
}
