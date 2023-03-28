package persistencia;

import modelo.*;

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

    //os setters da classe são para adicionar e remover na lista de cada entidade
    public void addSetorPersistente(Setor setor){
        persistenteSetor.adicionarObjeto(setor);
    }

    public String removeSetorPersistente(String name){
        Entidade a = persistenteSetor.buscaPorName(name);
        if(a != null) {
            persistenteSetor.removerObjeto(a);
            return "REMOÇÃO REALIZADA!";
        } else return "SETOR NÃO ENCONTRADO!";
    }


}

