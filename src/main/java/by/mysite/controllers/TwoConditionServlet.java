package by.mysite.controllers;

import by.mysite.model.entities.Student;
import by.mysite.model.serices.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "twoConditionServlet", urlPatterns = "/criteria")
public class TwoConditionServlet extends HttpServlet {
    private StudentService service;

    @Override
    public void init() throws ServletException {
        service = new StudentService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        List<Student> students = service.getStudentsByCriteria(params);

        if (!students.isEmpty()) {
            req.setAttribute("students", students);
        } else {
            req.setAttribute("message", "Students not found");
        }

        RequestDispatcher rd = req.getRequestDispatcher("/extendStudents.jsp");
        rd.forward(req, resp);
    }
}
