package Esercizio1;

import java.util.ArrayList;
import java.util.List;

public class RegistroAcquisti {
    List<Vendita> vendite = new ArrayList<>(); 
    private static RegistroAcquisti instance; 

    //singleton pattern
    private RegistroAcquisti(){}
    public static RegistroAcquisti ClassRegistroAcquisti(){
        if(instance == null){
             instance = new RegistroAcquisti(); 
        }
        return instance; 
    }

    //getter and "setters"
    public ArrayList<Vendita> getVendite(){
        return (ArrayList<Vendita>)vendite; 
    }
    public void addToGiocattoli(Vendita vendita){
        vendite.add(vendita); 
    } 
}
