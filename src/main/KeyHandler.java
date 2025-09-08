
package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    GamePanel gp;
    public boolean upPressed, downPressed, rightPressed, leftPressed;
    
    public KeyHandler(GamePanel gp)
    {
        this.gp=gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
       int code =e.getKeyCode();
       
       if(code == KeyEvent.VK_UP)
       {
           upPressed = true;
       }
       
       if(code == KeyEvent.VK_DOWN)
       {
           downPressed=true;
       }
       
       if(code == KeyEvent.VK_LEFT)
       {
           leftPressed=true;
       }
       
       if(code == KeyEvent.VK_RIGHT)
       {
           rightPressed=true;
       }
       
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code= e.getKeyCode();
        
        if(code == KeyEvent.VK_UP)
       {
           upPressed = false;
       }
       
       if(code == KeyEvent.VK_DOWN)
       {
           downPressed=false;
       }
       
       if(code == KeyEvent.VK_LEFT)
       {
           leftPressed=false;
       }
       
       if(code == KeyEvent.VK_RIGHT)
       {
           rightPressed=false;
       }
        
    }
    
}
