package Esercizio1;

public class Cliente {
    public static int id = 1;
    private int myId;  
    private String name; 
    private String username; 
    private int moneyAmt; 

    //getter e setter
    public int getId() {
        return myId;
    }

    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }public void setUsername(String username) {
        this.username = username;
    }

    public int getMoneyAmt() {
        return moneyAmt;
    }public void setMoneyAmt(int moneyAmt) {
        this.moneyAmt = moneyAmt;
    }

    //constructors
    public Cliente(){
        myId = id; 
        id++; 
    }
    public Cliente(String name, String username){
        this(); 
        this.name = name; 
        this.username = username; 
    }
}
