package object;

import entity.Entity;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import main.GamePanel;

public class OBJ_Key extends Entity
{
    public OBJ_Key(GamePanel gp)
    {
        
        super(gp);
        name= "Key";
        //down1;
        try
        {
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/object-3.png (1).png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
    }
}
