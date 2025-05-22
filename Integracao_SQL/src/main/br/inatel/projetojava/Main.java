package main.br.inatel.projetojava;

import main.br.inatel.projetojava.DAO.*;
import main.br.inatel.projetojava.Model.exceptions.InvalidMenuInputException;
import main.br.inatel.projetojava.Model.personas.*;
import main.br.inatel.projetojava.Model.personagens.jogaveis.*;
import main.br.inatel.projetojava.Model.personagens.*;
import main.br.inatel.projetojava.Model.hub.Cidade;
import main.br.inatel.projetojava.Model.itens.armas.Arma;
import main.br.inatel.projetojava.Model.itens.consumiveis.Consumiveis;
import main.br.inatel.projetojava.Model.itens.equipamentos.Equipamento;
import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.itens.LojadeItens;
import main.br.inatel.projetojava.Model.personagens.npc.NPC;
import main.br.inatel.projetojava.Model.relacional.ProtagonistaPersona;
import main.br.inatel.projetojava.Model.relacional.UsuarioHasPersona;

import java.util.*; // Todas as classes necessárias.

import static main.br.inatel.projetojava.Model.hub.MenuBuscas.mostrar_menu_buscas;
import static main.br.inatel.projetojava.Model.hub.MenuCidade.mostrarMenuCidade;
import static main.br.inatel.projetojava.Model.personagens.combate.CombateManager.iniciarCombate;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);


        ProtagonistaDAO protagonistaDAO = new ProtagonistaDAO();
        //protagonistaDAO.testConnection();
        Protagonista protagonista = new Protagonista("Makoto Yuki", 17, "Masculino", 20, "The Fool",100.00, 50, 10000.00, 4);
        protagonistaDAO.insertProtagonista(protagonista);
        protagonistaDAO.selectProtagonista();
        int idProtagonista = protagonistaDAO.insertProtagonista(protagonista);
        System.out.println(idProtagonista);

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

        // ---------------------------------------- Personas do Makoto --------------------------------

        PersonasDAO personasDAO = new PersonasDAO();
        protagonista.personas.add(new Personas("Alice", 20, "Death", List.of(tiposPersonaProtagonista[0]), "Bless", "Dark", random.nextDouble(50) + 30)); // forte em Dark, fraca contra Bless
        protagonista.personas.add(new Personas("Eligor", 25, "Tower", List.of(tiposPersonaProtagonista[1]), "Ice", "Fire", random.nextDouble(50) + 30)); // forte contra fogo, fraco contra gelo
        protagonista.personas.add(new Personas("Arsène", 1, "Fool", List.of(tiposPersonaProtagonista[2]), "Ice", "Dark", random.nextDouble(50) + 30)); // forte em Dark, fraco contra gelo
        protagonista.personas.add(new Personas("Jack-o'-Lantern", 2, "Magician", List.of(tiposPersonaProtagonista[3]), "Gun", "Fire", random.nextDouble(50) + 30)); // forte em Fire, fraco contra Gun
        protagonista.personas.add(new Personas("Pixie", 3, "Lovers", List.of(tiposPersonaProtagonista[4]), "Gun", "Electricity", random.nextDouble(50) + 30)); // forte em Electric, fraca contra Gun
        protagonista.personas.add(new Personas("Incubus", 5, "Devil", List.of(tiposPersonaProtagonista[5]), "Bless", "Dark", random.nextDouble(50) + 30)); // forte em Dark, fraco contra luz
        protagonista.personas.add(new Personas("Succubus", 8, "Moon", List.of(tiposPersonaProtagonista[6]), "Bless", "Dark", random.nextDouble(50) + 30)); // forte em Dark, fraca contra luz
        protagonista.personas.add(new Personas("Silky", 4, "Priestess", List.of(tiposPersonaProtagonista[7]), "Fire", "Ice", random.nextDouble(50) + 30)); // forte em Ice, fraca contra fogo
        protagonista.personas.add(new Personas("Orobas", 17, "Hierophant", List.of(tiposPersonaProtagonista[8]), "Ice", "Fire", random.nextDouble(50) + 30)); // forte em Fire, fraco contra gelo

        // Erro aqui pq n insere protagonista no SQL, oq faz com que o id dele n seja válido e dê erro.
        ProtagonistaPersonaDAO protagonistaPersonaDAO = new ProtagonistaPersonaDAO();
        for (Personas persona : protagonista.personas) {

            personasDAO.insertPersona(persona); // garante que ela está no banco
            ProtagonistaPersona relacao = new ProtagonistaPersona(idProtagonista, persona.getId());
            // Inserir na tabela de relacionamento:
            protagonistaPersonaDAO.insertProtagonistaPersona(relacao);
        }

        /*
        personasDAO.insertPersona(protagonista.personas.getFirst());
        personasDAO.insertPersona(protagonista.personas.get(1));
        personasDAO.insertPersona(protagonista.personas.get(2));
        personasDAO.insertPersona(protagonista.personas.get(3));
        personasDAO.insertPersona(protagonista.personas.get(4));
        personasDAO.insertPersona(protagonista.personas.get(5));
        personasDAO.insertPersona(protagonista.personas.get(6));
        personasDAO.insertPersona(protagonista.personas.get(7));
        personasDAO.insertPersona(protagonista.personas.get(8));
        */

        protagonista.persona_atual = protagonista.personas.getFirst();

        // ---------------------------------------- Heróis(SEES): ----------------------------------------

        UsuariosDAO usuariosDAO = new UsuariosDAO();
        Map<String, Usuarios> user = new HashMap<>();

        user.put("Yukari", new Usuarios("Yukari", 16, "Feminino", 10, "Lovers", 100.0, 80.0, "Healer", false));
        user.put("Mitsuru", new Usuarios("Mitsuru", 18, "Feminino", 20, "Empress", 120.0, 100.0, "Ice Caster", false));
        user.put("Junpei", new Usuarios("Junpei Iori", 17, "Masculino", 30, "The Fool", 150.0, 70.0, "Slash Attacker", false));
        user.put("Akihiko", new Usuarios("Akihiko Sanada", 18, "Masculino", 40, "The Fool", 160.0, 85.0, "Electric Striker / Boxer", false));
        user.put("Fuuka", new Usuarios("Fuuka Yamagishi", 16, "Feminino", 45, "Priestess", 90.0, 120.0, "Support / Navigator", false));
        user.put("Aigis", new Usuarios("Aigis", 17, "Feminino", 25, "Aeon", 180.0, 90.0, "Gunner / Tank", false));
        user.put("Koromaru", new Usuarios("Koromaru", 10, "Masculino", 33, "The Fool", 110.0, 95.0, "Dark/Fire User", false));
        user.put("Ken", new Usuarios("Ken Amada", 10, "Masculino", 60, "The Fool", 100.0, 110.0, "Light/Lance User", false));
        user.put("Shinjiro", new Usuarios("Shinjiro Aragaki", 18, "Masculino", 55, "The Fool", 200.0, 65.0, "Brute Physical Attacker", false));

        usuariosDAO.insertUsuario(user.get("Yukari"));
        usuariosDAO.insertUsuario(user.get("Mitsuru"));
        usuariosDAO.insertUsuario(user.get("Junpei"));
        usuariosDAO.insertUsuario(user.get("Akihiko"));
        usuariosDAO.insertUsuario(user.get("Fuuka"));
        usuariosDAO.insertUsuario(user.get("Aigis"));
        usuariosDAO.insertUsuario(user.get("Koromaru"));
        usuariosDAO.insertUsuario(user.get("Ken"));
        usuariosDAO.insertUsuario(user.get("Shinjiro"));

        // ---------------------------------------- Vilões (Strega): ----------------------------------------------------

        user.put("Takaya", new Usuarios("Takaya Sakaki", 20, "Masculino", 23, "Fortune", 160.0, 140.0, "Dark Caster / Líder da Strega", true));
        user.put("Jin", new Usuarios("Jin Shirato", 19, "Masculino", 10, "Hermit", 120.0, 130.0, "Support Hacker / Tech", true));
        user.put("Chidori", new Usuarios("Chidori Yoshino", 17, "Feminino", 99, "Hanged Man", 130.0, 150.0, "Fire Caster / Emo Artista", true));

        usuariosDAO.insertUsuario(user.get("Takaya"));
        usuariosDAO.insertUsuario(user.get("Jin"));
        usuariosDAO.insertUsuario(user.get("Chidori"));

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


