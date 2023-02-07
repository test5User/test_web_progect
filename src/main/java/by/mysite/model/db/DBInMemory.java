package by.mysite.model.db;

import by.mysite.model.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DBInMemory {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Vasia Pupkin", "vasia.pupkin@gmail.com"));
        students.add(new Student(2, "Ivan Ivanov", "ivan.ibanov@gmail.com"));
        students.add(new Student(3, "Petr Petrov", "petr.petrov@gmail.com"));
    }

    public static boolean isContainsStudentByFIO(String fio) {
        return students.stream().anyMatch(it -> it.getFio().equals(fio));
    }

    public static Student findStudentByFIO(String fio) {
        return students.stream()
                .filter(it -> it.getFio().equals(fio))
                .findFirst().orElse(null);
    }

    public static List<Student> findStudentsByIds(int fromId, int toId) {
        return students.stream()
                .filter(it -> it.getId() >= fromId && it.getId() <= toId)
                .collect(Collectors.toList());
    }
}
