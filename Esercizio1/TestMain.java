package Esercizio1;

import java.nio.channels.ClosedByInterruptException;

public class TestMain {
    public static void main(String[] args) {
        Giocattolo ciao = new Giocattolo(); 
        System.out.println(ciao.getId());
        Giocattolo ciao1 = new Giocattolo(); 
        System.out.println(ciao1.getId());

        Cliente bro = new Cliente(); 
        System.out.println(bro.getId()); 
        Cliente bro1 = new Cliente(); 
        System.out.println(bro1.getId());
    }
}
