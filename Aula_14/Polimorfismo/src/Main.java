public class Main {
    public static void main(String[] args) {
        //BrownieNutella bn = new BrownieNutella("BrownieDeNutella", 20, "Nutella");
        // 2° forma de polimorfismo:
        Brownie b1 = new BrownieNutella("BrownieNutella", 20.0, "Nutella");
        Brownie b2 = new BrownieCafe("BrownieCafe", 10.0, "Cafe");
        Brownie b3 = new BrownieDoceDeLeite("BrownieDoceDeLeite", 15.0, "Doce");
        Comprador comprador = new Comprador("Antônio", 25.0);
        b1.addCarrinhoCompras();

        if(b1 instanceof BrownieNutella) {
            BrownieNutella brownienutella = (BrownieNutella) b1; // Casting
            brownienutella.addCarrinhoCompras();
            comprador.efetuarCompra(brownienutella);
        }

        comprador.efetuarCompra(b1);
        comprador.efetuarCompra(b2);
        comprador.efetuarCompra(b3);

        b1.calculaValorTotalCompra();

        b1.mostraInfo();
        b2.mostraInfo();
        b3.mostraInfo();

    }
}