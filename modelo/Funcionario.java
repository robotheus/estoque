package modelo;

public class Funcionario extends Entidade{
    private Setor setorFunc;

    public Funcionario(String name){
        super(name);
        this.setorFunc = null;
    }

    public Funcionario(String name, Setor setor){
        super(name);
        this.setorFunc = setor;
    }

    public Setor getSetorFunc() {
        return setorFunc;
    }

    public void setSetorFunc(Setor setorFunc) {
        this.setorFunc = setorFunc;
    }

    public void cadastrarSolicitacao(String name, int qtd){
        Produto sol = new Produto(name, setorFunc, qtd);
        this.setorFunc.produtosDisponiveis.add(sol);
    }

    public int informaDisponibilidade(String name, int qtd){
        for(Produto s : setorFunc.disponibilidades){
            if(name.equals(s.getName())){
                s.setQtd(s.getQtd() + qtd);
                return 0;
            }
        }

        Produto prod = new Produto(name, setorFunc, qtd);
        setorFunc.disponibilidades.add(prod);
        return 0;
    }

    public String toString() {
        return super.toString() + "Funcionario [setorFunc=" + setorFunc + "]";
    }

    
}
