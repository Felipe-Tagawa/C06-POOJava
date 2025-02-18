public class Main {
    public static void main(String[] args) {

        Zumbi zumbi1 = new Zumbi();
        Zumbi zumbi2 = new Zumbi();

        zumbi1.vida = 10;
        zumbi2.vida = 15;

        zumbi1 = zumbi2; // Fazendo os dois apontarem para o mesmo lugar.

        zumbi1.vida = 20;

        System.out.println(zumbi1.vida);
        System.out.println(zumbi2.vida);

    }
}