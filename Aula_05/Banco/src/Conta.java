public class Conta {


    // Atributos
    int saldo;
    int limite;
    float numero_da_conta;
    String nome_do_Dono;

    // Métodos
    public void sacar(int quantidade){
        saldo -= quantidade;
    }

    public void depositar(int quantidade){
        saldo += quantidade;
    }

}
