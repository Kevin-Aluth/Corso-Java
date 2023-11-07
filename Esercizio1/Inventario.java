package Esercizio1;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Giocattolo> giocattoli = new ArrayList<>();
    private static Inventario instance; 

    //singleton pattern
    private Inventario(){}
    public static Inventario ClassInventario(){
        if(instance == null){
            instance = new Inventario(); 
        }
        return instance; 
    }

    //getter and "setters"
    public ArrayList<Giocattolo> getGiocattoli(){
        return (ArrayList<Giocattolo>)giocattoli; 
    }
    public void addToGiocattoli(Giocattolo giocattolo){
        giocattoli.add(giocattolo); 
        System.out.println("Giocattolo aggiunto"); 
    } 
    public void removeFromGiocattoli(int id){
        Giocattolo activeGiocattolo = null; 
        for(Giocattolo i : giocattoli){
            if(i.getId() == id){
                activeGiocattolo = i; 
                break; 
            }
        }
        if(activeGiocattolo != null) {
            giocattoli.remove(activeGiocattolo); 
            System.out.println("Giocattolo rimosso");
        } else System.out.println("Id non trovato"); 
    }

    @Override
    public String toString(){
        String output = ""; 
        for(int i = 0; i < giocattoli.size(); i++)
        {
            output += giocattoli.get(i).toString() + "\n"; 
        }
        return output; 
    }
}
