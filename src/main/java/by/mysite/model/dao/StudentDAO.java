package by.mysite.model.dao;

import by.mysite.model.db.ConnectionManager;
import by.mysite.model.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO {
    private static final String QUERY = "SELECT id, fio, email FROM student WHERE fio LIKE ?";
    public Student findStudentByFIO(String fio) {
        try(Connection cn = ConnectionManager.getConnection();
            PreparedStatement ps = cn.prepareStatement(QUERY)) {
            ps.setString(1, fio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                return new Student(id, fio, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> findStudentsByIds(int fromId, int toId) {
        return null;
    }
}
