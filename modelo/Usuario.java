package modelo;

public class Usuario extends Entidade{
    private Setor setor;

    public Usuario(String name){
        super(name);
        this.setor = null;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String toString() {
        if(setor != null) return super.toString() + ", setor = " + setor.getName() + "]";
        else return super.toString() + "]";
    }
}
