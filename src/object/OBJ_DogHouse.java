package object;

import entity.Entity;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.io.IOException;
import main.GamePanel;

public class OBJ_DogHouse extends Entity
{
    public OBJ_DogHouse(GamePanel gp)
    {
        super(gp);
        
        name= "DogHouse";
        try
        {
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/object-2.png.png"));
        }
        catch(IOException e)
        {
                    
        }
       
    }
}

