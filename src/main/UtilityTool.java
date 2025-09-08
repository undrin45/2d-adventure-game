/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author harin
 */
public class UtilityTool
{
    public BufferedImage scaleImage(BufferedImage og, int width, int height)
    {
        BufferedImage scaledImage= new BufferedImage(width, height, og.getType());
        Graphics2D g2= scaledImage.createGraphics();
        g2.drawImage(og,0,0,width,height,null);
        g2.dispose();
        
        return scaledImage;
    }
}
