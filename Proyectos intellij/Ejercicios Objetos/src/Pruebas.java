public class Pruebas {
    public static void main(String[] args) {
        String s = "XIV";
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
        System.out.println(result);
    }

    static private int valorDigitRoma(char c) {
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
}