// ---------------------------------------- Personas: ---------------------------------------------------

//                                        Personas SEES:

        user.get("Yukari").addPersona(new Personas("Isis", 45, "Lovers", List.of(tiposUsuarios[0]), "Electricity", "Wind", random.nextDouble(50) + 30));
        user.get("Mitsuru").addPersona(new Personas("Artemisia", 48, "Empress", List.of(tiposUsuarios[1]), "Fire", "Ice", random.nextDouble(50) + 30));
        user.get("Junpei").addPersona(new Personas("Trismegistus", 43, "Magician", List.of(tiposUsuarios[2]), "Wind", "Fire", random.nextDouble(50) + 30));
        user.get("Akihiko").addPersona(new Personas("Caesar", 47, "Emperor", List.of(tiposUsuarios[3]), "Pierce", "Electricity", random.nextDouble(50) + 30));
        user.get("Fuuka").addPersona(new Personas("Juno", 40, "Priestess", List.of(tiposUsuarios[4]), "Physical", "Support", 0)); // suporte, não combate direto
        user.get("Aigis").addPersona(new Personas("Athena", 50, "Chariot", List.of(tiposUsuarios[5]), "Electricity", "Strike", random.nextDouble(50) + 30));
        user.get("Koromaru").addPersona(new Personas("Cerberus", 42, "Strength", List.of(tiposUsuarios[6]), "Ice", "Dark", random.nextDouble(50) + 30));
        user.get("Ken").addPersona(new Personas("Kala-Nemi", 41, "Justice", List.of(tiposUsuarios[7]), "Darkness", "Light", random.nextDouble(50) + 30));
        user.get("Shinjiro").addPersona(new Personas("Castor", 46, "Hierophant", List.of(tiposUsuarios[8]), "Light", "Physical", random.nextDouble(50) + 30));

        UsuarioHasPersonaDAO usuarioHasPersonaDAO = new UsuarioHasPersonaDAO();

        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Yukari").getId(), user.get("Yukari").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Mitsuru").getId(), user.get("Mitsuru").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Junpei").getId(), user.get("Junpei").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Akihiko").getId(), user.get("Akihiko").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Fuuka").getId(), user.get("Fuuka").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Aigis").getId(), user.get("Aigis").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Koromaru").getId(), user.get("Koromaru").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Ken").getId(), user.get("Ken").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Shinjiro").getId(), user.get("Shinjiro").getPersonas().getId());

        /*

        personasDAOuser.insertPersona(user.get("Yukari").getPersonas());
        personasDAOuser.insertPersona(user.get("Mitsuru").getPersonas());
        personasDAOuser.insertPersona(user.get("Junpei").getPersonas());
        personasDAOuser.insertPersona(user.get("Akihiko").getPersonas());
        personasDAOuser.insertPersona(user.get("Fuuka").getPersonas());
        personasDAOuser.insertPersona(user.get("Aigis").getPersonas());
        personasDAOuser.insertPersona(user.get("Koromaru").getPersonas());
        personasDAOuser.insertPersona(user.get("Ken").getPersonas());
        personasDAOuser.insertPersona(user.get("Shinjiro").getPersonas());

         */

//                                            Strega:
        user.get("Takaya").addPersona(new Personas("Hypnos", 55, "Fortune", List.of(tiposUsuarios[9]), "Ice", "Dark", random.nextDouble(50) + 30));
        user.get("Jin").addPersona(new Personas("Moros", 52, "Hermit", List.of(tiposUsuarios[10]), "Wind", "Electricity", random.nextDouble(50) + 30));
        user.get("Chidori").addPersona(new Personas("Medea", 50, "Hanged Man", List.of(tiposUsuarios[11]), "Physical", "Fire", random.nextDouble(50) + 30));

        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Takaya").getId(), user.get("Takaya").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Jin").getId(), user.get("Jin").getPersonas().getId());
        usuarioHasPersonaDAO.insertUsuarioHasPersona(user.get("Chidori").getId(), user.get("Chidori").getPersonas().getId());

        /*
        personasDAOuser.insertPersona(user.get("Takaya").getPersonas());
        personasDAOuser.insertPersona(user.get("Jin").getPersonas());
        personasDAOuser.insertPersona(user.get("Chidori").getPersonas());

         */
