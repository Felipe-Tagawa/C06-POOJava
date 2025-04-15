public class BrownieNutella extends Brownie{

    public BrownieNutella(String nome, double preco, String sabor) {
        super(nome, preco, sabor);
    }

    // Sobrescrever um método para torná-lo específico(depende de herança prévia):
    @Override
    public void addCarrinhoCompras(){
        System.out.println("Adicionando um Brownie de Nutella no carrinho de compras.");
    }
    // A sobrescrita de método é sempre prioritário em relação à da superclasse, mesmo que o objeto seja do tipo da Superclasse:
    // Ex.: Brownie bn = new BrownieNutella(...);
    // bn.addCarrinhoCompras(); --> Vai sair o resultado do método sobrescrito.
}
