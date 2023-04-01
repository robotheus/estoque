package modelo;

import java.util.ArrayList;

public class Recibo {
    private int qtdBensNoCarrinho;
    private ArrayList<Bem> bens;

    public Recibo(ArrayList<Bem> todosBens){
        this.qtdBensNoCarrinho = 0;
        bens = todosBens;
    }

    public int getqtdBensNoCarrinho() {
        return qtdBensNoCarrinho;
    }

    public void setqtdBensNoCarrinho(int qtdBensNoCarrinho) {
        this.qtdBensNoCarrinho = qtdBensNoCarrinho;
    }

    public ArrayList<Bem> getBens() {
        return bens;
    }

    public String toString() {
        return "ResumoTroca [qtdBensNoCarrinho=" + qtdBensNoCarrinho + ", bens=" + bens + "]";
    }
}
