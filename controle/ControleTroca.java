package controle;

import java.util.ArrayList;

import modelo.*;
import persistencia.BancoDeDados;
import persistencia.Excecao;

public class ControleTroca{
    BancoDeDados banco;

    public ControleTroca(){
        banco = BancoDeDados.getInstance();
    }
    
    public String criaTroca(String origem, String destino, String bem){
        try{
            Setor s1 = (Setor) banco.getPersistenteSetor().buscaPorName(origem);
            Setor s2 = (Setor) banco.getPersistenteSetor().buscaPorName(destino);
            Bem b = (Bem) banco.getPersistenteBem().buscaPorName(bem);
            
            ItemTroca item = new ItemTroca(b, Status.PROCESSANDO);

            Troca troca = new Troca(s1, s2);
            troca.getItensTroca().add(item);;
            banco.getPersistenteTroca().adicionarObjeto(troca);
            return "true";
        } catch (Excecao e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String altera(String id, String bem, int op){
        try{
            int idTroca = Integer.parseInt(id);
            Troca aux1 = (Troca) banco.getPersistenteTroca().buscaPorId(idTroca);
            Bem aux2 = (Bem) banco.getPersistenteBem().buscaPorName(bem);
            
            if(!(aux1.getOrigem().getName().equals(aux2.getSetor().getName()))) return "Esse bem nao esta disponivel neo setor de origem";
            if(op == 1){
                ItemTroca item = new ItemTroca(aux2, Status.PROCESSANDO);
                aux1.getItensTroca().add(item);

                return "true";
            } else {
                for(ItemTroca x : aux1.getItensTroca()){
                    if(x.getBem().getName().equals(aux2.getName())){
                        aux1.removeItemTroca(x);
                        return "true";
                    }
                }
            }
            return "true";
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }
    
    public String finaliza(int id){
        try{
            Troca h = (Troca) banco.getPersistenteTroca().buscaPorId(id);
            
            for(ItemTroca x : h.getItensTroca()){
                x.setStatus(Status.FINALIZADO);
                x.getBem().setSetor(h.getDestino());
            }
    
            return h.toString();
        } catch(Exception e){
            String mensagem = e.toString();
            String[] msg = mensagem.split(":");
            return msg[1];
        }
    }

    public String visualiza(int id){
        try{
            Entidade aux3 = banco.getPersistenteTroca().buscaPorId(id);
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
            list = banco.getPersistenteTroca().visualizarTudo();
            return list;
        } catch(Exception e){
            return list;
        }
    }
}
