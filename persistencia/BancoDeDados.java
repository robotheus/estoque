package persistencia;

public class BancoDeDados {
    private Persistente persistenteUsuario;
    private Persistente persistenteSetor;
    private Persistente persistenteBem;
    private Persistente persistenteTroca;
    private static BancoDeDados uniqueInstance;

    private BancoDeDados() {
        this.persistenteUsuario = new Persistente();
        this.persistenteSetor = new Persistente();
        this.persistenteBem = new Persistente();
        this.persistenteTroca = new Persistente();
    }
        
    public static BancoDeDados getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new BancoDeDados();
        }
        return uniqueInstance;
    }

    public Persistente getPersistenteUsuario() {
        return this.persistenteUsuario;
    }

    public Persistente getPersistenteSetor() {
        return this.persistenteSetor;
    }

    public Persistente getPersistenteBem() {
        return this.persistenteBem;
    }

    public Persistente getPersistenteTroca() {
        return this.persistenteTroca;
    }
}

