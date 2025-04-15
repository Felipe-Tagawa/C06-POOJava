public class Main {
    public static void main(String[] args) {

        BrownieCafe bc = new BrownieCafe("Fefézin", 10, "Café");
        BrownieNutella bn = new BrownieNutella("Nutella", 20, "Nutella");
        BrownieDoceDeLeite bd = new BrownieDoceDeLeite("Doce", 12, "DoceDeLeite");

        bc.addCarrinhoDeCompras();
        bn.addCarrinhoDeCompras();
        bd.addCarrinhoDeCompras();

        bd.adicionaDoceDeLeite();
        bc.adicionaCafe();
        bn.adicionaNutella();

        bd.mostraInfo();
        bc.mostraInfo();
        bn.mostraInfo();

    }
}