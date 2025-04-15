public class Main {
    public static void main(String[] args) {

        // Quando pensamos em instâncias, pensamos em objetos concretos, que realizam comportamentos.
        // Não faz sentido criar instâncias da superclasse, apenas das subclasses:
        // Brownie brownie = new Brownie(); --> não há uso para a superclasse(há herança e méto.dos sobrescritos).
        // Dessa forma, uma classe abstrata vêm da superclasse que é geral e apenas as subclasses serão utilizadas e herdarão dessa superclasse.
        // Ter noção da Superclasse e não pode ter instâncias sobre ela.
        // *** Ela deve ser usada como referência para o polimorfismo *** prova
        // * Nem toda superclasse deve ser abstrata, pois pode ser necessário instanciar, por algum motivo, uma superclasse.
        // Méto.do abstrato: todas as classes que herdam da superclasse são obrigadas a ter o méto.do sobrescrito:
        // public abstract void addCarrinhoDeCompras(); --> não faz nada, apenas os métodos das subclasses fazem(obrigatoriamente).

        Cachorro cachorro = new Cachorro("Oliver", 100);
        Lontra lontra = new Lontra("Bob", 50);
        Boi boi = new Boi("Laranja", 250);

        cachorro.mostraInfo();
        lontra.mostraInfo();
        boi.mostraInfo();
        cachorro.emitirSom();
        lontra.emitirSom();
        boi.emitirSom();
    }
}