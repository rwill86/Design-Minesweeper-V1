
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.MineSweepers;


public class Menu {
   protected MineSweepers game;
   protected Input input;
   //Init Menu
    public void init(MineSweepers game, Input input){
        this.game = game;
        this.input = input;
    }
    
    public void tick(){
        
    }
    //Render Menu
    public void render(Screen screen){      
    }
}
