public class Main {

    public static void main(String[] args) {
        Protagonista protagonista = new Protagonista("Makoto Yuki", 17, "Masculino");
        // Personas[] persona = new Personas[10]; // Inicialmente somente 10.

        // Tipos de personas para o protagonista
        String[][] tiposPersonaProtagonista = {
                {"Almighty", "Dark"},     // Alice
                {"Physical", "Fire"},     // Eligor
                {"Curse", "Physical"},    // Arsène
                {"Fire", "None"},         // Jack-o'-Lantern
                {"Electric", "Healing"},  // Pixie
                {"Dark", "Ailment"},      // Incubus
                {"Dark", "Charm"},        // Succubus
                {"Ice", "Healing"},       // Silky
                {"Fire", "Support"},      // Orobas
                {"Physical", "Dark"}      // Bicorn
        };

        protagonista.personas[0] = new Personas("Alice", 20, "Death", tiposPersonaProtagonista[0]);
        protagonista.personas[1] = new Personas("Eligor", 25, "Tower", tiposPersonaProtagonista[1]);
        protagonista.personas[2] = new Personas("Arsène", 1, "Fool", tiposPersonaProtagonista[2]);
        protagonista.personas[3] = new Personas("Jack-o'-Lantern", 2, "Magician", tiposPersonaProtagonista[3]);
        protagonista.personas[4] = new Personas("Pixie", 3, "Lovers", tiposPersonaProtagonista[4]);
        protagonista.personas[5] = new Personas("Incubus", 5, "Devil", tiposPersonaProtagonista[5]);
        protagonista.personas[6] = new Personas("Succubus", 8, "Moon", tiposPersonaProtagonista[6]);
        protagonista.personas[7] = new Personas("Silky", 4, "Priestess", tiposPersonaProtagonista[7]);
        protagonista.personas[8] = new Personas("Orobas", 17, "Hierophant", tiposPersonaProtagonista[8]);
        protagonista.personas[9] = new Personas("Bicorn", 6, "Hermit", tiposPersonaProtagonista[9]);

        // Heróis(SEES):
        Usuarios[] user = new Usuarios[12]; // Por enquanto há 12 usuários.
        user[0] = new Usuarios("Yukari", 16, "Feminino", "Healer", false, "Lovers");
        user[1] = new Usuarios("Mitsuru", 18, "Feminino", "Ice Caster", false, "Empress");
        user[2] = new Usuarios("Junpei Iori", 17, "Masculino", "Slash Attacker", false, null);
        user[3] = new Usuarios("Akihiko Sanada", 18, "Masculino", "Electric Striker / Boxer", false, null );
        user[4] = new Usuarios("Fuuka Yamagishi", 16, "Feminino", "Support / Navigator", false, "Priestess");
        user[5] = new Usuarios("Aigis", 17, "Feminino", "Gunner / Tank", false, "Aeon");
        user[6] = new Usuarios("Koromaru", 10, "Masculino", "Dark/Fire User", false, null);
        user[7] = new Usuarios("Ken Amada", 10, "Masculino", "Light/Lance User", false, null);
        user[8] = new Usuarios("Shinjiro Aragaki", 18, "Masculino", "Brute Physical Attacker", false, null);

        // Vilões (Strega):
        user[9] = new Usuarios("Takaya Sakaki", 20, "Masculino", "Dark Caster / Líder da Strega", true, null);
        user[10] = new Usuarios("Jin Shirato", 19, "Masculino", "Support Hacker / Tech", true, null);
        user[11] = new Usuarios("Chidori Yoshino", 17, "Feminino", "Fire Caster / Emo Artista", true, null);

        // Tipos de personas para cada usuário:
        String[][] tiposUsuarios = {
                {"Wind", "Healing"},      // Yukari - Isis
                {"Ice", "Status"},        // Mitsuru - Artemisia
                {"Fire", "Physical"},     // Junpei - Trismegistus
                {"Electric", "Physical"}, // Akihiko - Caesar
                {"Support", "Analysis"},  // Fuuka - Juno
                {"Physical", "Pierce"},   // Aigis - Athena
                {"Fire", "Dark"},         // Koromaru - Cerberus
                {"Light", "Pierce"},      // Ken - Kala-Nemi
                {"Physical", "None"},     // Shinjiro - Castor
                {"Dark", "Light"},        // Takaya - Hypnos
                {"Support", "Almighty"},  // Jin - Moros
                {"Fire", "Healing"}       // Chidori - Medea
        };

        //Personas SEES:

        user[0].addPersona(new Personas("Isis", 45, "Lovers", tiposUsuarios[0]));
        user[1].addPersona(new Personas("Artemisia", 48, "Empress", tiposUsuarios[1]));
        user[2].addPersona(new Personas("Trismegistus", 43, "Magician", tiposUsuarios[2]));
        user[3].addPersona(new Personas("Caesar", 47, "Emperor", tiposUsuarios[3]));
        user[4].addPersona(new Personas("Juno", 40, "Priestess", tiposUsuarios[4]));
        user[5].addPersona(new Personas("Athena", 50, "Chariot", tiposUsuarios[5]));
        user[6].addPersona(new Personas("Cerberus", 42, "Strength", tiposUsuarios[6]));
        user[7].addPersona(new Personas("Kala-Nemi", 41, "Justice", tiposUsuarios[7]));
        user[8].addPersona(new Personas("Castor", 46, "Hierophant", tiposUsuarios[8]));

        // Personas da Strega:
        user[9].addPersona(new Personas("Hypnos", 55, "Fortune", tiposUsuarios[9]));
        user[10].addPersona(new Personas("Moros", 52, "Hermit", tiposUsuarios[10]));
        user[11].addPersona(new Personas("Medea", 50, "Hanged Man", tiposUsuarios[11]));


        user[0].mostraInfoPersonagem();
        user[0].mostraInfoPersona();

        protagonista.mostraInfoPersonagem();

        // Adicionar os Confidants(NPCs):


        // Adicionar habilidades das personas:

    }
}