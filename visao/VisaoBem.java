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
            System.out.println("    Digite 3 para ALTERAR o BEM (quantidade).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            op = sc.nextInt();
        
            switch(op){
                case 0:
                    return;
    
                case 1:
                    System.out.println("Digite o NOME do novo BEM: ");
                    sc.nextLine();
                    String nameBem = sc.nextLine();
                    System.out.println("Digite o SETOR do novo BEM: ");
                    sc.nextLine();
                    String setorBem = sc.nextLine();
                    System.out.println("Digite a QUANTIDADE do novo BEM: ");
                    int qtdBem = sc.nextInt();
                    
                    Setor s = (Setor) banco.getPersistenteSetor().buscaPorName(setorBem);
                    
                    if(s == null){
                        System.out.println("SETOR NÃO ENCONTRADO!");
                        break;
                    }
                    
                    Bem novoBem = new Bem(nameBem, s, qtdBem);
                    banco.getPersistenteBem().adicionarObjeto(novoBem);
    
                    System.out.println();
                    break;
                        
                case 2:
                    System.out.println("Digite o NOME do BEM a ser REMOVIDO:");
                    sc.nextLine();
                    String removeBem = sc.nextLine();
                        
                    Bem b = (Bem) banco.getPersistenteUsuario().buscaPorName(removeBem);
                    if(b != null) banco.getPersistenteUsuario().removerObjeto(b);
                    else System.out.println("BEM NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                        
                case 3:
                    System.out.println("Digite o NOME do BEM a ser ALTERADO:");
                    sc.nextLine();
                    String bemAlterado = sc.nextLine();
                    System.out.println("Digite a NOVA QUANTIDADE do bem:");
                    int newQtd = sc.nextInt();
                        
                    Bem aux1 = (Bem) banco.getPersistenteBem().buscaPorName(bemAlterado);
                        
                    if(aux1 != null){
                        aux1.setQtd(newQtd);
                    } else System.out.println("BEM NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Digite o ID para visualização:");
                    int idSearch = sc.nextInt();
                        
                    Entidade aux3 = banco.getPersistenteBem().buscaPorId(idSearch);
                    
                    if(aux3 != null) System.out.println(aux3);
                    else System.out.println("ID NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 5:
                    banco.getPersistenteBem().visualizarTudo();
                    
                default:
                    break;
            }
        }
    }
}
