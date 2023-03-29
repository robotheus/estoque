package visao;

import java.util.Scanner;

import modelo.*;
import persistencia.*;

public class VisaoTroca {
    public static void MenuTroca(BancoDeDados banco, Scanner sc){
        int op;

        while(true){
            System.out.println("--------------------TROCA--------------------");
            System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
            System.out.println("    Digite 1 para REALIZAR um TROCA.");
            System.out.println("    Digite 2 para ALTERAR uma TROCA (REMOVER OU ALTERAR ITENS).");
            System.out.println("    Digite 3 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 4 para VISUALIZAR TODOS.");

            op = sc.nextInt();

            switch(op) {
                case 0: 
                    return;
                
                case 1:
                    
                    break;
                        
                case 2:
                    
                    break;
                        
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;    
                    
                default:
                    break;
            }    
        }
    }
}