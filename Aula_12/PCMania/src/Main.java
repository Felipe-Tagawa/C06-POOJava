import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Bem vindo à loja de computadores, primeiro insira o seu nome:  ");
        String nome = entrada.nextLine();
        System.out.print("Agora insira seu CPF para login: ");
        long cpf = Long.parseLong(entrada.nextLine());
        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("Veja nossas opções de computadores: ");
        System.out.println();

        MemoriaUSB mem = new MemoriaUSB();
        cliente.computador[0] = new Computador("Apple", 2037); // Matrícula.
        cliente.computador[1] = new Computador("Samsung", 3721); // Matrícula + 1234.
        cliente.computador[2] = new Computador("Dell", 7715); // Matrícula + 5678.

        for(int i = 0; i < 3; i++){ // Depois ajustar pra length.
            cliente.computador[i].hw[0] = new HardwareBasico();
            cliente.computador[i].hw[1] = new HardwareBasico();
            cliente.computador[i].hw[2] = new HardwareBasico();
            cliente.computador[i].sistema = new OS();
            cliente.computador[i].mem = mem;
        }

        System.out.println("Opção 1: ");
        System.out.println();

        cliente.computador[0].hw[0].setNome("Pentium Core i3");
        cliente.computador[0].hw[1].setNome("Memoria RAM");
        cliente.computador[0].hw[2].setNome("HD");
        cliente.computador[0].hw[0].setCapacidade(2200); // 2200 MHz.
        cliente.computador[0].hw[1].setCapacidade(8); // 8Gb Memória Ram.
        cliente.computador[0].hw[2].setCapacidade(500); // 500 Gb HD.
        cliente.computador[0].sistema.setNome("Linux Ubuntu");
        cliente.computador[0].sistema.setTipo(32); // 32 bits
        cliente.computador[0].mem.setNome("Pen-Drive");
        cliente.computador[0].mem.setCapacidade(16); // 16Gb
        cliente.computador[0].addMemoriaUSB(mem);
        cliente.computador[0].mostraPCConfigs(); // Mostrar as configurações do PC1.

        System.out.println("Opção 2: ");
        System.out.println();

        cliente.computador[1].hw[0].setNome("Pentium Core i5");
        cliente.computador[1].hw[1].setNome("Memoria RAM");
        cliente.computador[1].hw[2].setNome("HD");
        cliente.computador[1].hw[0].setCapacidade(3370); // 3370 MHz.
        cliente.computador[1].hw[1].setCapacidade(16); // 16Gb Memória Ram.
        cliente.computador[1].hw[2].setCapacidade(1000); // 1000Gb HD ou 1Tb.
        cliente.computador[1].sistema.setNome("Windows 8");
        cliente.computador[1].sistema.setTipo(64); // 64 bits
        cliente.computador[1].mem.setNome("Pen-drive");
        cliente.computador[1].mem.setCapacidade(32); // 32Gb
        cliente.computador[1].addMemoriaUSB(mem);
        cliente.computador[1].mostraPCConfigs(); // Mostrar as configurações do PC1.



        System.out.println("Opção 3: ");
        System.out.println();

        cliente.computador[2].hw[0].setNome("Pentium Core i7");
        cliente.computador[2].hw[1].setNome("Memoria RAM");
        cliente.computador[2].hw[2].setNome("HD");
        cliente.computador[2].hw[0].setCapacidade(4500); // 4500 MHz.
        cliente.computador[2].hw[1].setCapacidade(32); // 32Gb Memória Ram.
        cliente.computador[2].hw[2].setCapacidade(2000); // 2000 Gb HD ou 2Tb.
        cliente.computador[2].sistema.setNome("Windows 10");
        cliente.computador[2].sistema.setTipo(64); // 64 bits
        cliente.computador[2].mem.setNome("HD Externo");
        cliente.computador[2].mem.setCapacidade(1000); // 1000 Gb ou 1Tb
        cliente.computador[2].addMemoriaUSB(mem);
        cliente.computador[2].mostraPCConfigs(); // Mostrar as configurações do PC1.

        int op; // Variável para opção de escolha do cliente.
        boolean escolhido1 = false, escolhido2 = false, escolhido3 = false; // Aplicar a lógica de estoque.
        float valorTotal = 0; // Valor total da compra do cliente.
        while(true) {

            System.out.println("Escolha a sua opção(1 - 3) ou 0 para sair: ");
            op = entrada.nextInt();
            if(op == 0 && !escolhido1 && !escolhido2 && !escolhido3){
                System.out.println("Você não comprou nada!");
                break;
            }
            if(op == 0){
                break;
            }
            switch (op) {
                case 1:
                    if (!escolhido1) {
                        System.out.println("Computador 1 comprado!");
                        escolhido1 = true;
                        valorTotal += cliente.computador[0].preco;
                    } else {
                        System.out.println("Você já comprou o Computador 1!");
                    }
                    break;
                case 2:
                    if (!escolhido2) {
                        System.out.println("Computador 2 comprado!");
                        escolhido2 = true;
                        valorTotal += cliente.computador[1].preco;
                    } else {
                        System.out.println("Você já comprou o Computador 2!");
                    }
                    break;
                case 3:
                    if (!escolhido3) {
                        System.out.println("Computador 3 comprado!");
                        escolhido3 = true;
                        valorTotal += cliente.computador[2].preco;
                    } else {
                        System.out.println("Você já comprou o Computador 3!");
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção viável!");
                    break;
            }
        }

        if(escolhido1 || escolhido2 || escolhido3) {
            System.out.println("O(s) PC(s) comprado(s) é(são) : ");
            if(escolhido1){
                cliente.computador[0].mostraPCConfigs();
            }
            if(escolhido2){
                cliente.computador[1].mostraPCConfigs();
            }
            if(escolhido3){
                cliente.computador[2].mostraPCConfigs();
            }
            System.out.println();
            System.out.print("O valor total das compras: " + cliente.calculaTotalCompra(valorTotal));
        }

        entrada.close();
    }
}