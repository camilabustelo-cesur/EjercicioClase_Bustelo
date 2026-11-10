package org.example.ejercicioclase_bustelo.data;

import org.example.ejercicioclase_bustelo.models.Registro;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RegistroJdbcDAO implements DAO<Registro> {



    private DataSource ds;

    public RegistroJdbcDAO(DataSource ds) {
        this.ds = ds;
    }


    @Override
    public Optional<Registro> findByNombre(String nombre) {
        String findID = "SELECT * FROM Registro WHERE nombre = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement psw = conn.prepareStatement(findID)){
            psw.setString(1,nombre);
                try(ResultSet rs = psw.executeQuery()){
                    if(rs.next()){
                        return Optional.of(new Registro());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Registro> findAll() {
        return List.of();
    }

    @Override
    public Registro save(Registro obj) {
        return null;
    }

    @Override
    public void update(Registro entity) {

    }

    @Override
    public void deleteByNombre(String nombre) {

    }
}
