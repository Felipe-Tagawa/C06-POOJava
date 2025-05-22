public class Main {
    public static void main(String[] args) {
        /*
            Obrigatoriedade de tratamento de erros(erros em vermelho) antes de executar.
            Outra opção: Throws declaration após a public main - tudo que chamar esse method main precisará fazer um try - catch na classe que chama.
            Mas não faz sentido colocar na main, pois nenhuma classe chama a main - jogar o erro para outra classe.
        */

        /*
        public void sacar(double quantia){
            if(quantia < (saldo + limite)){
                this.saldo -= quantia;
            }
            else{
                throw new IllegalArgumentException(); -- Lançar uma exceção para mostrar que deu erro.
            }
        }
        */

        /* Para mostrar a mensagem personalizada para um erro específico:

        public class SaldoInsuficienteException extends RuntimeException {
            public SaldoInsuficienteException(String message){
                super(message);
            }
        }

        // no method sacar:
        else{
            throw new SaldoInsuficienteException("Saldo insuficiente");
            // Precisa de um try-catch onde for chamar esse method.
        }

        Herdar só de Exception gera uma checked exception e herdar de runtime gera uma unchecked exception.
        finally após catch sempre será executado.
        */

        Conta conta = new Conta(100, 500);
        Cliente cliente1 = new Cliente("Zezinho", 123456789);
        Cliente cliente2 = new Cliente("Zezao", 987654321);
        Cliente cliente3 = null;

        conta.setClientes(cliente1);
        conta.setClientes(cliente2);
        conta.setClientes(cliente3);


        try {
            conta.mostraInfo();
        }catch(NullPointerException e){
            System.out.println("Erro: " + e);
        }

        try{
            conta.sacar(1000);
        }catch(SaldoInsuficienteException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            System.out.println("Fim do programa");
        }


    }
}