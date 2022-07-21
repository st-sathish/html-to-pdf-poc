import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.commons.io.FileUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerationExample {

    public static void main(String[] args) throws IOException {
        //final String filePath = "";
        final String filePath = "/home/daypay/workspace/intellij/mp-report-poc/reports/tax-recipt.html";
        HtmlConverter.convertToPdf(
                new File(filePath),
                new File("demo-html.pdf"));
        final Map<String, Object> data = new HashMap<>();
        data.put("cardNumber", "123455");
        data.put("cvv", "123455");
        data.put("month", "123455");
        data.put("year", "123455");
        Context context = new Context();
        context.setVariables(data);
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        String htmlContent = templateEngine.process(filePath, context);
        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("http://localhost:8080");
        HtmlConverter.convertToPdf(htmlContent, target, converterProperties);
        /* extract output as bytes */
        byte[] bytes = target.toByteArray();
        FileUtils.writeByteArrayToFile(new File("demo-html.pdf"), bytes);
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(bytes);
    }
}
