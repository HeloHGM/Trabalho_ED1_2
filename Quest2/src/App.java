// Questão 2

// O máximo divisor comum (MDC) de dois números inteiros x e y pode ser calculado usando-se uma definição recursiva:

// 	•	MDC(x, y) = MDC(x − y, y), se x > y
// 	•	MDC(x, y) = MDC(y, x)
// 	•	MDC(x, x) = x

import java.util.Scanner;

public class App {
    public static int mdc(int x, int y) {
        if (x == y) {
            return x;
        } else if (x > y) {
            return mdc(x - y, y);
        } else {
            return mdc(y, x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o primeiro número: ");
        int x = scanner.nextInt();
        
        System.out.print("Digite o segundo número: ");
        int y = scanner.nextInt();
        
        scanner.close();
        
        System.out.println("MDC de " + x + " e " + y + " é: " + mdc(x, y));
    }
}
