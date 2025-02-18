public class Zumbi {
    // Exercício com UML.

    double vida;
    String nome;

    public double mostraVida(){
        return vida;
    }

    public void transfereVida(Zumbi zumbiAlvo, double quantia){

        if(vida > quantia) {
            zumbiAlvo.vida += quantia;
            vida -= quantia;
        }
        else{
            System.out.println("O zumbi não tem isso de vida para tranferir!");
        }
    }

}

