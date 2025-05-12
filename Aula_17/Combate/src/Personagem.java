public abstract class Personagem {

    protected String nome;
    protected int vida;
    protected Arma []armas = new Arma[2]; // Agregação

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public void addArma(Arma arma){

        for(int i = 0; i < armas.length; i++){
            if(armas[i] == null){
                armas[i] = arma;
                break;
            }
        }
    }

    public void mostrarArmas(){
        for(int i = 0; i < armas.length; i++){
            if(armas[i] == null){
                System.out.println("Sem armas disponíveis!");
            }
            else {
                System.out.println(armas[i]);
            }
        }
    }

    public void atacar(int posicao, Personagem personagem){
        // Usar o Instance of para saber se o personagem é um herói ou vilão.
        if(armas[posicao] != null){
            if(armas[posicao].getDurabilidade() > 0){
                if(personagem.vida <= 0){
                    System.out.println("Este personagem já foi derrotado!");
                }
                else{
                    personagem.vida -= armas[posicao].getDano();
                    armas[posicao].setDurabilidade(0);
                }
            }
        }
        else{
            System.out.println("Não há armas para atacar!");
        }

    }

}
