public class Comprador {

    private String nome;
    private double saldo;

    public void efetuarCompra(Brownie brownie){
        brownie.addCarrinhoCompras();
        brownie.calculaValorTotalCompra();
        System.out.println("Comprando um brownie de " + brownie.getSabor());
    }

    public Comprador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }
}
