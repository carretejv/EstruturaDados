public class Paciente {
    private int numero;
    private double peso;
    private double altura;

    public Paciente(int numero, double peso, double altura) {
        this.numero = numero;
        this.peso = peso;
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void listarPaciente() {
        System.out.println("Número: " + numero + ", Peso: " + peso + ", Altura: " + altura);
    }

    @Override
    public String toString() {
        return numero + "," + peso + "," + altura;
    }
}
