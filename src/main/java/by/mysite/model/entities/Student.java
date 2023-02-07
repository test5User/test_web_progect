package by.mysite.model.entities;

public class Student {
    private int id;
    private String fio;
    private String email;

    public Student() {
    }

    public Student(int id, String fio, String email) {
        this.id = id;
        this.fio = fio;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
