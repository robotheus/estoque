package visao;

import java.util.Scanner;

import modelo.Administrador;

public class VisaoAdmin {
    Scanner sc = new Scanner(System.in);
    Administrador adm;

    public VisaoAdmin(Administrador adm){
        this.adm = adm;    
    }

    public void menu(){
        while(true){
            System.out.println("--------------------MENU--------------------");
            System.out.println("    Digite 0 para SAIR.");
            System.out.println("    Digite 1 para cadastrar uma CHEFIA.");
            System.out.println("    Digite 2 para cadastrar um SETOR.");
            int op = sc.nextInt();

            switch(op){
                case 1:
                    System.out.println("Digite o nome da CHEFIA:");
                    String chefiaName = sc.nextLine();
                    adm.cadastrarChefia(chefiaName);
                
                case 2:
                    System.out.println("Digite o nome do SETOR");
                    String setorName = sc.nextLine();
                    adm.cadastrarSetor(setorName);
                
                case 3:
                    
            }
        }
        
    }
}
