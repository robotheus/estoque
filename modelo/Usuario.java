package modelo;

public class Usuario {
    private Setor setor;

    public Usuario(){
        super();
        this.setor = null;
    }

    public Usuario(Setor setor){
        super();
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    //cadastra usuario remove usuario
}
