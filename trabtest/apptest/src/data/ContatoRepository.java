package data;

import models.Contato;
import config.DBConnection;

import java.awt.Taskbar.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepository {
    
    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (? ? ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, contato.getNome());
                stmt.setString(2, contato.getEmail());
                stmt.setString(3, contato.getTelefone());

                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas > 0) {
                    System.out.println("Adicionado.");
                }

            } catch (SQLException e) {
                System.out.println("Erro ao adicionar.");
                e.printStackTrace();
            }
    }

    public List<Contato> obterTodosContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contato contato = new Contato(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                contatos.add(contato);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter contatos.");
            e.printStackTrace();
        }
        return contatos;
    }
}