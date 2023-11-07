package Esercizio1; 

public class Giocattolo{
    public static int id = 1; 
    private int myId; 
    private String name; 
    private int price; 
    private int recomendedAge; 
    
    //getter e setter
    public int getId() {
        return myId;
    }
    
    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getRecomendedAge() {
        return recomendedAge;
    }public void setRecomendedAge(int recomendedAge) {
        this.recomendedAge = recomendedAge;
    }

    //constructors
    public Giocattolo(){
        myId = id;
        id++;
    }
    public Giocattolo(String name, int price, int recomendedAge){
        this(); 
        this.name = name; 
        this.price = price; 
        this.recomendedAge = recomendedAge; 
    }

    @Override 
    public String toString(){
        return name +
        ", Prezzo: " + price +
        ", Eta' raccomandata: " + recomendedAge +
        ", Id: " + myId; 
    }
}