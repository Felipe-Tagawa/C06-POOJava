public class Bloco {

    public static int numBlocos = 0; // Static faz o numBlocos pertencer à classe e não à instância.

    public Bloco(){
        numBlocos++;
    }

    public static int getNumBlocosDestruidos(){
        return Jogador.numBlocosDestruidos;
    }

}
