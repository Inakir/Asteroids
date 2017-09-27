package asteroids;

import java.awt.*;
import java.awt.event.*;
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
import javax.swing.*;
import javax.swing.event.*;
import static java.lang.System.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.util.Arrays.*;



public class Asteroids extends JPanel implements KeyListener, Runnable
{
    spaceship ship;
    spaceship ship2;
    enemy[] enemies;
    int score;
    int score2;
    int count;
    int speed;
    int speed2;
    int players;
    boolean rotatecounter;
    boolean rotateclock;
    boolean rotatecounter2;
    boolean rotateclock2;
    boolean shoot;
    boolean shoot2;
    boolean fly;
    boolean fly2;
    boolean shipisdead;
    boolean ship2isdead;
    boolean gameover;
    String name;
    String name2;
    int[] leaders;
    champion[] champions;
    String[][] leaderboard;
    
    public Asteroids()
    {
        ship = new spaceship();
        speed = 5;
        speed2 = 5;
        score = 0;
        score2 = 0;
        enemies = new enemy[25];
        rotatecounter = false;
        rotateclock = false;
        rotatecounter2 = false;
        rotateclock2 = false;
        shoot = false;
        shoot2 = false;
        fly = false;
        fly2 = false;
        shipisdead = false;
        ship2isdead = false;
        gameover = false;
        players = 1;
        name = "";
        name2 = "";
        leaderboard = new String[30][3];
        
        
        
        enemies[0] = new big_asteroid();
        
        int y = 0;
        while(y<enemies.length&&enemies[y]!=null)
        {
            y++;
        }
        count = y-1;
        
        this.addKeyListener(this);
        setVisible(true);
    }
    public void paintComponent( Graphics window )
    {
        super.paintComponent(window);
        paintShip(window);
        paintShip2(window);
        paintEnemies(window);
        paintShots(window);
        paintShots2(window);
       
    }
    
    public void paintShip(Graphics window)
    {
        if(ship!=null)
        {
            window.setColor(ship.getColor());
            window.drawLine(ship.getHeadx(), ship.getHeady(), ship.getLcornerx(), ship.getLcornery());
            window.drawLine(ship.getHeadx(), ship.getHeady(), ship.getRcornerx(), ship.getRcornery());
            window.drawLine(ship.getXpos(), ship.getYpos(), ship.getLcornerx(), ship.getLcornery());
            window.drawLine(ship.getXpos(), ship.getYpos(), ship.getRcornerx(), ship.getRcornery());
        
            for(int x = 0; x<ship.lives*5;x+=5)
            {
                window.fillOval(1150+x, 25, 5, 5);
            }
        }
        else
        {
            window.drawString("dead", 1150, 25);
        } 
        window.drawString(name+ " " +score+" ", 1100, 10);
    }
    
    public void paintShip2(Graphics window)
    {
        if(ship2!=null)
        {
            window.setColor(ship2.getColor());
            window.drawLine(ship2.getHeadx(), ship2.getHeady(), ship2.getLcornerx(), ship2.getLcornery());
            window.drawLine(ship2.getHeadx(), ship2.getHeady(), ship2.getRcornerx(), ship2.getRcornery());
            window.drawLine(ship2.getXpos(), ship2.getYpos(), ship2.getLcornerx(), ship2.getLcornery());
            window.drawLine(ship2.getXpos(), ship2.getYpos(), ship2.getRcornerx(), ship2.getRcornery());
        
            for(int x = 0; x<ship2.lives*5;x+=5)
            {
                window.fillOval(1150+x, 75, 5, 5);
            }
        }
        else
        {
            window.drawString("dead", 1150, 75);
        }
        window.drawString(name2+ " " +score2+" ", 1100, 50);
    }
    
    public void paintEnemies(Graphics window)
    {
        try
        {
            if(count>=0)
            {
                for(int x = 0; x<=count;x++)
                {
                    window.drawOval(enemies[x].getXpos(), enemies[x].getYpos(), enemies[x].getSize(), enemies[x].getSize());
                }
            }
        }
        catch(Exception e){}
        
    }
    
    public void paintShots(Graphics window)
    {
        try
        {
            if(ship.count>=0)
            {
                for(int x = 0; x<=ship.count;x++)
                {
                window.setColor(ship.getShots()[x].getColor());
                window.fillOval(ship.getShots()[x].getXpos(), ship.getShots()[x].getYpos(), 4, 4);
                }
            }
        }
        catch(Exception e){}
            
    }
    
