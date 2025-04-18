import java.util.Scanner;

class Nodo {
    int dado;
    Nodo proximo;

    public Nodo(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class PilhaEncadeada {
    private Nodo topo;

    public PilhaEncadeada() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        novoNodo.proximo = topo;
        topo = novoNodo;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        int valor = topo.dado;
        topo = topo.proximo;
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return topo.dado;
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        Nodo temp = topo;
        System.out.print("Pilha: ");
        while (temp != null) {
            System.out.print(temp.dado + " ");
            temp = temp.proximo;
        }
        System.out.println();
    }
}

public class TestePilhaEncadeada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaEncadeada pilha = new PilhaEncadeada();
        
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
                    System.out.println("Elemento removido: " + pilha.pop());
                    break;
                case 3:
                    System.out.println("Topo da pilha: " + pilha.peek());
                    break;
                case 4:
                    pilha.imprimirPilha();
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
