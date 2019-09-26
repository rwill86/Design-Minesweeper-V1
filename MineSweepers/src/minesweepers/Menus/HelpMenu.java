
package minesweepers.Menus;

//@author MrRit

public class HelpMenu extends Menu{
    public HelpMenu(){      
    }
    
    //Tick 
    @Override
    public void tick(){
        if(input.enter.clicked){
            game.setMenu(null);
        }
        
        if(input.help.clicked){
            game.setMenu(null);
        }
    }
}
