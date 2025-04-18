class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    // Construtor da pilha, inicializa com uma capacidade especificada
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Indica pilha vazia
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Método para verificar se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    // Método para empilhar um elemento
    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    // Método para desempilhar um elemento
    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1; // Retorna -1 indicando erro
        }
        return elementos[topo--];
    }

    // Método para visualizar o elemento do topo da pilha
    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1; // Retorna -1 indicando erro
        }
        return elementos[topo];
    }

    // Método para imprimir os elementos da pilha
    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        // Empilhando elementos
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        // Imprimindo a pilha
        pilha.imprimirPilha();

        // Exibindo o topo da pilha
        System.out.println("Topo da pilha: " + pilha.peek());

        // Desempilhando o topo
        System.out.println("Removendo: " + pilha.pop());

        // Imprimindo a pilha após remoção
        pilha.imprimirPilha();
    }
}


