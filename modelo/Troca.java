package modelo;

import java.util.ArrayList;

public class Troca extends Entidade{
    private Setor setOrigem;
    private Setor setDestino;
    private ArrayList<ItemTroca> itensTroca;
    
    public Troca(Setor setOrigem, Setor setDestino){
        super(setOrigem.getName() + " -> " + setDestino.getName());
        this.setOrigem = setOrigem;
        this.setDestino = setDestino;
        this.itensTroca = new ArrayList<ItemTroca>();
    }

    public Setor getOrigem() {
        return setOrigem;
    }

    public Setor getDestino() {
        return setDestino;
    }

    public ArrayList<ItemTroca> getItensTroca() {
        return itensTroca;
    }

    public void adicionaItemTroca(ItemTroca bem){
        itensTroca.add(bem);
    }

    public void removeItemTroca(ItemTroca bem){
        itensTroca.remove(bem);
    }

    public String toString() {
        String a = super.toString() + ", setor de origem = " + setOrigem.getName() + ", setor de destino = " + setDestino.getName() + ", bens envolvidos: ";
        
        for(ItemTroca x : itensTroca){
            a += (x.getBem().getName() + " (" + x.getstatus() + ")");
            a += ", ";
        }
        
        a = a.substring(0, a.length() - 2);
        return a + "]";
    }
}