    public void paintShots2(Graphics window)
    {
        try
        {
            if(ship2.count>=0)
            {
                for(int x = 0; x<=ship2.count;x++)
                {
                window.setColor(ship2.getShots()[x].getColor());
                window.fillOval(ship2.getShots()[x].getXpos(), ship2.getShots()[x].getYpos(), 4, 4);
                }
            }
        }
        catch(Exception e){}
            
    }
    
    public void mover()
    {
        if(count>=0)
        {
            for(int x = 0; x<=count;x++)
            {
                if(enemies[x]!=null)
                {
                    enemies[x].move();
                }
            }
        }
    }
    
    public void shipchecker()
    {
        if(ship.isDestroyed())
        {
            if(ship.getLives()>0)
            {
                ship.live();
                ship.setLives(ship.getLives()-1);
            }
            
            else
            {
                ship = null;
                shipisdead = true;
            }
                
        }
        
        if(ship2.isDestroyed())
        {
            if(ship2.getLives()>0)
            {
                ship2.live();
                ship2.setLives(ship2.getLives()-1);
            }
            
            else
            {
                ship2 = null;
                ship2isdead = true;
            }
                
        }
    }
    
    public void shotchecker() 
    {
        if(ship!=null)
        {
            int x = 0;
            while (ship.getShots()[x] != null) 
            {
                if (ship.getShots()[x].isDestroyed()) 
                {
                    ship.shots[x] = null;
                }
                x++;
            }

            for (int y = 0; y < ship.getShots().length; y++) 
            {
                if (ship.getShots()[y] == null && ship.count > y) 
                {
                    shot temp2 = ship.getShots()[ship.count];

                    shot temp = ship.getShots()[y];
                    ship.shots[y] = ship.getShots()[ship.count];
                    ship.shots[ship.count] = temp;

                    if (temp2 != null) 
                    {
                        if (ship.count > 0) 
                        {
                            count--;
                        }
                    }
                }
            }
        }
        
        if(ship2!=null)
        {
            int x = 0;
            while (ship2.getShots()[x] != null) 
            {
                if (ship2.getShots()[x].isDestroyed()) 
                {
                    ship2.shots[x] = null;
                }
                x++;
            }

            for (int y = 0; y < ship2.getShots().length; y++) 
            {
                if (ship2.getShots()[y] == null && ship2.count > y) 
                {
                    shot temp2 = ship2.getShots()[ship2.count];

                    shot temp = ship2.getShots()[y];
                    ship2.shots[y] = ship2.getShots()[ship2.count];
                    ship2.shots[ship2.count] = temp;

                    if (temp2 != null) 
                    {
                        if (ship2.count > 0) 
                        {
                            count--;
                        }
                    }
                }
            }
        }
    }
    
    public void enemychecker()
    {
        int x = 0;
        
        while(enemies[x]!=null)
        {
            if(enemies[x].isDestroyed())
            {
                
                if(enemies[x].splits())
                {
                    enemies[count+1] = enemies[x].split()[1];
                    enemies[x] = enemies[x].split()[0];
                    count++;
                }
                else
                {
                    enemies[x] = null;
                }
            }
            x++;
        }
        
        for(int y = 0; y<enemies.length;y++)
        {
            if(enemies[y]==null&&count>y)
            {
                enemy temp2 = enemies[count];
                
                enemy temp = enemies[y];
                enemies[y] = enemies[count];
                enemies[count] = temp;
                
                if(temp2!=null)
                {
                    if(count>0)
                    {
                        count--;
                    }
                }
            }
        }
        
    }
    
