package modelo;

public class Troca extends Entidade{
    private Setor setOrigem;
    private Setor setDestino;
    private Bem bemTroca;

    public Troca(Setor setOrigem, Setor setDestino, Bem bemTroca){
        super();
        this.setOrigem = setOrigem;
        this.setDestino = setDestino;
        this.bemTroca = bemTroca;
    }

    public Setor getSetOrigem() {
        return setOrigem;
    }

    public Setor getSetDestino() {
        return setDestino;
    }

    public Bem getBemTroca(){
        return this.bemTroca;
    }

    public String toString() {
        return super.toString() + "Troca [setOrigem=" + setOrigem + ", setDestino=" + setDestino + ", bemTroca=" + bemTroca + "]";
    }

    //setters sao pertinentes??
    //classe de transicao
    //adicionar bem remover bem da classe de transicao
    //trocar um bem
    
}
