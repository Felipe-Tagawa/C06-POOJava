public class Piloto {

    String nome;
    boolean vilao;
    Kart kart;

    public void soltaSuperPoder(){
        if(vilao){
            System.out.println("O piloto " + nome + " soltou um poder maligno!");
        }
        else{
            System.out.println("O piloto " + nome + " soltou um poder estelar!");
        }
    }

}
