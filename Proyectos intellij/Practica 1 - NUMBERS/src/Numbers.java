public class Numbers {
    public static String say(long n) {
        // Pasamos el numero a array de int y metemos la longitud del mismo en una variable.
        int[] digits = convertirArray(n);
        int longitudNumero = cifrasNumero(digits);

        // Declaramos la variable "resultado".
        String resultado = "";

        // Si "n" vale 0 entonces el resultado sera "zero". Si no, creamos la string correspondiente.
        if (n == 0) {
            resultado = "zero";
        } else {
            resultado = añadirSufijos(longitudNumero, digits);
        }

        // Esto elimina el posible espacio del final en el resultado.
        if (resultado.substring(resultado.length() - 1).equals(" ")) {
            resultado = resultado.substring(0, resultado.length() - 1);
        }
        return resultado.substring(0, 1).toUpperCase() + resultado.substring(1);
    }

    public static long words(String s) {
        int longitud = s.length() - 1;

        s = s.replace(" and", "");
        s = s.replace("-", " ");
        s = s.toLowerCase();

        String[] cadenaSeparada = s.split(" ");

        long numero = 0;
        long resultado = 0;

        for (int i = 0; i < cadenaSeparada.length; i++) {
            if (!potencias(cadenaSeparada[i])) {
                if (cadenaSeparada[i].equals("hundred")) {
                    numero *= 100;
                } else if (cadenaSeparada[i].endsWith("ty")) {
                    numero += tenMultiplesWords(cadenaSeparada[i]);
                } else {
                    numero += zeroToNineteenWords(cadenaSeparada[i]);
                }
            } else {
                resultado += multiplicarPorPotencia(numero, cadenaSeparada[i]);
                numero = 0;
            }
        }

        resultado += numero;

        return resultado;
    }

    private static int zeroToNineteenWords(String word) {
        String[] array0_19 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        int pos = 0;

        while (pos < array0_19.length) {
            if (word.equals(array0_19[pos])) {
                break;
            }
            pos++;
        }

        return pos;
    }

    private static int tenMultiplesWords(String word) {
        String[] array20_90 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int pos = 0;

        while (pos < array20_90.length) {
            if (word.equals(array20_90[pos])) {
                break;
            }
            pos++;
        }

        return (pos + 2) * 10;
    }

    private static boolean potencias(String word) {
        String[] sufijos = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

        boolean potencia = false;

        for (int i = 0; i < sufijos.length; i++) {
            if (word.equals(sufijos[i])) {
                potencia = true;
            }
        }

        return potencia;
    }

    private static long multiplicarPorPotencia(long numero, String potencia) {
        String[] sufijos = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

        for (int i = 0; i < sufijos.length; i++) {
            if (sufijos[i].equals(potencia)) {
                numero *= Math.pow(10, i * 3);
            }
        }

        return numero;
    }

    // Función para añadir los sufijos (hundred, million, etc.).
    private static String añadirSufijos(int longitudNumero, int[] array) {
        // Array con los sufijos.
        String[] sufijos = {"", " thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion "};

        StringBuilder resultado = new StringBuilder();

        // Esta variable indica en el grupo de 3 en el que nos encontramos. Miles, Millones, Centenares, etc. En la
        // variable he añadido un -1 para que redondee siempre hacia abajo. Si no, saldria que tres cifras de mil
        // equivale a millones.
        int fase = (longitudNumero - 1) / 3;

        // Este loop va haciendo los numeros tantas veces como grupos de 3 tengamos.
        while (longitudNumero > 0) {
            // Llamamos a la función para construir el numero.
            resultado.append(sacarCentenas(longitudNumero, array));

            // Mete el sufijo solo si alguno de los 3 valores no es 0. Esto es para evitar que salga un "zero million",
            // por ejemplo.
            if (longitudNumero > 3 && array[array.length - longitudNumero] + array[array.length - longitudNumero + 1] +
                    array[array.length - longitudNumero + 2] != 0) {
                resultado.append(sufijos[fase]);
            }

            // Si después del thousand no hay centenas, pero si decenas o unidades, entonces pone "and".
            if (fase == 1 && (array[array.length - 3] == 0 && array[array.length - 1] + array[array.length - 2] != 0)) {
                resultado.append("and ");
            }

            // Pasamos a la siguiente fase y calculamos la longitud del numero que nos falta.
            fase--;
            int resto = (longitudNumero % 3);
            if (resto == 0) {
                resto = 3;
            }
            longitudNumero -= resto;
        }

        // Es importante convertir el resultado a String porque lo tenia en StringBuilder.
        return resultado.toString();
    }

    // Funcion para construir cada numero en grupos de 3 (centenas, decenas y unidades).
    private static String sacarCentenas(int longitudNumero, int[] array) {
        // Primero declaramos todas las variables que vamos a utilizar.
        String centenas = "";
        String decenunidades = "";
        String decenas = "";
        String unidades = "";
        String resultado = "";


        // Cifra de las centenas
        if (longitudNumero % 3 == 0) {
            // Unicamente si hay un valor en la posicion de las centenas añade "hundred".
            if (array[array.length - longitudNumero] != 0) {
                centenas = zeroToNineteen((int) array[array.length - longitudNumero]) + " hundred";
                resultado = centenas;

                // Añade un and si los digitos de despues no son 0.
                if (array[array.length - longitudNumero + 1] + array[array.length - longitudNumero + 2] != 0) {
                    resultado = resultado + " and ";
                }
            }
            // Pasa a la siguiente cifra
            longitudNumero--;
        }

        long decenasyUnidades = 0;

        // Esta parte es por si las decenas y unidades son del 0 al 19, ya que tienen un nombre único.
        if (longitudNumero % 3 == 2) {
            decenasyUnidades = (array[array.length - longitudNumero] * 10) + array[array.length - longitudNumero + 1];
        }

        // Si se cumple la condicion entonces añade del 0 al 19.
        if (decenasyUnidades < 20 && decenasyUnidades > 0) {
            decenunidades = zeroToNineteen((int) decenasyUnidades);
            resultado = resultado + decenunidades;
        } else {
            // Si la condición no se cumple, crea las decenas.
            if (array[array.length - longitudNumero] != 0 && longitudNumero % 3 == 2) {
                decenas = tenMultiples(array[array.length - longitudNumero]);
                resultado = resultado + decenas;

                // Si despues de las decenas el valor es != 0 entonces añade "-".
                if (array[array.length - longitudNumero + 1] != 0) {
                    resultado = resultado + "-";
                }

                // Pasa a la siguiente cifra.
                longitudNumero--;
            }

            // Finalmente añade las unidades en caso de que el valor sea diferente a 0.
            if (array[array.length - longitudNumero] != 0 && longitudNumero % 3 == 1) {
                unidades = zeroToNineteen((int) array[array.length - longitudNumero]);
            }
            resultado = resultado + unidades;
        }

        // Devuelve el resultado.
        return resultado;
    }

    // Funcion que determina cuantas cifras tiene el número introducido en la función principal.
    private static int cifrasNumero(int[] arrayDigits) {
        int longitudNumero = 0;

        // En este ciclo se comprueba posicion por posicion si hay ceros o no. Una vez que encuentra algo diferente a
        // cero se detiene y ya tiene la longitud del numero.
        for (int i = 0; i < arrayDigits.length; i++) {
            longitudNumero = arrayDigits.length - i;
            if (arrayDigits[i] != 0) {
                break;
            }
        }

        // Devuelve el resultado
        return longitudNumero;
    }

    // Funcion que convierte el numero en un array de int.
    private static int[] convertirArray(long n) {
        // Crea el array de el numero maximo de posiciones (quintillion).
        int[] array = new int[21];

        // En este ciclo se divide el numero entre la potencia de 10^i. Si el resultado es cero divide entre una
        // potencia mas pequeña. Si es distinto a cero, asigna ese valor a su correspondiente posición en el array y
        // cambia el numero por el resto de la división. Vuelve a operar hasta que recorre todas las posiciones.
        for (int i = array.length; i > 0; i--) {
            long potencia = (long) Math.pow(10, i - 1);
            if (n / potencia != 0) {
                array[array.length - i] = (int) (n / potencia);
                n = n % potencia;
            } else {
                array[array.length - i] = 0;
            }
        }

        // Devuelve resultado.
        return array;
    }

    // Esta función selecciona del array de strings el numero del 0 - 19 que corresponda segun la variable introducida.
    private static String zeroToNineteen(int n) {
        String[] array0_19 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        return array0_19[n];
    }

    // Esta funcion devuelve los multiplos de 10 (20, 30, ...90) segun la variable introducida.
    private static String tenMultiples(int n) {
        n = n - 2;

        String[] array20_90 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        return array20_90[n];
    }
}

