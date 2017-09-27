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

public class shot extends object
{
    boolean passes;
    
    public shot(int x, int y, int a, Color c)
    {
        super(x,y);
        angle = a;
        speed = 50;
        color = c;
    }
    
    
    
}
