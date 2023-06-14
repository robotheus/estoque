import visao.MenuGeral;
import persistencia.*;

public class Program{
    public static void main(String[] args){
        BancoDeDados banco = new BancoDeDados();
        new MenuGeral(banco);
    }
}