package modelo;

public class Bem extends Entidade{
    private Setor setor;
    private int qtd;

    public Bem(String name, Setor setor, int qtd){
        super(name);
        this.qtd = qtd;
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String toString() {
        return super.toString() + "Produto [setor=" + setor + ", qtd=" + qtd + "]";
    }

    //cadastrar um bem disponivel
    //remover um bem disponivel
}
