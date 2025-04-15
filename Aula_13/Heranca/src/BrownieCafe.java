public class BrownieCafe extends Brownie {

    //Subclasse
    int quantCafe;

    public BrownieCafe(String nome, double preco, String sabor) {
        super(nome,preco, sabor); // Chamada da superclasse.
    }

    // Méto.do específico:

    public void adicionaCafe(){
        System.out.println("Adicionando cafe");
    }
}
