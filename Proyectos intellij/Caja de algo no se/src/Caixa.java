public class Caixa {
    Object[] objectArray;
    int nObjectes = 0;
    int capacitat = 0;

    public Caixa() {
        objectArray = new Object[2];
        this.capacitat = 2;
    }

    public Caixa(int capacitat) {
        objectArray = new Object[capacitat];
        this.capacitat = capacitat;
    }

    public void addElement(Object o) {
        if (this.nObjectes == this.capacitat) {
            int newCapacity = this.capacitat * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < this.capacitat; i++) {
                newArray[i] = this.objectArray[i];
            }
            this.objectArray = newArray;
            this.capacitat = newCapacity;

            System.out.printf("Capacidad aumentada a %d\n", newCapacity);
        }

        this.objectArray[this.nObjectes] = o;
        this.nObjectes++;
    }

    @Override
    public String toString() {
        String result = "\n";
        for (int i = 0; i < this.nObjectes; i++) {
            result += this.objectArray[i].toString() + ", ";
        }

        return result;
    }

    public void remove(int pos) {
        if (pos < this.nObjectes) {
            for (int i = pos; i < nObjectes - 1; i++) {
                objectArray[i] = objectArray[i + 1];
            }
            this.objectArray[nObjectes - 1] = null;
            this.nObjectes--;
        }
    }

    public Object get(int pos) {
        if (pos < this.nObjectes) {
            return objectArray[pos];
        }

        return new RuntimeException("Valio verguísima");
    }
}
