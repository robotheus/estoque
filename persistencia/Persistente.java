package persistencia;

import java.util.ArrayList;

import modelo.*;

public class Persistente {
    private ArrayList<Entidade> persistencia;
    
    public Persistente(){
        this.persistencia = new ArrayList<Entidade>();
    }

    public void adicionarObjeto(Entidade instancia) {
        persistencia.add(instancia);
    }

    public void removerObjeto(Entidade instancia) {
        persistencia.remove(instancia);
    }

    public Entidade buscaPorId(int id) throws Excecao {
        for (Entidade x : persistencia) {
            if (x.getId() == id) {
                return x;
            }
        }
        
        throw new Excecao("ID NAO ENCONTRADO!");
    }

    public Entidade buscaPorName(String name) throws Excecao {
        for (Entidade x : persistencia) {
            if (name.equals(x.getName())) {
                return x;
            }
        }
        
        throw new Excecao("NOME NAO ENCONTRADO!");
    }

    public ArrayList<Entidade> visualizarTudo(){
        ArrayList<Entidade> lista = new ArrayList<Entidade>();
        
        for(Entidade x : persistencia){
            lista.add(x);
        }

        return lista;
    }
}
