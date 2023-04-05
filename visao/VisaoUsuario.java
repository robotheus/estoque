package visao;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.*;
import persistencia.BancoDeDados;
import persistencia.Excecao;

public class VisaoUsuario {
    public static void MenuUsuario(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------USUARIO--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para CADASTRAR um USUARIO.");
            System.out.println("    Digite 2 para REMOVER um USUARIO.");
            System.out.println("    Digite 3 para ALTERAR o USUARIO (Trocar/Atribuir setor).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            try {
                op = sc.nextInt();
                switch(op) {
                    case 0:
                        return;
                        
                    case 1:
                        System.out.println("Digite o NOME do novo USARIO: ");
                        sc.nextLine();
                        String nameUser = sc.nextLine();
    
                        Usuario novoUsuario = new Usuario(nameUser);
                        banco.getPersistenteUsuario().adicionarObjeto(novoUsuario);
                        
                        System.out.println("USUARIO CADASTRADO! ID: " + novoUsuario.getId());
                        System.out.println();
                        break;
                            
                    case 2:
                        System.out.println("Digite o NOME do USUARIO a ser REMOVIDO:");
                        sc.nextLine();
                        String removeName = sc.nextLine();
                            
                        Entidade b = banco.getPersistenteUsuario().buscaPorName(removeName);
                        banco.getPersistenteUsuario().removerObjeto(b);
                            
                        System.out.println();
                        break;
                            
                    case 3:
                        System.out.println("Digite o NOME do USUÁRIO a ser ALTERADO:");
                        sc.nextLine();
                        String userAlterado = sc.nextLine();
                        System.out.println("Digite o NOME do NOVO SETOR do USUARIO:");
                        String newSetorAlterado = sc.nextLine();
                            
                        Usuario aux1 = (Usuario) banco.getPersistenteUsuario().buscaPorName(userAlterado);
                        Setor aux2 = (Setor) banco.getPersistenteSetor().buscaPorName(newSetorAlterado);
                            
                        aux1.setSetor(aux2);
                            
                        System.out.println();
                        break;
                        
                    case 4:
                        System.out.println("Digite o ID para visualização:");
                        
                        int idSearch = sc.nextInt();
                            
                        Entidade aux3 = banco.getPersistenteUsuario().buscaPorId(idSearch);
                        System.out.println(aux3);
                        
                        break;
                        
                    case 5:
                        banco.getPersistenteUsuario().visualizarTudo();
                        break;
                        
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                        break;
                }
            } catch (Excecao e) {
                System.out.println("BUSCA INVALIDA: " + e.getMessage());
            } catch (InputMismatchException a) {
                System.out.println("CAMPO PREENCHIDO INCORRETAMENTE! ESCOLHA NOVAMENTE.");
                sc.nextLine();
            }
            
        }
    }
}
