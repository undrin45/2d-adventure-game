/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author harin
 */
public class OBJ_Heart extends Entity
{

    public OBJ_Heart(GamePanel gp)
    {
        super(gp);
        name= "Heart";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            
            image= uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2= uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3= uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
         
    }
}
