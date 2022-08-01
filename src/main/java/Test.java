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
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> data = new HashMap<>();
        data.put("clientName", "client name heeel");
        data.put("clientAddress", "client name heeel");
        data.put("clientIdentificationNumber", "client name heeel");
        data.put("clientDocumentIssueDate", "22-06-2022");
        data.put("clientAuthority", "authoriey");
        data.put("clientPin", "234567788");
        data.put("companyName", "Infosyss");
        data.put("attorneyNumber", "Infosyss");
        data.put("attorneyDate", "Infosyss");
        data.put("reasonPayment", "Infosyss");
        data.put("loanId", "Infosyss");
        data.put("todayDate", "22-06-2022");
        data.put("principalAmount", "60000");
        data.put("loanAmountInWords", "Infosyss");
        Context context = new Context();
        context.setVariables(data);
        String orderHtml = templateEngine.process("test", context);
        System.out.println(orderHtml);
        ByteArrayOutputStream target = new ByteArrayOutputStream();
        /* Call convert method */
        HtmlConverter.convertToPdf(orderHtml, target);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();
        FileUtils.writeByteArrayToFile(new File("test.pdf"), bytes);
//        final String filePath = "/home/daypay/workspace/intellij/mp-report-poc/reports/disbursal.html";
//                HtmlConverter.convertToPdf(
//                new File(filePath),
//                new File("test.pdf"));
    }
}
