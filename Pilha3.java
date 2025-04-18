import java.util.Scanner;
import java.util.Stack;

public class PilhaJavaUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        while (true) {
            System.out.println("\n1 - Inserir elemento na pilha");
            System.out.println("2 - Remover elemento da pilha");
            System.out.println("3 - Mostrar topo da pilha");
            System.out.println("4 - Imprimir pilha");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    int elemento = scanner.nextInt();
                    pilha.push(elemento);
                    break;
                case 2:
                    if (!pilha.isEmpty()) {
                        System.out.println("Elemento removido: " + pilha.pop());
                    } else {
                        System.out.println("Erro: Pilha vazia!");
                    }
                    break;
                case 3:
                    if (!pilha.isEmpty()) {
                        System.out.println("Topo da pilha: " + pilha.peek());
                    } else {
                        System.out.println("Erro: Pilha vazia!");
                    }
                    break;
                case 4:
                    System.out.println("Pilha atual: " + pilha);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
