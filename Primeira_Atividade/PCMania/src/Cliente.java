public class Cliente {

    public String nome;
    public long cpf;
    public float valor;
    public int []op = new int[3];

    Computador[]computador = new Computador[3];

    public Cliente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public float calculaTotalCompra(){
        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0 && i < computador.length && computador[i] != null) {
                valor += op[i] * computador[i].preco;
            }
        }

        return valor;

    }


}
