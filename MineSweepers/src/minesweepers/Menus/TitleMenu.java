
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;

public class TitleMenu extends Menu{
    private int selection = 0;
    private String[] options = {"Normal","Comb", "Colour", "Help"}; //"Colour"
    public TitleMenu(){  
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
                game.mode = false;
                game.setMenu(null);
            }
            
            if(selection == 1){
                game.mode = true;
                game.setMenu(null);
            }
            
            if(selection == 2){
                //Colour
            }
            
             if(selection == 3){
                game.setMenu(new HelpMenu());
            }
        }
    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        String title = "Minesweeper";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, (6 + 1) * 8, Colour.get(000, 555, 555, 555)); 
        for(int i = 0; i < 4; i++){
            String label = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i){
                colour = Colour.get(000, 555, 555, 555);
            }
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
        }
        String label = "Press Enter";
        Font.draw(label, screen, (screen.width - label.length() * 8) / 2, (12 + 1) * 8, Colour.get(000, 555, 555, 555));  
    }
}