package modelo;

import java.util.ArrayList;

public class Troca extends Entidade{
    //classe da transação
    private Setor setOrigem;
    private Setor setDestino;
    private ArrayList<Produto> prod = new ArrayList<Produto>();

    public Troca(Setor setOrigem, Setor setDestino, ArrayList<Produto> prod){
        super();
        this.setOrigem = setOrigem;
        this.setDestino = setDestino;
        this.prod = prod;
    }

    public Setor getSetOrigem() {
        return setOrigem;
    }

    public Setor getSetDestino() {
        return setDestino;
    }

    

    
    
    public String toString() {
        return super.toString() + "Troca [setOrigem=" + setOrigem + ", setDestino=" + setDestino + "]";
    }

    
}
