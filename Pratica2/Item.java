public class Item {
    
    private Produto produtoComprado;
    private int quantidade;
    private double valorTotal;

    public Item(Produto p, int q) {
        this.produtoComprado = p;
        this.quantidade = q;
    }

    public void setProdutoComprado(Produto produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public Produto getProduto() {
        return produtoComprado;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double calculaValorTotal() {
        valorTotal = getQuantidade() * produtoComprado.getPreco();
        return valorTotal;
    }

}
