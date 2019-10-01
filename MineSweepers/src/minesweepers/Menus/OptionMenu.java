
package minesweepers.Menus;

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;

public class OptionMenu extends Menu{
    private int selection = 0;
    private int subselection = 0;
    private boolean selected = false;
    private String[] options = {"Board Size", "Menu"};
    private int[] numbers = {9, 10, 11, 12, 13, 16};
    public OptionMenu(){       
    }
    //Tick 
    @Override
    public void tick(){
        int size = options.length;
        int numbersize = numbers.length;
        if(selected == false){
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
        } else {
            if(subselection > numbersize){
               subselection = 0;
            }
        
            if(subselection < 0){
               subselection = size;
            }
        
            if(input.up.clicked){
               subselection--;
            }
        
            if(input.down.clicked){
               subselection++;
            }
        }
        
        if(input.enter.clicked){
            if(selected == false){
            if(selection == 0){
                 selected = true; 
            }
            
            if(selection == 1){
                game.setMenu(new TitleMenu());
            }
            } else{
                selected = false;
                game.boardSize = numbers[subselection];
                game.mineNumber(game.boardSize);
            }
        }
    }
    
    //Render
    @Override
    public void render(Screen screen){
        String title = "Options";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, (5 + 1) * 8, Colour.get(000, 555, 555, 555));
        if(selected == false){
            screen.clear(0);
            for(int i = 0; i < 2; i++){
                String label = options[i];
                int colour = Colour.get(0, 222, 222, 222);
                if(selection == i && selected == false){
                    colour = Colour.get(000, 555, 555, 555);
                } 
                Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
            }
        } else{
            screen.clear(0);
            for(int i = 0; i < numbers.length; i++){
                int n = numbers[i];
                String label = Integer.toString(n);
                int colour = Colour.get(0, 222, 222, 222);
                if(subselection == i){
                    colour = Colour.get(000, 555, 555, 555);
                } 
                Font.draw(label, screen,(screen.width - label.length() * 8) / 2, (8 + i) * 8, colour); 
            }
        }    
        String label = "Press Enter";
        Font.draw(label, screen, (screen.width - label.length() * 8) / 2, (14 + 1) * 8, Colour.get(000, 555, 555, 555));  
    }
}
