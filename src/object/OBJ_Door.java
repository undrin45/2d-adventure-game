package object;

import entity.Entity;
import javax.imageio.ImageIO;
import java.io.IOException;
import main.GamePanel;

public class OBJ_Door extends Entity
{
    public OBJ_Door(GamePanel gp)
    {
        super(gp);
        name= "Door";
        try
        {
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/object-1.png.png"));
        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
        collision=true;
         
    }
}
