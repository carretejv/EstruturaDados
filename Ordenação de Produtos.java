import java.util.Arrays;
import java.util.Comparator;

public class Teste {

    public static void main(String[] args) {
        // Criando o array de produtos
        Produto[] produtos = new Produto[]{
            new Produto(105, "Teclado", 129.90),
            new Produto(101, "Mouse", 59.90),
            new Produto(110, "Notebook", 3500.00),
            new Produto(102, "Monitor", 899.00),
            new Produto(109, "Webcam", 199.90),
            new Produto(106, "Caixa Som", 89.90),
            new Produto(108, "Cabo USB", 25.00),
            new Produto(103, "Pen Drive", 49.90),
            new Produto(107, "HD Externo", 320.00),
            new Produto(104, "Mousepad", 29.90)
        };

        System.out.println("== PRODUTOS ORDENADOS POR CÓDIGO ==");
        Arrays.sort(produtos, new ComparatorCodigo());
        exibirProdutos(produtos);

        System.out.println("\n== PRODUTOS ORDENADOS POR VALOR ==");
        Arrays.sort(produtos, new ComparatorValor());
        exibirProdutos(produtos);
    }

    // Método para exibir os produtos
    private static void exibirProdutos(Produto[] produtos) {
        for (Produto produto : produtos) {
            System.out.printf("Código: %d | Nome: %-10s | Valor: R$ %.2f\n", 
                produto.getCodigo(), produto.getNome(), produto.getValor());
        }
    }
}

// Classe Produto
class Produto {
    private int codigo;
    private String nome;
    private double valor;

    public Produto(int codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}

// Comparator para ordenar por código
class ComparatorCodigo implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Integer.compare(p1.getCodigo(), p2.getCodigo());
    }
}

// Comparator para ordenar por valor
class ComparatorValor implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getValor(), p2.getValor());
    }
}
