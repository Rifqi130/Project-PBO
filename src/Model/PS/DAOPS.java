package Model.PS;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPS implements InterfaceDAOPS {
    @Override
    public void insert(ModelPS playstation) {
        try {
            String query = "INSERT INTO rental (nama, paket, harga, lamasewa, hargatotal ) VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, playstation.getNama());
            preparedStatement.setString(2, playstation.getPaket());
            preparedStatement.setInt(3, playstation.getHarga());
            preparedStatement.setInt(4, playstation.getLamasewa());
            preparedStatement.setInt(5, playstation.getHargatotal());
            
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelPS playstation) {
        try {
            String query = "UPDATE rental SET nama=?, paket=?, harga=?, lamasewa=?, hargatotal=?, WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, playstation.getNama());
            preparedStatement.setString(2, playstation.getPaket());
            preparedStatement.setInt(3, playstation.getHarga());
            preparedStatement.setInt(4, playstation.getLamasewa());
            preparedStatement.setInt(5, playstation.getHargatotal());
            preparedStatement.setInt(6, playstation.getId());
            
            preparedStatement.executeUpdate();
            ResultSet ps = preparedStatement.getGeneratedKeys();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Update gagal: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM rental WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Delete gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelPS> getAll() {
        List<ModelPS> playstationList = new ArrayList<>();

        try {
            Statement statement = Connector.connect().createStatement();
            
            String query = "SELECT * FROM rental;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelPS playstation = new ModelPS();
                
                playstation.setId(resultSet.getInt("id"));
                playstation.setNama(resultSet.getString("nama"));
                playstation.setPaket(resultSet.getString("paket"));
                playstation.setHarga(resultSet.getInt("harga"));
                playstation.setLamasewa(resultSet.getInt("lamasewa"));
                playstation.setHargatotal(resultSet.getInt("hargatotal"));
                
                playstationList.add(playstation);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return playstationList;
    }
}
