import java.util.Arrays;

public class Polynomial {
    // Array on es guardaran els monomis durant tot el programa
    float[] poliArray;

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        // Cream un nou array am la longitud de l'array que ens pasen
        this.poliArray = new float[cfs.length];

        // Copia'm cada possició de l'array cfs al nou array.
        for (int i = 0; i < poliArray.length; i++) {
            this.poliArray[i] = cfs[i];
        }
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
        // Primer llevam tots els espais, després reemplaçam els signes. Si hi ha un + possam un " " i si hi ha un -
        // posam un " -"
        s = s.replace(" ", "");
        s = s.replace("+", " ");
        s = s.replace("-", " -");

        // Aqui eliminiam el possible espai al principi de la String
        if (s.charAt(0) == ' ') s = s.substring(1);

        // Split de la String als espais
        String[] variables = s.split(" ");

        // Funció per trobar el grau maxim del polinomi. Aquesta funció també s'empra per replenar el polinomi si no li
        // passam un array null.
        int grauMax = grauTermes(variables, null);

        // Construim el polinomi amb el grau maxim.
        float[] polinomi = construeixArray(grauMax);

        // Funcio per ficar els monomis al polinomi. Aquesta vegada no li passam un array null
        grauTermes(variables, polinomi);

        this.poliArray = polinomi;
    }

    // Funció per trobar el grau màxim i replenar el polinomi
    int grauTermes(String[] variables, float[] polinomi) {
        int grauMax = 0;

        // El cicle recorrera totes les possicions de l'array de monomis.
        for (int i = 0; i < variables.length; i++) {
            /*
                Processam el monomi per que quedi amb el seguen format:
                NxP

                N = Numero
                x = variable x
                P = Exponent
             */
            String monomi = variables[i];
            monomi = monomi.replace("^", "");

            // Posam un 1 si no hi ha exponent pero si hi ha x
            if (monomi.charAt(monomi.length() - 1) == 'x') monomi += "1";

            // Possam un 1 com a nombre si la x no te res davant i un -1 si te un signe -
            if (monomi.charAt(0) == 'x') monomi = "1" + monomi;
            if (monomi.length() > 1 && monomi.substring(0, 2).equals("-x")) monomi = "-1" + monomi.substring(1);

            // Aqui separam els elements del monomi utilitzant la x
            String[] elements = monomi.split("x");

            // Si el grau del monomi es mes gran que els que s'han trobat fins ara, es guarda com a grau maxim
            if (elements.length > 1) {
                grauMax = Math.max(Integer.parseInt(elements[1]), grauMax);
            }

            // Si el polinomi que li passam com a parametre no es null, el replena.
            if (polinomi != null) {
                // Transforma els valors dels elements del monomi a int
                int valor = Integer.parseInt(elements[0]);
                // Nomes agafa el grau si l'array te mes de longitud 1
                int grau = (elements.length > 1) ? Integer.parseInt(elements[1]) : 0;

                // Fica el valor a la possicio corresponent
                polinomi[polinomi.length - grau - 1] += valor;
            }
        }

        return grauMax;
    }

    // Funcio per construir l'array i replenar-lo amb 0
    float[] construeixArray(int grauMax) {
        float[] array = new float[grauMax + 1];

        for (int i = 0; i < grauMax + 1; i++) {
            array[i] = 0;
        }

        return array;
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        // Cream un objecte auxiliar per guardar els resultats
        Polynomial aux = new Polynomial();

        // guardam les longituds dels arrays
        int longitud1 = this.poliArray.length;
        int longitud2 = p.poliArray.length;

        // Cream un array auxiliar per guardar els resultats amb la longitud del polinomi de major grau
        float[] arrayAux = new float[Math.max(longitud1, longitud2)];

        // Sumam el valor dels polinomis al nou array auxiliar. Primer un i despres l'altre
        sumaValor(arrayAux, this.poliArray);
        sumaValor(arrayAux, p.poliArray);

        // Finalment assignam els resultats al objecte auxiliar i el retornam
        aux.poliArray = arrayAux;

        return aux;
    }

    // Funcio per sumar els valors d'un array a un altre.
    void sumaValor(float[] aux, float[] array) {
        // Començam a sumar de dreta a esquerra i tenim en compte la longitud de l'array mes cur
        for (int i = 0; i < array.length; i++) {
            int pos1 = aux.length - 1 - i;
            int pos2 = array.length - 1 - i;
            aux[pos1] += array[pos2];
        }
    }

    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {
        // Cream un objecte auxiliar
        Polynomial aux = new Polynomial();

        // Calulam la nova longitud a partir de la suma dels graus dels altres polinomis
        int longitudNova = this.poliArray.length + p2.poliArray.length - 1;
        float[] resultat = new float[longitudNova];

        for (int i = 0; i < this.poliArray.length; i++) {
            // Funcio que multiplica els valors i els afegeix al resultat. Aquesta funcio multiplica un monomi del
            // polinomi 1 per tots els del polinomi 2
            multiplicarValor(resultat, p2, i);
        }

        // Retorna resultat
        aux.poliArray = resultat;
        return aux;
    }

    // Funcio que multiplica un valor de un polinomi per tots els valors d'un altre.
    void multiplicarValor(float[] resultat, Polynomial p2, int i) {
        for (int j = 0; j < p2.poliArray.length; j++) {
            float coeficient;
            int grauNou;

            // Variables amb els graus dels monomis
            int grau1 = this.poliArray.length - 1 - i;
            int grau2 = p2.poliArray.length - 1 - j;

            // Calula el coeficient i el grau resultant de la multiplicació
            coeficient = this.poliArray[i] * p2.poliArray[j];
            grauNou = grau1 + grau2;

            // Afegeix el coeficient al grau corresponent
            resultat[resultat.length - grauNou - 1] += coeficient;
        }
    }

    // Divideix el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    // Torna el quocient i també el residu (ambdós polinomis)
    public Polynomial[] div(Polynomial p2) {
        // Cream un array d'objectes auxiliar que guardara residu i quocient.
        Polynomial[] aux = new Polynomial[2];
        aux[0] = new Polynomial();
        aux[1] = new Polynomial();

        // Calculam el grau nou amb la resta dels dos graus anteriors.
        int grauNou = Math.abs(this.poliArray.length - p2.poliArray.length) + 1;

        // Crea arrays per al quocient, dividend i divisor. El residu sera lo que quedi del dividend. Ho fa amb una funció
        // per copiar arrays.
        float[] quocient = new float[grauNou];
        float[] dividend = copiaArray(this.poliArray);
        float[] divisor = copiaArray(p2.poliArray);

        for (int i = 0; i < grauNou; i++) {
            // Cada quocient es calcula dividint el terme del dividend al qual ens trobam per el primer del divisor.
            quocient[i] = dividend[i] / divisor[0];
            for (int j = 0; j < divisor.length; j++) {
                // Quan tenim el quocient, el multiplica'm pel divisor i aixo el restam al divididend.
                dividend[j + i] -= quocient[i] * divisor[j];
            }
        }

        // Finalment passam el residu(dividend) i el quocient als objectes auxiliars.
        aux[0].poliArray = quocient;
        aux[1].poliArray = dividend;

        return aux;
    }

    // Funció bàsica per copiar arrays
    private float[] copiaArray(float[] array) {
        float[] resultat = new float[array.length];

        for (int i = 0; i < resultat.length; i++) {
            resultat[i] = array[i];
        }

        return resultat;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        // Aquest array l'he fet per trevallar mes comodament amb this.poliArray
        float[] arrray = this.poliArray;

        // Polinomi sense x (no es un polinomi per tant no te solució)
        if (arrray.length == 1) return null;

        // polinomi de grau 1
        if (arrray.length == 2) {
            return new float[]{-arrray[1] / arrray[0]};
        }

        // Calculam el nombre de monomis del polinomi amb una funció
        int nombreMonomis = treureNombreMonomis();

        // Polinomis que nomes tenen dos monomis;
        if (nombreMonomis == 2) {
            // Funció per calcular arrels de polinomis amb nomes dos monomis
            return nomesDosMonomis(arrray);
        }

        // Polinomis de tres monomis que son de 2n grau o biquadratics.
        if (nombreMonomis == 3) {
            // Segon grau
            if (arrray.length == 3) {
                // Declar aquestes variables amb aquests noms per la formula de la equació quadràtica.
                float a = this.poliArray[0];
                float b = this.poliArray[1];
                float c = this.poliArray[2];

                // Funció per resoldre equacions quadràtiques o de segon grau
                return quadratica(a, b, c);
            }

            // Biquadratics
            if (esBiquadratica()) {
                // Guardam la longitud a una variable
                int longitud = this.poliArray.length;

                float a = this.poliArray[0];
                float b = this.poliArray[(longitud - 1) / 2];
                float c = this.poliArray[longitud - 1];

                // Primer guardam una solució quadràtica a un array que he anomenat "holder" (perque "aguanta" les dades).
                float[] holder = quadratica(a, b, c);

                // Si holder es null vol dir que no hi ha solucions
                if (holder == null) return null;

                // En cas contrari se calculen les solucions restants amb una funció que fa les arrels corresponents
                return calcularBiquadratica(holder, longitud);
            }
        }

        // Ruffini
        return ruffini(arrray);
    }

    // Funció per fer ruffini
    private float[] ruffini(float[] arrray) {
        // Primer copia l'array per poder treballar amb ell. També crea un array on guardar els resultats.
        float[] expressioRufini = copiaArray(arrray);
        float[] resultats = new float[arrray.length - 1];

        for (int i = 0; i < arrray.length - 3; i++) {
            // Les bases son els posibles multiplicadors per ruffini. Aquí es calculen amb una funció
            float[] bases = cercarBase(expressioRufini[expressioRufini.length - 1]);

            // Aquesta funció seria equivalent a fer una ronda de ruffini. Va actualitzant l'expressio i guardant resultats.
            expressioRufini = rondaRuffini(bases, expressioRufini, resultats);
        }

        // Quan acaba ruffini, falten resultats que es calculen despres. Aquests se guarden al següent array.
        float[] resultatsRestants;

        // Si el que queda de fer ruffini es de grau 2 es fa l'equació quadràtica.
        if (expressioRufini.length == 3) {
            float a = expressioRufini[0];
            float b = expressioRufini[1];
            float c = expressioRufini[2];

            resultatsRestants = quadratica(a, b, c);
        } else {
            // Si no, vol dir que nomes te dos monomis i es calcula amb aquesta funció.
            resultatsRestants = nomesDosMonomis(expressioRufini);
        }

        // Si hi ha resultats restants, els afageix a l'array de resultats.
        if (resultatsRestants != null) afegirResultatsRestants(resultatsRestants, resultats);

        // Després lleva zeros a l'array si n'hi ha
        resultats = llevarZerosAlResultat(resultats);

        // Ordena els resultats de menor a major i els retorna
        Arrays.sort(resultats);

        return resultats;
    }

    // Funció bàsica per llevar zeros del resultat.
    private float[] llevarZerosAlResultat(float[] resultats) {
        // Primer compta quant de zeros hi ha.
        int numeroDeZeros = comptarZeros(resultats);

        // Si n'hi ha, fa un bucle introduint to el que no es un zero a un array auxiliar.
        if (numeroDeZeros > 0) {
            float[] resultatSenseZeros = new float[resultats.length - numeroDeZeros];

            for (int i = 0; i < resultats.length; i++) {
                if (resultats[i] != 0) {
                    resultatSenseZeros[i] = resultats[i];
                }
            }
            // Quan acaba el bucle actualitza resultats
            resultats = resultatSenseZeros;
        }

        return resultats;
    }

    // Funció bàsica per comptar zeros.
    private int comptarZeros(float[] resultats) {
        int nZeros = 0;

        for (int i = 0; i < resultats.length; i++) {
            if (resultats[i] == 0) nZeros++;
        }

        return nZeros;
    }

    // Funcio basica que afegeix els resultats restants a on troba un 0
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

    // Funció per fer una ronda de ruffini
    private float[] rondaRuffini(float[] bases, float[] expressioRufini, float[] resultats) {
        for (int i = 0; i < bases.length; i++) {
            // Array auxiliar per poder operar
            float[] arrayAux = copiaArray(expressioRufini);

            // Agafa la primera base
            float base = bases[i];
            boolean baseEnResultat = comprobarResultat(resultats, base);

            // Si aquesta base ja esta dins al resultat, la bota
            if (baseEnResultat) continue;

            // Si no, opera ruffini al array. A cada factor li resta l'anterior per la base.
            for (int j = 1; j < arrayAux.length; j++) {
                arrayAux[j] += base * arrayAux[j - 1];
            }

            // Finalment, si el darrer valor de l'array es 0 guarda el resultat. Si no torna a començar el cicle amb la següent base
            if (arrayAux[arrayAux.length -1] == 0) {
                // Funcio per guardar resultats
                guardarResultat(base, resultats);

                // Funcio per llevar el zero final del resultat.
                arrayAux = llevarZero(arrayAux);

                expressioRufini = arrayAux;
                break;
            }
        }

        return expressioRufini;
    }

    // Funcio per llevar el 0 final a ruffini
    private float[] llevarZero(float[] arrayAux) {
        // Aquesta funció és especifica de ruffini perque nomes lleva el darrer caracter.
        float[] senseZero = new float[arrayAux.length - 1];

        for (int i = 0; i < senseZero.length; i++) {
            senseZero[i] = arrayAux[i];
        }

        arrayAux = senseZero;

        return arrayAux;
    }

    // Funció per guardar el resultat
    private void guardarResultat(float base, float[] resultats) {
        // Nomes guarda el resultat quan troba una posició a l'array amb valor 0.
        for (int i = 0; i < resultats.length; i++) {
            if (resultats[i] == 0) {
                resultats[i] = base;
                break;
            }
        }
    }

    // Aquesta funció comprova si una base està dins els resultats. Determina si pot operar amb ella o no.
    private boolean comprobarResultat(float[] resultados, float base) {
        for (int i = 0; i < resultados.length; i++) {
            if (base == resultados[i]) return true;
        }

        return false;
    }

    // Funció que treu tots els múltiples del número, als quals he anomenat "bases".
    float[] cercarBase(float numero) {
        // Primer determina el numero de bases i després replena un array amb les possibles bases. Si li pasam un array
        // a la funció, el replena i si no nomes retorna el numero de bases.
        int numeroDeBases = treureBases(numero, null);

        // Cream l'array amb el numero de bases determinat i usam la funció anterior per modificar-lo i afegir les bases.
        float[] bases = new float[numeroDeBases * 2];
        treureBases(numero, bases);

        return bases;
    }

    // Funcio per treure les bases
    private int treureBases(float numero, float[] bases) {
        int contador = 0;

        // Ho fa amb el valor absolut del numero perque tenen el matixos multiples i s'eviten iteracions extres.
        numero = Math.abs(numero);

        // Si el residu del numero entre i es 0, llavors es considera que i es multiple del numero. Si li hem passat
        // un array different de null el replena. Si no, només augmenta el comptador.
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

    // Funció per calcular biquadràtiques
    private float[] calcularBiquadratica(float[] holder, int longitud) {
        // Primer determina si es una biquadratica parell o senar.
        if (((longitud - 1) / 2) % 2 == 1) {
            // Si es senar calcula la biquadràtica y retorna un resultat d'una arrel senar
            float[] resultat = new float[holder.length];
            for (int i = 0; i < holder.length; i++) {
                resultat[i] = (float) Math.pow(holder[i], 1f / ((longitud - 1f) / 2f));
            }

            return resultat;
        } else {
            // Si es parell, ha de tornar els possibles resultats que poden ser 2, 1 o ningun.
            int nSolucions = ferArrels(holder, null);

            float[] resultat = new float[nSolucions];

            // Aqui calcula els resultats de l'arrel parell.
            ferArrels(holder, resultat);

            return resultat;
        }
    }

    // Funció per quan només hi ha dos monomis a un polinomi
    private float[] nomesDosMonomis(float[] array) {
        // Determina si el grau es parell o senar.
        boolean parell = this.poliArray.length % 2 == 1;

        // Les que no tenen solucio per que intenten fer una arrel parell d'un nombre negatiu
        if (parell && this.poliArray[poliArray.length - 1] > 0) return null;

        boolean negatiu = false;

        // Determina si el numero es negatiu. Si ho es li canvia el signe abans de operar i després. Això es perque java
        // dona problemes al fer potencies d'un numero negatiu i d'aquesta forma es pot evitar.
        if (-array[array.length - 1] < 0) {
            negatiu = true;
            array[array.length - 1] *= -1;
        }

        // Calcula l'arrel
        float resultado = (float) Math.pow(-array[array.length - 1] / array[0], 1 / (float) (array.length - 1));

        // Tornam canviar el signe si era negatiu.
        if (negatiu) resultado *= -1;

        // si el numero es senar retorna el resultat. Si es parell retorna el resultat amb signe negatiu i positiu.
        if (!parell) {
            return new float[]{resultado};
        } else {
            float[] arrayResultante = {-resultado, resultado};
            Arrays.sort(arrayResultante);
            return arrayResultante;
        }
    }

    // Funció per calcular les arrels de la biquadràtica
    private int ferArrels(float[] holder, float[] resultat) {
        // Primer inicialitza una variable amb el nombre màxim de resultats
        int nResultats = 2 * holder.length;

        for (int i = 0; i < holder.length; i++) {
            // Si el valor de holder[i] es negatiu es descarten dos resultats.
            if (holder[i] < 0) {
                nResultats -= 2;
                continue;
            }

            // Si el valor de holder[i] és 0 es descarta un resultat. S'afegeix el valor al resultat si l'array no es null
            if (holder[i] == 0) {
                nResultats--;
                if (resultat != null) {
                    resultat[i] = 0;
                }
                continue;
            }

            // Si no es cap dels anteriors no es descarta cap resultat. S'afegeixen els valors al resultat si l'array no es null
            if (resultat != null) {
                float whatever = (float) Math.sqrt(holder[i]);
                resultat[2 * i] = whatever;
                resultat[2 * i + 1] = -whatever;
            }
        }

        // Si l'array de resultats no es null, l'ordena
        if (resultat != null) Arrays.sort(resultat);

        return nResultats;
    }

    // Funció per determinar si un polinomi es biquadràtic
    private boolean esBiquadratica() {
        // Si el grau es senar retorna false
        if (this.poliArray.length % 2 == 0) return false;

        // Tenint en compte que nomes poden ser biquadratics polinomis amb 3 monomis, si el d'enmig es 0 no pot ser
        // bicuadràtic.
        if (this.poliArray[(this.poliArray.length - 1) / 2] != 0) {
            return true;
        }

        return false;
    }

    // Funció per polinomis de segon grau.
    private float[] quadratica(float a, float b, float c) {
        // Resultat del que hi ha dins de l'arrel
        float contingutArrel = (float) Math.pow(b, 2) - (4 * a * c);

        // Si el contingut es negatiu no hi ha solucio.
        if (contingutArrel < 0) return null;

        // Si es 0 nomes hi ha una solucio.
        if (contingutArrel == 0) return new float[]{-b / (2 * a)};

        // Finalment calcula les dues solucions si les condicions anteriors no es cumpleixen.
        float[] array = new float[2];

        array[0] = (float) ((-b + Math.sqrt(contingutArrel)) / (2 * a));
        array[1] = (float) ((-b - Math.sqrt(contingutArrel)) / (2 * a));

        Arrays.sort(array);

        return array;
    }

    // Funció per calcular el numero de monomis d'un polinomi
    private int treureNombreMonomis() {
        int resultado = 0;

        // Si un valor de l'array de polinomis es distint a 0 llavors conté un monomi i s'incrementa el comptador.
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
