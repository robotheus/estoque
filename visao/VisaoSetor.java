package visao;

import java.util.Scanner;
import modelo.*;
import persistencia.*;

public class VisaoSetor {
    public static void MenuSetor(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------SETOR--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para CADASTRAR um SETOR.");
            System.out.println("    Digite 2 para REMOVER um SETOR.");
            System.out.println("    Digite 3 para ALTERAR o SETOR (Usuário Chefe).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            op = sc.nextInt();

            switch(op) {
                case 0: 
                    return;
                
                case 1:
                    System.out.println("Digite o NOME do novo SETOR: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                        
                    Setor novoSetor = new Setor(name);
                    banco.getPersistenteSetor().adicionarObjeto(novoSetor);
                        
                    System.out.println();
                    break;
                        
                case 2:
                    System.out.println("Digite o NOME do SETOR a ser REMOVIDO:");
                    sc.nextLine();
                    String removeName = sc.nextLine();
                        
                    Entidade a = banco.getPersistenteSetor().buscaPorName(removeName);
                    if(a != null) banco.getPersistenteSetor().removerObjeto(a);
                    else System.out.println("SETOR NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                        
                case 3:
                    System.out.println("Digite o NOME do novo USUÁRIO CHEFE:");
                    sc.nextLine();
                    String newChefe = sc.nextLine();
                    System.out.println("Digite o NOME do setor a ser ALTERADO:");
                    String setorAlterado = sc.nextLine();
                        
                    Setor aux1 = (Setor) banco.getPersistenteSetor().buscaPorName(setorAlterado);
                    Usuario aux2 = (Usuario) banco.getPersistenteUsuario().buscaPorName(newChefe);
                        
                    if(aux1 != null){
                        if(aux2 != null){
                            aux1.setUserChefe(aux2);
                        } else System.out.println("USUARIO NÃO ENCONTRADO!");
                    } else System.out.println("SETOR NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Digite o ID para visualização:");
                    int idSearch = sc.nextInt();
                        
                    Entidade aux3 = banco.getPersistenteSetor().buscaPorId(idSearch);
                    if(aux3 != null) System.out.println(aux3);
                    else System.out.println("ID NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 5:
                    banco.getPersistenteSetor().visualizarTudo();
                    
                default:
                    break;
            }    
        }
    }
}
