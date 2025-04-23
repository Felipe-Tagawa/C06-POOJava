public class NPC extends SerHumano {

    public NPC(String nome, int idade, String genero) {
        super(nome, idade, genero);
    }

    @Override
    public void interagir() {
        System.out.println("NPC" + nome + " interage!");
    }

    public void conversar(){

    }

    public void darMissao(){

    }

    public void receberItem(String item){

    }

}
