package modelo;

import java.util.ArrayList;

public class Troca extends Entidade{
    private Setor setOrigem;
    private Setor setDestino;
    private ArrayList<Bem> bemTroca;
    private Recibo carrinho;

    public Troca(Setor setOrigem, Setor setDestino){
        super();
        this.setOrigem = setOrigem;
        this.setDestino = setDestino;
        this.bemTroca = new ArrayList<Bem>();
        this.carrinho = new Recibo(bemTroca);
    }

    public Setor getSetOrigem() {
        return setOrigem;
    }

    public void setSetOrigem(Setor setOrigem) {
        this.setOrigem = setOrigem;
    }

    public Setor getSetDestino() {
        return setDestino;
    }

    public void setSetDestino(Setor setDestino) {
        this.setDestino = setDestino;
    }

    public ArrayList<Bem> getBemTroca() {
        return bemTroca;
    }

    public Recibo getCarrinho(){
        return this.carrinho;
    }

    public void addCarrinho(Bem b){
        this.carrinho.getBens().add(b);
        this.carrinho.setqtdBensNoCarrinho(this.carrinho.getqtdBensNoCarrinho() + 1);
    }

    public void removeCarrinho(Bem b){
        this.carrinho.getBens().remove(b);
        this.carrinho.setqtdBensNoCarrinho(this.carrinho.getqtdBensNoCarrinho() - 1);
    }

    public String toString() {
        return super.toString() + ", setOrigem = " + setOrigem.getName() + ", setDestino = " + setDestino.getName() + ", bem = " + bemTroca.toString() + "]";
    }
}
