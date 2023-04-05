package visao;

import java.util.InputMismatchException;
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

            try{
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
    
                        System.out.println("SETOR CADASTRADO! ID: " + novoSetor.getId());
                        System.out.println();
                        break;
                            
                    case 2:
                        System.out.println("Digite o NOME do SETOR a ser REMOVIDO:");
                        sc.nextLine();
                        String removeName = sc.nextLine();
                            
                        Entidade a = banco.getPersistenteSetor().buscaPorName(removeName);
                        banco.getPersistenteSetor().removerObjeto(a);
                            
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
                            
                        aux1.setUserChefe(aux2);
                            
                        System.out.println();
                        break;
                        
                    case 4:
                        System.out.println("Digite o ID para visualização:");
                        int idSearch = sc.nextInt();
                            
                        Entidade aux3 = banco.getPersistenteSetor().buscaPorId(idSearch);
                        System.out.println(aux3);
                            
                        System.out.println();
                        break;
                        
                    case 5:
                        banco.getPersistenteSetor().visualizarTudo();
                        break;
                        
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                        break;
                }
            } catch(Excecao e){
                System.out.println("BUSCA INVALIDA: " + e.getMessage());
            } catch(InputMismatchException e){
                System.out.println("CAMPO PREENCHIDO INCORRETAMENTE! ESCOLHA NOVAMENTE.");
                sc.nextLine();
            }       
        }
    }
}
