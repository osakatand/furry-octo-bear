package fr.emn.gsi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Example {

    private static final String FILE_PATH = "pdf/presentation_1.pdf";

    @GET
    @Path("/pdf")
    @Produces("application/pdf")
    public Response getFile() {

        File file = new File(FILE_PATH);

        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition",
                "attachment; filename=presentation.pdf");
        return response.build();

    }

    @GET
    @Path("/html")
    @Produces("text/html")
    public String getHtml() {
        String response = "<html><h1>Hello world</h1></html>";
        return response;
    }

    @GET
    @Path("/article")
    @Produces("application/json")
    public List<ArticleBean> ping() {
        List<ArticleBean> articles = new ArrayList<ArticleBean>();
        ArticleBean article1 = new ArticleBean();
        article1.setId(0);
        article1.setName("article1");
        articles.add(article1);

        ArticleBean article2 = new ArticleBean();
        article2.setId(1);
        article2.setName("article1");
        articles.add(article2);

        return articles;
    }

}

