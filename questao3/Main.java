import java.util.Scanner;

public class Main {
    public static int mod(int x, int y) {
        // se x == y, retorna 0
        if (x == y) {
            return 0;
        }
        // se x < y, retorna x
        if (x < y) {
            return x;
        }
        // se x > y, chama mod com (x - y, y)
        return mod(x - y, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x: ");
        int x = scanner.nextInt();

        System.out.print("y: ");
        int y = scanner.nextInt();

        int resultado = mod(x, y);
        System.out.println("MOD(" + x + ", " + y + ") = " + resultado);

        scanner.close();
    }
}

