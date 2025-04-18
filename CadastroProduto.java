import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome='" + nome + '\'' + ", quantidade=" + quantidade + '}';
    }
}

class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(int codigo, String nome, int quantidade) {
        produtos.add(new Produto(codigo, nome, quantidade));
    }

    public boolean removerProduto(int codigo) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getCodigo() == codigo) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Produto buscarPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public Produto buscarPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        
        estoque.adicionarProduto(1, "Arroz", 10);
        estoque.adicionarProduto(2, "Feijão", 20);
        estoque.adicionarProduto(3, "Macarrão", 15);
        
        System.out.println("Lista de produtos:");
        estoque.listarProdutos();
        
        System.out.println("\nBuscando produto pelo código 2:");
        System.out.println(estoque.buscarPorCodigo(2));
        
        System.out.println("\nBuscando produto pelo nome 'Macarrão':");
        System.out.println(estoque.buscarPorNome("Macarrão"));
        
        System.out.println("\nRemovendo produto com código 1");
        estoque.removerProduto(1);
        estoque.listarProdutos();
    }
}
