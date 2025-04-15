public class Brownie {
    // SuperClasse ou Classe Mãe.
    // protected: acessível dentro da herança.
    protected String nome;
    protected double preco;
    protected String sabor;

    public Brownie(String nome, double preco, String sabor) {
        this.nome = nome;
        this.preco = preco;
        this.sabor = sabor;
    }

    public void addCarrinhoDeCompras(){
        System.out.println("Carrinho de compras");
    }

    public void calculaValorTotalCompra(){
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
    }

    public void mostraInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
    }

}
