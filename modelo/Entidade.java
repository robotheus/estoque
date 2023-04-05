package modelo;

public abstract class Entidade {
    private int id;
    private String name;
    private static int count = 0;

    public Entidade(){
        count++;
        this.id = count;
        this.name = null;
    }

    public Entidade(String name){
        count++;
        this.id = count;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "[id = " + id + ", name = " + name;
    }  
}
