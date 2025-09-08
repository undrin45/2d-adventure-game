/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Entity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_Heart;
import object.OBJ_Key;

/**
 *
 * @author harin
 */
public class UI
{
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80b;
    BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn= false;
    public String message="";
    int messageCounter=0;
    public boolean gameFinished = false;
    //public boolean gameLost= false;
    
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40=new Font("Arial", Font.PLAIN, 40);
        
        
        arial_40=new Font("Arial", Font.PLAIN, 40);
        arial_80b=new Font("Arial", Font.BOLD, 70);
        OBJ_Key key = new OBJ_Key(gp);
        keyImage= key.down1;
        
        //Create HUD object
        Entity heart= new OBJ_Heart(gp);
        heart_full=heart.image2;
        heart_half=heart.image3;
        heart_blank=heart.image;
    }
    
    public void draw(Graphics2D g2)
    {
        
        this.g2=g2;
        
        if(gp.player.life == 0)
        {
            
            
            
            String text;
            int textLength;
            int x;
            int y;
           
            
            
            g2.setFont(arial_80b);
            g2.setColor(Color.red);
            text = "YOU DIED";
            textLength= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x= gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2;
            g2.drawString(text, x, y);
            
            gp.gameThread= null;
        }
        if(gameFinished == true)
        {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            
            
            String text;
            int textLength;
            int x;
            int y;
           
            text = "There's no place like home";
            textLength= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x= gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2-(gp.tileSize*2);
            g2.drawString(text, x, y);
            
            g2.setFont(arial_80b);
            g2.setColor(Color.green);
            text = "YOU WON";
            textLength= (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x= gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2+(gp.tileSize*2);
            g2.drawString(text, x, y);
            
            gp.gameThread= null;
            
        }
        
        else
        {
            drawPlayerLife();
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x "+gp.player.hasKey,74,65);
        
            //message
            if(messageOn == true)
            {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
                messageCounter++;

                if(messageCounter > 120)
                {
                    messageCounter =0;
                    messageOn=false;
                }
            }
        }
        
        
    }
    
    public void showMessage(String text)
    {
        message=text;
        messageOn=true;
        
    }
    
    public void drawPlayerLife()
    { 
        
        int x= (int)(gp.tileSize*12.5);
        int y= 25;
        int i=0;
        //draw maxLife
        while(i < gp.player.maxLife/2)
        {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
       
        //reset values
        x= (int)(gp.tileSize*12.5);
        y= 25;
        i=0; 
        //draw currentlife
        while(i < gp.player.life)
        {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life)
            {
                g2.drawImage(heart_full, x, y,null);
            }
            i++;
            x+=gp.tileSize;
        }
  
    }
    
    
}

