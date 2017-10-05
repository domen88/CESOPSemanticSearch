package it.unibo.cesop.demo;

import it.unibo.cesop.demo.model.Document;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.jade.JadeTemplateEngine;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Programma {

    public static void main(String[] args) throws MalformedURLException {

        //Set Java Spark server port
        port(8080);

        //Set static file folder
        staticFileLocation("/public/css");

        //Program param
        final boolean mode = args[0].equals("137.204.57.106") ? Boolean.TRUE : Boolean.FALSE;

        //URL Solr
        final SolrClient server = new HttpSolrClient.Builder("http://"+args[0]+":8983/solr/VisionTestCurriculumCollection").build();

        get("/", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("message", "Hello Jade!");
            return new ModelAndView(model, "index"); // located in resources/templates directory
        }, new JadeTemplateEngine());

        post("/cerca", (Request request, Response response) -> {
            //Start time
            Instant start = Instant.now();
            Map<String, Object> model = new HashMap<>();

            String cerca = request.queryParams("cerca");
            model.put("message", cerca);

            //Set solr query
            final String wildCard= "http\\:\\/\\/www.cesop.it\\/ontologies\\/";
            SolrQuery query = new SolrQuery();
            String squery;
            if (mode) {
                squery = String.format("Competenze_ancestors_labels_t:%s OR Competenze_parent_labels_t:%s OR Competenze_label_t:%s", cerca, cerca, cerca);
            } else {
                squery = String.format("Competenze:%s", cerca);
            }
            query.setRows(Integer.MAX_VALUE);
            query.setQuery(squery);
            //query.addFilterQuery("Cognome:"+ cerca);

            //Get results
            QueryResponse rsp = server.query(query);
            SolrDocumentList docs = rsp.getResults();
            List<Document> beans = rsp.getBeans(Document.class);

            Instant stop = Instant.now();
            Duration duration = Duration.between(start, stop);
            double seconds = (double)duration.getNano() / 1000000000.0;
            model.put("total", String.format("%.3f", seconds));
            model.put("nris", beans.size());
            model.put("documents", beans);
            model.put("mode", mode);

            return new ModelAndView(model, "cerca"); // located in resources/templates directory
        }, new JadeTemplateEngine());


    }
}
