package ru.job4j.dream.servlet;

import ru.job4j.dream.store.Store;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Store.instOf().deleteCandidate(id);
        File file = new File("c:\\images\\" + req.getParameter("id") + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        resp.sendRedirect("candidates.do");
    }
}
