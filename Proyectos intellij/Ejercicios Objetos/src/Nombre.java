public class Nombre {
    int valor;

    // Constructor base decimal
    Nombre(int i) {
        this.valor = i;
    }

    // Constructor nombres romans
    Nombre(String s) {
        int result = 0;
        int darrer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Se suma el nombre actual al resultat
            int actual = valorDigitRoma(c);
            result += actual;

            // Si aquest nombre es mes gran que l'anterior, es resten dues vegades l'anterior
            if (darrer > 0 && darrer < actual) {
                result -= darrer * 2;
            }

            // L'actual pasa a ser el darrer nombre despres de cada iteracio
            darrer = actual;
        }

        // S'asigna el resultat al valor de l'objecte
        this.valor = result;
    }

    // Funcio que retorna el valor de cada digit del nombre romà
    private int valorDigitRoma(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    // Funcio que torna this.valor a hexadecimal
    String hex() {
        String binari = this.bin();
        binari = ompleZeros(binari);
        String result = "";
        for (int i = 0; i < binari.length() / 4; i++) {
            String bloque = binari.substring(i * 4, i * 4 + 4);
            result = result + getHexDigit(bloque);
        }
        return result;
    }

    // Funcio que omple amb zeros a l'esquerra un numero per passar-lo a hexadecimal
    private String ompleZeros(String binari) {
        int binLength = binari.length();
        if (binLength % 4 != 0) {
            int n = 4 - (binLength % 4);
            for (int i = 0; i < n; i++) {
                binari = "0" + binari;
            }
        }
        return binari;
    }

    // Funció que torna el valor en hexadecimal d'un bloc de quatre digits en binari
    private String getHexDigit(String bloque) {
        switch (bloque) {
            case "0000":
                return "0";
            case "0001":
                return "1";
            case "0010":
                return "2";
            case "0011":
                return "3";
            case "0100":
                return "4";
            case "0101":
                return "5";
            case "0110":
                return "6";
            case "0111":
                return "7";
            case "1000":
                return "8";
            case "1001":
                return "9";
            case "1010":
                return "A";
            case "1011":
                return "B";
            case "1100":
                return "C";
            case "1101":
                return "D";
            case "1110":
                return "E";
            case "1111":
                return "F";
        }
        return "X";
    }

    // Funcio que torna this.valor a binari
    String bin() {
        String resultat = "";
        for (int n = this.valor; n > 0; n = n >> 1) {
            resultat = ((n & 1) == 0) ? "0" + resultat : "1" + resultat;
        }
        return resultat;
    }
}
