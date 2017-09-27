package asteroids;

public class enemy extends object
{
    int score;
    boolean splits;
    
    
    public enemy()
    {
        super((int)(Math.random()*1000),(int)(Math.random()*800));
        score = 0;
        splits = false;
        angle = (int)(Math.random()*360);
    }
    
    public enemy(int x, int y)
    {
        super(x,y);
        score = 0;
        splits = false;
        angle = (int)(Math.random()*360);
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int s)
    {
        score = s;
    }
    
    public boolean splits()
    {
        return splits;
    }
    
    public enemy[] split()
    {
        return null;
    }
    
}
