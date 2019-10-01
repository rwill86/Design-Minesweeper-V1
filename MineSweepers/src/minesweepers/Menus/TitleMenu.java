
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;
import minesweepers.Level.LevelBoard;
import minesweepers.Level.LevelColour;
import minesweepers.Music;

public class TitleMenu extends Menu{
    private int selection = 0;
    private String[] options = {"Normal","Comb", "Colour", "Help", "High Score", "Options", "Exit"}; 
    public TitleMenu(){  
         Music.title.loop();
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
                Music.title.stop();
                //Board
                game.mode = false;
                game.colourmode = false;
                game.setMenu(null);
                game.setBoard(new LevelBoard());
            }
            
            if(selection == 1){
                Music.title.stop();
                //Honey
                game.mode = true;
                game.colourmode = false;
                game.setMenu(null);
                game.setBoard(new LevelBoard());
            }
            
            if(selection == 2){
                Music.title.stop();
                //Colour
                game.colourmode = true;
                game.setMenu(null);
                game.setBoard(new LevelColour());
            }
            
            if(selection == 3){
                //Help
                game.setMenu(new HelpMenu());
            }
            
              if(selection == 4){
                //Score
                game.max();
                game.setMenu(new HighScoreMenu());
            }
            
            if(selection == 5){
                //Option
                game.setMenu(new OptionMenu());
            }
             
             if(selection == 6){
                //Exit
                game.exit();
            }
        }
    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        String title = "Minesweeper";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, (5 + 1) * 8, Colour.get(000, 555, 555, 555)); 
        for(int i = 0; i < 7; i++){
            String label = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i){
                colour = Colour.get(000, 555, 555, 555);
            }
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
        }
        String label = "Press Enter";
        Font.draw(label, screen, (screen.width - label.length() * 8) / 2, (15 + 1) * 8, Colour.get(000, 555, 555, 555));  
    }
}