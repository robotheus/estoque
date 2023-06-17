package controle;

import java.util.ArrayList;

import modelo.Entidade;
import modelo.Setor;
import modelo.Usuario;
import persistencia.BancoDeDados;

public class ControleUsuario {
    BancoDeDados banco = BancoDeDados.getInstance();

    public void cadastra(String name){
        Setor novoSetor = new Setor(name);
        banco.getPersistenteUsuario().adicionarObjeto(novoSetor);
    }
    
    public String remove(String name){
        try{
            Entidade userRemovido = banco.getPersistenteUsuario().buscaPorName(name);
            banco.getPersistenteUsuario().removerObjeto(userRemovido);
            return "true";
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String altera(String usuario, String setor){
        try{
            Usuario aux1 = (Usuario) banco.getPersistenteUsuario().buscaPorName(usuario);
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
            Entidade aux3 = banco.getPersistenteUsuario().buscaPorId(id);
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
            list = banco.getPersistenteUsuario().visualizarTudo();
            return list;
        } catch(Exception e){
            return list;
        }
    }
}
