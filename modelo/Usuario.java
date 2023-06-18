package modelo;

public class Usuario extends Entidade{
    private Entidade setor;

    public Usuario(String name){
        super(name);
        this.setor = null;
    }

    public Entidade getSetor() {
        return setor;
    }

    public void setSetor(Entidade setor) {
        this.setor = setor;
    }

    public String toString() {
        if(setor != null) return super.toString() + ", setor = " + setor.getName() + "]";
        else return super.toString() + "]";
    }
}
