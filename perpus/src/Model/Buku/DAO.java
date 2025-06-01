package Model.Buku;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements Interface {

    @Override
    public void insert(ModelBuku buku) {
        try {
            String query = "INSERT INTO databuku (judul, penulis, tahun, alur, bahasa, orisinalitas, rating) VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = Connector.getConnection().prepareStatement(query);
            statement.setString(1, buku.getJudul());
            statement.setString(2, buku.getPenulis());
            statement.setInt(3, buku.getTahun());
            statement.setInt(4, buku.getAlur());
            statement.setInt(5, buku.getBahasa());
            statement.setInt(6, buku.getOrisinalitas());
            statement.setFloat(7, buku.getRating());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelBuku buku) {
        try {
            String query = "UPDATE databuku SET judul=?, penulis=?, tahun=?, alur=?, bahasa=?, orisinalitas=?, rating=? WHERE id=?;";

            PreparedStatement statement = Connector.getConnection().prepareStatement(query);
            statement.setString(1, buku.getJudul());
            statement.setString(2, buku.getPenulis());
            statement.setInt(3, buku.getTahun());
            statement.setInt(4, buku.getAlur());
            statement.setInt(5, buku.getBahasa());
            statement.setInt(6, buku.getOrisinalitas());
            statement.setFloat(7, buku.getRating());
            statement.setInt(8, buku.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM databuku WHERE id=?;";

            PreparedStatement statement = Connector.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelBuku> getAll() {
        List<ModelBuku> listBuku = new ArrayList<>();

        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM databuku;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelBuku buku = new ModelBuku();
                buku.setId(resultSet.getInt("id"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPenulis(resultSet.getString("penulis"));
                buku.setTahun(resultSet.getInt("tahun"));
                buku.setAlur(resultSet.getInt("alur"));
                buku.setBahasa(resultSet.getInt("bahasa"));
                buku.setOrisinalitas(resultSet.getInt("orisinalitas"));

                listBuku.add(buku);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Get All Failed: " + e.getLocalizedMessage());
        }

        return listBuku;
    }
}
