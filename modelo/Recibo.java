package modelo;

import java.util.ArrayList;

public class Recibo {
    private int qtdBensNoCarrinho;
    private ArrayList<Bem> bens;

    public Recibo(ArrayList<Bem> todosBens){
        this.qtdBensNoCarrinho = 1;
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
        return "RECIBO: [Quantidade de itens trocados = " + qtdBensNoCarrinho + ", bens = " + bens.toString() + "]";
    }
}
