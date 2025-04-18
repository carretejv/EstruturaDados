public class Paciente {
    private int id;
    private String nome;
    private double peso;
    private double altura;
    private int sexo;

    public Paciente(int id, String nome, double peso, double altura, int sexo) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        String sexoStr = (sexo == 1) ? "Masculino" : "Feminino";
        return "ID: " + id + ", Nome: " + nome + ", Peso: " + peso + ", Altura: " + altura + ", Sexo: " + sexoStr;
    }
}
