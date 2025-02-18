public class Main {
    public static void main(String[] args) {

        Piloto p1 = new Piloto();
        Piloto p2 = new Piloto();
        Kart kart1 = new Kart();
        Kart kart2 = new Kart();

        p1.kart = kart1;
        p2.kart = kart2;

        p1.vilao = false;
        p2.vilao = true;

        p1.nome = "Mario";
        p2.nome = "Wario";

        p1.kart.nome = "Kart do Mario";
        p2.kart.nome = "Kart do Wario";

        p1.kart.motor.cilindradas = 50;
        p2.kart.motor.cilindradas = 60;
        p1.kart.motor.velocidadeMaxima = 40;
        p2.kart.motor.velocidadeMaxima = 30;

        p1.kart.motor.mostraInfo();
        p2.kart.motor.mostraInfo();

        p1.kart.fazerDrift();
        p2.kart.fazerDrift();
        p2.soltaSuperPoder();
        p1.kart.pular();

        p1.kart.fazerDrift();

        p1.kart.soltarTurbo();

        p1.soltaSuperPoder();
        if(p2.kart.motor.velocidadeMaxima < 70){
            System.out.println(p2.nome + " tomou o poder na cara e capotou!");
        }
        else{
            System.out.println("Escapou do poder!");
        }


    }
}