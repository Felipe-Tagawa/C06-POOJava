import PacoteA.ClasseA;
import PacoteB.ClasseB;
import br.com.inatel.calculadora.soma.Soma;

public class Main {
    public static void main(String[] args) {
        ClasseA ca = new ClasseA();
        ClasseB cb = new ClasseB();

        Soma s = new Soma();
        s.setSaldo(10);
        s.metodoA();
        System.out.println(s.getSaldo());

        ca.metodoA();

        PacoteB.ClasseA ca2 = new PacoteB.ClasseA(); // 2° classe de mesmo nome é necessário usar Pacote.
    }
}