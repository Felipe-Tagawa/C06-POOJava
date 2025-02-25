public class Jogador {

    Arma arma;
    int energia, vida;

    public void Jogador(Arma arma, int energia, int vida){
        this.arma = arma;
        this.energia = energia;
        this.vida = vida;
    }

    public void atacar(Jogador alvo){
        if(energia > arma.custoDeEnergia && alvo.vida > 0) {

            alvo.vida -= arma.dano;
            energia -= arma.custoDeEnergia;

            if(alvo.vida < 0) alvo.vida = 0;
        }
        else{
            System.out.println("Você não tem mais energia da arma ou ele já morreu!");
        }
    }

    public String toString(){
        return "Jogador [dano da arma = " + arma.dano + ", vida do jogador = " + vida + "]";

    }


}
