public class Exercici_9 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(a == b);

    }
    /*
    El codi anterior imprimiria "false". Això es deu a que estam comparant objectes i "==" nomes serveix per comparar
    tipus primitius. Quan comparam objectes amb "==" mai sirán iguals perque els objectes en si són diferents.
     */

}
