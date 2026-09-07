import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Aluno {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String codigoMatricula;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;

    public Aluno(String nome, String sobrenome, LocalDate dataNascimento, int coragem, int inteligencia, int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getCasa() { return casa; }

    public int calcularIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    public String formatarCasa() {
        return this.casa != null ? this.casa.toUpperCase() : "NÃO DEFINIDA";
    }

    public String gerarNomeUsuario() {
        String inicial = this.nome.substring(0, 1).toLowerCase();
        String sobrenomeFormatado = this.sobrenome.replaceAll("\\s+", "").toLowerCase();
        return inicial + sobrenomeFormatado;
    }

    public void gerarCodigoMatricula(int posicao) {
        String iniciais = this.nome.substring(0, 1).toUpperCase() + this.sobrenome.substring(0, 1).toUpperCase();
        int ano = LocalDate.now().getYear();
        this.codigoMatricula = String.format("%s-%d-%02d", iniciais, ano, posicao);
    }

    public boolean verificacaoCasa(String casaBuscada) {
        return this.casa != null && this.casa.equalsIgnoreCase(casaBuscada);
    }

    public boolean verificarPresencaPalavra(String palavra) {
        return this.sobrenome.toLowerCase().contains(palavra.toLowerCase());
    }

    public void calcularCasa() {
        double ptsGrifinoria = (2 * coragem) + lealdade;
        double ptsSonserina = (2 * ambicao) + estrategia;
        double ptsCorvinal = (2 * inteligencia) + criatividade;
        double ptsLufaLufa = ((2 * lealdade) + coragem) / 3.0;

        double max = Math.max(ptsGrifinoria, Math.max(ptsSonserina, Math.max(ptsCorvinal, ptsLufaLufa)));

        if (max == ptsGrifinoria) this.casa = "Grifinória";
        else if (max == ptsSonserina) this.casa = "Sonserina";
        else if (max == ptsCorvinal) this.casa = "Corvinal";
        else this.casa = "Lufa-Lufa";
    }

    public void exibirInformacoes() {
        System.out.println("\nMatrícula: " + this.codigoMatricula);
        System.out.println("Nome: " + this.nome + " " + this.sobrenome);
        System.out.println("Login: " + gerarNomeUsuario());
        System.out.println("Idade: " + calcularIdade() + " anos (Maioridade mágica: " + (verificarMaioridadeMagica() ? "Sim" : "Não") + ")");
        System.out.println("Casa: " + formatarCasa());
    }
}

public class SistemaHogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];
        int totalAlunos = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\n--- Sistema de Cadastro de Hogwarts ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar todos os alunos");
            System.out.println("3. Exibir alunos de uma casa");
            System.out.println("4. Exibir alunos por casa");
            System.out.println("5. Exibir alunos maiores de idade");
            System.out.println("6. Exibir alunos menores de idade");
            System.out.println("7. Buscar alunos por sobrenome");
            System.out.println("8. Encerrar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 8) {
                System.out.println("Encerrando o sistema...");
                break;
            }

            switch (opcao) {
                case 1:
                    if (totalAlunos >= 10) {
                        System.out.println("Limite máximo de 10 alunos atingido!");
                        break;
                    }
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    LocalDate dataNasc = LocalDate.parse(scanner.nextLine(), formatter);
                    
                    System.out.println("Insira os atributos de 0 a 10:");
                    System.out.print("Coragem: "); int coragem = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inteligência: "); int inteligencia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ambição: "); int ambicao = Integer.parseInt(scanner.nextLine());
                    System.out.print("Lealdade: "); int lealdade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Estratégia: "); int estrategia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Criatividade: "); int criatividade = Integer.parseInt(scanner.nextLine());

                    Aluno novoAluno = new Aluno(nome, sobrenome, dataNasc, coragem, inteligencia, ambicao, lealdade, estrategia, criatividade);
                    novoAluno.calcularCasa();
                    novoAluno.gerarCodigoMatricula(totalAlunos + 1);
                    alunos[totalAlunos] = novoAluno;
                    totalAlunos++;
                    System.out.println("Aluno cadastrado e selecionado para: " + novoAluno.getCasa());
                    break;

                case 2:
                    for (int i = 0; i < totalAlunos; i++) {
                        alunos[i].exibirInformacoes();
                    }
                    break;

                case 3:
                    System.out.print("Informe a casa (Grifinória, Sonserina, Corvinal, Lufa-Lufa): ");
                    String casaBuscada = scanner.nextLine();
                    int contCasa = 0;
                    for (int i = 0; i < totalAlunos; i++) {
                        if (alunos[i].verificacaoCasa(casaBuscada)) {
                            alunos[i].exibirInformacoes();
                            contCasa++;
                        }
                    }
                    System.out.println("Total de alunos na casa " + casaBuscada + ": " + contCasa);
                    break;

                case 4:
                    String[] casas = {"Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa"};
                    for (String casa : casas) {
                        System.out.println("\n--- " + casa.toUpperCase() + " ---");
                        for (int i = 0; i < totalAlunos; i++) {
                            if (alunos[i].verificacaoCasa(casa)) {
                                System.out.println("- " + alunos[i].getNome() + " " + alunos[i].getSobrenome());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- Alunos Maiores de Idade ---");
                    for (int i = 0; i < totalAlunos; i++) {
                        if (alunos[i].verificarMaioridadeMagica()) alunos[i].exibirInformacoes();
                    }
                    break;

                case 6:
                    System.out.println("\n--- Alunos Menores de Idade ---");
                    for (int i = 0; i < totalAlunos; i++) {
                        if (!alunos[i].verificarMaioridadeMagica()) alunos[i].exibirInformacoes();
                    }
                    break;

                case 7:
                    System.out.print("Informe o sobrenome ou parte dele para busca: ");
                    String termo = scanner.nextLine();
                    for (int i = 0; i < totalAlunos; i++) {
                        if (alunos[i].verificarPresencaPalavra(termo)) {
                            alunos[i].exibirInformacoes();
                        }
                    }
                    break;
                
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
        scanner.close();
    }
}
