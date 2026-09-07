import java.util.Scanner;

class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    // Construtor
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getImc() { return imc; }

    // Método para calcular o IMC
    public void calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }

    // Método para informar a faixa de obesidade
    public String informaObesidade() {
        if (this.imc < 18.5) return "Abaixo do peso";
        if (this.imc <= 24.9) return "Peso normal";
        if (this.imc <= 29.9) return "Sobrepeso";
        if (this.imc <= 34.9) return "Obesidade grau 1";
        if (this.imc <= 39.9) return "Obesidade grau 2";
        return "Obesidade grau 3";
    }
}

public class MainPessoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de IMC ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Altura (ex: 1.75): ");
        double altura = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso (ex: 70.5): ");
        double peso = Double.parseDouble(scanner.nextLine());

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);
        pessoa.calculaIMC();

        System.out.printf("\n%s %s, seu IMC é: %.2f\n", pessoa.getNome(), pessoa.getSobrenome(), pessoa.getImc());
        System.out.println("Classificação: " + pessoa.informaObesidade());
        
        scanner.close();
    }
}
