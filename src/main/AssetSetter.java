package main;

import monster.MON_GreenSlime;
import object.OBJ_DogHouse;
import object.OBJ_Door;
import object.OBJ_Key;
//import object.OBJ_TreasureChest;
import object.OBJ_Woodstock;

public class AssetSetter
{
    GamePanel gp;
    
    public AssetSetter(GamePanel gp)
    {
        this.gp=gp;
    }
    
    public void setObject()
    {
        //if images dont show up switch to setup method in respective obj classes
        gp.obj[0]= new OBJ_Key(gp);
        gp.obj[0].worldX= 19 * gp.tileSize;
        gp.obj[0].worldY= 40 * gp.tileSize;
       
        gp.obj[6]= new OBJ_Key(gp);
        gp.obj[6].worldX= 41 * gp.tileSize;
        gp.obj[6].worldY= 47 * gp.tileSize;
        
        gp.obj[5]= new OBJ_Key(gp);
        gp.obj[5].worldX= 20 * gp.tileSize;
        gp.obj[5].worldY= 7 * gp.tileSize;
        
        
        gp.obj[2] = new OBJ_DogHouse(gp);
        gp.obj[2].worldX= 10 * gp.tileSize;
        gp.obj[2].worldY= 8 * gp.tileSize;
       
        gp.obj[3] = new OBJ_Woodstock(gp);
        gp.obj[3].worldX= 38 * gp.tileSize;
       gp.obj[3].worldY= 9 * gp.tileSize;
        
       gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldX= 10 * gp.tileSize;
        gp.obj[4].worldY= 11 * gp.tileSize;
        
    }
    
    public void setMonster()
    {
        gp.monster[0]= new MON_GreenSlime(gp);
        gp.monster[0].worldX=gp.tileSize*23;
        gp.monster[0].worldY=gp.tileSize*36;
        
        gp.monster[1]= new MON_GreenSlime(gp);
        gp.monster[1].worldX=gp.tileSize*23;
        gp.monster[1].worldY=gp.tileSize*37;
        
        gp.monster[2]= new MON_GreenSlime(gp);
        gp.monster[2].worldX=gp.tileSize*23;
        gp.monster[2].worldY=gp.tileSize*38;
        
        gp.monster[3]= new MON_GreenSlime(gp);
        gp.monster[3].worldX=gp.tileSize*23;
        gp.monster[3].worldY=gp.tileSize*39;
        
       // gp.monster[4]= new MON_GreenSlime(gp);
       // gp.monster[4].worldX=gp.tileSize*11;
        //gp.monster[4].worldY=gp.tileSize*32;
        
    }
}
