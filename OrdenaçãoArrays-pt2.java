import java.util.*;

class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class ProdutosOrdenados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[10];

        // Entrada de dados
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o preço do produto " + (i + 1) + ": ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Consumir quebra de linha
            produtos[i] = new Produto(nome, preco);
        }

        // Ordena os produtos do mais caro ao mais barato
        Arrays.sort(produtos, (p1, p2) -> Double.compare(p2.preco, p1.preco));

        // Exibe os produtos ordenados
        System.out.println("\nProdutos do mais caro ao mais barato:");
        for (Produto p : produtos) {
            System.out.printf("%s - R$ %.2f\n", p.nome, p.preco);
        }

        scanner.close();
    }
}
