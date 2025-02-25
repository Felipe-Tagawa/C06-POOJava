public class Main {
    public static void main(String[] args) {

        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        Arma arma1 = new Arma();
        Arma arma2 = new Arma();

        j1.arma = arma1;
        j2.arma = arma2;

        j1.energia = 101;
        j1.vida = 120;
        j2.vida = 50;
        j1.arma.custoDeEnergia = 100;
        j1.arma.dano = 50;
        j2.arma.custoDeEnergia = 100;
        j2.arma.dano = 70;
        j2.energia = 50;

        j1.atacar(j2);
        System.out.println(j1.toString());
        System.out.println(j2.toString());
        if(j2.vida > 0) {
            j1.atacar(j2);
            System.out.println(j1.toString());
            System.out.println(j2.toString());
        }

    }
}