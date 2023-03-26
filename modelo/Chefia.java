package modelo;

import java.util.ArrayList;

public class Chefia extends Entidade{
    private Setor setor;

    public Chefia(String name){
        super(name);
        this.setor = null;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    public void cadastrarFuncionario(String name){
        Funcionario func = new Funcionario(name);
        func.setSetorFunc(this.setor);
    }

    public int cadastrarProdutoDisponivel(String name, int qtd){
        for(Produto s : setor.produtosDisponiveis){
            if(name.equals(s.getName())){
                s.setQtd(s.getQtd() + qtd);
                return 0;
            }
        }

        Produto prod = new Produto(name, this.setor, qtd);
        setor.produtosDisponiveis.add(prod);
        return 0;
    }

    public void puxarProduto(Setor setorOrigem, ArrayList<Produto> prod){
        Troca troca = new Troca(setorOrigem, this.setor, prod);
    }

    public void verSolicitacoes(Setor s){
        for(Produto p : s.pedidos){
            System.out.println(p);
        }
    }

    public void verDisponibilidades(Setor s){
        for(Produto p : s.pedidos){
            System.out.println(p);
        }
    }

    public String toString() {
        return super.toString() + "Chefia [setor=" + setor + "]";
    }
}
