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

    //como ficam os getters e setters?
}

