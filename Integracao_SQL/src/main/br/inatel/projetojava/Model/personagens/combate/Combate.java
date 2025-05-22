package main.br.inatel.projetojava.Model.personagens.combate;

import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;
import main.br.inatel.projetojava.Model.personas.Personas;

public interface Combate {
    public void atacar(Personas persona, UsuarioPersona alvo); // Atacar personagem ou persona ou os dois?

    public void defender();

    public boolean agir(int turno, Personas persona, UsuarioPersona alvo);
}
