public class Brownie implements Comparable<Brownie>{

    protected String nome;
    protected double preco;
    protected String sabor;

    // Ordenação da forma que quiser:
    @Override
    public int compareTo(Brownie BrownieExemplo){
        if(this.preco < BrownieExemplo.getPreco()){
            return -1;
        }
        if(this.preco > BrownieExemplo.getPreco()){
            return 1;
        }
        return 0; // Iguais.
    }

    private double getPreco() {
        return preco;
    }

}
