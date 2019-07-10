/*
package com.pawanchoure;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.logging.Level;  
import java.util.logging.Logger;  

import org.apache.pdfbox.cos.COSDocument;  
import org.apache.pdfbox.exceptions.COSVisitorException;  
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdfparser.PDFParser;  
import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.PDPage;  
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;  
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.pdmodel.font.PDType1Font;  
import org.apache.pdfbox.util.PDFTextStripper;  
  
*/
/**
 * 
 * @author Anuj 
 *//*

public class PDFTextParser {  
  
    public PDFTextParser() {  
    }  
  
    */
/**
     * Converts PDF to Text using Apache PDFBox 
     * @param fileName 
     * @throws CryptographyException 
     * @throws BadSecurityHandlerException 
     *//*

    public void convertPDFToText(String fileName) throws BadSecurityHandlerException, CryptographyException {  
        String pdfText = null;  
        PDFParser pdfparser = null;  
        COSDocument cosDocument = null;  
        PDDocument pdDocument = null;  
  
        File file = new File("C:\\hdfc.pdf");  
        try {  
        	
        	
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);  
        	InputStream inputStream =new FileInputStream("C:\\hdfc.pdf");
            pdfparser = new PDFParser(inputStream);  
  
            //parse document  
            pdfparser.parse();  
  
            PDDocument originialPdfDoc = pdfparser.getPDDocument();

            boolean isOriginalDocEncrypted = originialPdfDoc.isEncrypted();
            if (isOriginalDocEncrypted) {
                originialPdfDoc.openProtection(new StandardDecryptionMaterial("PAWA7521"));
            }
            
            cosDocument = pdfparser.getDocument();  
            pdDocument = new PDDocument(cosDocument);  
  
            //create PDFTextStipper to convert PDF to Text  
            PDFTextStripper pDFTextStripper = new PDFTextStripper();  
            pdfText = pDFTextStripper.getText(pdDocument);  
  
            System.out.println("PDF Content :");  
            System.out.println(pdfText);  
  
        } catch (IOException ex) {  
            Logger.getLogger(PDFTextParser.class.getName()).log(Level.SEVERE, null, ex);  
        } finally {  
            //Close documents  
            try {  
                if (cosDocument != null) {  
                    cosDocument.close();  
                }  
                if (pdDocument != null) {  
                    pdDocument.close();  
                }  
            } catch (IOException ex) {  
                Logger.getLogger(PDFTextParser.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
    }  
  
    */
/**
     * Convert Text to PDF using Apache PDFBox 
     * @param fileName 
     *//*

    public void convertTextToPDF(String fileName) {  
        System.out.println("Save Text to PDF File: "+fileName);  
        PDDocument pDDocument = null;  
        PDPage pDPage = null;  
      
        try {  
            //Create PDDocument  
            pDDocument = new PDDocument();  
            pDPage = new PDPage();  
            pDPage.setMediaBox(PDPage.PAGE_SIZE_A4);  
  
            //Add Page to Document  
            pDDocument.addPage(pDPage);  
  
            //Create PDPageContentStream  
            PDPageContentStream contentStream = new PDPageContentStream(pDDocument, pDPage);  
  
            //SetFont  
            PDType1Font font = PDType1Font.COURIER;  
            float fontSize = 8;  
            contentStream.setFont(font, fontSize);  
  
            //Write data to Contentstream  
            contentStream.beginText();  
            contentStream.moveTextPositionByAmount(30,800);  
            contentStream.drawString("Hello Anuj, I am created using Apache PDFBox");  
            contentStream.endText();  
            contentStream.close();  
  
            //Save to Document  
            pDDocument.save(fileName);  
  
        } catch (IOException ex) {  
            Logger.getLogger(PDFTextParser.class.getName()).log(Level.SEVERE, null, ex);  
        } catch (COSVisitorException ex) {  
            Logger.getLogger(PDFTextParser.class.getName()).log(Level.SEVERE, null, ex);  
        } finally {  
            try {  
                if (pDDocument != null) {  
                    pDDocument.close();  
                }  
            } catch (IOException ex) {  
                Logger.getLogger(PDFTextParser.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
    }  
  
    public static void main(String[] args) throws BadSecurityHandlerException, CryptographyException {  
        PDFTextParser pDFTextParser = new PDFTextParser();  
        pDFTextParser.convertPDFToText("pawan.pdf");  
  
        //complex one. Would prefer jasper reports or iText than this for writing  
       // pDFTextParser.convertTextToPDF("TextToPDF.pdf");  
    }  
}  
*/
