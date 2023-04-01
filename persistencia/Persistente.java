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

    public Entidade buscaPorId(int id) {
        for (Entidade x : persistencia) {
            if (x.getId() == id) {
                return x;
            }
        }
        
        return null; //se nao encontrar aquele id
    }

    public Entidade buscaPorName(String name){
        for (Entidade x : persistencia) {
            if (name.equals(x.getName())) {
                return x;
            }
        }
        
        return null; //se nao encontrar aquele nome
    }
    public void visualizarTudo(){
        for(Entidade x : persistencia){
            System.out.println("ID: " + x.getId() + ", NOME: " + x.getName());
        }
    }
}
