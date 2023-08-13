package com.carmanagementsystem.services.impl;

import com.carmanagementsystem.entities.ServiceRequest;
import com.carmanagementsystem.entities.Services;
import com.carmanagementsystem.exceptions.ResourceNotFoundException;
import com.carmanagementsystem.repositories.ServiceRequestRepository;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.awt.*;
import java.io.ByteArrayOutputStream;

@Service
public class InvoiceGenerator {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

  public byte[] generateInvoicePdf(ServiceRequest serviceRequest) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    try {
      Document document = new Document();
      PdfWriter.getInstance(document, outputStream);

      document.open();

      Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
      Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

      // Title
      Paragraph title = new Paragraph("Invoice", titleFont);
      title.setAlignment(Element.ALIGN_CENTER);
      document.add(title);

      // Service Request Details
      Paragraph details = new Paragraph(
              "Service Request ID: " + serviceRequest.getId() + "\n" +
                      "Service Date: " + serviceRequest.getServiceDate() + "\n" +
                      "Customer: " + serviceRequest.getCustomer().getCustomerName() + "\n" +
                      "Vehicle: " + serviceRequest.getVehicle().getRegNo() + "\n\n", normalFont);
      document.add(details);

      // Service Items Table
      PdfPTable table = new PdfPTable(3);
      table.setWidthPercentage(100);
      table.setWidths(new float[]{1, 4, 2});
      table.addCell("No.");
      table.addCell("Service Name");
      table.addCell("Price");

      int itemNumber = 1;
      for (Services item : serviceRequest.getServiceItems()) {
        table.addCell(String.valueOf(itemNumber));
        table.addCell(item.getName());
        table.addCell(String.valueOf(item.getPrice()));
        itemNumber++;
      }
      document.add(table);

      // Total Amount
      double totalAmount = serviceRequest.getServiceItems().stream()
              .mapToDouble(Services::getPrice)
              .sum();
      Paragraph total = new Paragraph("Total Amount: ₹" + totalAmount, normalFont);
      total.setAlignment(Element.ALIGN_RIGHT);
      document.add(total);

      document.close();

      return outputStream.toByteArray();
    } catch (DocumentException e) {
      e.printStackTrace();
      return null; // Handle error
    }
  }

//    public static void main(String[] args) {
//        try {
//            // Assuming you have a ServiceRequest instance available
//            ServiceRequest serviceRequest = ...; // Retrieve the service request from your database
//
//            byte[] invoiceBytes = generateInvoice(serviceRequest);
//            // Save or send the invoiceBytes as needed (e.g., write to a file, send as response)
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
