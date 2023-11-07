package Esercizio1;

public class TestMain {
    public static void main(String[] args) {
        Giocattolo ciao = new Giocattolo("Palla", 13, 12); 
        System.out.println(ciao.getId());
        Giocattolo ciao1 = new Giocattolo("Slime", 2, 11); 
        System.out.println(ciao1.getId());

        Cliente bro = new Cliente("Pippo", "Baudo", 23); 
        System.out.println(bro.getId()); 
        Cliente bro1 = new Cliente("Maria", "De Filippi", 45); 
        System.out.println(bro1.getId());

        Inventario myInventario = Inventario.ClassInventario(); 
        myInventario.addToGiocattoli(ciao1);
        myInventario.addToGiocattoli(ciao);
        System.out.println(myInventario);

        RegistroAcquisti registroAcquisti = RegistroAcquisti.ClassRegistroAcquisti(); 
    }
}
