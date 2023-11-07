package Esercizio1;

public abstract class Account {
    public static int id = 1;
    private int myId;  
    private String name; 
    private String username; 

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

    //constructor
    public Account(){
        myId = id; 
        id++; 
    }
    public Account(String name, String username){
        this(); 
        this.name = name; 
        this.username = username; 
    }
}
