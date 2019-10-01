
package minesweepers.Menus;

import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;

// @author MrRit

public class AddScoreMenu extends Menu{
    public String[] keys = {"A", "B","C","D","E","F","G"
            ,"H", "I", "J","K", "L", "M","N","O", "P", "Q",
            "R", "S","T","U","V","W","X","Y","Z",};
    public String[] options = {"Next"};
    private int selection = 0;
    private int subselection = 0;
    public String name = "";
    public int nameSize = 0;
    public boolean mode = true;
    public AddScoreMenu(){      
    }
    //Tick 
    @Override
    public void tick(){
        int keysize = keys.length;
        int optionsize = options.length;
        
        if(mode == false){
            if(selection > optionsize){
               selection = 0;
            }
        
            if(selection < 0){
               selection = optionsize;
            }
        } else {
            if(subselection > keysize){
               subselection = 0;
            }
        
            if(subselection < 0){
               subselection = keysize;
            }
        
            if(input.left.clicked){
               subselection--;
            }
        
            if(input.right.clicked){
               subselection++;
            }
        }
        
        if(input.up.clicked){
            mode = true;

        }
        
        if(input.down.clicked){
            mode = false;
        }
        
        if(input.enter.clicked){
            if(selection == 0 && mode == false && !name.equals("")){
                game.save(name, game.score);
                game.open();
                game.setMenu(new WonMenu());    
            }
            if(mode == true && nameSize < 7){
                name += keys[subselection];
                nameSize++;
            }
        }
    }
    //Render
    @Override
    public void render(Screen screen){
        screen.clear(0);
        //Title
        String title = "Enter Score";
        Font.draw(title, screen, (screen.width - title.length() * 8) / 2, (5 + 1) * 8, Colour.get(000, 555, 555, 555));     
        //Name
        if(name != null){
            Font.draw(name, screen, (screen.width - title.length() * 8) / 2, (8 + 1) * 8, Colour.get(000, 555, 555, 555));    
        }
        //Keys
        for(int i = 0; i < keys.length; i++){
            String label = keys[i];
            int colour = Colour.get(0, 222, 222, 222);   
            if(subselection == i){
                colour = Colour.get(000, 555, 555, 555);
            }   
            Font.draw(label, screen,(i * 8), (10 + 1) * 8, colour); 
        }
        //Options
        for(int i = 0; i < 1; i++){
            String next = options[i];
            int colour = Colour.get(0, 222, 222, 222);
            if(selection == i && mode == false){
                colour = Colour.get(000, 555, 555, 555);
            } 
            Font.draw(next, screen,(screen.width - next.length() * 8) / 2, (16 + i) * 8, colour); 
        }
    }
}
