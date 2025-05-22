import java.util.HashSet;
import java.util.Set;

public class Conta {

    private double saldo;
    private double limite;
    private Set<Cliente> clientes = new HashSet<>();

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    public void mostraInfo(){
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("Clientes: ");
        for (Cliente cliente : clientes) {
            try {
                System.out.println(cliente.getNome());
                System.out.println(cliente.getCpf());
            }catch(NullPointerException e){
                System.out.println("Erro triste: " + e);
            }
        }
    }

    public void sacar(double quantia) throws SaldoInsuficienteException {
        if(quantia < (saldo + limite)){
            this.saldo -= quantia;
        }
        else{
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }

    public void setClientes(Cliente cliente) {
        clientes.add(cliente);
    }
}