    public void destroyer() 
    {
        int y = 0;
        while (y < enemies.length && enemies[y] != null) 
        {
            for (int length = 0; length < enemies[y].getSize(); length++) 
            {
                for (int a = 0; a < 360; a++) 
                {
                    int tempx = enemies[y].getXpos() + (int) (Math.cos(a / 57.2957795) * length);
                    int tempy = enemies[y].getYpos() - (int) (Math.sin(a / 57.2957795) * length);
                    int x = 0;
                    while (ship!=null && x < ship.getShots().length && ship.getShots()[x] != null) 
                    {
                        if (ship.getShots()[x].getXpos() == tempx && ship.getShots()[x].getYpos() == tempy) 
                        {
                            enemies[y].destroyed();
                            ship.shots[x].destroyed();
                            score+=enemies[y].getScore();
                            break;
                            
                        }
                        x++;
                    }
                    
                    int z = 0;
                    while (ship2!=null && z < ship2.getShots().length && ship2.getShots()[z] != null) 
                    {
                        if (ship2.getShots()[z].getXpos() == tempx && ship2.getShots()[z].getYpos() == tempy) 
                        {
                            enemies[y].destroyed();
                            ship2.shots[z].destroyed();
                            score2+=enemies[y].getScore();
                            break;
                            
                        }
                        z++;
                    }
                    
                    
                    if((ship!=null)&&(ship.getHeadx()==tempx&&ship.getHeady()==tempy||ship.getLcornerx()==tempx&&ship.getLcornery()==tempy||ship.getRcornerx()==tempx&&ship.getRcornery()==tempy||ship.getXpos()==tempx&&ship.getYpos()==tempy))
                    {
                        ship.destroyed();
                    }
                    
                    if((ship2!=null)&&(ship2.getHeadx()==tempx&&ship2.getHeady()==tempy||ship2.getLcornerx()==tempx&&ship2.getLcornery()==tempy||ship2.getRcornerx()==tempx&&ship2.getRcornery()==tempy||ship2.getXpos()==tempx&&ship2.getYpos()==tempy))
                    {
                        ship2.destroyed();
                    }
                }
            }
            y++;
        }

    }

    public void fly()
    {
        if (ship != null) 
        {
            if (fly) 
            {
                speed = 1;
            }

            if (ship.getSpeed() > 50) 
            {
                speed = 0;
            }

            if (!fly) 
            {
                speed = -2;
                if (ship.getSpeed() <= 0) 
                {
                    ship.setSpeed(0);
                    speed = 0;
                }
            }
            ship.setSpeed(ship.getSpeed() + speed);
            ship.move();
        }
        
    }
    
    public void fly2()
    {
        if (ship2 != null) 
        {
            if (fly2) 
            {
                speed2 = 1;
            }

            if (ship2.getSpeed() > 50) 
            {
                speed2 = 0;
            }

            if (!fly2) 
            {
                speed2 = -2;
                if (ship2.getSpeed() <= 0) 
                {
                    ship2.setSpeed(0);
                    speed2 = 0;
                }
            }
            ship2.setSpeed(ship2.getSpeed() + speed2);
            ship2.move();
        }
        
    }
    
    public void ship1mover()
    {
        
        if (ship != null) 
        {
            if (rotatecounter) 
            {
                ship.rotatecounter();
            }

            if (rotateclock) 
            {
                ship.rotateclock();
            }

            fly();

            if (shoot) 
            {
                ship.shoot();
                ship.setShotup();
            }
            
            ship.shotmover();
        }
    }
    
    public void ship2mover()
    {
        
        if (ship2 != null) 
        {
            if (rotatecounter2) 
            {
                ship2.rotatecounter();
            }

            if (rotateclock2) 
            {
                ship2.rotateclock();
            }

            fly2();

            if (shoot2) 
            {
                ship2.shoot();
                ship2.setShotup();
            }
            
            ship2.shotmover();
        }
    }
    
    public void enternames()
    {
        String temp = "";
        temp+="Type in:\n";
        temp+="1-one player\n";
        temp+="2-two player\n";
        
        String player = JOptionPane.showInputDialog(temp);
        if(player.contains("2"))
        {
            players = 2;
            ship2 = new spaceship(400, 400, Color.blue);
        }
        
        if(players==1)
        {
            temp = "";
            temp+="Type in Player 1's name:\n";
            name = JOptionPane.showInputDialog(temp);
        }
        
        if(players==2)
        {
            temp = "";
            temp+="Type in Player 1's name:\n";
            name = JOptionPane.showInputDialog(temp);
            temp = "";
            temp+="Type in Player 2's name:\n";
            name2 = JOptionPane.showInputDialog(temp);
        }
        
    }
    
