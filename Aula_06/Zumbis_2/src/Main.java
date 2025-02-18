public class Main {
    public static void main(String[] args) {

        Zumbi zumbi_novo = new Zumbi();
        Zumbi zumbiAlvo = new Zumbi();
        zumbi_novo.vida = 100;
        zumbiAlvo.vida = 500;

        zumbi_novo.transfereVida(zumbiAlvo, 10);
        System.out.println(zumbi_novo.vida);

        System.out.println(zumbiAlvo.mostraVida());

    }
}