
// Questão 4

// Um problema típico em ciência da computação consiste em converter um número da sua forma decimal para a forma binária.

import java.util.Scanner;

public class App {
  public static String decimalParaBinario(int n) {
      if (n == 0) {
          return "";
      } else {
          return decimalParaBinario(n / 2) + (n % 2);
      }
  }

  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      System.out.print("Digite o número: ");
      int numero = scanner.nextInt();

      System.out.println("Binário de " + numero + " é: " + decimalParaBinario(numero));
      scanner.close();
  }
}