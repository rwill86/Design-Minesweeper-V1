
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;

public class LostMenu extends Menu{
    private int selection = 0;
    private String[] options = {"Reset", "Exit"};
    public LostMenu(){
        
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
                game.reset();
                game.setMenu(null);
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
        String title = "BOOM!";
        String lost = "Game Over!";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, 4 * 8, Colour.get(000, 555, 555, 555)); 
        Font.draw(lost, screen, (screen.width - lost.length() * 8) / 2, 6 * 8, Colour.get(000, 555, 555, 555)); 
        for(int i = 0; i < 2; i++){
            String label = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i){
                colour = Colour.get(000, 555, 555, 555);
            }
            Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
        }
    }
}
