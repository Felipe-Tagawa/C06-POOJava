public class Kart {

    String nome;
    Motor motor;

    public Kart(){
        motor = new Motor(); // Construtor.
    }

    public boolean pular(){
        System.out.println(nome + " desviou do poder!");
        return true;
    }

    public void soltarTurbo(){
        this.motor.velocidadeMaxima = 70;
    }

    public void fazerDrift(){
        this.motor.cilindradas -= 10;
        this.motor.velocidadeMaxima -= 15;
    }

}
