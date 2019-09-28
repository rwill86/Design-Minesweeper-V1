
package minesweepers.Menus;

//@author MrRit

import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.MineSweepers;
import minesweepers.Mouse;


public class Menu {
    protected MineSweepers game;
    protected Input input;
    protected Mouse mouse;
    //Init Menu
    public void init(MineSweepers game, Input input, Mouse mouse){
        this.game = game;
        this.input = input;
        this.mouse = mouse;
    }
    
    public void tick(){
        
    }
    //Render Menu
    public void render(Screen screen){      
    }
}
