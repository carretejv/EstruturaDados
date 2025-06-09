class No {
    int valor;
    No esquerda, direita;
    
    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    private No raiz;
    
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }
    
    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);
        if (valor < atual.valor) atual.esquerda = inserirRec(atual.esquerda, valor);
        else atual.direita = inserirRec(atual.direita, valor);
        return atual;
    }
    
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }
    
    private boolean buscarRec(No atual, int valor) {
        if (atual == null) return false;
        if (valor == atual.valor) return true;
        return valor < atual.valor
            ? buscarRec(atual.esquerda, valor)
            : buscarRec(atual.direita, valor);
    }
    
    public void emOrdem() {
        emOrdemRec(raiz);
    }
    
    private void emOrdemRec(No atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.print(atual.valor + " ");
            emOrdemRec(atual.direita);
        }
    }
}

public class TesteArvore {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(40);
        arvore.inserir(20);
        arvore.inserir(60);
        arvore.inserir(10);
        arvore.inserir(30);
        
        arvore.emOrdem(); // saída: 10 20 30 40 60
        System.out.println("\nBusca 30: " + arvore.buscar(30)); // true
    }
}