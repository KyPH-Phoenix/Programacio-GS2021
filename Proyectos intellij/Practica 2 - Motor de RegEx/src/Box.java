public class Box<T> {
    private Object[] objectArray;
    private int nObjects;
    private int capacity;

    public Box() {
        this.objectArray = new Object[2];
        this.capacity = 2;
    }

    public Box(int capacity) {
        this.objectArray = new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return this.nObjects;
    }

    public void addElement(T o) {
        if (this.nObjects == this.capacity) {
            int newCapacity = this.capacity * 2;
            Object[] newArray = new Object[newCapacity];

            for (int i = 0; i < this.capacity; i++) {
                newArray[i] = this.objectArray[i];
            }

            this.objectArray = newArray;
            this.capacity = newCapacity;

            // System.out.printf("Capacidad aumentada a %d\n", newCapacity);
        }

        this.objectArray[this.nObjects] = o;
        this.nObjects++;
    }

    @Override
    public String toString() {
        String result = "\n";
        for (int i = 0; i < this.nObjects; i++) {
            result += this.objectArray[i].toString();
        }

        return result;
        //return result.substring(0, result.length() - 2);
    }

    public void remove(int pos) {
        if (pos < this.nObjects) {
            for (int i = pos; i < nObjects - 1; i++) {
                objectArray[i] = objectArray[i + 1];
            }
            this.objectArray[nObjects - 1] = null;
            this.nObjects--;
        }
    }

    public T get(int pos) {
        if (pos < this.nObjects) {
            return (T) objectArray[pos];
        }

        throw new RuntimeException("La posición no existe");
    }

}
