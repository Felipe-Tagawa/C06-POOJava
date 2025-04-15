public class Brownie {

    protected String nome;
    protected double preco;
    protected String sabor;

    double valor;

    public Brownie(String nome, double preco, String sabor) {
        this.nome = nome;
        this.preco = preco;
        this.sabor = sabor;
    }

    public void addCarrinhoCompras(){
        System.out.println("Adicionando um Brownie no carrinho de compras.");
    }

    public void calculaValorTotalCompra(){
        System.out.println("Valor da compra: " + preco);
    }

    public void mostraInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Sabor: " + sabor);
    }

    public String getSabor() {
        return sabor;
    }
}
