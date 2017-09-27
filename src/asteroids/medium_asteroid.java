package asteroids;

public class medium_asteroid extends enemy
{
    enemy m1;
    enemy m2;
    
    public medium_asteroid(int x, int y)
    {
        super(x,y);
        size = 50;
        score = 15;
        speed = (int)(Math.random()*15);
        splits = true;
    }
    
    public enemy[] split()
    {
        m1 = new small_asteroid(xpos, ypos);
        m2 = new small_asteroid(xpos, ypos);
        
        enemy[] temp = {m1, m2};
        
        return temp;
    }
}
