import java.sql.SQLOutput;

public class Operadores {
    public static void main(String[] args) {
        // Precedencia de una operacion es la que tiene preferencia
        int x = 1 + 3 * 6 - 7;
        int y = (1 + 3) * (6 - 7);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        /*
            Operadors bàsics +,-,*,/ y %(modulo o residuo)
            Divisio entre enters trunca el resultat
            Shorthands: +=, -=, *=, etc.
            Operadors "unaris". x = a * (-1)
            operadors autoincrement/decrement
                ++a, --a
                a++, a--
        */
        /*
            Operadores relacionales
                Rsultado booleANO
                <,>,<=,>=,== y !=
                == i != funcionan distinto cuando se orienta a objetos. No tiene en cuenta
                    los valores si no las referencias. Por ejemplo Srings.
         */
        /* Operadores lógicos
            &&, ||, !
         */
        /*
            asdf
         */

        String s1 = "Tu edad es: ";
        int num = 19;
        String s2 = s1 + num;
        System.out.println(s2);
    }
}
