
package com.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PDFViewerPanel extends JPanel{
    private BufferedImage image;
    
    public PDFViewerPanel(BufferedImage image){
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0,0, null);
        }
    }
}
