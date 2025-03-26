public class Main {
    public static void main(String[] args) {
        Bloco bloco1 = new Bloco();
        Bloco bloco2 = new Bloco();
        Bloco bloco3 = new Bloco();
        Bloco bloco4 = new Bloco();

        Jogador jogador = new Jogador("Felipe", 0);

        jogador.destruirBloco(bloco1);
        jogador.destruirBloco(bloco2);



        System.out.println("A quantidade de blocos criados é de: " + Bloco.numBlocos);
        System.out.println("A quantidade de blocos destruídos é de: " + Bloco.getNumBlocosDestruidos());
        jogador.mostraInfoJogador();
    }
}