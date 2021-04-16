package tn.esprit.spring.service;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import tn.esprit.spring.entity.*;
public class NotificationPdf {
	private List<Notification> listPayments;
    
    public NotificationPdf(List<Notification> listNotifcation) {
        this.listNotifcation = listNotifcation;
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.red);
        cell.setPadding(4);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Payment idNotification", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Payment email", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Payment description", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Payment creationDate", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
        for (Notification notifications : listNotification) {
            table.addCell(String.valueOf(Notification.getIdNotification()));
            table.addCell((String.valueOf(Notification.getEmail())));
            table.addCell((String.valueOf(Notification.getDescription())));
            table.addCell((String.valueOf(Notification.getCreationDate())));
        }
        public void export(HttpServletResponse response) throws DocumentException, IOException {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
             
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(Color.red);
             
            Paragraph n = new Paragraph("List of Notifications", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);
             
            document.add(n);
             
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {1.5f, 3.5f, 3.5f, 1.5f});
            table.setSpacingBefore(10);
             
            writeTableHeader(table);
            writeTableData(table);
             
            document.add(table);
             
            document.close();
             
        }
    }

}
