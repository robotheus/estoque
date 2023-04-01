package modelo;

public class Bem extends Entidade{
    private Setor setor;

    public Bem(String name, Setor setor){
        super(name);
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String toString() {
        return super.toString() + "Produto [setor=" + setor;
    }
}
