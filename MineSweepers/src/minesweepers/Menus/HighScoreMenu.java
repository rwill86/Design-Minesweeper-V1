
package minesweepers.Menus;

// @author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;
import minesweepers.User;

public class HighScoreMenu extends Menu{
    private String[] options = {"Menu", "Exit"};
    private int selection = 0;
    private String[] high = {"Steve 5", "Jim 4", "Tim 6"};
    public HighScoreMenu(){    
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
                game.setMenu(new TitleMenu());
            }
             
            if(selection == 1){
                //Exit
                game.exit();
            }
        }
    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        String title = "High Score";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, (5 + 1) * 8, Colour.get(000, 555, 555, 555));    
        int s = 0;
        for(User u : game.scoreList){
            if(s > 5){
                break;
            }
            String points =  Integer.toString(u.getScore());
            String label = u.getName() + ": " + points;
            int colour = Colour.get(0, 222, 222, 222);
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + s) * 8, colour); 
            s++;
        }
        for(int i = 0; i < 2; i++){
            String label = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i){
                colour = Colour.get(000, 555, 555, 555);
            }
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (14 + i) * 8, colour); 
        }
    }
}
