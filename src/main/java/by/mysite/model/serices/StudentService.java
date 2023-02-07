package by.mysite.model.serices;

import by.mysite.model.dao.StudentDAO;
import by.mysite.model.db.DBInMemory;
import by.mysite.model.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public List<Student> getStudentsByCriteria(Map<String, String[]> params) {
        List<Student> students = new ArrayList<>();
        String criteria = params.get("criteria")[0];
        switch (criteria) {
            case "name" : {
                String name = params.get("fio")[0];
                //students.add(DBInMemory.findStudentByFIO(name));
                students.add(studentDAO.findStudentByFIO(name));
                students = students.stream().filter(Objects::nonNull).collect(Collectors.toList());
                break;
            }
            case "id" : {
                String fromId = params.get("fromId")[0];
                String toId = params.get("toId")[0];
                int from = Integer.parseInt(fromId);
                int to = Integer.parseInt(toId);
                students.addAll(DBInMemory.findStudentsByIds(from, to));
                break;
            }
            default: break;
        }
        return students;
    }
}
