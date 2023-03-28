import visao.MenuGeral;
import persistencia.BancoDeDados;

public class Program{
    public static void main(String[] args){
        BancoDeDados banco = new BancoDeDados();
        MenuGeral.Menu(banco);
    }
}