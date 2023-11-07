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
    public void addToVendite(Vendita vendita){
        vendite.add(vendita); 
    } 

    @Override
    public String toString(){
        String output = ""; 
        for(int i = 0; i < vendite.size(); i++){
            output += vendite.get(i).toString() + "\n"; 
        }
        return output;  
    }
}
