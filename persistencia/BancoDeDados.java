package persistencia;

public class BancoDeDados {
    private Persistente persistenteChefia;
    private Persistente persistenteFuncionario;
    private Persistente persistenteSetor;
    private Persistente persistenteProduto;
    private Persistente persistenteTroca;

    public BancoDeDados() {
        persistenteChefia = new Persistente();
        persistenteFuncionario = new Persistente();
        persistenteSetor = new Persistente();
        persistenteProduto = new Persistente();
        persistenteTroca = new Persistente();
    }

    public Persistente getPersistenteChefia() {
        return persistenteChefia;
    }

    public Persistente getPersistenteFuncionario() {
        return persistenteFuncionario;
    }

    public Persistente getPersistenteSetor() {
        return persistenteSetor;
    }

    public Persistente getPersistenteProduto() {
        return persistenteProduto;
    }

    public Persistente getPersistenteTroca() {
        return persistenteTroca;
    }

    //como ficam os setters?

    
}

