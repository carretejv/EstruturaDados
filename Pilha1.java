import java.util.Scanner;

class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Indica que a pilha está vazia
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1; // Indicativo de erro
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public int size() {
        return topo + 1;
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a capacidade da pilha: ");
        int capacidade = scanner.nextInt();
        Pilha pilha = new Pilha(capacidade);
        
        while (true) {
            System.out.println("\n1 - Inserir elemento na pilha");
            System.out.println("2 - Remover elemento da pilha");
            System.out.println("3 - Mostrar topo da pilha");
            System.out.println("4 - Mostrar tamanho da pilha");
            System.out.println("5 - Imprimir pilha");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    int elemento = scanner.nextInt();
                    pilha.push(elemento);
                    break;
                case 2:
                    System.out.println("Elemento removido: " + pilha.pop());
                    break;
                case 3:
                    System.out.println("Topo da pilha: " + pilha.peek());
                    break;
                case 4:
                    System.out.println("Tamanho da pilha: " + pilha.size());
                    break;
                case 5:
                    pilha.imprimirPilha();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
