public class Computador {

    public String marca;
    public float preco;

    HardwareBasico[]hw;
    OS sistema;
    MemoriaUSB mem; // Agregação.



    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        hw = new HardwareBasico[3]; // Composição.
        sistema = new OS(); // Composição.
    }


    // O uso das %- :  apenas para deixar a saída mais elegante.
    public void mostraPCConfigs() {
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| %-53s | ", "Marca: " + this.marca);
        System.out.println();
        System.out.printf("| %-53s | ", "Preço: R$ " + this.preco);
        System.out.println();

        for (int i = 0; i < hw.length; i++) {
            if (hw[i] != null) {
                if(hw[i].nome.startsWith("Pentium")) { // startsWith nos deixa não ter que repetir os "or" para i3,i5 e i7.
                    System.out.printf("| %-53s | ", "Hardware 1: " + hw[i].nome + " de capacidade " + hw[i].capacidade + " MHz");
                    System.out.println();
                }
                else{
                    System.out.printf("| %-53s | ", "Hardware " + (i + 1) + ": " + hw[i].nome + " de capacidade " + hw[i].capacidade + " Gb");
                    System.out.println();
                }
            } else {
                System.out.printf("| %-53s | ", "Não há hardware --- PROBLEMA!");
                System.out.println();
            }
        }

        System.out.printf("| %-53s | ", "Nome do Sistema Operacional: " + this.sistema.nome + "(" + this.sistema.tipo + " bits)");
        System.out.println();

        if (mem != null) {
            if(this.mem.capacidade != 1000) {
                System.out.printf("| %-53s | ", "Nome da memória: " + this.mem.nome + " de capacidade " + this.mem.capacidade + " Gb");
                System.out.println();
            }
            else {
                System.out.printf("| %-53s | ", "Nome da memória: " + this.mem.nome + " de capacidade 1 Tb");
                System.out.println();
            }
        } else {
            System.out.printf("| %-52s | ", "Memória não existente!");
            System.out.println();
        }

        System.out.println("|-------------------------------------------------------|");
    }

    public void addMemoriaUSB(MemoriaUSB musb){
        if(mem == null){
            mem = musb;
            System.out.println("- Memória USB adicionada com sucesso!");
        }
    }

}
