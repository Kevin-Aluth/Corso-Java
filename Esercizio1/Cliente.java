package Esercizio1;

public class Cliente extends Account {
    private int moneyAmt; 

    public int getMoneyAmt() {
        return moneyAmt;
    }public void setMoneyAmt(int moneyAmt) {
        this.moneyAmt = moneyAmt;
    }

    public Cliente(String name, String username, int moneyAmt){
        super(name, username); 
        this.moneyAmt = moneyAmt; 
    }
}
