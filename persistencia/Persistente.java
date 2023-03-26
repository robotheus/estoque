package persistencia;

import java.util.ArrayList;

import modelo.Produto;
import modelo.Setor;
import modelo.Troca;
import modelo.Chefia;
import modelo.Funcionario;

public class Persistente {
    private ArrayList<Setor> setorPersistencia;
    private ArrayList<Produto> prodPersistencia;
    private ArrayList<Chefia> chefiaPersistencia;
    private ArrayList<Funcionario> funcPersistencia;
    private ArrayList<Troca> trocasPersistencia;

    public Persistente(){
        this.setorPersistencia = new ArrayList<Setor>();
        this.prodPersistencia = new ArrayList<Produto>();
        this.chefiaPersistencia = new ArrayList<Chefia>();
        this.funcPersistencia = new ArrayList<Funcionario>();
        this.trocasPersistencia = new ArrayList<Troca>();
    }

    public <T> Object searchId(int id){
        for(Setor x : setorPersistencia){
            if(x.getId() == id) return x;
        }

        for(Produto x : prodPersistencia){
            if(x.getId() == id) return x;
        }

        for(Chefia x : chefiaPersistencia){
            if(x.getId() == id) return x;
        }

        for(Funcionario x : funcPersistencia){
            if(x.getId() == id) return x;
        }

        for(Troca x : trocasPersistencia){
            if(x.getId() == id) return x;
        }

        return "ID INEXISTENTE";
    }

    public void addSetor(Setor s){
        setorPersistencia.add(s);
    }
    
    public void removeSetor(Setor s){
        setorPersistencia.remove(s);
    }

    public void addProduto(Produto p){
        prodPersistencia.add(p);
    }
    
    public void removeProduto(Produto p){
        prodPersistencia.remove(p);
    }

    public void addChefia(Chefia c){
        chefiaPersistencia.add(c);
    }

    public void removeChefia(Chefia f){
        chefiaPersistencia.remove(f);
    }

    public void addFunc(Funcionario f){
        funcPersistencia.add(f);
    }

    public void removeFunc(Funcionario f){
        funcPersistencia.remove(f);
    }

    public ArrayList<Setor> getsetorPersistencia() {
        return setorPersistencia;
    }

    public ArrayList<Produto> getProdPersistencia() {
        return prodPersistencia;
    }

    public ArrayList<Chefia> getChefiaPersistencia() {
        return chefiaPersistencia;
    }

    public ArrayList<Funcionario> getFuncPersistencia() {
        return funcPersistencia;
    }

    public ArrayList<Troca> gettrocasPersistencia() {
        return trocasPersistencia;
    }
    
}
