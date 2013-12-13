package com.sites;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        List<String> sites = SiteService.load(filter);

        response.setContentType("application/json");
        
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(sites));
        }
    }
    
    @Override
    public void init() throws ServletException {       
        String path = this.getServletContext().getRealPath("data/top-1m.csv");
        SiteService.build(path);
    }
}
