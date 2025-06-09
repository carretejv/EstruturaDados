public class BuscaBinariaExemplo {
    public static int buscar(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                return meio; // encontrado
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1; // não encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 8, 15, 23, 42, 56};
        int resultado = buscar(numeros, 15);
        System.out.println("Índice encontrado: " + resultado);
    }
}