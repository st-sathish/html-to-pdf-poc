import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.commons.io.FileUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Test {

    public static ClassLoaderTemplateResolver thymeleafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("LEGACYHTML5");
        return templateResolver;
    }

    public static void main(String[] args) throws IOException {
        final TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        Context context = new Context();
        context.setVariable("price", "23sath");
        String orderHtml = templateEngine.process("test", context);
        System.out.println(orderHtml);
        ByteArrayOutputStream target = new ByteArrayOutputStream();
        /* Call convert method */
        HtmlConverter.convertToPdf(orderHtml, target);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();
        FileUtils.writeByteArrayToFile(new File("test.pdf"), bytes);
//        final String filePath = "/home/daypay/workspace/intellij/mp-report-poc/reports/test.html";
//                HtmlConverter.convertToPdf(
//                new File(filePath),
//                new File("test.pdf"));
    }
}
