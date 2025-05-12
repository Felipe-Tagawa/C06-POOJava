public class Main {
    public static void main(String[] args) {

        Heroi heroi = new Heroi("Hulk", 300);
        Vilao vilao = new Vilao("Líder", 180);
        Arma armaheroi[] = new Arma[2];
        Arma armavilao[] = new Arma[2];
        armaheroi[0] = new Arma("Punho", 50, 100000);
        armaheroi[1] = new Arma("Soco inglês", 80, 1000000);
        armavilao[0] = new Arma("Pistola", 20 , 100);
        armavilao[1] = new Arma("Canhão de plasma", 60, 10000);

        heroi.addArma(armaheroi[0]);
        heroi.addArma(armaheroi[1]);
        vilao.addArma(armavilao[0]);
        vilao.addArma(armavilao[1]);

        System.out.println("Mostrando as armas: ");
        heroi.mostrarArmas();
        vilao.mostrarArmas();

        heroi.atacar(0, vilao);
        vilao.atacar(1, heroi);

        System.out.println("Vida do " + heroi.nome + " : " +heroi.vida);
        System.out.println("Vida do " + vilao.nome + " : " +vilao.vida);

        System.out.print(heroi.nome + "está usando o especial: ");

        heroi.usarEspecial(vilao);

        System.out.print(vilao.nome + "está usando o especial: ");

        vilao.usarEspecial(heroi);

        System.out.println("Vida do " + heroi.nome + " : " +heroi.vida);
        System.out.println("Vida do " + vilao.nome + " : " +vilao.vida);

        System.out.println(heroi.armas[0].toString());

    }
}