import java.util.Arrays;

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
        s = s.replace(" ", "");
        s = s.replace("+", " ");
        s = s.replace("-", " -");
        if (s.charAt(0) == ' ') s = s.substring(1);

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

            String[] element = posicio.split("x");

            if (element.length > 1) {
                grauMax = Math.max(Integer.parseInt(element[1]), grauMax);
            }

            if (polinomi != null) {
                int valor = Integer.parseInt(element[0]);
                int grau = (element.length > 1) ? Integer.parseInt(element[1]) : 0;

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
        aux[0] = new Polynomial();
        aux[1] = new Polynomial();

        int grauNou = Math.abs(this.poliArray.length - p2.poliArray.length) + 1;
        float[] quocient = new float[grauNou];
        float[] dividend = copiaArray(this.poliArray);
        float[] divisor = copiaArray(p2.poliArray);

        for (int i = 0; i < grauNou; i++) {
            quocient[i] = dividend[i] / divisor[0];
            for (int j = 0; j < divisor.length; j++) {
                dividend[j + i] -= quocient[i] * divisor[j];
            }
        }

        aux[0].poliArray = quocient;
        aux[1].poliArray = dividend;

        return aux;
    }

    private float[] copiaArray(float[] array) {
        float[] resultat = new float[array.length];

        for (int i = 0; i < resultat.length; i++) {
            resultat[i] = array[i];
        }

        return resultat;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        float[] arrray = this.poliArray;

        // Polinomi sense x (no es un polinomi)
        if (arrray.length == 1) return null;

        // polinomi de grau 1
        if (arrray.length == 2) {
            return new float[]{-arrray[1] / arrray[0]};
        }

        int nombreMonomis = treureNombreMonomis();

        // Polinomis que nomes tenen dos monomis;
        if (nombreMonomis == 2) {
            return nomesDosMonomis(arrray);
        }

        // Polinomis de tres monomis que son de 2n grau o biquadratics.
        if (nombreMonomis == 3) {
            // Segon grau
            if (arrray.length == 3) {
                // Declar aquestes variables amb aquests noms per la formula de la equacio quadratica.
                float a = this.poliArray[0];
                float b = this.poliArray[1];
                float c = this.poliArray[2];

                return quadratica(a, b, c);
            }

            // Biquadratics
            if (esBiquadratica()) {
                int longitud = this.poliArray.length;

                float a = this.poliArray[0];
                float b = this.poliArray[(longitud - 1) / 2];
                float c = this.poliArray[longitud - 1];

                float[] holder = quadratica(a, b, c);
                if (holder == null) return null;

                return calcularBiquadratica(holder, longitud);
            }
        }

        // Ruffini
        float[] expressioRufini = copiaArray(arrray);
        float[] resultats = new float[arrray.length - 1];

        for (int i = 0; i < arrray.length - 3; i++) {
            float[] bases = cercarBase(expressioRufini[expressioRufini.length - 1]);

            expressioRufini = rondaRuffini(bases, expressioRufini, resultats);
        }

        float[] resultatsRestants;

        if (expressioRufini.length == 3) {
            float a = expressioRufini[0];
            float b = expressioRufini[1];
            float c = expressioRufini[2];

            resultatsRestants = quadratica(a, b, c);
        } else {
            resultatsRestants = nomesDosMonomis(expressioRufini);
        }

        if (resultatsRestants != null) afegirResultatsRestants(resultatsRestants, resultats);
        resultats = llevarZerosAlResultat(resultats);

        Arrays.sort(resultats);

        return resultats;
    }

    private float[] llevarZerosAlResultat(float[] resultats) {
        int numeroDeZeros = comptarZeros(resultats);

        if (numeroDeZeros > 0) {
            float[] resultatSenseZeros = new float[resultats.length - numeroDeZeros];

            for (int i = 0; i < resultats.length; i++) {
                if (resultats[i] != 0) {
                    resultatSenseZeros[i] = resultats[i];
                }
            }

            resultats = resultatSenseZeros;
        }

        return resultats;
    }

    private int comptarZeros(float[] resultats) {
        int nZeros = 0;

        for (int i = 0; i < resultats.length; i++) {
            if (resultats[i] == 0) nZeros++;
        }

        return nZeros;
    }

    private void afegirResultatsRestants(float[] resultatsRestants, float[] resultats) {
        for (int i = 0; i < resultats.length; i++) {
            if (resultats[i] == 0) {
                for (int j = 0; j < resultatsRestants.length; j++) {
                    resultats[i + j] = resultatsRestants[j];
                }
                break;
            }
        }
    }

    private float[] rondaRuffini(float[] bases, float[] expressioRufini, float[] resultats) {
        for (int i = 0; i < bases.length; i++) {
            float[] arrayAux = copiaArray(expressioRufini);

            float base = bases[i];
            boolean baseEnResultat = comprobarResultat(resultats, base);

            if (baseEnResultat) continue;

            for (int j = 1; j < arrayAux.length; j++) {
                arrayAux[j] += base * arrayAux[j - 1];
            }

            if (arrayAux[arrayAux.length -1] == 0) {
                guardarResultat(base, resultats);
                arrayAux = llevarZero(arrayAux);
                expressioRufini = arrayAux;
                break;
            }
        }

        return expressioRufini;
    }

    private float[] llevarZero(float[] arrayAux) {
        float[] senseZero = new float[arrayAux.length - 1];

        for (int i = 0; i < senseZero.length; i++) {
            senseZero[i] = arrayAux[i];
        }

        arrayAux = senseZero;

        return arrayAux;
    }

    private void guardarResultat(float base, float[] resultats) {
        for (int i = 0; i < resultats.length; i++) {
            if (resultats[i] == 0) {
                resultats[i] = base;
                break;
            }
        }
    }

    private boolean comprobarResultat(float[] resultados, float base) {
        for (int i = 0; i < resultados.length; i++) {
            if (base == resultados[i]) return true;
        }

        return false;
    }

    float[] cercarBase(float numero) {
        int numeroDeBases = treureBases(numero, null);

        float[] bases = new float[numeroDeBases * 2];
        treureBases(numero, bases);

        return bases;
    }

    private int treureBases(float numero, float[] bases) {
        int contador = 0;

        numero = Math.abs(numero);

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                if (bases != null) {
                    bases[contador * 2] = i;
                    bases[contador * 2 + 1] = -i;
                }
                contador++;
            }
        }

        return contador;
    }

    private float[] calcularBiquadratica(float[] holder, int longitud) {
        if (((longitud - 1) / 2) % 2 == 1) {
            float[] resultat = new float[holder.length];
            for (int i = 0; i < holder.length; i++) {
                resultat[i] = (float) Math.pow(holder[i], 1f / ((longitud - 1f) / 2f));
            }

            return resultat;
        } else {
            int nSolucions = ferArrels(holder, null);

            float[] resultat = new float[nSolucions];

            ferArrels(holder, resultat);

            return resultat;
        }
    }

    private float[] nomesDosMonomis(float[] array) {
        // Determina si el grau es parell o senar.
        boolean parell = this.poliArray.length % 2 == 1;

        // Les que no tenen solucio per que intenten fer una arrel parell d'un nombre negatiu
        if (parell && this.poliArray[poliArray.length - 1] > 0) return null;

        boolean negatiu = false;


        if (-array[array.length - 1] < 0) {
            negatiu = true;
            array[array.length - 1] *= -1;
        }

        float resultado = (float) Math.pow(-array[array.length - 1] / array[0], 1 / (float) (array.length - 1));

        if (negatiu) resultado *= -1;


        if (!parell) {
            return new float[]{resultado};
        } else {
            float[] arrayResultante = {-resultado, resultado};
            Arrays.sort(arrayResultante);
            return arrayResultante;
        }
    }

    private int ferArrels(float[] holder, float[] resultat) {
        int nResultats = 2 * holder.length;

        for (int i = 0; i < holder.length; i++) {
            if (holder[i] < 0) {
                nResultats -= 2;
                continue;
            }

            if (holder[i] == 0) {
                nResultats--;
                if (resultat != null) {
                    resultat[i] = 0;
                }
                continue;
            }

            if (resultat != null) {
                float whatever = (float) Math.sqrt(holder[i]);
                resultat[2 * i] = whatever;
                resultat[2 * i + 1] = -whatever;
            }
        }

        if (resultat != null) Arrays.sort(resultat);

        return nResultats;
    }

    private boolean esBiquadratica() {
        if (this.poliArray.length % 2 == 0) return false;

        if (this.poliArray[(this.poliArray.length - 1) / 2] != 0) {
            return true;
        }

        return false;
    }

    private float[] quadratica(float a, float b, float c) {
        // Resultat del que hi ha dins de l'arrel
        float contingutArrel = (float) Math.pow(b, 2) - (4 * a * c);

        // Si el contingut es negatiu no hi ha solucio.
        if (contingutArrel < 0) return null;

        // Si es 0 nomes hi ha una solucio.
        if (contingutArrel == 0) return new float[]{-b / (2 * a)};

        float[] array = new float[2];

        array[0] = (float) ((-b + Math.sqrt(contingutArrel)) / (2 * a));
        array[1] = (float) ((-b - Math.sqrt(contingutArrel)) / (2 * a));

        Arrays.sort(array);

        return array;
    }

    private int treureNombreMonomis() {
        int resultado = 0;

        for (int i = 0; i < this.poliArray.length; i++) {
            if (this.poliArray[i] != 0) resultado++;
        }

        return resultado;
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
