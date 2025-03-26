public class Computador {

    public String marca;
    public float preco;

    HardwareBasico[]hw;
    OS sistema;
    MemoriaUSB mem;



    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        hw = new HardwareBasico[3]; // Composição
        sistema = new OS(); // Composição
    }


    public void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Preco: " + this.preco);
        for(int i = 0; i < hw.length; i++){
            if(hw[i] != null) {
                System.out.println("Hardware: " + hw[i].nome + " de capacidade: " + hw[i].capacidade);
            }
            else{
                System.out.println("Não há hardware --- PROBLEMA!");
            }
        }
        System.out.println("Nome do Sistema Operacional: " + this.sistema.nome + " de tipo " + this.sistema.tipo);
        if(mem != null){
        System.out.println("Nome da memória: " + this.mem.nome + " de capacidade " + this.mem.capacidade);
        }
        else {
            System.out.println("Memória não existente!");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb){
        if(mem == null){
            mem = musb;
            System.out.println("Memória USB adicionada com sucesso!");
        }
        else{
            System.out.println("ERRO: Já existe uma memória USB associada a este computador!");
        }
    }

}
