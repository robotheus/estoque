package modelo;

public class Setor extends Entidade{
    private Usuario userChefe;

    public Setor(String name){
        super(name);
        this.userChefe = null;
    }

    public Setor(String name, Usuario userChefe){
        super(name);
        this.userChefe = userChefe;
    }

    public Usuario getUserChefe() {
        return userChefe;
    }

    public void setUserChefe(Usuario userChefe) {
        this.userChefe = userChefe;
    }

    public String toString() {
        return super.toString() + "Setor [userChefe=" + userChefe + "]";
    } 

    //cadastrar um setor
    //remover um setor
    


    
    
    
}
