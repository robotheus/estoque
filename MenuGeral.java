package visao;

import java.util.InputMismatchException;
import java.util.Scanner;
import persistencia.BancoDeDados;

public class MenuGeral {
    public static void Menu(BancoDeDados banco) {
        Scanner sc = new Scanner(System.in);
        int op;
        
        while(true){
            System.out.println("--------------------stocker--------------------");
            System.out.println("Selecione seu tipo de usuário ou 0 para SAIR:");
            System.out.println("    Digite 1 para SETOR.");
            System.out.println("    Digite 2 para USUARIO.");
            System.out.println("    Digite 3 para BEM.");
            System.out.println("    Digite 4 para TROCA.");
            
            try {
                op = sc.nextInt();
                switch(op) {
                    case 0:
                        sc.close();    
                        return;
    
                    case 1:
                        VisaoSetor.MenuSetor(banco, sc);
                        break;
                        
                    case 2:
                        VisaoUsuario.MenuUsuario(banco, sc);
                        break;
                    
                    case 3:
                        VisaoBem.MenuBem(banco, sc);
                        break; 
                    
                    case 4:
                        VisaoTroca.MenuTroca(banco, sc);
                        break;
                    
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("CAMPO PREENCHIDO INCORRETAMENTE! ESCOLHA NOVAMENTE.");
                sc.nextLine();
            }
        }
    }  
}
