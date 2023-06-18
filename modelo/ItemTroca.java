package modelo;

public class ItemTroca {
    private Status status;
    private Bem bem;

    public ItemTroca(Bem bem, Status status){
        this.bem = bem;
        this.status = status;
    }

    public Status getstatus() {
        return status;
    }

    public Bem getBem() {
        return bem;
    }

    public void setStatus(Status s){
        this.status = s;
    }

    public String toString() {
        return "Itens trocados: [status = " + status + ", bem = " + bem + "]";
    }
}
