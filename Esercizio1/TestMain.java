package Esercizio1;

import java.util.Scanner;

public class TestMain extends RegistroVendite {
    static Scanner myScanner = new Scanner(System.in); ; 
    static Account activeAccount = null; 
    static final int MAX_ACCOUNT_NUM = 10; 
    static Account[] accounts = new Account[MAX_ACCOUNT_NUM];
    static Inventario inventario = Inventario.ClassInventario(); 
    static RegistroAcquisti registroAcquisti = RegistroAcquisti.ClassRegistroAcquisti(); 
    public static void main(String[] args) {
        System.out.println("Ciao da MyBranch");

        //adding toys
        inventario.addToGiocattoli(new Giocattolo("Palla", 10, 10));
        inventario.addToGiocattoli(new Giocattolo("Slime", 5, 10));
        inventario.addToGiocattoli(new Giocattolo("PlayStation", 240, 14));
        //creating admin
        accounts[0] = new Admin("Kevin", "Kevinoh"); 
        int accountsSigned = 1; 
        //accessing account and showing actions
        boolean hasQuit = false; 
        while(activeAccount == null && !hasQuit){
            System.out.println("1) Accedi\n2) Registrati\n0) Quitta");
            String input = myScanner.nextLine(); 
            switch (input) {
                case "1":
                    //account access
                    System.out.println("Inserisci username: ");
                    String username = myScanner.nextLine(); 
                    for(int i = 0; i < accountsSigned; i++){
                        if(accounts[i].getUsername().equals(username)){
                            activeAccount = accounts[i]; 
                            break; 
                        }
                    }
                    if(activeAccount != null){
                        System.out.println("Accesso completato. ");
                        System.out.println("Benvenuto, " + activeAccount.getName());
                        showMenu();
                    }
                    else System.out.println("Account non trovato");
                    break;
                case "2": 
                    //account creation
                    System.out.println("Inserisci username: ");
                    String accountUsername = myScanner.nextLine(); 
                    System.out.println("Inserisci nome e cognome: ");
                    String accountName = myScanner.nextLine(); 
                    System.out.println("Quanti soldi vuoi spendere? ");
                    int money = myScanner.nextInt(); 
                    myScanner.nextLine();
                    accounts[accountsSigned] = new Cliente(accountName, accountUsername, money);  
                    accountsSigned++; 
                    System.out.println("Account creato. ");
                    break; 
                case "0": 
                    hasQuit = true; 
                    break; 
                default:
                    System.out.println("Inserisci opzione valida");
                    break;
            }
        }
    }

    static void showMenu(){
        if(activeAccount instanceof Admin){
            String input = "";
            boolean hasChosen = false;  
            while(!hasChosen){
                //showing menu
                System.out.println("Scegli un'opzione: ");
                System.out.println("1) Aggiungi giocattolo\n2) Rimuovi giocattolo\n3) Mostra giocattoli\n0) Quitta"); 
                input = myScanner.nextLine(); 

                switch (input) {
                    case "1": 
                    //creating toy
                        System.out.println("Inserisci nome: ");
                        String nome = myScanner.nextLine();
                        System.out.println("Inserisci prezzo (numero): "); 
                        int prezzo = myScanner.nextInt(); 
                        System.out.println("Inserisci eta' target (numero): ");
                        int eta = myScanner.nextInt();  
                        inventario.addToGiocattoli(new Giocattolo(nome, prezzo, eta));
                        System.out.println("Giocattolo aggiunto"); 
                        myScanner.nextLine(); 
                        break; 
                    case "2": 
                        //removing toy
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
                        activeAccount = null; 
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
                //showing menu
                System.out.println("Scegli un'opzione: ");
                System.out.println("1) Acquista giocattolo\n2) Mostra giocattoli\n3) Mostra acquisti\n0) Quitta"); 
                input = myScanner.nextLine(); 

                switch (input) {
                    case "1":
                        //buying toy
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
                        activeAccount = null; 
                        break; 
                    default:
                        System.out.println("Seleziona un'opzione valida. ");
                        break;
                }
            }
        }
    }
}
