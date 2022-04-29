package Containers2.Exercici1;

import java.util.Iterator;

public class Sequence implements Iterable<Integer> {
    private int[] data = {1, 5, 6, 7, -1, 2};

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < data.length;
            }

            @Override
            public Integer next() {
                int oldPos = data[position];
                position++;
                if (position <= data.length) return oldPos;
                return null;
            }
        };
    }
}