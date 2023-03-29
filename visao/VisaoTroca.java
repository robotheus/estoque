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
            System.out.println("    Digite 2 para REMOVER um USUARIO.");
            System.out.println("    Digite 3 para ALTERAR o USUARIO (Trocar de setor).");
            System.out.println("    Digite 4 para VISUALIZAR VIA ID.");
            System.out.println("    Digite 5 para VISUALIZAR TODOS.");
        }
    }
}
