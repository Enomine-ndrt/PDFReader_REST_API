
package com.view;
import com.api.ApiClient;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.reader.PDFLoader;
import javax.swing.*;
import java.awt.*;


public class Vista extends javax.swing.JFrame {

    private JButton jbutton1;
    //private JScrollPane scrollPane;
    private JPanel imagePanel;
    
    public Vista() {
        initComponents();
        setupCustomComponents();
    }

    
    private void setupCustomComponents(){
        jButton1.addActionListener(e -> cargarPDF());
        imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        JScrollPane.setViewportView(imagePanel);
    }
    
     private void cargarPDF() {
       //String pdfUrl = "http://localhost/municipio_res_api/laravel.pdf";
       //PDFLoader pdfLoader = new PDFLoader();
       //pdfLoader.loadAndDisplay(pdfUrl, imagePanel);
       ApiClient apiClient = new ApiClient();
       String pdfUrl = apiClient.getPdfUrl();
       
       if(pdfUrl != null && !pdfUrl.isEmpty()){
           PDFLoader pdfLoader = new PDFLoader();
           pdfLoader.loadAndDisplay(pdfUrl, imagePanel);
       }else{
           JOptionPane.showMessageDialog(this,"No se pudo obtener la url del pdf");
       }
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        JScrollPane = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("PDF");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addGap(64, 64, 64)
                .addComponent(jButton2)
                .addContainerGap(400, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JScrollPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
       try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Cambiar a otros temas según se desee
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                               
                new Vista().setVisible(true);
            }
        });
        
       
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

   
}
