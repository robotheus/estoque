package persistencia;

public class BancoDeDados {
    private Persistente persistenteUsuario;
    private Persistente persistenteSetor;
    private Persistente persistenteBem;
    private Persistente persistenteTroca;

    public BancoDeDados() {
        persistenteUsuario = new Persistente();
        persistenteSetor = new Persistente();
        persistenteBem = new Persistente();
        persistenteTroca = new Persistente();
    }

    public Persistente getPersistenteUsuario() {
        return persistenteUsuario;
    }

    public Persistente getPersistenteSetor() {
        return persistenteSetor;
    }

    public Persistente getPersistenteBem() {
        return persistenteBem;
    }

    public Persistente getPersistenteTroca() {
        return persistenteTroca;
    }

    //os setters como ficam?? vao ser usados?? ja tenho os metodos de alterar
}

