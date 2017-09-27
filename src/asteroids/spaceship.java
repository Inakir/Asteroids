package asteroids;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import static java.lang.System.*;
import javax.swing.JPanel;
import static java.lang.System.*;
import java.io.*;
import java.net.URL;
import java.util.*;

public class spaceship extends object
{
    int headx;
    int heady;
    shot[] shots;
    boolean shotup;
    int count;
    int lcornerx;
    int lcornery;
    int rcornerx;
    int rcornery;
    int size;
    int lives;


    public spaceship()
    {
        super();
        size = 20;
        speed = 0;
        shots = new shot[10];
        count = 0;
        lives = 1;
        shotup=false;
        headx =(int) (xpos+Math.cos(angle/57.2957795)*size);
        heady = (int)(ypos-Math.sin(angle/57.2957795)*size);
        lcornerx = (int)(xpos+Math.cos((angle+135)/57.2957795)*size);
        lcornery = (int)(ypos-Math.sin((angle+135)/57.2957795)*size);
        rcornerx = (int)(xpos+Math.cos((angle+225)/57.2957795)*size);
        rcornery = (int)(ypos-Math.sin((angle+225)/57.29577955)*size);
    }

    public spaceship(int x, int y)
    {
        super(x,y);
        size = 20;
        speed = 0;
        lives = 3;
        shots = new shot[10];
        count = 0;
        headx =(int) (xpos+Math.cos(angle/57.2957795)*size);
        heady = (int)(ypos-Math.sin(angle/57.2957795)*size);
        lcornerx = (int)(xpos+Math.cos((angle+135)/57.2957795)*size);
        lcornery = (int)(ypos-Math.sin((angle+135)/57.2957795)*size);
        rcornerx = (int)(xpos+Math.cos((angle+225)/57.2957795)*size);
        rcornery = (int)(ypos-Math.sin((angle+225)/57.29577955)*size);
    }
    
    public spaceship(int x, int y, Color c)
    {
        super(x,y,c);
        size = 20;
        speed = 0;
        lives = 3;
        shots = new shot[10];
        count = 0;
        headx =(int) (xpos+Math.cos(angle/57.2957795)*size);
        heady = (int)(ypos-Math.sin(angle/57.2957795)*size);
        lcornerx = (int)(xpos+Math.cos((angle+135)/57.2957795)*size);
        lcornery = (int)(ypos-Math.sin((angle+135)/57.2957795)*size);
        rcornerx = (int)(xpos+Math.cos((angle+225)/57.2957795)*size);
        rcornery = (int)(ypos-Math.sin((angle+225)/57.29577955)*size);
    }
    
    public int getHeadx()
    {
        return headx;
    }
    
    public int getHeady()
    {
        return heady;
    }
    
    public int getLcornerx()
    {
        return lcornerx;
    }
    
    public int getLcornery()
    {
        return lcornery;
    }
    
    public int getRcornerx()
    {
        return rcornerx;
    }
    
    public int getRcornery()
    {
        return rcornery;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void setLives(int l)
    {
        lives = l;
    }
    
    public void refresh()
    {
        headx =(int) (xpos+Math.cos(angle/57.2957795)*size);
        heady = (int)(ypos-Math.sin(angle/57.2957795)*size);
        lcornerx = (int)(xpos+Math.cos((angle+135)/57.2957795)*size);
        lcornery = (int)(ypos-Math.sin((angle+135)/57.2957795)*size);
        rcornerx = (int)(xpos+Math.cos((angle+225)/57.2957795)*size);
        rcornery = (int)(ypos-Math.sin((angle+225)/57.29577955)*size);
    }
    
    public void live()
    {
        destroyed = false;
        xpos = 500;
        ypos = 400;
        angle = 90;
        refresh();
    }
    
    public void rotatecounter()
    {
        angle-=10;
        refresh();
    }
    
    public void rotateclock()
    {
        angle+=10;
        refresh();
    }
    
    public void move()
    {
        xpos +=(int) (Math.cos(angle/57.2957795)*speed);
        ypos -=(int)(Math.sin(angle/57.2957795)*speed);
        
        if(xpos>1200)
        {
            xpos = 0;
        }
        
        if(xpos<0)
        {
            xpos = 1200;
        }
        
        if(ypos>768)
        {
            ypos = 0;
        }
        
        if(ypos<0)
        {
            ypos = 768;
        }
        refresh();
    }
    
    public void shotmover()
    {
        int x = 0;
        while(x<shots.length&&shots[x]!=null)
        {
            shots[x].move();
            x++;
        }
    }
    
    public void setShotup()
    {
        if(shotup)
        {
            shotup=false;
        }
        else
        {
            shotup = true;
        }
    }
    
    public void shoot()
    {
        if(!shotup)
        {
            shots[count] = new bullet(headx, heady, angle);
        }
        else
        {
            shots[count] = new laser(headx, heady, angle);
        }
            
        count++;
        if(count==10)
        {
            count=0;
        }
    }
    
    public shot[] getShots()
    {
        return shots;
    }
            
            
            
}

