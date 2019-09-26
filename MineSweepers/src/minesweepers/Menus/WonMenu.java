
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;


public class WonMenu extends Menu{
    private int selection = 0;
    private String[] options = {"Next Level", "Exit"};
    public int seconds;
    public int score;
    public int level;
    public WonMenu(int level,int seconds, int score){
        this.level = level;
        this.seconds = seconds;
        this.seconds = score;
    }
    //Tick 
    @Override
    public void tick(){
        int size = options.length;
        
        if(selection > size){
            selection = 0;
        }
        
        if(selection < 0){
            selection = size;
        }
        
        if(input.up.clicked){
            selection--;
        }
        
        if(input.down.clicked){
            selection++;
        }
        
        if(input.enter.clicked){
             if(selection == 0){
                game.nextLevel();
            }
            
            if(selection == 1){
                game.exit();
            }
        }

    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        String title = "You Won";
        String levelm = "Level " + level;
        String scorem = "Score " + score;
        String timem = "Time " + seconds;
        
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, 4 * 8, Colour.get(000, 555, 555, 555));
        Font.draw(levelm , screen,(screen.width - levelm.length() * 8) / 2, 6 * 8, Colour.get(000, 555, 555, 555));
        Font.draw(scorem, screen, (screen.width - scorem.length() * 8) / 2, 8 * 8, Colour.get(000, 555, 555, 555));
        Font.draw(timem, screen, (screen.width - timem.length() * 8) / 2, 10 * 8, Colour.get(000, 555, 555, 555));
        
        for(int i = 0; i < 2; i++){
            String label = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i){
                colour = Colour.get(000, 555, 555, 555);
            }
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (12 + i) * 8, colour); 
        }
        
    }
}

