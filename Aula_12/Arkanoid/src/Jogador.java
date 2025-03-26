public class Jogador {
        String nome;
        int pontuacao;

        public static int numBlocosDestruidos = 0;

        public Jogador(String nome, int pontuacao) {
                this.nome = nome;
                this.pontuacao = pontuacao;
        }

        public void destruirBloco(Bloco bloco){
                Bloco.numBlocos--;
                this.pontuacao += 10;
                numBlocosDestruidos++;

        }

        public void mostraInfoJogador(){
                System.out.println("Nome: " + this.nome);
                System.out.println("Pontuacao: " + this.pontuacao);
        }


        
}
