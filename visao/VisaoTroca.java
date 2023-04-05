package visao;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.*;
import persistencia.*;

public class VisaoTroca {
    public static void MenuTroca(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------TROCA--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para CRIAR um TROCA.");
            System.out.println("    Digite 2 para ALTERAR uma TROCA (REMOVER OU ADICIONAR ITENS).");
            System.out.println("    Digite 3 para FINALIZAR um TROCA. (troca os setores e imprime o recibo)");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");

            try {
                op = sc.nextInt();
                switch(op) {
                    case 0: 
                        return;
                    
                    case 1:
                        System.out.println("Qual o setor de ORIGEM do produto?");
                        sc.nextLine();
                        String origem = sc.nextLine();
                        System.out.println("Qual o SEU SETOR?");
                        String destino = sc.nextLine();
                        System.out.println("Qual bem deseja requisitar para seu setor?");
                        String b = sc.nextLine();
    
                        Setor SetorOri = (Setor) banco.getPersistenteSetor().buscaPorName(origem);
                        Setor SetorDest = (Setor) banco.getPersistenteSetor().buscaPorName(destino);
                        Bem bemTroca = (Bem) banco.getPersistenteBem().buscaPorName(b);
                        
                        Troca t = new Troca(SetorOri, SetorDest);
                        t.getBemTroca().add(bemTroca);
                        banco.getPersistenteTroca().adicionarObjeto(t);
                        System.out.println("TROCA CRIADA! ID: " + t.getId());
    
                        break;
                            
                    case 2:
                        System.out.println("Digite o ID da troca que deseja ALTERAR:");
                        int y = sc.nextInt();
                        Troca x = (Troca) banco.getPersistenteTroca().buscaPorId(y);

                        System.out.println("DIGITE 1 PARA ADICIONAR BEM E 2 PARA REMOVER BEM.");
                        int g = sc.nextInt();
                        if(g == 1){
                            System.out.println("Digite o nome do BEM que deseja ADICIONAR:");
                            sc.nextLine();
                            String n = sc.nextLine();
                            
                            Bem k = (Bem) banco.getPersistenteBem().buscaPorName(n);
                            x.getBemTroca().add(k); //add um bem a troda id x
                            x.addCarrinho(k); //adcionar ao carrinho
                            x.getCarrinho().setqtdBensNoCarrinho(x.getCarrinho().getqtdBensNoCarrinho() + 1); //atualiza a quantidade de bens no carrinho
                        } else if(g == 2){
                            System.out.println("Digite o nome do BEM que deseja REMOVER:");
                            sc.nextLine();
                            String n = sc.nextLine();

                            Bem k = (Bem) banco.getPersistenteBem().buscaPorName(n);
                            x.getBemTroca().remove(k); //remove um bem a troda id x
                            x.removeCarrinho(k); //remove ao carrinho
                            x.getCarrinho().setqtdBensNoCarrinho(x.getCarrinho().getqtdBensNoCarrinho() - 1); //atualiza a quantidade de bens no carrinho
                        }
    
                        break;
                            
                    case 3:
                        System.out.println("Digite o ID da troca que deseja FINALIZAR:");
                        int w = sc.nextInt();
    
                        Troca h = (Troca) banco.getPersistenteTroca().buscaPorId(w);
                        for(Bem c : h.getBemTroca()){
                            c.setSetor(h.getSetDestino());
                        }
    
                        System.out.println(h.getCarrinho().toString());
    
                        break;
                        
                    case 4:
                        System.out.println("Digite o ID para visualização:");
                        int idSearch = sc.nextInt();
                            
                        Entidade aux3 = banco.getPersistenteTroca().buscaPorId(idSearch);
                        
                        System.out.println(aux3);
                        System.out.println("ID NÃO ENCONTRADO!");
                            
                        System.out.println();
                        break;
                        
                    case 5:
                        banco.getPersistenteTroca().visualizarTudo();
                        break;
                    
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                        break;
                }
            } catch (Excecao e) {
                System.out.println("BUSCA INVALIDA: " + e.getMessage());
            } catch(InputMismatchException a){
                System.out.println("CAMPO PREENCHIDO INCORRETAMENTE!");
                sc.nextLine();
            }   
        }
    }
}