public class Nombre {
    int valor;

    Nombre(int i) {
        this.valor = i;
    }

    Nombre(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1) {
                if (valorDigitRoma(s.charAt(i + 1)) <= valorDigitRoma(s.charAt(i))) {
                    result += valorDigitRoma(s.charAt(i));
                } else {
                    int n = valorDigitRoma(s.charAt(i + 1)) - valorDigitRoma(s.charAt(i));
                    result += n;
                    i++;
                }
            } else {
                result += valorDigitRoma(s.charAt(i));
            }
        }
        this.valor = result;
    }

    private int valorDigitRoma(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    String hex() {
        String binari = this.bin();
        binari = ompleZeros(binari);
        String result = "";
        for (int i = 0; i < binari.length() / 4; i++) {
            String bloque = binari.substring(i*4, i*4+4);
            result = result + getHexDigit(bloque);
        }
        return result;
    }

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

    private String getHexDigit(String bloque) {
        switch (bloque) {
            case "0000": return "0";
            case "0001": return "1";
            case "0010": return "2";
            case "0011": return "3";
            case "0100": return "4";
            case "0101": return "5";
            case "0110": return "6";
            case "0111": return "7";
            case "1000": return "8";
            case "1001": return "9";
            case "1010": return "A";
            case "1011": return "B";
            case "1100": return "C";
            case "1101": return "D";
            case "1110": return "E";
            case "1111": return "F";
        }
        return "X";
    }

    String bin() {
        String resultat = "";
        for (int n = this.valor; n > 0; n = n >> 1) {
            resultat = ((n & 1) == 0) ? "0" + resultat : "1" + resultat;
        }
        return resultat;
    }
}
