
package main;
import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable
{
    //SCREEN SETTINGS
    final int originalTileSize=16; // 16*16 tile
    final int scale=3;
    
    public final int tileSize=originalTileSize*scale; //48*48 tile
    public final int maxScreenCol=16;
    public final int maxScreenRow=12;
    public final int screenWidth=tileSize*maxScreenCol; // 48*16=768 px
    public final int screenHeight=tileSize*maxScreenRow;// 48*12=576 px
    
    
    //world settings
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth= tileSize+ maxWorldCol;
    public final int worldHeight= tileSize*maxWorldRow;
    
    int FPS=60;
    
    
    TileManager tileM= new TileManager(this);
    KeyHandler keyH=new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker= new CollisionChecker(this);
    public AssetSetter aSetter =  new AssetSetter(this);
    public UI ui=new UI(this);
            
    public Player player=new Player(this, keyH);
    public Entity obj[] = new Entity[10];
    public Entity monster[]= new Entity[20];
    ArrayList<Entity> entityList= new ArrayList<>();

    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
   
    
    public void setupGame()
    {
        aSetter.setObject();
        aSetter.setMonster();
    }
    
    
    public void startGameThread()
    {
        gameThread=new Thread(this);
        gameThread.start();
    }
    
    @Override
//    public void run()
//    {
//        double drawInterval=1000000000/FPS; //0.0166 seconds
//        double nextDrawTime=System.nanoTime()+ drawInterval;
//        
//        
//        while(gameThread != null)
//        {
//            
//            update();
//            
//            repaint();
//            
//
//            try{
//                 double remainingTime=nextDrawTime - System.nanoTime();
//                 remainingTime/=1000000;
//                 
//                 if(remainingTime <0)
//                 {
//                     remainingTime=0;
//                 }
//                 Thread.sleep((long) remainingTime);
//                 
//                 nextDrawTime += drawInterval;
//                 
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            
//        }
//    }
    
    public void run()
    {
        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;
        
        while(gameThread !=null)
        {
            currentTime= System.nanoTime();
            
            delta+= (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >=1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000)
            {
                //System.out.println("FPS: "+ drawCount);
                drawCount=0;
                timer=0;
            }
        }
        
    }
    
    public void update()
    {
        player.update();
        
        for(int i=0; i < monster.length; i++)
        {
            if(monster[i] != null)
            {
                monster[i].update();
                //System.out.println("monster motion updating");
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        
        
        //background
        tileM.draw(g2);
        
        //player
        entityList.add(player);
        
        //object
        for(int i=0; i< obj.length; i++)
        {
            if(obj[i] != null)
            {
                //obj[i].draw(g2, this);
                entityList.add(obj[i]);
            }
        }
        
        //monster
        for(int i=0; i< monster.length; i++)
        {
            if(monster[i] != null)
            {
                entityList.add(monster[i]);
                //System.out.println("monster added to entitylist");
            }
        }
        
        Collections.sort(entityList,new Comparator<Entity>()
        {
            @Override
            public int compare(Entity e1, Entity e2)
            {
                int result= Integer.compare(e1.worldY, e2.worldY);
                return result;
            }
        });
        
        for(int i=0; i< entityList.size(); i++)
        {
            entityList.get(i).draw(g2);
        }
        entityList.clear();

        //player.draw(g2);

        ui.draw(g2);
        
        g2.dispose();
    }
    
}
