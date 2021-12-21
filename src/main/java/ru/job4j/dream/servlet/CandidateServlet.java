package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
        req.setAttribute("cities", DbStore.instOf().findAllCities());
        req.getRequestDispatcher("/candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Candidate candidate = new Candidate();
        candidate.setId(Integer.parseInt(req.getParameter("id")));
        candidate.setName(req.getParameter("name"));
        candidate.setCityId(Integer.parseInt(req.getParameter("cityId")));
        DbStore.instOf().save(candidate);
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
