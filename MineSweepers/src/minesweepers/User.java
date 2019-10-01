
package minesweepers;

//@author MrRit

public class User{
    String name;
    int points;
    public User(String name, int points){
        this.name = name;
        this.points = points;
    }
    
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return points;
    }
}
