import java.util.HashMap;

public class Estoque {

    private HashMap<Integer, Produto> produtos;
    private int tamanho;

    public Estoque() {
        this.produtos = new HashMap<>();
        this.tamanho = produtos.size();
    }

    public void setProdutos(HashMap<Integer, Produto> produtos) {
        this.produtos = produtos;
    }

    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public HashMap<Integer, Produto> getTamanho() {
        return produtos;
    }

    public boolean addProduto(Produto produto) {
        for (int chave : produtos.keySet()) {
                if (produto.getCodigo() == produtos.get(chave).getCodigo()) {
                    return false;
                }
            }
        produtos.put(produto.getCodigo(), produto);
        return true;
        
    }

    public Produto buscaProduto(int codigo) {
        for (int chave : produtos.keySet()) {
            if (codigo == produtos.get(chave).getCodigo()) {
                return produtos.get(chave);
            }
        }
        return null;
    }

    public void removeProduto(Produto produto) {
        for (int chave : produtos.keySet()) {
            if (chave == produtos.get(chave).getCodigo()) {
                produtos.remove(produto);
            }
        }
    }

}