import java.util.ArrayList;

public class Fatura {

    private ArrayList<Item> itemsFatura;
    private double valorTotalFatura;

    public Fatura() {
        this.itemsFatura = new ArrayList<Item>();
    }

    public void setItemsFatura(ArrayList<Item> itemsFatura) {
        this.itemsFatura = itemsFatura;
    }

    public ArrayList<Item> getItemsFatura() {
        return itemsFatura;
    }

    public double calculaValorTotalFatura() {
        for (int i = 0; i < itemsFatura.size(); i++) {
            valorTotalFatura += itemsFatura.get(i).getValorTotal();
        }
        return valorTotalFatura;
    }

    public double getValorTotalFatura() {
        return valorTotalFatura;
    }

}
