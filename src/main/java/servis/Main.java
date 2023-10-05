package servis;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DAO dao = new DAO();
        PeopelFactory.makePeopel().forEach(x ->{
            try {
                dao.insert(x);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
