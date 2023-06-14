import visao.MenuGeralGUI;
import persistencia.*;

public class Program{
    public static void main(String[] args){
        BancoDeDados banco = new BancoDeDados();
        new MenuGeralGUI(banco);
    }
}