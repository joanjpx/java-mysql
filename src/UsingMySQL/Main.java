package UsingMySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        Conexion CN = new Conexion("root","","java","localhost");
        CN.conectar();
        CN.insertar();
        CN.actualizar(14);
        CN.consultar();
    }
}
