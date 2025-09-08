/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster;

import entity.Entity;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author harin
 */
public class MON_GreenSlime extends Entity
{

    public MON_GreenSlime(GamePanel gp)
    {
        super(gp);
        type=2;
        name="Green Slime";
        speed=1;
        maxLife=4;
        life=maxLife;
        
        solidArea.x=3;
        solidArea.y=18;
        solidArea.width=42;
        solidArea.height=30;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        
        getImage();
        
    }
    
    public void getImage()
    {
       try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2.png"));
            
            up1= uTool.scaleImage(up1, gp.tileSize, gp.tileSize);
            up2= uTool.scaleImage(up2, gp.tileSize, gp.tileSize);
            down1= uTool.scaleImage(down1, gp.tileSize, gp.tileSize);
            down2= uTool.scaleImage(down2, gp.tileSize, gp.tileSize);
            left1= uTool.scaleImage(left1, gp.tileSize, gp.tileSize);
            left2= uTool.scaleImage(left2, gp.tileSize, gp.tileSize);
            right1= uTool.scaleImage(right1, gp.tileSize, gp.tileSize);
            right2= uTool.scaleImage(right2, gp.tileSize, gp.tileSize);
            
        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
    }
    
    @Override
    public void setAction()
    {   
       //System.out.println(actionLockCounter);
        actionLockCounter++;
        //System.out.println(actionLockCounter);
        if(actionLockCounter == 120)
        {
            //System.out.println("actionlock reached 120");
            Random random = new Random();
            int i=random.nextInt(100)+1;
            //System.out.println("Random number generated: "+i);
            if(i <= 25){
                direction = "up";
                //System.out.println("i initiates upwards movement");
            }
            if(i>25 && i <= 50){
                direction = "down";
                //System.out.println("i initiates downwards movement");
            }
            if(i>50 && i <= 75){
                direction = "left";
                //System.out.println("i initiates left movement");
            }
            if(i>75 && i <= 100){
                direction = "right";
                //System.out.println("i initiates right movement");
            }
            actionLockCounter=0;
        }
        
        
    }
    
}
