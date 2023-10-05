package servis;

import model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    Connection connection;

    public DAO() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/p1","root","1234");
    }
    public void insert(Person x) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement ("insert into Person" +
                "(id,firstname,lastName,age,gender,geography,email,profession,salary,isAlive)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, x.getId());
        preparedStatement.setString(2,x.getFirstName());
        preparedStatement.setString(3,x.getLastName());
        preparedStatement.setString(3,x.getLastName());
        preparedStatement.setInt(4,x.getAge());
        preparedStatement.setString(5,x.getGender());
        preparedStatement.setString(6,x.getGeography());
        preparedStatement.setString(7,x.getEmail());
        preparedStatement.setString(8,x.getProfession());
        preparedStatement.setDouble(9,x.getSalary());
        preparedStatement.setBoolean(10,x.getAlive());
        preparedStatement.executeUpdate();
    }
}
