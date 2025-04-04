public class Cliente {
    public String nome;
    public long cpf;
    float valor = 0;

    Computador[] computadores = new Computador[3];

    public Cliente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    // Calcula o valor atual e total dos computadores comprados:
    public float calculaTotalCompra(){
        for(Computador comp : computadores){
            if(comp != null) {
                valor += comp.preco;
            }
        }
        return valor;
    }
}