package by.mysite.controllers;

import by.mysite.model.db.DBInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "searchStudentController", urlPatterns = "/search")
public class SearchStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        String criteria = req.getParameter("criteria");

        //todo сдеоать прослойку
        boolean isFound = DBInMemory.isContainsStudentByFIO(fio);
        RequestDispatcher rd = null;
        if (isFound) { //main scenario
            rd = req.getRequestDispatcher("/yesPage.html");
        } else {  //alt scenario
            rd = req.getRequestDispatcher("/noPage.html");
        }

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
