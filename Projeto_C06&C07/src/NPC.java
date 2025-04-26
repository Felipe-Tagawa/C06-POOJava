public class NPC extends SerHumano {

    String arcana;

    public NPC(String nome, int idade, String genero, String arcana) {
        super(nome, idade, genero);
        this.arcana = arcana;
    }

    @Override
    public void interagir() {
        System.out.println("NPC" + nome + " interage!");
    }

    @Override
    public void mostraInfoPersonagem() {

    }

    public void conversar(){

    }

    public void darMissao(){

    }

    public void receberItem(String item){

    }

}
