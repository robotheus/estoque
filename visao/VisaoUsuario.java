package visao;

import java.util.Scanner;

import modelo.*;
import persistencia.BancoDeDados;

public class VisaoUsuario {
    public static void MenuUsuario(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------USUARIO--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para CADASTRAR um USUARIO.");
            System.out.println("    Digite 2 para REMOVER um USUARIO.");
            System.out.println("    Digite 3 para ALTERAR o USUARIO (Trocar de setor).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            op = sc.nextInt();
            
            switch(op) {
                case 0:
                    return;
                    
                case 1:
                    System.out.println("Digite o NOME do novo USARIO: ");
                    sc.nextLine();
                    String nameUser = sc.nextLine();

                    System.out.println("Digite o SETOR do novo USARIO: ");
                    String setorUser = sc.nextLine();
                    
                    Setor s = (Setor) banco.getPersistenteSetor().buscaPorName(setorUser);

                    if(s == null){
                        System.out.println("SETOR NAO ENCONTRADO");
                        break;
                    }

                    Usuario novoUsuario = new Usuario(nameUser);
                    Setor a = (Setor) banco.getPersistenteSetor().buscaPorName(setorUser);
                    novoUsuario.setSetor(a);
                    banco.getPersistenteUsuario().adicionarObjeto(novoUsuario);
                    
                    System.out.println("USUARIO CADASTRADO! ID: " + novoUsuario.getId());
                    System.out.println();
                    break;
                        
                case 2:
                    System.out.println("Digite o NOME do USUARIO a ser REMOVIDO:");
                    sc.nextLine();
                    String removeName = sc.nextLine();
                        
                    Entidade b = banco.getPersistenteUsuario().buscaPorName(removeName);
                    if(b != null) banco.getPersistenteUsuario().removerObjeto(b);
                    else System.out.println("USUARIO NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                        
                case 3:
                    System.out.println("Digite o NOME do USUÁRIO a ser ALTERADO:");
                    sc.nextLine();
                    String userAlterado = sc.nextLine();
                    System.out.println("Digite o NOME do NOVO SETOR do USUARIO:");
                    String newSetorAlterado = sc.nextLine();
                        
                    Usuario aux1 = (Usuario) banco.getPersistenteUsuario().buscaPorName(userAlterado);
                    Setor aux2 = (Setor) banco.getPersistenteUsuario().buscaPorName(newSetorAlterado);
                        
                    if(aux1 != null){
                        if(aux2 != null){
                            aux1.setSetor(aux2);
                        } else System.out.println("USUARIO NÃO ENCONTRADO!");
                    } else System.out.println("SETOR NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Digite o ID para visualização:");
                    
                    int idSearch = sc.nextInt();
                        
                    Entidade aux3 = banco.getPersistenteUsuario().buscaPorId(idSearch);
                    if(aux3 != null) System.out.println(aux3);
                    else System.out.println("ID NÃO ENCONTRADO!");
                        
                    System.out.println();
                    break;
                    
                case 5:
                    banco.getPersistenteUsuario().visualizarTudo();
                    
                default:
                    break;
            }
        }
    }
}
