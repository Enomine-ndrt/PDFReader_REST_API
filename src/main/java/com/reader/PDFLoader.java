
package com.reader;

import com.view.PDFViewerPanel;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


public class PDFLoader {
    
    public void loadAndDisplay(String pdfUrl,JPanel imagePanel){
      try{
          InputStream inputStream = new URL(pdfUrl).openStream();
          PDDocument document = PDDocument.load(inputStream);
          PDFRenderer renderer = new PDFRenderer(document);
          
          imagePanel.removeAll();
          
          for(int i =0;i< document.getNumberOfPages();i++){
              BufferedImage image = renderer.renderImage(i);
              PDFViewerPanel pdfPanel = new PDFViewerPanel(image);
              imagePanel.add(pdfPanel);
          }
          
          imagePanel.revalidate();
          imagePanel.repaint();
          document.close();
          inputStream.close();
          
      }catch(Exception e){
          e.printStackTrace();
      }  
    }
    
}
