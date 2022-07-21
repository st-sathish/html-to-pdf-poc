import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class ReportGenerationExample {

    public static void main(String[] args) throws IOException {
        HtmlConverter.convertToPdf(new File("reports/tax-receipt.html"),new File("demo-html.pdf"));
    }
}
