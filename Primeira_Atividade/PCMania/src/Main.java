import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Bem vindo à loja de computadores, primeiro insira o seu nome:  ");

        String nome = entrada.nextLine();
        while(nome.isEmpty()) {
            System.out.println("Insira um nome permitido: ");
            nome = entrada.nextLine();
        }

        System.out.print("Agora insira seu CPF para login: ");
        long cpf = Long.parseLong(entrada.nextLine());
        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("Veja nossas opções de computadores: ");

        MemoriaUSB mem = new MemoriaUSB();
        cliente.computador[0] = new Computador("Apple", 2037.f); // Matrícula.
        cliente.computador[1] = new Computador("Samsung", 3721.f); // Matrícula + 1234.
        cliente.computador[2] = new Computador("Dell", 7715.f); // Matrícula + 5678.

        for(int i = 0; i < cliente.computador.length; i++){
            cliente.computador[i].hw[0] = new HardwareBasico();
            cliente.computador[i].hw[1] = new HardwareBasico();
            cliente.computador[i].hw[2] = new HardwareBasico();
            cliente.computador[i].sistema = new OS();
            cliente.computador[i].mem = mem;
        }

        cliente.computador[0].hw[0].setNome("Pentium Core i3");
        cliente.computador[0].hw[1].setNome("Memoria RAM");
        cliente.computador[0].hw[2].setNome("HD");
        cliente.computador[0].hw[0].setCapacidade(2200); // 2200 MHz.
        cliente.computador[0].hw[1].setCapacidade(8); // 8Gb Memória Ram.
        cliente.computador[0].hw[2].setCapacidade(500); // 500 Gb HD.
        cliente.computador[0].sistema.setNome("Linux Ubuntu");
        cliente.computador[0].sistema.setTipo(32); // 32 bits
        cliente.computador[0].addMemoriaUSB(mem);
        cliente.computador[0].mem.setNome("Pen-Drive");
        cliente.computador[0].mem.setCapacidade(16); // 16Gb
        cliente.computador[0].addMemoriaUSB(mem);

        cliente.computador[1].hw[0].setNome("Pentium Core i5");
        cliente.computador[1].hw[1].setNome("Memoria RAM");
        cliente.computador[1].hw[2].setNome("HD");
        cliente.computador[1].hw[0].setCapacidade(3370); // 3370 MHz.
        cliente.computador[1].hw[1].setCapacidade(16); // 16Gb Memória Ram.
        cliente.computador[1].hw[2].setCapacidade(1000); // 1000Gb HD ou 1Tb.
        cliente.computador[1].sistema.setNome("Windows 8");
        cliente.computador[1].sistema.setTipo(64); // 64 bits
        cliente.computador[0].addMemoriaUSB(mem);
        cliente.computador[1].mem.setNome("Pen-drive");
        cliente.computador[1].mem.setCapacidade(32); // 32Gb
        cliente.computador[1].addMemoriaUSB(mem);

        cliente.computador[2].hw[0].setNome("Pentium Core i7");
        cliente.computador[2].hw[1].setNome("Memoria RAM");
        cliente.computador[2].hw[2].setNome("HD");
        cliente.computador[2].hw[0].setCapacidade(4500); // 4500 MHz.
        cliente.computador[2].hw[1].setCapacidade(32); // 32Gb Memória Ram.
        cliente.computador[2].hw[2].setCapacidade(2000); // 2000 Gb HD ou 2Tb.
        cliente.computador[2].sistema.setNome("Windows 10");
        cliente.computador[2].sistema.setTipo(64); // 64 bits
        cliente.computador[0].addMemoriaUSB(mem);
        cliente.computador[2].mem.setNome("HD Externo");
        cliente.computador[2].mem.setCapacidade(1000); // 1000 Gb ou 1Tb
        cliente.computador[2].addMemoriaUSB(mem);

        System.out.println();
        System.out.println("Escolha entre as opções de promoção a seguir para visualizar: ");
        System.out.println();
        System.out.println("Modelo 1 - Mais Simples e Barato.");
        System.out.println("Modelo 2 - Intermediário.");
        System.out.println("Modelo 3 - Mais Robusto e Caro.");
        System.out.println("4 - Ir para as compras.");
        System.out.println();

        int opcao;
        do {
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    cliente.computador[0].mostraPCConfigs();
                    System.out.println();
                    System.out.println("Modelo 1 - Mais Simples e Barato.");
                    System.out.println("Modelo 2 - Intermediário.");
                    System.out.println("Modelo 3 - Mais Robusto e Caro.");
                    System.out.println("4 - Ir para as compras.");
                    System.out.println();
                    break;
                case 2:
                    cliente.computador[1].mostraPCConfigs();
                    System.out.println();
                    System.out.println("Modelo 1 - Mais Simples e Barato.");
                    System.out.println("Modelo 2 - Intermediário.");
                    System.out.println("Modelo 3 - Mais Robusto e Caro.");
                    System.out.println("4 - Ir para as compras.");
                    System.out.println();
                    break;
                case 3:
                    cliente.computador[2].mostraPCConfigs();
                    System.out.println();
                    System.out.println("Modelo 1 - Mais Simples e Barato.");
                    System.out.println("Modelo 2 - Intermediário.");
                    System.out.println("Modelo 3 - Mais Robusto e Caro.");
                    System.out.println("4 - Ir para as compras.");
                    System.out.println();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Escreva um valor válido.");
            }
        }while(opcao != 4);

        int op; // Variável para opção de escolha do cliente.
        boolean[] escolhido = new boolean[3]; // Aplicar a lógica de estoque, começam com false.

        // Fiz uma lógica de no máximo 3 computadores de cada promoção poderem ser comprados por cada usuário(estoque).
        boolean[] compradoFull = new boolean[3]; // Vai ser verdadeira se todos os computadores de tal promoção se esgotarem.

        System.out.println("Agora que já está ciente das promoções");
        while(true) {

            System.out.println();
            System.out.println("Escolha sua opção(1 - 3) ou 0 para sair:");
            op = entrada.nextInt();

            if(op == 0){
                break;
            }
            switch (op) {
                case 1:
                    if(cliente.op[0] < 3) {
                        System.out.println("Computador 1 comprado!");
                        escolhido[0] = true;
                        cliente.op[0]++;
                        if(cliente.op[0] == 3) {
                            compradoFull[0] = true;
                        }
                    }
                    else {
                        System.out.println("Você já comprou o Computador 1 o número máximo de vezes!");
                    }
                    break;
                case 2:
                    if (cliente.op[1] < 3) {
                        System.out.println("Computador 2 comprado!");
                        escolhido[1] = true;
                        cliente.op[1]++;
                        if(cliente.op[1] == 3) {
                            compradoFull[1] = true;
                        }
                    } else {
                        System.out.println("Você já comprou o Computador 2, o número máximo de vezes!");
                    }
                    break;
                case 3:
                    if (cliente.op[2] < 3) {
                        System.out.println("Computador 3 comprado!");
                        escolhido[2] = true;
                        cliente.op[2]++;
                        if(cliente.op[2] == 3) {
                            compradoFull[2] = true;
                        }
                    } else {
                        System.out.println("Você já comprou o Computador 3, o número máximo de vezes!");
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção viável!");
                    break;
            }
        }

        if (escolhido[0] || escolhido[1] || escolhido[2]) {
            System.out.println("O(s) PC(s) comprado(s) é(são):");
            System.out.println();

            for(int i = 0; i < cliente.computador.length; i++){
                if(escolhido[i]){
                    cliente.computador[i].mostraPCConfigs();
                }
            }

            System.out.printf("| %-53s | ","Você comprou " + cliente.op[0] + " " + cliente.computador[0].marca);
            System.out.println();
            System.out.printf("| %-53s | ","Você comprou " + cliente.op[1] + " " + cliente.computador[1].marca);
            System.out.println();
            System.out.printf("| %-53s | ","Você comprou " + cliente.op[2] + " " + cliente.computador[2].marca);
            System.out.println();

            // O uso das %- :  apenas para deixar a saída mais elegante.
            if (compradoFull[0] && compradoFull[1] && compradoFull[2]) {
                System.out.printf("| %-53s | ", "Você comprou todos os computadores disponíveis!");
                System.out.println();
            }

            System.out.printf("| %-53s | ", "O valor total das compras: R$ " + cliente.calculaTotalCompra());
            System.out.println();
            System.out.println("|-------------------------------------------------------|");
        }
        else{
            System.out.println("Nenhuma compra foi feita, esperamos que tenha mais interesse na próxima!");
        }

        System.out.println();
        System.out.println("Obrigado " + cliente.nome + ", volte sempre!");

        entrada.close();
    }
}