public class Polynomial {
    float[] poliArray;

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        this.poliArray = new float[cfs.length];
        for (int i = 0; i < poliArray.length; i++) {
            this.poliArray[i] = cfs[i];
        }
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
        s = s.replace("+ ", "");
        s = s.replace("- ", "-");

        String[] variables = s.split(" ");

        int grauMax = grauTermes(variables, null);

        float[] polinomi = construeixArray(grauMax);
        grauTermes(variables, polinomi);

        this.poliArray = polinomi;
    }

    int grauTermes(String[] variables, float[] polinomi) {
        int grauMax = 0;

        for (int i = 0; i < variables.length; i++) {
            String posicio = variables[i];
            posicio = posicio.replace("^", "");

            if (posicio.charAt(posicio.length() - 1) == 'x') posicio += "1";

            if (posicio.charAt(0) == 'x') posicio = "1" + posicio;
            if (posicio.length() > 1 && posicio.substring(0, 2).equals("-x")) posicio = "-1" + posicio.substring(1);

            String[] elemento = posicio.split("x");

            if (elemento.length > 1) {
                grauMax = Math.max(Integer.parseInt(elemento[1]), grauMax);
            }

            if (polinomi != null) {
                int valor = Integer.parseInt(elemento[0]);
                int grau = (elemento.length > 1) ? Integer.parseInt(elemento[1]) : 0;

                polinomi[polinomi.length - grau - 1] += valor;
            }
        }

        return grauMax;
    }

    float[] construeixArray(int grauMax) {
        float[] array = new float[grauMax + 1];

        for (int i = 0; i < grauMax + 1; i++) {
            array[i] = 0;
        }

        return array;
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        Polynomial aux = new Polynomial();

        int longitud1 = this.poliArray.length;
        int longitud2 = p.poliArray.length;

        float[] arrayAux = new float[Math.max(longitud1, longitud2)];

        sumaValor(arrayAux, this.poliArray);
        sumaValor(arrayAux, p.poliArray);

        aux.poliArray = arrayAux;

        return aux;
    }

    void sumaValor(float[] aux, float[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos1 = aux.length - 1 - i;
            int pos2 = array.length - 1 - i;
            aux[pos1] += array[pos2];
        }
    }

    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {
        Polynomial aux = new Polynomial();
        int longitudNova = this.poliArray.length + p2.poliArray.length - 1;
        float[] resultat = new float[longitudNova];

        for (int i = 0; i < this.poliArray.length; i++) {
            multiplicarValor(resultat, p2, i);
        }

        aux.poliArray = resultat;
        return aux;
    }

    void multiplicarValor(float[] resultat, Polynomial p2, int i) {
        for (int j = 0; j < p2.poliArray.length; j++) {
            float coeficient;
            int grauNou;

            int grau1 = this.poliArray.length - 1 - i;
            int grau2 = p2.poliArray.length - 1 - j;

            coeficient = this.poliArray[i] * p2.poliArray[j];
            grauNou = grau1 + grau2;

            resultat[resultat.length - grauNou - 1] += coeficient;
        }
    }

    // Divideix el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    // Torna el quocient i també el residu (ambdós polinomis)
    public Polynomial[] div(Polynomial p2) {
        Polynomial[] aux = new Polynomial[2];



        return aux;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        return null;
    }

    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object o) {
        Polynomial p = (Polynomial) o;

        return this.toString().equals(p.toString());
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        if (this.poliArray == null)
            return "0";

        StringBuilder resultado = new StringBuilder();
        int longitud = this.poliArray.length;
        for (int i = 0; i < longitud; i++) {
            int valor = (int) this.poliArray[i];
            int pos = longitud - (i + 1);
            if (valor != 0) {
                String signo = (valor > 0) ? " + " : " - ";
                if (i != longitud - 1) {
                    if (i != longitud - 2) {
                        resultado.append((Math.abs(valor) == 1) ? (signo + "x^" + (pos)) : (signo + Math.abs(valor) + "x^" + (pos)));
                    } else {
                        resultado.append((Math.abs(valor) == 1) ? (signo + "x") : (signo + Math.abs(valor) + "x"));
                    }
                } else {
                    resultado.append(signo + Math.abs(valor));
                }
            }
        }

        if (resultado.toString().equals("")) {
            return "0";
        }

        if (resultado.toString().charAt(1) == '-') {
            return ("-" + resultado.substring(3));
        }

        return resultado.substring(3);
    }
}
