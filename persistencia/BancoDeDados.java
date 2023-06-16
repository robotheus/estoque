package persistencia;

public class BancoDeDados {
    private Persistente persistenteUsuario;
    private Persistente persistenteSetor;
    private Persistente persistenteBem;
    private Persistente persistenteTroca;
    private static BancoDeDados uniqueInstance;

    private BancoDeDados() {
        persistenteUsuario = new Persistente();
        persistenteSetor = new Persistente();
        persistenteBem = new Persistente();
        persistenteTroca = new Persistente();
    }
        
    public static BancoDeDados getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new BancoDeDados();
        }
        return uniqueInstance;
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
}

