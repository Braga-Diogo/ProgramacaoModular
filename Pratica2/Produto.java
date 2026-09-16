public class Produto {

    private String nome;
    private int codigo;
    private double preco;

    public Produto(String n, int c, double p) {
        this.nome = n;
        this.codigo = c;
        this.preco = p;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

}