public class NPC extends SerHumano {

    private String arcana;
    private String ocupação;

    public NPC(String nome, int idade, String genero, String ocupacao, String arcana) {
        super(nome, idade, genero);
        this.arcana = arcana;
        this.ocupação = ocupacao;
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
