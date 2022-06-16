import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Tablero {
    private char[][] valores;
    private char turn;

    public Tablero () {
        this.valores = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        this.turn = 'X';
    }

    public Tablero (String s) {
        this.valores = new char[3][3];
        List<Character> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            String character = (c + "").toUpperCase(Locale.ROOT);
            String variables = "OX ";

            if (variables.contains(character)) list.add(character.charAt(0));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.valores[i][j] = list.get(i*3 + j);
            }
        }

        this.turn = checkTurn(list);
    }

    private char checkTurn(List<Character> list) {
        char result = 0;
        int nX = 0;
        int nO = 0;

        for (int i = 0; i < 9; i++) {
            char c = list.get(i);
            if (c != ' ') {
                if (c == 'X') nX++;
                else nO++;
            }
        }

        if (nX == nO) return 'X';
        else return 'O';
    }

    public char getElement(int fila, int columna) {
        return valores[fila][columna];
    }

    public void setElement(int fila, int columna, char c) {
        String variables = "OX ";
        String character = (c + "").toUpperCase(Locale.ROOT);

        if (variables.contains(character)) {
            if (valores[fila][columna] == ' ') valores[fila][columna] = character.charAt(0);
            else System.out.println("Casilla ya ocupada");
        } else {
            System.out.println("Caracter introducido no válido");
        }
    }

    public char guessWinner() {
        char c = checkVertical();
        if (c != ' ') return c;

        c = checkHorizontal();
        if (c != ' ') return c;

        return checkDiagonal();
    }

    private char checkVertical() {
        String check = "";
        for (int i = 0; i < 3; i++) {
            boolean alreadyPlaced = false;
            for (int j = 0; j < 3; j++) {
                if (valores[j][i] == ' ') {
                    if (!alreadyPlaced) {
                        check += this.turn;
                        alreadyPlaced = true;
                    }
                    else {
                        break;
                    }
                }
                else check += valores[j][i];
            }

            if (check.equals("XXX") || check.equals("OOO")) {
                return check.charAt(0);
            }

            check = "";
        }

        return ' ';
    }

    private char checkHorizontal() {
        String check = "";
        for (int i = 0; i < 3; i++) {
            boolean alreadyPlaced = false;
            for (int j = 0; j < 3; j++) {
                if (valores[i][j] == ' ') {
                    if (!alreadyPlaced) {
                        check += this.turn;
                        alreadyPlaced = true;
                    }
                    else {
                        break;
                    }
                }
                else check += valores[i][j];
            }

            if (check.equals("XXX") || check.equals("OOO")) {
                return check.charAt(0);
            }

            check = "";
        }

        return ' ';
    }

    private char checkDiagonal() {
        String check = "";
        boolean alreadyPlaced = false;
        for (int i = 0; i < 3; i++) {
            if (valores[i][i] == ' ') {
                if (!alreadyPlaced) {
                    check += this.turn;
                    alreadyPlaced = true;
                }
                else break;
            } else check += valores[i][i];
        }

        if (check.equals("XXX") || check.equals("OOO")) return check.charAt(0);
        alreadyPlaced = false;
        check = "";

        for (int i = 0; i < 3; i++) {
            if (valores[i][Math.abs(i - 2)] == ' ') {
                if (!alreadyPlaced) {
                    check += this.turn;
                    alreadyPlaced = true;
                }
                else break;
            } else check += valores[i][Math.abs(i - 2)];
        }

        if (check.equals("XXX") || check.equals("OOO")) return check.charAt(0);
        return ' ';
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += valores[i][j];
                if (j != 2) result += "|";
            }

            result += "\n";
        }

        result += "\nTurn: " + this.turn + "\n";

        return result;
    }
}
