import java.util.Scanner;
import modelo.Administrador;

public class Program{
    public static void main(String[] matheus){
        Scanner sc = new Scanner(System.in);
        Administrador adm = new Administrador();

        while(true){
            System.out.println("--------------------stocker--------------------");
            System.out.println("Selecione seu tipo de usuário ou 0 para SAIR:");
            System.out.println("    Digite 1 para Administrador do sistema.");
            System.out.println("    Digite 2 para Chefia.");
            System.out.println("    Digite 3 para Funcionário.");
            int op = sc.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("Digite a senha de ADMINISTRADOR: ");
                    String pass = sc.next();
                    if (pass.equals(adm.getName())) adm.getVisao().menu();
                    sc.close();
                    break;
                
                default:
                    sc.close();
                    break;
            }
        }
    }
}