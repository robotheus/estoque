package controle;

import java.util.ArrayList;

import modelo.Bem;
import modelo.Entidade;
import modelo.Setor;
import persistencia.BancoDeDados;
import persistencia.Excecao;

public class ControleBem{
    BancoDeDados banco = BancoDeDados.getInstance();

    public String cadastra(String name, String setor){
        try{
            Setor s = (Setor) banco.getPersistenteSetor().buscaPorName(setor);
            Bem novoBem = new Bem(name, s);
            banco.getPersistenteBem().adicionarObjeto(novoBem);
            return "true";
        } catch (Excecao e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String remove(String bem){
        try{
            Entidade bemRemovido = banco.getPersistenteBem().buscaPorName(bem);
            banco.getPersistenteBem().removerObjeto(bemRemovido);
            return "true";
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String altera(String bem, String setor){
        try{
            Bem aux1 = (Bem) banco.getPersistenteBem().buscaPorName(bem);
            Setor aux2 = (Setor) banco.getPersistenteSetor().buscaPorName(setor);
                      
            aux1.setSetor(aux2);
            return "true";
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String visualiza(int id){
        try{
            Entidade aux3 = banco.getPersistenteBem().buscaPorId(id);
            return aux3.toString();
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }

    public ArrayList<Entidade> visualizaTodos(){
        ArrayList<Entidade> list = new ArrayList<Entidade>();
        
        try{
            list = banco.getPersistenteBem().visualizarTudo();
            return list;
        } catch(Exception e){
            return list;
        }
    }
}
