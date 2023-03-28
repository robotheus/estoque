import java.util.Scanner;

public class Program{
    public static void main(String[] matheus){
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
                    sc.close();
                    break;
                
                default:
                    sc.close();
                    break;
            }
        }
    }
}