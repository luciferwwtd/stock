package fuckingweather;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fuckingweather.FreeMarkerTemplateEngine;
import spark.TemplateEngine;

public class fuckingFreeMarker {

    public static void main(String args[]) {

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "hello.ftl");
        }, new FreeMarkerTemplateEngine());
    }
}