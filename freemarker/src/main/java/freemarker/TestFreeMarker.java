package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TestFreeMarker {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(
                new File("/Users/Eric/Documents/IdeaProjects/HeadFirst-Spring-Develop/freemarker/src/main/resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template ftl = cfg.getTemplate("user.ftl");

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("name", "lilei");
        root.put("password", "12345");

        Writer out = new OutputStreamWriter(System.out);
        ftl.process(root, out);
    }

}
