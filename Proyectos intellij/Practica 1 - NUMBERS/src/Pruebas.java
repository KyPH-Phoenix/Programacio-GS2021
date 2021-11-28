import java.util.Arrays;
//
public class Pruebas {
    public static void main(String[] args) {
        long n = 543_432L;
        int[] array = convertirArray(n);
        int variableCualquiera = cifrasNumero(array);

        System.out.println(Arrays.toString(array));
        System.out.println(variableCualquiera);

        String cadena = "Hola cara-pan";
        char[] cadenaCompleta = cadena.toCharArray();
        String[] separado = new String[3];
        for (int i = 0; i < separado.length; i++) {
            String variableProvis = "";
            for (int j = 0; j < cadenaCompleta.length; j++) {
                if (cadenaCompleta[j] == ' ' || cadenaCompleta[j] == '-') {
                    separado[i] = variableProvis;
                    variableProvis = "";
                } else {
                    variableProvis = variableProvis + cadenaCompleta[i];
                }
            }
        }

        String resultado = "";

        if (n == 0) {
            resultado = "zero";
        } else {
            resultado = añadirSufijos(variableCualquiera, array);
        }

        System.out.println(resultado.substring(0,1).toUpperCase() + resultado.substring(1));
    }

    private static String añadirSufijos (int longitudNumero, int[] array) {
        String[] sufijos = {"", " thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion "};

        StringBuilder resultado = new StringBuilder();

        int fase = (longitudNumero - 1) / 3;

        while (longitudNumero > 0) {
            resultado.append(sacarCentenas(longitudNumero, array));
            // Mete el sufijo solo si alguno de los 3 valores no es 0
            if (longitudNumero > 3 && array[array.length - longitudNumero] + array[array.length - longitudNumero + 1] + array[array.length - longitudNumero + 2] != 0) {
                resultado.append(sufijos[fase]);
            }

            // Si después del thousand no hay centenas, pero si decenas o unidades, entonces pone "and".
            if (fase == 1 && (array[array.length -3] == 0 && array[array.length - 1] + array[array.length - 2] != 0)) {
                resultado.append("and ");
            }

            fase--;
            int resto = (longitudNumero % 3);
            if (resto == 0) {
                resto = 3;
            }
            longitudNumero -= resto;
        }

        return resultado.toString();
    }

    private static String sacarCentenas(int longitudNumero, int[] array) {
        String centenas = "";
        String decenunidades = "";
        String decenas = "";
        String unidades = "";

        String resultado = "";


        // Cifra de las centenas
        if (longitudNumero % 3 == 0) {
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

        if (longitudNumero % 3 == 2) {
            decenasyUnidades = (array[array.length - longitudNumero] * 10) + array[array.length - longitudNumero + 1];
        }

        if (decenasyUnidades < 20 && decenasyUnidades > 0) {
            decenunidades = zeroToNineteen((int) decenasyUnidades);
            resultado = resultado + decenunidades;
        } else {
            if (array[array.length - longitudNumero] != 0 && longitudNumero % 3 == 2) {
                decenas = tenMultiples(array[array.length - longitudNumero]);
                resultado = resultado + decenas;
                if (array[array.length - longitudNumero + 1] != 0) {
                    resultado = resultado + "-";
                }
                longitudNumero--;
            }

            if (array[array.length - longitudNumero] != 0 && longitudNumero % 3 == 1) {
                unidades = zeroToNineteen((int) array[array.length - longitudNumero]);
            }
            resultado = resultado + unidades;
        }

        return resultado;
    }

    private static int cifrasNumero(int[] arrayDigits) {
        int longitudNumero = 0;

        for (int i = 0; i < arrayDigits.length; i++) {
            longitudNumero = arrayDigits.length - i;
            if (arrayDigits[i] != 0) {
                break;
            }
        }

        return longitudNumero;
    }

    private static int[] convertirArray(long n) {
        int[] array = new int[21];

        for (int i = array.length; i > 0; i--) {
            long potencia = (long) Math.pow(10, i - 1);
            if ((n / potencia) != 0) {
                array[array.length - i] = (int) (n / potencia);
                n =(n % potencia);
            } else {
                array[array.length - i] = 0;
            }
        }
        return array;
    }

    private static String zeroToNineteen(int n) {
        String[] array0_19 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        return array0_19[n];
    }

    private static String tenMultiples(int n) {
        n = (n) - 2;

        String[] array20_90 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        return array20_90[n];
    }
}
