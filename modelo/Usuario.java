package modelo;

public class Usuario extends Entidade{
    private Setor setor;

    public Usuario(String name){
        super(name);
        this.setor = null;
    }

    public Usuario(String name, Setor setor){
        super(name);
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
