package Esercizio1; 

public abstract class RegistroVendite{
    static void buy(Giocattolo giocattolo, Cliente cliente){
        if(cliente.getMoneyAmt() >= giocattolo.getPrice()){
            cliente.setMoneyAmt(cliente.getMoneyAmt() - giocattolo.getPrice());
            RegistroAcquisti registroAcquisti = RegistroAcquisti.ClassRegistroAcquisti(); 
            registroAcquisti.addToVendite(new Vendita(giocattolo, cliente));
            System.out.println("Giocattolo acquistato. ");
        }
        else{
            System.out.println("Impossibile acquistare, fondi insufficienti. "); 
        }
    }
}