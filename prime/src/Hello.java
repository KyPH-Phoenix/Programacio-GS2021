public class Hello {
    public static void main(String[] args) {
        int[] numbers = {8, 7, 5, 19, 5};
        int x = 0;
        int men = numbers[0];
        int may = numbers[0];
        while (x<=4) {
            System.out.println(numbers[x]);
            if (numbers[x]>may)
                may = numbers[x];
            else if (numbers[x]<men);
                men = numbers[x];
            x++;
        }
        System.out.println(" ");
        System.out.println("El mayor es: " + may);
        System.out.println("El menor es: " + men);
    }
}
