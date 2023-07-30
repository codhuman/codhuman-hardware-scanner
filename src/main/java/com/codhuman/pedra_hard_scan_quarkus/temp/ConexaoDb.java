package com.codhuman.pedra_hard_scan_quarkus.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDb {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/pedra_db";
        String username = "seu_usuario";
        String password = "sua_senha";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Inserir um registro
            String insertQuery = "INSERT INTO cpu_info (modelo, velocidade) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "Intel Core i7");
            insertStatement.setDouble(2, 3.2);
            int rowsInserted = insertStatement.executeUpdate();
            System.out.println(rowsInserted + " registro(s) inserido(s).");

            // Atualizar um registro
            String updateQuery = "UPDATE cpu_info SET velocidade = ? WHERE modelo = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setDouble(1, 3.6);
            updateStatement.setString(2, "Intel Core i7");
            int rowsUpdated = updateStatement.executeUpdate();
            System.out.println(rowsUpdated + " registro(s) atualizado(s).");

            // Selecionar registros
            String selectQuery = "SELECT * FROM cpu_info";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String modelo = resultSet.getString("modelo");
                double velocidade = resultSet.getDouble("velocidade");
                System.out.println("Modelo: " + modelo + ", Velocidade: " + velocidade);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }
}
