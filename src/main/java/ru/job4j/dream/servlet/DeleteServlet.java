package ru.job4j.dream.servlet;

import ru.job4j.dream.store.Store;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class DeleteServlet extends HttpServlet {
    private File imageFolder;

    @Override
    public void init() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("c:\\projects\\job4j_dreamjob\\data\\dreamjob.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageFolder = new File(properties.getProperty("dreamjob.imagefolder"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Store.instOf().deleteCandidate(id);
        File file = new File(imageFolder.getAbsolutePath() + "\\" + req.getParameter("id") + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        resp.sendRedirect("candidates.do");
    }
}