// ---------------------------------------- NPCs: ----------------------------------------

        Map<String, NPC> npcs = new HashMap<>();

        npcs.put("Hierophant", new NPC("Bunkichi e Mitsuko", 70, "Masculino/Feminino", "Bibliotecários aposentados", "Hierophant"));
        npcs.put("Magician", new NPC("Kenji Tomochika", 16, "Masculino", "Aluno", "Magician"));
        npcs.put("Chariot", new NPC("Kazushi Miyamoto", 17, "Masculino", "Atleta do time de corrida", "Chariot"));
        npcs.put("Emperor", new NPC("Hidetoshi Odagiri", 17, "Masculino", "Membro do conselho estudantil", "Emperor"));
        npcs.put("Strength", new NPC("Yuko Nishiwaki", 17, "Feminino", "Gerente do time esportivo", "Strength"));
        npcs.put("Justice", new NPC("Chihiro Fushimi", 16, "Feminino", "Tesoureira do conselho estudantil", "Justice"));
        npcs.put("Hermit", new NPC("Maya", 27, "Feminino", "Professora", "Hermit"));
        npcs.put("Moon", new NPC("Nozomi Suemitsu", 15, "Masculino", "Gourmet King", "Moon"));
        npcs.put("Fortune", new NPC("Keisuke Hiraga", 17, "Masculino", "Presidente do clube de artes", "Fortune"));
        npcs.put("Sun", new NPC("Akinari Kamiki", 17, "Masculino", "Poeta", "Sun"));
        npcs.put("Tower", new NPC("Mutatsu", 55, "Masculino", "Monge", "Tower"));
        npcs.put("Hanged Man", new NPC("Maiko", 8, "Feminino", "Estudante do Jardim", "Hanged Man"));
        npcs.put("Temperance", new NPC("Bebé", 17, "Masculino", "Estudante francês de intercâmbio", "Temperance"));
        npcs.put("Devil", new NPC("Tanaka", 36, "Masculino", "Empresário da Tanaka's Amazing Commodities", "Devil"));

        NPCDAO npcdao = new NPCDAO();
        npcdao.insertNPC(npcs.get("Hierophant"));
        npcdao.insertNPC(npcs.get("Magician"));
        npcdao.insertNPC(npcs.get("Chariot"));
        npcdao.insertNPC(npcs.get("Emperor"));
        npcdao.insertNPC(npcs.get("Strength"));
        npcdao.insertNPC(npcs.get("Justice"));
        npcdao.insertNPC(npcs.get("Hermit"));
        npcdao.insertNPC(npcs.get("Moon"));
        npcdao.insertNPC(npcs.get("Fortune"));
        npcdao.insertNPC(npcs.get("Sun"));
        npcdao.insertNPC(npcs.get("Tower"));
        npcdao.insertNPC(npcs.get("Hanged Man"));
        npcdao.insertNPC(npcs.get("Temperance"));
        npcdao.insertNPC(npcs.get("Devil"));

