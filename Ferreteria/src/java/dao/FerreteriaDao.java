package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Ferreteria;

public class FerreteriaDao {

    Conexion conn;

    public FerreteriaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(Ferreteria ferr) {
        String sql = "insert into user_ferreteria values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ferr.getId());
            ps.setString(2, ferr.getNombre());
            ps.setString(3, ferr.getHerramientas());
            ps.setInt(4, (int) ferr.getPrecio());
            ps.setString(5, ferr.getFecha());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Ferreteria> ConsultarAll() {
        String sql = "select * from user_ferreteria";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Ferreteria> lista = new LinkedList<>();
            Ferreteria ferr;
            while (rs.next()) {
                ferr = new Ferreteria(0);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
