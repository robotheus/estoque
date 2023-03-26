package modelo;

import java.util.ArrayList;

public class Setor extends Entidade{
    private Chefia chefe;
    
    ArrayList<Produto> produtosDisponiveis = new ArrayList<Produto>();
    ArrayList<Produto> pedidos = new ArrayList<Produto>();
    ArrayList<Produto> disponibilidades = new ArrayList<Produto>();

    public Setor(String name){
        super(name);
        chefe = null;
    }

    public Setor(String name, Chefia chefe){
        super(name);
        this.chefe = chefe;
    }

    public Chefia getChefe() {
        return chefe;
    }

    public void setChefe(Chefia chefe) {
        this.chefe = chefe;
    }

    public String toString() {
        return super.toString() + "Setor [chefe=" + chefe + ", produtosDisponiveis=" + produtosDisponiveis + ", pedidos=" + pedidos
                + ", disponibilidades=" + disponibilidades + "]";
    }

    
    
    
}
