package asteroids;

public class small_asteroid extends enemy
{
    
    public small_asteroid(int x, int y)
    {
        super(x,y);
        size = 25;
        score = 20;
        speed = (int)(Math.random()*20);
    }
    
}
