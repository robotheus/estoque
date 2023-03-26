package modelo;

import visao.VisaoAdmin;
import persistencia.Persistente;

public class Administrador {
    private String name;
    private VisaoAdmin visao;
    private Persistente banco;

    public Administrador(){
        name = "ADM";
        visao = new VisaoAdmin(this);
        banco = new Persistente();
    }

    public void cadastrarChefia(String name){
        Chefia chefe = new Chefia(name);
        banco.addChefia(chefe);
    }

    public void cadastrarSetor(String nameSetor){
        Setor setor = new Setor(nameSetor);
        banco.addSetor(setor);
    }

    public void alterarChefiaDoSetor(Setor setor, Chefia chefe){
        setor.setChefe(chefe);
    }

    public void alterarSetorFunc(Setor setor, Funcionario func){
        func.setSetorFunc(setor);
    }

    public String toString() {
        return "Administrador [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VisaoAdmin getVisao() {
        return visao;
    }
}
