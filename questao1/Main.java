import java.util.Scanner;

public class Main {
    public static int contarOcorrencias(int N, int K) {
        if (N == 0) {
            return 0;
        }
        if (N % 10 == K) {
            return 1 + contarOcorrencias(N / 10, K);
        } else {
            return contarOcorrencias(N / 10, K);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite N: ");
        int N = scanner.nextInt();

        System.out.print("Digite K: ");
        int K = scanner.nextInt();

        int contagem = contarOcorrencias(N, K);
        System.out.println("O dígito " + K + " ocorre " + contagem + " vezes em " + N + ".");

        scanner.close();
    }
}
