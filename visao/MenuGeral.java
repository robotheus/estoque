package visao;

import java.util.Scanner;

import persistencia.BancoDeDados;

public class MenuGeral {
    public static void Menu(BancoDeDados banco){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("--------------------stocker--------------------");
            System.out.println("Selecione seu tipo de usuário ou 0 para SAIR:");
            System.out.println("    Digite 1 para SETOR.");
            System.out.println("    Digite 2 para USUARIO.");
            System.out.println("    Digite 3 para BEM.");
            System.out.println("    Digite 4 para TROCA.");

            int op = sc.nextInt();
            
            switch (op) {
                case 1:
                    VisaoSetor.MenuSetor(banco);
                    break;
                
                default:
                    
                    break;
            }
            
            sc.close();
        }

        
    }  
}
