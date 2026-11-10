package org.example.ejercicioclase_bustelo.data;

import org.example.ejercicioclase_bustelo.models.Registro;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroJdbcDAO implements DAO<Registro> {



    private DataSource ds;

    public RegistroJdbcDAO(DataSource ds) {
        this.ds = ds;
    }


    @Override
    public Optional<Registro> findById(Long id) {
        String sql = "SELECT * FROM registros WHERE id = ?";

        try (Connection conn = ds.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setLong(1,id);

            try (ResultSet rs = pst.executeQuery()){
                if (rs.next()) {
                    return Optional.of(new Registro());
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return Optional.empty();
    }

    @Override
    public List<Registro> findAll() {
        String sql = "SELECT * FROM registros";
        List<Registro> registros = new ArrayList<>();
        try (Connection conn = ds.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {
            while (rs.next()){
                registros.add(new Registro());
                }
            }  catch ( SQLException e) {
            throw new RuntimeException(e);
        }
        return registros;
    }

    @Override
    public Registro save(Registro obj) {
        String sql = "INSERT INTO registros(nombre,categoria,disponible) VALUES(?,?,?)";

        try(Connection conn = ds.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            pst.setString(1,obj.getNombre());
            pst.setString(2, obj.getCategoria());
            pst.setBoolean(3,obj.getDisponible());
            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()){
                if (rs.next()){
                    obj.setId(rs.getLong(1));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return obj;
    }

    @Override
    public void update(Registro entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
