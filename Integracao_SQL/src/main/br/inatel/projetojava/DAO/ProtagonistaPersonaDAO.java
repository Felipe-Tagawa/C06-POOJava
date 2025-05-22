package main.br.inatel.projetojava.DAO;

import main.br.inatel.projetojava.Model.relacional.ProtagonistaPersona;

import java.sql.SQLException;

public class ProtagonistaPersonaDAO extends ConnectionDAO {

    public void testConnection() {
        this.connectToDb();
    }

    public boolean insertProtagonistaPersona(ProtagonistaPersona protagonistaPersona) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO ProtagonistaPersona (idProtagonista, idPersona) VALUES (?, ?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, protagonistaPersona.getIdProtagonista());
            pst.setInt(2, protagonistaPersona.getIdPersona());
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro ao inserir protagonista_persona: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar recursos: " + exc.getMessage());
            }
        }

        return sucesso;
    }
}
