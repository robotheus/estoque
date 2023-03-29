package visao;

import java.util.Scanner;
import modelo.Setor;
import persistencia.*;

public class VisaoSetor {
    public static void MenuSetor(BancoDeDados banco){
        Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("--------------------SETOR--------------------");
                System.out.println("    Digite 0 para RETORNAR ao menu inicial.");
                System.out.println("    Digite 1 para CADASTRAR um SETOR.");
                System.out.println("    Digite 2 para REMOVER um SETOR.");
                System.out.println("    Digite 3 para ALTERAR o SETOR.");
                System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
                System.out.println("    Digite 5 para VISUALIZAR TODOS.");

                int op = sc.nextInt();
                
                switch (op) {
                    case 1:
                        System.out.println("Digite o NOME do NOVO setor: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        Setor novoSetor = new Setor(name);
                        banco.addSetorPersistente(novoSetor);
                        System.out.println();
                        break;
                    
                    case 2:
                        System.out.println("Digite o NOME do setor a ser REMOVIDO:");
                        sc.nextLine();
                        String removeName = sc.nextLine();
                        String a = banco.removeSetorPersistente(removeName);
                        System.out.println(a);
                        System.out.println();
                        break;
                    default:
                        break;
                }
            }   
    }
}
