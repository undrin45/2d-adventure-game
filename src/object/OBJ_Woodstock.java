package object;

import entity.Entity;
import javax.imageio.ImageIO;
import java.io.IOException;
import main.GamePanel;

public class OBJ_Woodstock extends Entity
{
    public OBJ_Woodstock(GamePanel gp)
    {
        super(gp);
        name= "Woodstock";
        try
        {
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/object-3.png.png"));
        }
        catch(IOException e)
        {
                    
        }
        
    }
}