package controle;

import modelo.*;
import persistencia.BancoDeDados;

public class ControleSetor{
    private BancoDeDados banco;

    public ControleSetor(){
        banco = BancoDeDados.getInstance();
    }

    public boolean cadastra(String name){
        if(name.isEmpty()) throw new NullPointerException();
        
        try{
            Setor novoSetor = new Setor(name);
            banco.getPersistenteSetor().adicionarObjeto(novoSetor);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    public void remove(String name){
        if(name.isEmpty()) throw new NullPointerException();
    
        try{
            Entidade setorRemovido = banco.getPersistenteSetor().buscaPorName(name);
            banco.getPersistenteSetor().removerObjeto(setorRemovido);
        } catch(Exception e){

        }
    }
    
    public void altera(String novoChefe, String setor){
        if(novoChefe.isEmpty()) throw new NullPointerException();
        if(setor.isEmpty()) throw new NullPointerException();

        try{
            Setor aux1 = (Setor) banco.getPersistenteSetor().buscaPorName(setor);
            Usuario aux2 = (Usuario) banco.getPersistenteUsuario().buscaPorName(novoChefe);
                            
            aux1.setUserChefe(aux2);
        } catch(Exception e){

        }
    }
    
    public void visualiza(int id){
        try{
            Entidade aux3 = banco.getPersistenteSetor().buscaPorId(id);
        } catch (Exception e){

        }
    }

    public void visualizaTodos(){
        try{
            banco.getPersistenteSetor().visualizarTudo();
        } catch(Exception e){
            
        }
    }
}
