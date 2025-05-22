package main.br.inatel.projetojava.Model.personagens.combate;

import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;
import main.br.inatel.projetojava.Model.personagens.jogaveis.Protagonista;
import main.br.inatel.projetojava.Model.personagens.jogaveis.Usuarios;

import java.util.ArrayList;

public class CombateManager {

    public static void iniciarCombate(ArrayList<UsuarioPersona> grupo1, ArrayList<UsuarioPersona> grupo2) {
        int turno = 1;
        boolean turnoDoGrupo1 = true;
        boolean combate = true;

        Protagonista protagonista = encontrarProtagonista(grupo1);

        if (protagonista == null) {
            System.out.println("Erro: O grupo 1 precisa conter um protagonista!");
            return;
        }

        System.out.println("\n--- Combate iniciado! ---");

        while (combate && !todosDerrotados(grupo2) && protagonista.getHp() > 0) {
            System.out.println("\n--- Turno " + turno + " ---");

            if (turnoDoGrupo1) {
                System.out.println("Turno do Grupo 1:");
                for (UsuarioPersona membro : grupo1) {
                    if (membro.getHp() <= 0) {
                        System.out.println(membro.getNome() + " está incapacitado e não pode agir.");
                        continue;
                    }

                    // Caso o protagonista tenha morrido entre turnos
                    if (protagonista.getHp() <= 0) {
                        System.out.println(protagonista.getNome() + " foi derrotado! Combate encerrado.");
                        combate = false;
                        break;
                    }

                    UsuarioPersona alvo = escolherAlvo(grupo2);
                    if (alvo == null) break;

                    combate = executarTurnoIndividual(membro, alvo, turno);
                    if (!combate) break;
                }
            }
            else {
                System.out.println("Turno do Grupo 2:");
                for (UsuarioPersona membro : grupo2) {
                    if (membro.getHp() <= 0) continue;

                    UsuarioPersona alvo = escolherAlvo(grupo1);
                    if (alvo == null) break;

                    combate = executarTurnoIndividual(membro, alvo, turno);

                    // Caso o protagonista morra nesse turno
                    if (protagonista.getHp() <= 0) {
                        System.out.println(protagonista.getNome() + " foi derrotado! Combate encerrado.");
                        combate = false;
                        break;
                    }

                    if (!combate) break;
                }
            }

            turnoDoGrupo1 = !turnoDoGrupo1;
            turno++;
        }

        if (protagonista.getHp() <= 0) {
            System.out.println(protagonista.getNome() + " caiu em batalha. O grupo recua.");
        }
        else if (todosDerrotados(grupo2)) {
            System.out.println("Grupo 2 foi derrotado!");
        }

        System.out.println("--- Combate Encerrado ---");
    }

    private static boolean executarTurnoIndividual(UsuarioPersona atacante, UsuarioPersona defensor, int turno) {
        System.out.println("\nÉ o turno de " + atacante.getNome());

        if (atacante instanceof Protagonista protagonista) {
            return atacante.agir(turno, protagonista.persona_atual, defensor);
        }
        else if (atacante instanceof Usuarios usuario) {
            return atacante.agir(turno, usuario.getPersonas(), defensor);
        }
        return true;
    }

    private static UsuarioPersona escolherAlvo(ArrayList<UsuarioPersona> grupo) {
        for (UsuarioPersona p : grupo) {
            if (p.getHp() > 0)
                return p;
        }
        return null;
    }

    private static boolean todosDerrotados(ArrayList<UsuarioPersona> grupo) {
        for (UsuarioPersona p : grupo) {
            if (p.getHp() > 0)
                return false;
        }
        return true;
    }

    private static Protagonista encontrarProtagonista(ArrayList<UsuarioPersona> grupo) {
        for (UsuarioPersona p : grupo) {
            if (p instanceof Protagonista protagonista) {
                return protagonista;
            }
        }
        return null;
    }
}