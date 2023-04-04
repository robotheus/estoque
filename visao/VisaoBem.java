package visao;

import java.util.Scanner;
import modelo.*;
import persistencia.*;

public class VisaoBem {
    public static void MenuBem(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------BEM--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para CADASTRAR um BEM.");
            System.out.println("    Digite 2 para REMOVER um BEM.");
            System.out.println("    Digite 3 para ALTERAR o BEM (setor).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            op = sc.nextInt();
        
            try{
                switch(op){
                    case 0:
                        return;
        
                    case 1:
                        System.out.println("Digite o NOME do novo BEM: ");
                        sc.nextLine();
                        String nameBem = sc.nextLine();
                        System.out.println("Digite o SETOR do novo BEM: ");
                        String setorBem = sc.nextLine();
                        
                        Setor s = (Setor) banco.getPersistenteSetor().buscaPorName(setorBem);
                        Bem novoBem = new Bem(nameBem, s);
                        banco.getPersistenteBem().adicionarObjeto(novoBem);
                        System.out.println("BEM CADASTRADO! ID: " + novoBem.getId());
                        System.out.println();
                        break;
                            
                    case 2:
                        System.out.println("Digite o NOME do BEM a ser REMOVIDO:");
                        sc.nextLine();
                        String removeBem = sc.nextLine();
                            
                        Bem b = (Bem) banco.getPersistenteUsuario().buscaPorName(removeBem);
                        banco.getPersistenteUsuario().removerObjeto(b);
                            
                        System.out.println();
                        break;
                            
                    case 3:
                        System.out.println("Digite o NOME do BEM a ser ALTERADO:");
                        sc.nextLine();
                        String bemAlterado = sc.nextLine();
                        System.out.println("Digite o NOVO SETOR do bem:");
                        String newSetor = sc.nextLine();
                            
                        Bem aux1 = (Bem) banco.getPersistenteBem().buscaPorName(bemAlterado);
                        Setor aux2 = (Setor) banco.getPersistenteSetor().buscaPorName(newSetor);
                        
                        aux1.setSetor(aux2);
                        
                        System.out.println();
                        break;
                        
                    case 4:
                        System.out.println("Digite o ID para visualização:");
                        int idSearch = sc.nextInt();
                            
                        Entidade aux3 = banco.getPersistenteBem().buscaPorId(idSearch);
                        
                        System.out.println(aux3);
                            
                        System.out.println();
                        break;
                        
                    case 5:
                        banco.getPersistenteBem().visualizarTudo();
                        break; 
                        
                    default:
                        break;
                }
            } catch(Excecao e){
                System.out.println("BUSCA INVALIDA: " + e.getMessage());
            }
        }
    }
}
