
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;


public class HelpMenu extends Menu{
    private int selection = 0;
    private String[] options = {"AWSD - Movement", "F - Flag", "Enter - Action", "R - Reset", "P - Pause", "T - Switch Mode"};
    public HelpMenu(){
    }
    
    //Tick 
    @Override
    public void tick(){
        if(input.enter.clicked){
            game.setMenu(new TitleMenu());
        }
    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        String title = "Input";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, 4 * 8, Colour.get(000, 555, 555, 555)); 
        for(int i = 0; i < 6; i++){
            String label = options[i];
            int colour = Colour.get(000, 555, 555, 555);
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
        }
         String label = "Press Enter";
        Font.draw(label, screen, (screen.width - label.length() * 8) / 2, (14 + 1) * 8, Colour.get(000, 555, 555, 555));  
    }
}
