package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
public class DeleteServlet extends HttpServlet {
    private File imageFolder;

    @Override
    public void init() {
       Config config = new Config();
        this.imageFolder = new File(config.get("dreamjob.imagefolder"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DbStore.instOf().deleteCandidate(id);
        File file = new File(imageFolder.getAbsolutePath() + "\\" + req.getParameter("id") + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        resp.sendRedirect("candidates.do");
    }
}
