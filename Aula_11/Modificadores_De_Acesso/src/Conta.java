public class Conta {

    private int numero; // Protege os membros de serem acessados na main.
    private float saldo, limite;
    private Cliente titular;

    void saca(float quantia) { // Se n tem public nem private, ele é default(publico dentro do pacote e privado para fora do pacote).
        if(this.saldo > quantia){
            this.saldo -= quantia;
            System.out.println("Saque realizado com sucesso!");
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    private boolean verificaSerasa(){ // Acesso só dentro da classe.
    }

    public void pedirEmprestimo(float quantia){
        if(verificaSerasa()){

        }
    }

    public float getSaldo(){ // Getter
        return this.saldo;
    }

    public void setSaldo(float saldo){ // Setter
        this.saldo = saldo;
    }

}
