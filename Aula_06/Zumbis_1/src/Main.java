public class Main {
    public static void main(String[] args) {

        Zumbi zumbi1 = new Zumbi();
        zumbi1.nome = "Robson";
        zumbi1.vida = 100;
        zumbi1.dano = 100;
        Zumbi zumbi2 = new Zumbi();
        zumbi2.nome = "Arthur";
        zumbi2.vida = 200;
        zumbi2.dano = 50;

        zumbi1.causar_dano(zumbi2, zumbi1.dano);

        System.out.println(zumbi2.vida);

    }
}