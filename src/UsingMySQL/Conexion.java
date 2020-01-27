package UsingMySQL;
import java.sql.*;
public class Conexion {

    private String user;
    private String password;
    private String db;
    private String host;
    private String url;
    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;

    public Conexion(String usuario, String password, String bd, String servidor) {
        this.user = usuario;
        this.password = password;
        this.db = bd;
        this.host = servidor;
        this.url = "jdbc:mysql://" + this.host + "/" + this.db;
    }

    public void conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                stm = conn.createStatement();
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void consultar() throws SQLException {
        rs = stm.executeQuery("SELECT * FROM usuarios");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }
    }

    public void actualizar(int id) throws SQLException {
        stm.execute("UPDATE usuarios SET username='nombre usuario' WHERE id=" +id);
    }

    public void insertar() throws SQLException {
        stm.execute("INSERT INTO usuarios (username, password) VALUES ('new_name', 'new_Pass')");
    }

    public void eliminar() throws SQLException {
        stm.execute("DELETE FROM usuarios WHERE id=" + 1);
    }
}