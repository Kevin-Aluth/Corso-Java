package Esercizio1;

public class Vendita {
    private Cliente cliente; 
    private Giocattolo giocattolo; 

    public Vendita(Giocattolo giocattolo, Cliente cliente){
        this.giocattolo = giocattolo; 
        this.cliente = cliente; 
    }

    @Override
    public String toString(){
        return "Titolare acquisto: " + cliente.getUsername() + ", Nome giocattolo: " + giocattolo.getName(); 
    }
}
