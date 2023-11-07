package Esercizio1; 

public abstract class RegistroVendite{
    void buy(Giocattolo giocattolo, Cliente cliente){
        cliente.setMoneyAmt(cliente.getMoneyAmt() - giocattolo.getPrice());
        RegistroAcquisti registroAcquisti = RegistroAcquisti.ClassRegistroAcquisti(); 
        registroAcquisti.addToGiocattoli(new Vendita(giocattolo, cliente));
    }
}