// ----------------------------------------- Shadows(inimigos): -------------------------------------

        List<Shadow> shadows = new ArrayList<>();
        shadows.add(new Shadow("Dancer of Sorrow", 160, 18, "Moon", List.of("Magic"), "Fire", "Ice", random.nextDouble(50) + 30));
        shadows.add(new Shadow("Brutal Ogre", 210, 22, "Strength", List.of("Physical"), "Wind", "Fire", random.nextDouble(50) + 30));
        shadows.add(new Shadow("Twisted Teacher", 130, 14, "Hierophant", List.of("Mental"), "Electricity", "Dark", random.nextDouble(50) + 30));
        shadows.add(new Shadow("Dark Cupid", 100, 11, "Lovers", List.of("Ailment"), "Bless", "Dark", random.nextDouble(50) + 30));
        shadows.add(new Shadow("Searing Beast", 190, 20, "Chariot", List.of("Physical", "Magic"), "Ice", "Fire", random.nextDouble(50) + 30));

        ShadowDAO shadowdao = new ShadowDAO();
        shadowdao.insertShadow(shadows.get(0));
        shadowdao.insertShadow(shadows.get(1));
        shadowdao.insertShadow(shadows.get(2));
        shadowdao.insertShadow(shadows.get(3));
        shadowdao.insertShadow(shadows.get(4));

        //                                  Habilidades das personas do protagonista:
        // ---------------------------------------- Personas habilidades: ----------------------------------------

        protagonista.personas.getFirst().addHabilidade(new Habilidades("Megidolaon", "Almighty", "Causa dano massivo a todos os inimigos", 6));
        protagonista.personas.getFirst().addHabilidade(new Habilidades("Mudo", "Dark", "Chance de causar morte instantânea a um inimigo", 3));
        protagonista.personas.getFirst().addHabilidade(new Habilidades("Die For Me!", "Dark", "Alta chance de causar morte instantânea a todos os inimigos", 7));

        protagonista.personas.get(1).addHabilidade(new Habilidades("Agidyne", "Fire", "Causa dano de fogo pesado a um inimigo", 5));
        protagonista.personas.get(1).addHabilidade(new Habilidades("Power Charge", "Support", "Aumenta o próximo dano físico causado", 0));
        protagonista.personas.get(1).addHabilidade(new Habilidades("Maragion", "Fire", "Causa dano de fogo médio a todos os inimigos", 4));

        protagonista.personas.get(2).addHabilidade(new Habilidades("Eiha", "Dark", "Causa dano sombrio leve a um inimigo", 2));
        protagonista.personas.get(2).addHabilidade(new Habilidades("Lunge", "Physical", "Causa dano físico leve a um inimigo", 3));
        protagonista.personas.get(2).addHabilidade(new Habilidades("Cleave", "Physical", "Causa dano físico leve a um inimigo", 3));

        protagonista.personas.get(3).addHabilidade(new Habilidades("Agi", "Fire", "Causa dano de fogo leve a um inimigo", 2));
        protagonista.personas.get(3).addHabilidade(new Habilidades("Rakunda", "Debuff", "Reduz a defesa de um inimigo", 0));
        protagonista.personas.get(3).addHabilidade(new Habilidades("Tarukaja", "Buff", "Aumenta o ataque de um aliado por 3 turnos", 0));

        protagonista.personas.get(4).addHabilidade(new Habilidades("Zio", "Electric", "Causa dano elétrico leve a um inimigo", 2));
        protagonista.personas.get(4).addHabilidade(new Habilidades("Dia", "Healing", "Restaura uma pequena quantidade de HP a um aliado", 0));
        protagonista.personas.get(4).addHabilidade(new Habilidades("Patra", "Healing", "Cura um aliado de status negativos", 0));

        protagonista.personas.get(5).addHabilidade(new Habilidades("Dream Needle", "Ailment", "Causa dano físico leve com chance de causar sono", 2));
        protagonista.personas.get(5).addHabilidade(new Habilidades("Life Drain", "Dark", "Drena uma pequena quantidade de HP de um inimigo", 3));
        protagonista.personas.get(5).addHabilidade(new Habilidades("Mudo", "Dark", "Chance de causar morte instantânea a um inimigo", 3));

        protagonista.personas.get(6).addHabilidade(new Habilidades("Tentarafoo", "Ailment", "Chance de causar confusão a todos os inimigos", 0));
        protagonista.personas.get(6).addHabilidade(new Habilidades("Evil Touch", "Ailment", "Chance de causar medo a um inimigo", 0));
        protagonista.personas.get(6).addHabilidade(new Habilidades("Spirit Drain", "Support", "Drena uma pequena quantidade de SP de um inimigo", 1));

        protagonista.personas.get(7).addHabilidade(new Habilidades("Bufu", "Ice", "Causa dano de gelo leve a um inimigo", 2));
        protagonista.personas.get(7).addHabilidade(new Habilidades("Media", "Healing", "Restaura uma pequena quantidade de HP a todos os aliados", 0));
        protagonista.personas.get(7).addHabilidade(new Habilidades("Rakukaja", "Buff", "Aumenta a defesa de um aliado por 3 turnos", 0));

        protagonista.personas.getLast().addHabilidade(new Habilidades("Maragi", "Fire", "Causa dano de fogo leve a todos os inimigos", 3));
        protagonista.personas.getLast().addHabilidade(new Habilidades("Dekunda", "Support", "Remove penalidades de status de todos os aliados", 0));
        protagonista.personas.getLast().addHabilidade(new Habilidades("Sukukaja", "Buff", "Aumenta a precisão e evasão de um aliado por 3 turnos", 0));

        HabilidadesDAO habilidadesdao = new HabilidadesDAO();

        habilidadesdao.insertHabilidade(protagonista.personas.getFirst().getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.getFirst().getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.getFirst().getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(1).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(1).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(1).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(2).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(2).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(2).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(3).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(3).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(3).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(4).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(4).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(4).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(5).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(5).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(5).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(6).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(6).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(6).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.get(7).getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.get(7).getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.get(7).getHabilidades().get(2));

        habilidadesdao.insertHabilidade(protagonista.personas.getLast().getHabilidades().get(0));
        habilidadesdao.insertHabilidade(protagonista.personas.getLast().getHabilidades().get(1));
        habilidadesdao.insertHabilidade(protagonista.personas.getLast().getHabilidades().get(2));


        // Habilidades dos usuários (SEES e Strega):
        // ---------------------------------------- Personas habilidadeds: ----------------------------------------

        user.get("Yukari").getPersonas().addHabilidade(new Habilidades("Agilao", "Fire", "Causa dano de fogo médio a um inimigo", 6));
        user.get("Yukari").getPersonas().addHabilidade(new Habilidades("Rebellion", "Support", "Aumenta a taxa de acerto crítico de um aliado por 3 turnos", 0));
        user.get("Yukari").getPersonas().addHabilidade(new Habilidades("Maragi", "Fire", "Causa dano de fogo leve a todos os inimigos", 4));
        user.get("Yukari").getPersonas().addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));

        user.get("Junpei").getPersonas().addHabilidade(new Habilidades("Zio", "Electric", "Causa dano elétrico leve a um inimigo", 4));
        user.get("Junpei").getPersonas().addHabilidade(new Habilidades("Maziodyne", "Electric", "Causa dano elétrico pesado a todos os inimigos com chance de causar choque", 12));
        user.get("Junpei").getPersonas().addHabilidade(new Habilidades("Sonic Punch", "Physical", "Causa dano físico leve a um inimigo com chance de causar aflição", 6));
        user.get("Junpei").getPersonas().addHabilidade(new Habilidades("Fist Master", "Passive", "Dobra o dano causado por armas de punho", 0));

        user.get("Mitsuru").getPersonas().addHabilidade(new Habilidades("Bufula", "Ice", "Causa dano de gelo médio a um inimigo com chance de congelar", 6));
        user.get("Mitsuru").getPersonas().addHabilidade(new Habilidades("Tentarafoo", "Ailment", "Chance de causar confusão a todos os inimigos", 8));
        user.get("Mitsuru").getPersonas().addHabilidade(new Habilidades("Ice Boost", "Passive", "Aumenta o dano de habilidades de gelo em 25%", 0));
        user.get("Mitsuru").getPersonas().addHabilidade(new Habilidades("Mabufula", "Ice", "Causa dano de gelo médio a todos os inimigos com chance de congelar", 12));

        user.get("Akihiko").getPersonas().addHabilidade(new Habilidades("Kill Rush", "Physical", "Causa dano físico leve a um inimigo múltiplas vezes", 12));
        user.get("Akihiko").getPersonas().addHabilidade(new Habilidades("Tarukaja", "Support", "Aumenta o ataque de um aliado por 3 turnos", 0));
        user.get("Akihiko").getPersonas().addHabilidade(new Habilidades("Swift Strike", "Physical", "Causa dano físico leve a todos os inimigos múltiplas vezes", 16));
        user.get("Akihiko").getPersonas().addHabilidade(new Habilidades("Makarakarn", "Support", "Reflete o próximo ataque mágico recebido por um aliado", 24));

        user.get("Ken").getPersonas().addHabilidade(new Habilidades("Hama", "Light", "Chance de causar morte instantânea a um inimigo", 8));
        user.get("Ken").getPersonas().addHabilidade(new Habilidades("Zan-ei", "Light", "Causa dano de luz leve a um inimigo", 6));
        user.get("Ken").getPersonas().addHabilidade(new Habilidades("Media", "Healing", "Restaura uma pequena quantidade de HP a todos os aliados", 0));
        user.get("Ken").getPersonas().addHabilidade(new Habilidades("Recarm", "Healing", "Revive um aliado com metade do HP", 0));

        user.get("Koromaru").getPersonas().addHabilidade(new Habilidades("Agi", "Fire", "Causa dano de fogo leve a um inimigo", 4));
        user.get("Koromaru").getPersonas().addHabilidade(new Habilidades("Mudoon", "Dark", "Alta chance de causar morte instantânea a um inimigo", 12));
        user.get("Koromaru").getPersonas().addHabilidade(new Habilidades("Fire Boost", "Passive", "Aumenta o dano de habilidades de fogo em 25%", 0));
        user.get("Koromaru").getPersonas().addHabilidade(new Habilidades("Hell Fang", "Physical", "Causa dano físico médio a um inimigo", 8));

        user.get("Aigis").getPersonas().addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));
        user.get("Aigis").getPersonas().addHabilidade(new Habilidades("Double Fangs", "Physical", "Causa dano físico leve a um inimigo duas vezes", 12));
        user.get("Aigis").getPersonas().addHabilidade(new Habilidades("Power Charge", "Support", "Aumenta o próximo dano físico causado por um aliado", 0));
        user.get("Aigis").getPersonas().addHabilidade(new Habilidades("Gigantic Fist", "Physical", "Causa dano físico muito pesado a um inimigo", 20));

        user.get("Shinjiro").getPersonas().addHabilidade(new Habilidades("Fatal End", "Physical", "Causa dano físico pesado a um inimigo", 10));
        user.get("Shinjiro").getPersonas().addHabilidade(new Habilidades("Kill Rush", "Physical", "Causa dano físico leve a um inimigo múltiplas vezes", 12));
        user.get("Shinjiro").getPersonas().addHabilidade(new Habilidades("Counterstrike", "Passive", "Chance de 15% de contra-atacar com dano físico médio", 0));

        user.get("Takaya").getPersonas().addHabilidade(new Habilidades("Mamudoon", "Dark", "Alta chance de causar morte instantânea a todos os inimigos", 16));
        user.get("Takaya").getPersonas().addHabilidade(new Habilidades("Hamaon", "Light", "Alta chance de causar morte instantânea a um inimigo", 14));
        user.get("Takaya").getPersonas().addHabilidade(new Habilidades("Mind Charge", "Support", "Aumenta o próximo dano mágico causado por um aliado", 0));

        user.get("Jin").getPersonas().addHabilidade(new Habilidades("Debilitate", "Support", "Reduz ataque, defesa e agilidade de um inimigo por 3 turnos", 0));
        user.get("Jin").getPersonas().addHabilidade(new Habilidades("Marakunda", "Support", "Reduz a defesa de todos os inimigos por 3 turnos", 0));
        user.get("Jin").getPersonas().addHabilidade(new Habilidades("Mabufula", "Ice", "Causa dano de gelo médio a todos os inimigos com chance de congelar", 12));

        user.get("Chidori").getPersonas().addHabilidade(new Habilidades("Maragion", "Fire", "Causa dano de fogo médio a todos os inimigos", 10));
        user.get("Chidori").getPersonas().addHabilidade(new Habilidades("Diarama", "Healing", "Restaura uma quantidade moderada de HP a um aliado", 0));
        user.get("Chidori").getPersonas().addHabilidade(new Habilidades("Fire Break", "Support", "Remove resistência ao fogo de todos os inimigos por 3 turnos", 0));

        HabilidadesDAO habilidadesdaouser = new HabilidadesDAO();

        habilidadesdaouser.insertHabilidade(user.get("Yukari").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Yukari").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Yukari").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Yukari").getPersonas().getHabilidades().get(3));
        
        habilidadesdaouser.insertHabilidade(user.get("Junpei").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Junpei").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Junpei").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Junpei").getPersonas().getHabilidades().get(3));
        
        habilidadesdaouser.insertHabilidade(user.get("Mitsuru").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Mitsuru").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Mitsuru").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Mitsuru").getPersonas().getHabilidades().get(3));

        habilidadesdaouser.insertHabilidade(user.get("Akihiko").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Akihiko").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Akihiko").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Akihiko").getPersonas().getHabilidades().get(3));

        habilidadesdaouser.insertHabilidade(user.get("Aigis").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Aigis").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Aigis").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Aigis").getPersonas().getHabilidades().get(3));

        habilidadesdaouser.insertHabilidade(user.get("Koromaru").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Koromaru").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Koromaru").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Koromaru").getPersonas().getHabilidades().get(3));

        habilidadesdaouser.insertHabilidade(user.get("Ken").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Ken").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Ken").getPersonas().getHabilidades().get(2));
        habilidadesdaouser.insertHabilidade(user.get("Ken").getPersonas().getHabilidades().get(3));

        habilidadesdaouser.insertHabilidade(user.get("Shinjiro").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Shinjiro").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Shinjiro").getPersonas().getHabilidades().get(2));

        habilidadesdaouser.insertHabilidade(user.get("Takaya").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Takaya").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Takaya").getPersonas().getHabilidades().get(2));

        habilidadesdaouser.insertHabilidade(user.get("Jin").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Jin").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Jin").getPersonas().getHabilidades().get(2));

        habilidadesdaouser.insertHabilidade(user.get("Chidori").getPersonas().getHabilidades().getFirst());
        habilidadesdaouser.insertHabilidade(user.get("Chidori").getPersonas().getHabilidades().get(1));
        habilidadesdaouser.insertHabilidade(user.get("Chidori").getPersonas().getHabilidades().get(2));
        
        //                                         Adicionar Itens:

        // HashMap - facilidade na busca:
        Map<String, Itens> item = new HashMap<>();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        ArmaDAO armaDAO = new ArmaDAO();
        ConsumiveisDAO consumiveisDAO = new ConsumiveisDAO();

        // ---------------------------------------- Equipamentos: ----------------------------------------

        item.put("God Hand", new Equipamento("God Hand", "Luva", 220.0, 2, "Crit Chance +15%", "unissex"));
        item.put("Kongou Hakama", new Equipamento("Kongou Hakama", "Armadura", 300.0, 3, "Resist Físico", "unissex"));
        item.put("Regent", new Equipamento("Regent", "Acessório", 150.0, 4, "Mag +10%", "unissex"));
        item.put("Black Headband", new Equipamento("Black Headband", "Cabeça", 120.0, 5, "Esquiva +10%", "unissex"));
        item.put("Omnipotent Orb", new Equipamento("Omnipotent Orb", "Especial", 5000.0, 6, "Anula Fraquezas", "unissex"));
        item.put("Sabbath Gloves", new Equipamento("Sabbath Gloves", "Luva", 200.0, 7, "Atk +10% / HP -5%", "unissex"));
        item.put("Dark Empress Dress", new Equipamento("Dark Empress Dress", "Armadura", 280.0, 8, "SP Regen +5/tur", "unissex"));
        item.put("Eternal Slippers", new Equipamento("Eternal Slippers", "Botas", 170.0, 9, "Velocidade +15%", "unissex"));
        item.put("Seven Sisters Badge", new Equipamento("Seven Sisters Badge", "Acessório", 130.0, 10, "Status Negativos -50%", "unissex"));

        equipamentoDAO.insertEquipamento((Equipamento) item.get("God Hand"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Kongou Hakama"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Regent"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Black Headband"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Omnipotent Orb"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Sabbath Gloves"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Dark Empress Dress"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Eternal Slippers"));
        equipamentoDAO.insertEquipamento((Equipamento) item.get("Seven Sisters Badge"));

        // ---------------------------------------- Armas: ------------------------------------------
        item.put("Paradise Lost", new Arma("Paradise Lost", "Espada", 250.0, "Raro", 85.0));
        item.put("Espada Curta", new Arma("Espada Curta", "Espada", 1500.0, "Normal", 48.0));
        item.put("Luvas de Combate", new Arma("Luvas de Combate", "Soco", 1800.0, "Normal", 52.0));
        item.put("Naginata", new Arma("Naginata", "Lança", 2000.0, "Normal", 56.0));
        item.put("Arco do Vento", new Arma("Arco do Vento", "Arco", 2200.0, "Raro", 60.0));

        armaDAO.insertArma((Arma) item.get("Paradise Lost"));
        armaDAO.insertArma((Arma) item.get("Espada Curta"));
        armaDAO.insertArma((Arma) item.get("Luvas de Combate"));
        armaDAO.insertArma((Arma) item.get("Naginata"));
        armaDAO.insertArma((Arma) item.get("Arco do Vento"));

// ------------------------------------ Consumíveis -------------------------------------------------
        item.put("Revival Bead", new Consumiveis("Revival Bead", "Revivir", 600, "Revive um aliado com 50% de HP"));
        item.put("Bead Chain", new Consumiveis("Bead Chain", "Cura", 1000, "Restaura totalmente o HP de todos os aliados"));
        item.put("Soul Drop", new Consumiveis("Soul Drop", "SP", 150, "Recupera 10 SP de um aliado"));
        item.put("Snuff Soul", new Consumiveis("Snuff Soul", "SP", 400, "Recupera 50 SP de um aliado"));
        item.put("Medical Powder", new Consumiveis("Medical Powder", "Cura", 100, "Restaura 50 HP de um aliado"));

        consumiveisDAO.insertConsumivel((Consumiveis) item.get("Revival Bead"));
        consumiveisDAO.insertConsumivel((Consumiveis) item.get("Bead Chain"));
        consumiveisDAO.insertConsumivel((Consumiveis) item.get("Soul Drop"));
        consumiveisDAO.insertConsumivel((Consumiveis) item.get("Snuff Soul"));
        consumiveisDAO.insertConsumivel((Consumiveis) item.get("Medical Powder"));
        
        // -------------------------------------- Loja de Itens: -------------------------------------

        Map<Itens, Integer> estoque = new HashMap<>();
        LojadeItensDAO lojadeItensDAO = new LojadeItensDAO();

        int j = 0;
        for (Itens i : item.values()) {
            estoque.put(i, 1);
            lojadeItensDAO.insertItem(i,j, 1);
            j++;
        }
        LojadeItens loja = new LojadeItens("Untouchable", estoque);


        // ------------------------------------ Menu Principal de buscas: ------------------------------------

        int opcao;

        while(true){
            try {
                opcao = mostrar_menu_buscas();
                if (opcao == 0) {
                    break;
                }

                switch (opcao) {

                    case 1 -> {
                        try {
                            System.out.println("\n----- Dados do Protagonista -----");
                            protagonista.mostraInfoPersonagem();
                            while (true) {
                                System.out.println("\nDeseja ver detalhes de alguma persona? (S/N)");
                                String resposta = "";
                                try {
                                    resposta = sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada. Por favor, digite S ou N.");
                                    sc.nextLine();
                                    break;
                                }
                                if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                                    System.out.println("Digite o número da persona: ");
                                    System.out.println("1. Alice");
                                    System.out.println("2. Eligor");
                                    System.out.println("3. Arsène");
                                    System.out.println("4. Jack-o'-Lantern");
                                    System.out.println("5. Pixie");
                                    System.out.println("6. Incubus");
                                    System.out.println("7. Succubus");
                                    System.out.println("8. Silky");
                                    System.out.println("9. Orobas");
                                    int numPersona = sc.nextInt();
                                    sc.nextLine();
                                    if (numPersona > 0 && numPersona <= protagonista.personas.size()) {
                                        protagonista.personas.get(numPersona - 1).mostrarStatusPersona();
                                    } else {
                                        System.out.println("Número inválido!");
                                    }
                                } else if (resposta.equalsIgnoreCase("N") || resposta.equalsIgnoreCase("n")) break;
                                else {
                                    System.out.println("Entrada Incorreta!");
                                }
                            }
                            while(true) {
                                System.out.println("Deseja evoluir uma Persona? (S/N)");
                                String resposta2 = sc.nextLine();
                                if (resposta2.equalsIgnoreCase("Sim") || resposta2.equalsIgnoreCase("S")) {
                                    System.out.println("Qual o nome da Persona que deseja evoluir?");
                                    String nome = sc.nextLine();
                                    boolean encontrada = false;

                                    for (Personas p : protagonista.personas) {
                                        if (p.getNome().equalsIgnoreCase(nome)) {
                                            protagonista.evoluirPersona(p);
                                            System.out.println(p.getNome() + " evoluiu para o nivel " + p.getNivel());
                                            encontrada = true;
                                            break;
                                        }
                                    }

                                    if (!encontrada) {
                                        System.out.println("Persona não encontrada!");
                                    }
                                } else if (resposta2.equalsIgnoreCase("N") || resposta2.equalsIgnoreCase("n")) break;
                                else {
                                    System.out.println("Entrada Incorreta!");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.println("\n----- Usuário -----");
                            int count = 1;
                            for (String nomeUsuario : user.keySet()) {
                                System.out.println(count + ". " + nomeUsuario);
                                count++;
                            }
                            System.out.println("\nDigite o nome do usuário que deseja consultar: ");
                            String nomeUsuario = sc.nextLine();
                            if (user.containsKey(nomeUsuario)) {
                                user.get(nomeUsuario).mostraInfoPersonagem();
                                if (user.get(nomeUsuario).getPersonas() != null) {
                                    user.get(nomeUsuario).getPersonas().mostrarStatusPersona();
                                } else {
                                    System.out.println("Este usuário não possui personas.");
                                }
                            } else {
                                System.out.println("Usuário não encontrado!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("\n----- NPC -----");
                            int count = 1;
                            for (String nomeNPC : npcs.keySet()) {
                                System.out.println(count + ". " + nomeNPC);
                                count++;
                            }
                            System.out.println("Digite o nome do Confidant do NPC que deseja consultar: ");
                            String nomeNPC = sc.nextLine();
                            if (npcs.containsKey(nomeNPC)) {
                                npcs.get(nomeNPC).mostraInfoPersonagem();
                            } else System.out.println("NPC não encontrado!");
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            System.out.println("\n----- Dados da Loja de Itens -----");

                            loja.mostraInfoLojadeItens();

                            System.out.println("\nDeseja comprar algum item? (S/N)");
                            String resposta = sc.nextLine();
                            if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")) {
                                loja.mostrarItens();
                                System.out.println("Digite o nome do item: ");
                                String nomeItem = sc.nextLine();
                                if (item.containsKey(nomeItem)) {
                                    loja.venderItem(protagonista, item.get(nomeItem));
                                } else {
                                    System.out.println("Item não encontrado!");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 5 -> {
                        try {
                            System.out.println("\n----- Dar/Equipar Itens -----");

                            // Mostrar inventário do protagonista
                            System.out.println("Itens disponíveis no inventário do protagonista:");
                            protagonista.inventario.mostrarInventarioPersonagem();

                            System.out.println("\nUsuários disponíveis:");
                            int count = 1;
                            for (String nomeUsuario : user.keySet()) {
                                System.out.println(count + ". " + nomeUsuario);
                                count++;
                            }

                            System.out.println("Deseja equipar um item no protagonista ou dá-lo a um aliado? (S/N)");
                            String resposta = sc.nextLine();
                            if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")) {
                                System.out.println("1. Protagonista");
                                System.out.println("2. Aliado");
                                System.out.println("0. Sair");
                                opcao = sc.nextInt();
                                sc.nextLine();
                                switch (opcao) {
                                    case 1 -> {
                                        try {
                                            System.out.print("Digite o nome do item a ser dado/equipado: ");
                                            String nomeItem = sc.nextLine();
                                            item.get(nomeItem).equiparItem(protagonista);
                                            System.out.println("Item equipado com sucesso!");
                                        } catch (NullPointerException e) {
                                            System.out.println("Erro ao equipar o item: " + e);
                                        }
                                    }
                                    case 2 -> {
                                        System.out.print("Digite o nome do item a ser dado/equipado: ");
                                        String nomeItem = sc.nextLine();
                                        System.out.println("Escreva o nome do aliado que deseja dar este item: ");
                                        try {
                                            String nomeAliado = sc.nextLine();
                                            if (user.containsKey(nomeAliado)) {
                                                protagonista.darItemUsuario(user.get(nomeAliado), item.get(nomeItem));
                                                item.get(nomeItem).equiparItem(user.get(nomeAliado));
                                                System.out.println("Item equipado com sucesso pelo usuário " + nomeAliado + "!");
                                            }
                                        } catch (NullPointerException e) {
                                            System.out.println("Erro ao equipar o item: " + e);
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Usuário não encontrado ou opção de saída!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 6 -> {
                        try {
                            System.out.println("\n----- Dados de Inimigos -----");
                            System.out.println("1. Vilões (Humanos)");
                            System.out.println("2. Shadows");
                            System.out.print("Escolha: ");
                            int tipoInimigo = sc.nextInt();
                            sc.nextLine();

                            if (tipoInimigo == 1) {
                                System.out.println("\n----- Vilões -----");
                                user.get("Takaya").mostraInfoPersonagem();
                                user.get("Jin").mostraInfoPersonagem();
                                user.get("Chidori").mostraInfoPersonagem();
                            } else if (tipoInimigo == 2) {
                                System.out.println("\n----- Shadows -----");
                                for (Shadow s : shadows) {
                                    System.out.println(s.toString());
                                }
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    case 7 -> {
                        System.out.println("\n----- Inventário do Protagonista -----");
                        protagonista.inventario.mostrarInventarioPersonagem();
                    }
                    case 8 -> {
                        try {
                            System.out.println("\n----- Inventário de Usuário -----");
                            int count = 1;
                            for (String nomeUsuario : user.keySet()) {
                                System.out.println(count + ". " + nomeUsuario);
                                count++;
                            }
                            System.out.println("\nDigite o nome do usuário que deseja ver o inventário: ");

                            String nomeUsuario = sc.nextLine();
                            if (user.containsKey(nomeUsuario)) {
                                user.get(nomeUsuario).inventario.mostrarInventarioPersonagem();
                            } else {
                                System.out.println("Usuário não encontrado!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro:" + e.getMessage());
                        }
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }catch(InvalidMenuInputException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        // --------------------------------- Implementação da cidade ---------------------------------
        Cidade tatsumiPort = new Cidade("Tatsumi Port Island");
        CidadeDAO cidadesDAO = new CidadeDAO();
        cidadesDAO.insertCidade(tatsumiPort);

        // Adicionando aos locais
        tatsumiPort.adicionarPersonagemAoLocal("Dormitório", user.get("Yukari"));
        tatsumiPort.adicionarPersonagemAoLocal("Dormitório", user.get("Junpei"));
        tatsumiPort.adicionarPersonagemAoLocal("Escola", user.get("Mitsuru"));
        tatsumiPort.adicionarPersonagemAoLocal("Rua", user.get("Takaya"));
        tatsumiPort.adicionarPersonagemAoLocal("Rua", user.get("Chidori"));
        tatsumiPort.adicionarPersonagemAoLocal("Shopping", user.get("Akihiko"));
        tatsumiPort.adicionarPersonagemAoLocal("Shopping", user.get("Aigis"));
        tatsumiPort.adicionarPersonagemAoLocal("Loja de Itens", user.get("Fuuka"));

        cidadesDAO.adicionarLocal("Tatsumi Port Island","Dormitório");
        cidadesDAO.adicionarLocal("Tatsumi Port Island","Escola");
        cidadesDAO.adicionarLocal("Tatsumi Port Island","Rua");
        cidadesDAO.adicionarLocal("Tatsumi Port Island","Shopping");
        cidadesDAO.adicionarLocal("Tatsumi Port Island","Loja de Itens");

        cidadesDAO.adicionarPersonagemAoLocal("Dormitório", protagonista);
        cidadesDAO.adicionarPersonagemAoLocal("Dormitório", user.get("Yukari"));
        cidadesDAO.adicionarPersonagemAoLocal("Rua", user.get("Junpei"));
        cidadesDAO.adicionarPersonagemAoLocal("Escola", user.get("Mitsuru"));
        cidadesDAO.adicionarPersonagemAoLocal("Rua", user.get("Takaya"));
        cidadesDAO.adicionarPersonagemAoLocal("Rua", user.get("Chidori"));
        cidadesDAO.adicionarPersonagemAoLocal("Shopping", user.get("Akihiko"));
        cidadesDAO.adicionarPersonagemAoLocal("Shopping", user.get("Aigis"));
        cidadesDAO.adicionarPersonagemAoLocal("Loja de Itens", user.get("Fuuka"));

        cidadesDAO.buscarTodasCidades();
        cidadesDAO.deletarCidade("Tatsumi Port Island");


        String localAtual = "Dormitório";

        opcao = -1;

        do {
            try {
                opcao = mostrarMenuCidade(localAtual);
                switch (opcao) {
                    case 1 -> {
                        try {
                            System.out.println("\nLocais disponíveis: " + tatsumiPort.getLocais().keySet());
                            System.out.print("Digite o nome do local: ");
                            String destino;

                            destino = sc.nextLine();

                            if (tatsumiPort.getLocais().containsKey(destino)) {
                                localAtual = destino;
                                System.out.println("Você foi para " + localAtual);
                            } else {
                                System.out.println("Local inválido!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("\nPersonagens no local " + localAtual + ":");
                        tatsumiPort.getPersonagensNoLocal(localAtual).forEach(p ->
                                System.out.println("- " + p.getNome()));
                    }
                    case 3 -> {
                        ArrayList<SerHumano> pessoas = tatsumiPort.getPersonagensNoLocal(localAtual);
                        if (pessoas.isEmpty()) {
                            System.out.println("Ninguém por aqui...");
                            break;
                        }
                        System.out.println("Com quem deseja interagir?");
                        for (int i = 0; i < pessoas.size(); i++) {
                            System.out.println((i + 1) + ". " + pessoas.get(i).getNome());
                        }

                        int escolha = sc.nextInt();

                        try {
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }

                        if (escolha > 0 && escolha <= pessoas.size()) {
                            System.out.println("interagindo");
                            //protagonista.interagir(pessoas.get(escolha - 1));
                        } else {
                            System.out.println("Escolha inválida!");
                        }
                    }
                    case 4 -> {
                        ArrayList<SerHumano> pessoas = tatsumiPort.getPersonagensNoLocal(localAtual);
                        ArrayList<UsuarioPersona> viloes = new ArrayList<>();
                        // colocando os vilões no array0
                        for (SerHumano pessoa : pessoas) {
                            if (pessoa instanceof Usuarios u) {
                                if (u.isVilao()) {
                                    viloes.add(u);
                                }
                            }
                        }

                        // inicializando o array manualmente para testes
                        ArrayList<UsuarioPersona> timeProtagonistas = new ArrayList<>();
                        timeProtagonistas.add(protagonista);
                        timeProtagonistas.add(user.get("Mitsuru"));
                        timeProtagonistas.add(user.get("Yukari"));
                        timeProtagonistas.add(user.get("Aigis"));

                        if (!viloes.isEmpty()) {
                            iniciarCombate(timeProtagonistas, viloes);
                        } else {
                            System.out.println("Não há vilões na área para combater");
                        }
                    }
                    case 5 -> {
                        System.out.println("Loja");
                        loja.mostraInfoLojadeItens();
                        loja.mostrarItens();
                    /*
                        Criar loop para que o protagonista possa comprar os itens
                    * */
                    }
                    case 0 -> System.out.println("Saindo do jogo...");
                    default -> System.out.println("Opção inválida!");
                }
            }catch(InvalidMenuInputException e){
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }
}