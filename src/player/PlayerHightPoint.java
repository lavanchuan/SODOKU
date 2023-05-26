package player;

public class PlayerHightPoint {
    String name;
    long time;
    
    public PlayerHightPoint(String name, long time){
        
        this.name = name;
        this.time = time;
    }
    
    public boolean equalsName(String name){
        
        if(name.equals(this.name))
            return true;
        else
            return false;
    }
    
    public long getTime(){
        
        return this.time;
    }
    
    public void setTime(long time){
        
        this.time = time;
    }
    
    public String getName(){
        
        return this.name;
    }
    
    public void setName(String name){
        
        this.name = name;
    }
    
    public void info(){
        
        System.out.println(name + " " + time);
    }
}
