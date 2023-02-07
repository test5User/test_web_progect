package by.mysite.controllers;

import by.mysite.model.db.DBInMemory;
import by.mysite.model.entities.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jspStudentController", urlPatterns = "/jspSearch")
public class JSPStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        String criteria = req.getParameter("criteria");

        Student student = DBInMemory.findStudentByFIO(fio);
        RequestDispatcher rd = req.getRequestDispatcher("/student.jsp");

        if (student != null) { //main scenario
            req.setAttribute("stud", student);
        } else {  //alt scenario
            String massage = "Student by name " + fio + " not found";
            req.setAttribute("message", massage);
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
