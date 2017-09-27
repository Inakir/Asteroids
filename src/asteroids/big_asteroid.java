package asteroids;

public class big_asteroid extends enemy
{
    enemy m1;
    enemy m2;
    
    public big_asteroid()
    {
        super();
        size = 100;
        score = 10;
        speed = (int)(Math.random()*10);
        splits = true;
    }
    
    public enemy[] split()
    {
        m1 = new medium_asteroid(xpos, ypos);
        m2 = new medium_asteroid(xpos, ypos);
        
        enemy[] temp = {m1, m2};
        
        return temp;
        
    }
}
