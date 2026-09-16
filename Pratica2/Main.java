import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto("Pao", 1, 5);
        Produto p2 = new Produto ("Manteiga", 2, 10);
        Produto p3 = new Produto("Presunto", 3, 15);
        Fatura fatura = new Fatura();
        int Menu = 1;

        System.out.println("Bem vindo ao Carrinho!");
        while (Menu != 0) {
        int opcao;
        System.out.println("1 - Comprar");
        System.out.println("2 - Fatura");
        System.out.println("3 - Excluir");
        System.out.println("4 - Alterar");
        System.out.println("5 - Finalizar");
        System.out.println("6 - Sair");
        System.out.print("Selecione a opção que desejar: ");
        opcao = sc.nextInt();
        switch (opcao) {

            case 1: 
        
            System.out.print(p1.getNome() + p1.getCodigo() + p1.getPreco() + "\n" + p2.getNome() + p2.);

            case 2:

            System.out.println("A Fatura atual possui os seguintes produtos: " + fatura.getItemsFatura() + "\n" +
            "O preço da fatura atual é: " + fatura.getValorTotalFatura());

            case 6:

                Menu = 0;

            default:
                System.out.println("Opção inválida");

        }
        
        } 
    }
    
}
