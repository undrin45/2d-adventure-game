package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity
{

    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public int minKey=3;
    
    public Player(GamePanel gp, KeyHandler keyH)
    {
       super(gp);
  
       this.keyH=keyH;
       
       screenX= gp.screenWidth/2- (gp.tileSize/2);
       screenY=gp.screenHeight/2- (gp.tileSize/2);
       
       solidArea= new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=32;
        solidArea.height=32;
        
       setDefaultValues();
       getPlayerImage();
    }
    
    public void setDefaultValues()
    {
        worldX=gp.tileSize*23;
        worldY=gp.tileSize*21;
        speed=4;
        direction="down";
        
        //player life status
        maxLife = 6;
        life=maxLife;
        
    }
    
    public void getPlayerImage()
    {
        try{
            
            up1=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-7.png.png"));
            up2=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-8.png.png"));
            down1=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-5.png.png"));
            down2=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-6.png.png"));
            left1=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-1.png.png"));
            left2=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-2.png.png"));
            right1=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-3.png.png"));
            right2=ImageIO.read(getClass().getResourceAsStream("/player/snoopy-4.png.png"));
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update()
    {
        
        if(keyH.upPressed ==  true || keyH.downPressed ==  true || keyH.leftPressed ==  true || keyH.rightPressed ==  true)
        {
           if(keyH.upPressed==true)
            {
                direction = "up";
            }
        
            else if(keyH.downPressed==true)
            {
                direction = "down";
            }
        
            else if(keyH.rightPressed==true)
            {
                direction = "right";
            }

            else if(keyH.leftPressed==true)
            {
                direction = "left";
            }

           
           
           //check tile colliion
           collisionOn=false;
           gp.cChecker.checkTile(this);
           
           //check object collision
           int objIndex=gp.cChecker.checkObject(this, true);
           pickUpObject(objIndex);
           
           //check monster collision
           int monsterIndex=gp.cChecker.checkEntity(this, gp.monster);
           
           contactMonster(monsterIndex);
           
           //if collision is false, plater can move
           
           if(collisionOn == false)
           {
               switch(direction)
               {
                   case "up": worldY-=speed; break;
                       
                   case "down": worldY+=speed; break;
                       
                   case "left": worldX-=speed; break;
                       
                    case "right": worldX+=speed; break;
               }
           }
           
            spriteCounter++;
            if(spriteCounter > 9)
            {
                if(spriteNum == 1)
                {
                    spriteNum =2;
                }
                else if(spriteNum == 2) 
                {
                    spriteNum=1;
                }
                spriteCounter=0;
            } 
        }
        
        //outside key if statemnet
        if(invincible == true)
        {
            invincibleCounter++;
            if(invincibleCounter > 60)
            {
                invincible=false;
                invincibleCounter =0;
            }
        }
       
        
    }
    
    public void pickUpObject(int i)
    {
            if(i != 999)
            {
                
                String objectName = gp.obj[i].name;
                switch(objectName)
                {
                    case "Key":
                        hasKey++;
                        gp.obj[i]=null;
                        gp.ui.showMessage("You got a key!");
                        
                        break;
                        
                    case "Door":
                        if(hasKey>=minKey)
                        {
                            gp.obj[i]=null;
                            hasKey=hasKey-3;
                            gp.ui.showMessage("You opened the door!");
                        }
                        else gp.ui.showMessage("You don't have enough keys!");
                        
                        System.out.println("Key: "+hasKey);
                        break;
                        
                    case "Woodstock":
                            
                        speed += 3;
                        gp.obj[i] = null;
                        gp.ui.showMessage("Speed up!");
                        break;
                            
                    case "DogHouse":
                        gp.ui.gameFinished = true;
                        break;
                        
                }
                
                
            }
        }
    
   @Override
    public void draw(Graphics2D g2)
{
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
       
        BufferedImage image=null;
       switch(direction)
        {
            case "up":
                if(spriteNum == 1)
               {
                   image=up1;
               }
              
               if(spriteNum == 2)
               {
                   image=up2;
               }
                
               break;
               
          case "down":
               if(spriteNum == 1){
                   image=down1;
               }
              
               if(spriteNum == 2){
                   image=down2;
               }
              break;
               
           case "left":
               if(spriteNum == 1){
                   image=left1;
               }
               
              if(spriteNum == 2){
                   image=left2;
               }
               break;
               
            case "right":
               if(spriteNum == 1){
                    image=right1;
                }
                
                if(spriteNum == 2){
                    image=right2;
                }
                break;
        }
       
    
      
    
    
    //makes player transpaetn when invncible
    if(invincible == true)
    {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
    }
     g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
     //reset opacity
     g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
}

    private void contactMonster(int i)
    {
        if(i != 999)
        {
            if(invincible == false)
            {
                life -=1;
                invincible=true;
            }
            
        }
    }
}
