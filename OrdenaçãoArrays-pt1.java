import java.util.Arrays;
import java.util.Scanner;

public class OrdenaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];

        // Entrada de dados
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }

        // Ordena os números em ordem crescente
        Arrays.sort(numeros);

        // Exibe os números ordenados
        System.out.println("\nNúmeros em ordem crescente:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
