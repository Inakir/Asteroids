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

public class object
{
    int xpos;
    int ypos;
    int angle;
    int speed;
    boolean destroyed;
    int size;
    Color color;
    

    public object()
    {
        xpos = 500;
        ypos = 400;
        angle = 90;
        speed = 0;
        int size = 0;
        color = Color.BLACK;
        destroyed = false;
    }
    
    public object(Color c)
    {
        xpos = 500;
        ypos = 400;
        angle = 90;
        speed = 0;
        size = 0;
        color = c;
        destroyed = false;
    }

    public object(int x, int y)
    {
        xpos = x;
        ypos = y;
        angle = 90;
        speed = 0;
        color = Color.BLACK;
        destroyed = false;
    }
    
    public object(int x, int y, Color c)
    {
        xpos = x;
        ypos = y;
        angle = 90;
        speed = 0;
        color = c;
        destroyed = false;
    }

    public void setXpos(int x)
    {
        xpos = x;
    }

    public void setYpos(int y)
    {
        ypos = y;
    }
    
    public void setAngle(int a)
    {
        angle = a;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    public void setColor(Color c)
    {
        color = c;
    }
    
    public int getAngle()
    {
        return angle;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    public int getXpos()
    {
        return xpos;
    }

    public int getYpos()
    {
        return ypos;
    }
    
    public Color getColor()
    {
        return color;
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
        
        if(ypos>725)
        {
            ypos = 0;
        }
        
        if(ypos<0)
        {
            ypos = 725;
        }
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int s)
    {
        size = s;
    }
    
    public void destroyed()
    {
        destroyed=true;
    }
    
        public boolean isDestroyed()
    {
        return destroyed;
    }
}
