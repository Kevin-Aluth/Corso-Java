package Esercizio1;

import java.util.Scanner;

public class TestMain extends RegistroVendite {
    static Scanner myScanner = new Scanner(System.in); ; 
    static Account activeAccount = new Admin("Kevin", "Kevinoh"); 
    static Inventario inventario = Inventario.ClassInventario(); 
    static RegistroAcquisti registroAcquisti = RegistroAcquisti.ClassRegistroAcquisti(); 
    public static void main(String[] args) {
        inventario.addToGiocattoli(new Giocattolo("Palla", 10, 10));
        inventario.addToGiocattoli(new Giocattolo("Slime", 5, 10));
        inventario.addToGiocattoli(new Giocattolo("PlayStation", 240, 14));

        System.out.println("Benvenuto, " + activeAccount.getName());
        showMenu();
    }

    static void showMenu(){
        if(activeAccount instanceof Admin){
            String input = "";
            boolean hasChosen = false;  
            while(!hasChosen){
                System.out.println("Scegli un'opzione: ");
                System.out.println("1) Aggiungi giocattolo\n2) Rimuovi giocattolo\n3) Mostra giocattoli\n0) Quitta"); 
                input = myScanner.nextLine(); 

                switch (input) {
                    case "1": 
                        System.out.println("Inserisci nome: ");
                        String nome = myScanner.nextLine();
                        System.out.println("Inserisci prezzo (numero): "); 
                        int prezzo = myScanner.nextInt(); 
                        System.out.println("Inserisci eta' target (numero): ");
                        int eta = myScanner.nextInt();  
                        inventario.addToGiocattoli(new Giocattolo(nome, prezzo, eta));
                        myScanner.nextLine(); 
                        break; 
                    case "2": 
                        System.out.println("Inserisci id giocattolo: "); 
                        int idToRemove = myScanner.nextInt(); 
                        inventario.removeFromGiocattoli(idToRemove);
                        myScanner.nextLine(); 
                        break; 
                    case "3":
                        System.out.println(inventario);
                        break;
                    case "0": 
                        hasChosen = true; 
                        break; 
                    default:
                        System.out.println("Seleziona un'opzione valida. ");
                        break;
                }
            }
        }
        else if(activeAccount instanceof Cliente){
            String input = "";
            boolean hasChosen = false;  
            Cliente cl = (Cliente)activeAccount; 
            while(!hasChosen){
                System.out.println("Scegli un'opzione: ");
                System.out.println("1) Acquista giocattolo\n2) Mostra giocattoli\n3) Mostra acquisti\n0) Quitta"); 
                input = myScanner.nextLine(); 

                switch (input) {
                    case "1":
                        System.out.println("Il tuo saldo e' di " + cl.getMoneyAmt());
                        System.out.println("Inserisci l'id del giocattolo da acquistare: ");
                        int i = myScanner.nextInt();
                        Giocattolo activeGiocattolo = null;  
                        for(Giocattolo g : inventario.getGiocattoli()){
                            if(g.getId() == i){
                                activeGiocattolo = g;
                                break; 
                            } 
                        }
                        if(activeGiocattolo != null) buy(activeGiocattolo, cl); 
                        else System.out.println("Id non trovato. ");
                        myScanner.nextLine(); 
                        break;
                    case "2":
                        System.out.println(inventario);
                        break; 
                    case "3": 
                        System.out.println(registroAcquisti);
                        break; 
                    case "0": 
                        hasChosen = true; 
                        break; 
                    default:
                        System.out.println("Seleziona un'opzione valida. ");
                        break;
                }
            }
        }
    }
}