    public void gameover() throws Exception
    {
        Scanner file = new Scanner(new File("leaderboard.txt"));
        
        int x = 0;
        
        champions = new champion[file.nextInt()+players];
        
        
        while(file.hasNext())
        {
            champions[x] = new champion(file.next(), file.next());
            x++;
            
        }
        champions[x] = new champion(name+"", score+"");
        
        if(players == 2)
        {
            x++;
            champions[x] = new champion(name2+"", score2+"");
        }
        
        leaders = new int[champions.length];
        for(int y = 0; y<leaders.length;y++)
        {
            leaders[y] = Integer.parseInt(champions[y].getScore());
            
        }
        
               
        MergeSort merge = new MergeSort(leaders, leaders.length);
        leaders = merge.getArray();
        
        for(int a = 0; a<leaders.length;a++)
        {
            for(int b = 0; b<champions.length;b++)
            {
                if(leaders[a]==Integer.parseInt(champions[b].getScore()))
                {
                    champion temp = champions[a];
                    champions[a] = champions[b];
                    champions[b] = temp;
                }
            }
        }
        
        PrintWriter save = new PrintWriter("leaderboard.txt");
        
        int y = 0;
        String temp = "";
        save.println(champions.length);
        
        for(int z = 0; z<champions.length;z++)
        {
            if(z<leaderboard.length)
            {
            leaderboard[y][0] = z+"";
            leaderboard[y][1] = champions[z].getName();
            
            save.println(champions[z].getName());
            leaderboard[y][2] = champions[z].getScore();
            save.println(champions[z].getScore());
            temp+=leaderboard[y][0]+"------";
            temp+=leaderboard[y][1]+"------";
            temp+=leaderboard[y][2];
            temp+="\n";
            y++;
            }
            else{break;}
        }
        
        save.close();
        
        temp+="search for a specific spot";
        String search =JOptionPane.showInputDialog(temp);
        
        try
        {
            int look = Integer.parseInt(search);
            String find = "Spot " + look + "\n\n";
            find+="the name of the person is : " + champions[look].getName()+"\n\n";
            find+="the score of the person is : " + champions[look].getScore()+"\n\n";
            find+="Press ok to exit";
            JOptionPane.showInputDialog(find);
        }
        catch(Exception e)
        {
            JOptionPane.showInputDialog("Your search for '" +search + "' did not show any results" + "\n\nPress anything to exit");
        }
        
        exit(0);
        
    }
    
    public void run() 
    {
        try
        {
        int x = 0;
        
        enternames();
        while(true)
        {
            if(x%50000==0)
            {
                try
                {
                    mover();
                    destroyer();
                    enemychecker();
                    ship1mover();
                    ship2mover();
                    shipchecker();
                    shotchecker();
                    
                }
                catch(Exception e)
                {
                    
                }
            }
            
            if(players==1&&shipisdead)
            {
                gameover = true;
                
            }
            
            if(shipisdead&&ship2isdead)
            {
                gameover = true;
            }
            
            if(gameover)
            {
                
                gameover();
            }
            
            x++;
            
            repaint();
        }
        }
        catch(Exception e){}
    }
    
    public void keyTyped(KeyEvent e) 
    {
        
      
    }

    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()== (KeyEvent.VK_UP))
        {
            fly = true;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_DOWN))
        {
            shoot = true;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_RIGHT))
        {
            rotatecounter = true;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_LEFT))
        {
            rotateclock = true;
        }
        
        if(e.getKeyChar()=='w'||e.getKeyChar()=='W')
        {
            fly2 = true;
        }
        
        if(e.getKeyChar()=='s'||e.getKeyChar()=='S')
        {
            shoot2 = true;
        }
        
        if(e.getKeyChar()=='d'||e.getKeyChar()=='D')
        {
            rotatecounter2 = true;
        }
        
        if(e.getKeyChar()=='a'||e.getKeyChar()=='A')
        {
            rotateclock2 = true;
        }
    }

    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode()== (KeyEvent.VK_UP))
        {
            fly = false;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_DOWN))
        {
            shoot = false;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_RIGHT))
        {
            rotatecounter = false;
        }
        
        if(e.getKeyCode()== (KeyEvent.VK_LEFT))
        {
            rotateclock = false;
        }
        
        if(e.getKeyChar()=='w'||e.getKeyChar()=='W')
        {
            fly2 = false;
        }
        
        if(e.getKeyChar()=='s'||e.getKeyChar()=='S')
        {
            shoot2 = false;
        }
        
        if(e.getKeyChar()=='d'||e.getKeyChar()=='D')
        {
            rotatecounter2 = false;
        }
        
        if(e.getKeyChar()=='a'||e.getKeyChar()=='A')
        {
            rotateclock2 = false;
        }
        
        
     
    }
    
    
    public static void main(String[] args) throws Exception
    {
        try
        {
            runner runner = new runner();
            runner.run(); 
        }
        catch(Exception e){}
     }
        
    }
