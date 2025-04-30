package br.inatel.projetojava;

import br.inatel.projetojava.itens.equipamentos.Equipamento;
import br.inatel.projetojava.itens.Itens;
import br.inatel.projetojava.itens.LojadeItens;
import br.inatel.projetojava.personagens.npc.NPC;
import br.inatel.projetojava.personagens.jogaveis.Protagonista;
import br.inatel.projetojava.personagens.jogaveis.Usuarios;
import br.inatel.projetojava.personas.Habilidades;
import br.inatel.projetojava.personas.Personas;

public class Main {

    public static void main(String[] args) {
        Protagonista protagonista = new Protagonista("Makoto Yuki", 17, "Masculino", 20);
        // br.inatel.projetojava.personas.Personas[] persona = new br.inatel.projetojava.personas.Personas[10]; // Inicialmente somente 10.

        // ---------------------------------------- Tipos de personas (protagonista) ----------------------------------------
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

        // ---------------------------------------- Heróis(SEES): ----------------------------------------
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

        // ---------------------------------------- Vilões (Strega): ----------------------------------------
        user[9] = new Usuarios("Takaya Sakaki", 20, "Masculino", "Dark Caster / Líder da Strega", true, null);
        user[10] = new Usuarios("Jin Shirato", 19, "Masculino", "Support Hacker / Tech", true, null);
        user[11] = new Usuarios("Chidori Yoshino", 17, "Feminino", "Fire Caster / Emo Artista", true, null);


        // ---------------------------------------- Tipos de personas (usuários): ----------------------------------------
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


        //br.inatel.projetojava.personas.Personas SEES:
        // ---------------------------------------- Personas: ----------------------------------------


        user[0].addPersona(new Personas("Isis", 45, "Lovers", tiposUsuarios[0]));
        user[1].addPersona(new Personas("Artemisia", 48, "Empress", tiposUsuarios[1]));
        user[2].addPersona(new Personas("Trismegistus", 43, "Magician", tiposUsuarios[2]));
        user[3].addPersona(new Personas("Caesar", 47, "Emperor", tiposUsuarios[3]));
        user[4].addPersona(new Personas("Juno", 40, "Priestess", tiposUsuarios[4]));
        user[5].addPersona(new Personas("Athena", 50, "Chariot", tiposUsuarios[5]));
        user[6].addPersona(new Personas("Cerberus", 42, "Strength", tiposUsuarios[6]));
        user[7].addPersona(new Personas("Kala-Nemi", 41, "Justice", tiposUsuarios[7]));
        user[8].addPersona(new Personas("Castor", 46, "Hierophant", tiposUsuarios[8]));

        // br.inatel.projetojava.personas.Personas da Strega:
        user[9].addPersona(new Personas("Hypnos", 55, "Fortune", tiposUsuarios[9]));
        user[10].addPersona(new Personas("Moros", 52, "Hermit", tiposUsuarios[10]));
        user[11].addPersona(new Personas("Medea", 50, "Hanged Man", tiposUsuarios[11]));


        user[0].mostraInfoPersonagem();
        user[0].mostraInfoPersona();

        protagonista.mostraInfoPersonagem();


        // ---------------------------------------- NPCs: ----------------------------------------


        NPC[] npcs = new NPC[14];
        npcs[0] = new NPC("Bunkichi e Mitsuko", 70, "Masculino/Feminino", "Bibliotecários aposentados", "Hierophant");
        npcs[1] = new NPC("Kenji Tomochika", 16, "Masculino", "Aluno", "Magician");
        npcs[2] = new NPC("Kazushi Miyamoto", 17, "Masculino", "Atleta do time de corrida", "Chariot");
        npcs[3] = new NPC("Hidetoshi Odagiri", 17, "Masculino", "Membro do conselho estudantil", "Emperor");
        npcs[4] = new NPC("Yuko Nishiwaki", 17, "Feminino", "Gerente do time esportivo", "Strength");
        npcs[5] = new NPC("Chihiro Fushimi", 16, "Feminino", "Tesoureira do conselho estudantil", "Justice");
        npcs[6] = new NPC("Maya", 27, "Feminino", "Professora", "Hermit");
        npcs[7] = new NPC("Nozomi Suemitsu", 15, "Masculino", "Gourmet King", "Moon");
        npcs[8] = new NPC("Keisuke Hiraga", 17, "Masculino", "Presidente do clube de artes", "Fortune");
        npcs[9] = new NPC("Akinari Kamiki", 17, "Masculino", "Poeta", "Sun");
        npcs[10] = new NPC("Mutatsu", 55, "Masculino", "Monge", "Tower");
        npcs[11] = new NPC("Maiko", 8, "Feminino", "Estudante do Jardim", "Hanged Man");
        npcs[12] = new NPC("Bebé", 17, "Masculino", "Estudante francês de intercâmbio", "Temperance");
        npcs[13] = new NPC("Tanaka", 36, "Masculino", "Empresário da Tanaka’s Amazing Commodities", "Devil");


        // br.inatel.projetojava.personas.Habilidades das personas do protagonista:
        // ---------------------------------------- Personas habilidades: ----------------------------------------


        protagonista.personas[0].addHabilidade(new Habilidades("Megidolaon", "Almighty", "Causa dano massivo a todos os inimigos", 6));
        protagonista.personas[0].addHabilidade(new Habilidades("Mudo", "Dark", "Chance de causar morte instantânea a um inimigo", 3));
        protagonista.personas[0].addHabilidade(new Habilidades("Die For Me!", "Dark", "Alta chance de causar morte instantânea a todos os inimigos", 7));

        protagonista.personas[1].addHabilidade(new Habilidades("Agidyne", "Fire", "Causa dano de fogo pesado a um inimigo", 5));
        protagonista.personas[1].addHabilidade(new Habilidades("Power Charge", "Support", "Aumenta o próximo dano físico causado", 0));
        protagonista.personas[1].addHabilidade(new Habilidades("Maragion", "Fire", "Causa dano de fogo médio a todos os inimigos", 4));

        protagonista.personas[2].addHabilidade(new Habilidades("Eiha", "Dark", "Causa dano sombrio leve a um inimigo", 2));
        protagonista.personas[2].addHabilidade(new Habilidades("Lunge", "Physical", "Causa dano físico leve a um inimigo", 3));
        protagonista.personas[2].addHabilidade(new Habilidades("Cleave", "Physical", "Causa dano físico leve a um inimigo", 3));

        protagonista.personas[3].addHabilidade(new Habilidades("Agi", "Fire", "Causa dano de fogo leve a um inimigo", 2));
        protagonista.personas[3].addHabilidade(new Habilidades("Rakunda", "Debuff", "Reduz a defesa de um inimigo", 0));
        protagonista.personas[3].addHabilidade(new Habilidades("Tarukaja", "Buff", "Aumenta o ataque de um aliado por 3 turnos", 0));

        protagonista.personas[4].addHabilidade(new Habilidades("Zio", "Electric", "Causa dano elétrico leve a um inimigo", 2));
        protagonista.personas[4].addHabilidade(new Habilidades("Dia", "Healing", "Restaura uma pequena quantidade de HP a um aliado", 0));
        protagonista.personas[4].addHabilidade(new Habilidades("Patra", "Healing", "Cura um aliado de status negativos", 0));

        protagonista.personas[5].addHabilidade(new Habilidades("Dream Needle", "Ailment", "Causa dano físico leve com chance de causar sono", 2));
        protagonista.personas[5].addHabilidade(new Habilidades("Life Drain", "Dark", "Drena uma pequena quantidade de HP de um inimigo", 3));
        protagonista.personas[5].addHabilidade(new Habilidades("Mudo", "Dark", "Chance de causar morte instantânea a um inimigo", 3));

        protagonista.personas[6].addHabilidade(new Habilidades("Tentarafoo", "Ailment", "Chance de causar confusão a todos os inimigos", 0));
        protagonista.personas[6].addHabilidade(new Habilidades("Evil Touch", "Ailment", "Chance de causar medo a um inimigo", 0));
        protagonista.personas[6].addHabilidade(new Habilidades("Spirit Drain", "Support", "Drena uma pequena quantidade de SP de um inimigo", 1));

        protagonista.personas[7].addHabilidade(new Habilidades("Bufu", "Ice", "Causa dano de gelo leve a um inimigo", 2));
        protagonista.personas[7].addHabilidade(new Habilidades("Media", "Healing", "Restaura uma pequena quantidade de HP a todos os aliados", 0));
        protagonista.personas[7].addHabilidade(new Habilidades("Rakukaja", "Buff", "Aumenta a defesa de um aliado por 3 turnos", 0));

        protagonista.personas[8].addHabilidade(new Habilidades("Maragi", "Fire", "Causa dano de fogo leve a todos os inimigos", 3));
        protagonista.personas[8].addHabilidade(new Habilidades("Dekunda", "Support", "Remove penalidades de status de todos os aliados", 0));
        protagonista.personas[8].addHabilidade(new Habilidades("Sukukaja", "Buff", "Aumenta a precisão e evasão de um aliado por 3 turnos", 0));

        protagonista.personas[9].addHabilidade(new Habilidades("Lunge", "Physical", "Causa dano físico leve a um inimigo", 3));
        protagonista.personas[9].addHabilidade(new Habilidades("Mudo", "Dark", "Chance de causar morte instantânea a um inimigo", 3));
        protagonista.personas[9].addHabilidade(new Habilidades("Tarunda", "Debuff", "Reduz o ataque de um inimigo por 3 turnos", 0));


        // br.inatel.projetojava.personas.Habilidades dos usuários (SEES e Strega):
        // ---------------------------------------- Personas habilidadeds: ----------------------------------------


        user[0].personas.addHabilidade(new Habilidades("Dia", "Healing", "Restaura uma pequena quantidade de HP a um aliado", 0));
        user[0].personas.addHabilidade(new Habilidades("Media", "Healing", "Restaura uma pequena quantidade de HP a todos os aliados", 0));
        user[0].personas.addHabilidade(new Habilidades("Magaru", "Wind", "Causa dano de vento leve a todos os inimigos", 6));
        user[0].personas.addHabilidade(new Habilidades("Me Patra", "Healing", "Cura pânico, medo e aflição de todos os aliados", 0));

        user[1].personas.addHabilidade(new Habilidades("Agilao", "Fire", "Causa dano de fogo médio a um inimigo", 6));
        user[1].personas.addHabilidade(new Habilidades("Rebellion", "Support", "Aumenta a taxa de acerto crítico de um aliado por 3 turnos", 0));
        user[1].personas.addHabilidade(new Habilidades("Maragi", "Fire", "Causa dano de fogo leve a todos os inimigos", 4));
        user[1].personas.addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));

        user[2].personas.addHabilidade(new Habilidades("Zio", "Electric", "Causa dano elétrico leve a um inimigo", 4));
        user[2].personas.addHabilidade(new Habilidades("Maziodyne", "Electric", "Causa dano elétrico pesado a todos os inimigos com chance de causar choque", 12));
        user[2].personas.addHabilidade(new Habilidades("Sonic Punch", "Physical", "Causa dano físico leve a um inimigo com chance de causar aflição", 6));
        user[2].personas.addHabilidade(new Habilidades("Fist Master", "Passive", "Dobra o dano causado por armas de punho", 0));

        user[3].personas.addHabilidade(new Habilidades("Bufula", "Ice", "Causa dano de gelo médio a um inimigo com chance de congelar", 6));
        user[3].personas.addHabilidade(new Habilidades("Tentarafoo", "Ailment", "Chance de causar confusão a todos os inimigos", 8));
        user[3].personas.addHabilidade(new Habilidades("Ice Boost", "Passive", "Aumenta o dano de habilidades de gelo em 25%", 0));
        user[3].personas.addHabilidade(new Habilidades("Mabufula", "Ice", "Causa dano de gelo médio a todos os inimigos com chance de congelar", 12));

        user[4].personas.addHabilidade(new Habilidades("Kill Rush", "Physical", "Causa dano físico leve a um inimigo múltiplas vezes", 12));
        user[4].personas.addHabilidade(new Habilidades("Tarukaja", "Support", "Aumenta o ataque de um aliado por 3 turnos", 0));
        user[4].personas.addHabilidade(new Habilidades("Swift Strike", "Physical", "Causa dano físico leve a todos os inimigos múltiplas vezes", 16));
        user[4].personas.addHabilidade(new Habilidades("Makarakarn", "Support", "Reflete o próximo ataque mágico recebido por um aliado", 24));

        user[5].personas.addHabilidade(new Habilidades("Hama", "Light", "Chance de causar morte instantânea a um inimigo", 8));
        user[5].personas.addHabilidade(new Habilidades("Zan-ei", "Light", "Causa dano de luz leve a um inimigo", 6));
        user[5].personas.addHabilidade(new Habilidades("Media", "Healing", "Restaura uma pequena quantidade de HP a todos os aliados", 0));
        user[5].personas.addHabilidade(new Habilidades("Recarm", "Healing", "Revive um aliado com metade do HP", 0));

        user[6].personas.addHabilidade(new Habilidades("Agi", "Fire", "Causa dano de fogo leve a um inimigo", 4));
        user[6].personas.addHabilidade(new Habilidades("Mudoon", "Dark", "Alta chance de causar morte instantânea a um inimigo", 12));
        user[6].personas.addHabilidade(new Habilidades("Fire Boost", "Passive", "Aumenta o dano de habilidades de fogo em 25%", 0));
        user[6].personas.addHabilidade(new Habilidades("Hell Fang", "Physical", "Causa dano físico médio a um inimigo", 8));

        user[7].personas.addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));
        user[7].personas.addHabilidade(new Habilidades("Double Fangs", "Physical", "Causa dano físico leve a um inimigo duas vezes", 12));
        user[7].personas.addHabilidade(new Habilidades("Power Charge", "Support", "Aumenta o próximo dano físico causado por um aliado", 0));
        user[7].personas.addHabilidade(new Habilidades("Gigantic Fist", "Physical", "Causa dano físico muito pesado a um inimigo", 20));

        user[8].personas.addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));
        user[8].personas.addHabilidade(new Habilidades("Kill Rush", "Physical", "Causa dano físico leve a um inimigo múltiplas vezes", 12));
        user[8].personas.addHabilidade(new Habilidades("Counterstrike", "Passive", "Chance de 15% de contra-atacar com dano físico médio", 0));

        user[9].personas.addHabilidade(new Habilidades("Mamudoon", "Dark", "Alta chance de causar morte instantânea a todos os inimigos", 16));
        user[9].personas.addHabilidade(new Habilidades("Hamaon", "Light", "Alta chance de causar morte instantânea a um inimigo", 14));
        user[9].personas.addHabilidade(new Habilidades("Mind Charge", "Support", "Aumenta o próximo dano mágico causado por um aliado", 0));

        user[10].personas.addHabilidade(new Habilidades("Debilitate", "Support", "Reduz ataque, defesa e agilidade de um inimigo por 3 turnos", 0));
        user[10].personas.addHabilidade(new Habilidades("Marakunda", "Support", "Reduz a defesa de todos os inimigos por 3 turnos", 0));
        user[10].personas.addHabilidade(new Habilidades("Mabufula", "Ice", "Causa dano de gelo médio a todos os inimigos com chance de congelar", 12));

        user[11].personas.addHabilidade(new Habilidades("Maragion", "Fire", "Causa dano de fogo médio a todos os inimigos", 10));
        user[11].personas.addHabilidade(new Habilidades("Diarama", "Healing", "Restaura uma quantidade moderada de HP a um aliado", 0));
        user[11].personas.addHabilidade(new Habilidades("Fire Break", "Support", "Remove resistência ao fogo de todos os inimigos por 3 turnos", 0));

        protagonista.personas[0].mostrarStatus();
        user[1].mostraInfoPersonagem();
        user[1].mostraInfoPersona();


        // Adicionar br.inatel.projetojava.itens.Itens:
        // ---------------------------------------- Itens: ----------------------------------------


        Itens[] item = new Equipamento[10];
        item[0] = new Equipamento("Paradise Lost", "Espada", 250.0, "Atk +20%");
        item[1] = new Equipamento("God Hand", "Luva", 220.0, "Crit Chance +15%");
        item[2] = new Equipamento("Kongou Hakama", "Armadura", 300.0, "Resist Físico");
        item[3] = new Equipamento("Regent", "Acessório", 150.0, "Mag +10%");
        item[4] = new Equipamento("Black Headband", "Cabeça", 120.0, "Esquiva +10%");
        item[5] = new Equipamento("Omnipotent Orb", "Especial", 9999.0, "Anula Fraquezas");
        item[6] = new Equipamento("Sabbath Gloves", "Luva", 200.0, "Atk +10% / HP -5%");
        item[7] = new Equipamento("Dark Empress Dress", "Armadura", 280.0, "SP Regen +5/tur");
        item[8] = new Equipamento("Eternal Slippers", "Botas", 170.0, "Velocidade +15%");
        item[9] = new Equipamento("Seven Sisters Badge", "Acessório", 130.0, "Status Negativos -50%");

        // Adicionar Loja de br.inatel.projetojava.itens.Itens:

        for (Itens itens : item) {
            LojadeItens loja = new LojadeItens("Untouchable", new Itens[]{itens});
            loja.mostrarItens();
        }
    }
}