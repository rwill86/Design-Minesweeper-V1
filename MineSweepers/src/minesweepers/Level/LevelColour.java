
package minesweepers.Level;

import java.util.Random;
import minesweepers.GUI.Colour;
import minesweepers.GUI.Screen;
import minesweepers.Menus.LostMenu;
import minesweepers.Menus.PauseMenu;
import minesweepers.Music;

//@author MrRit

public class LevelColour extends Level{
    public LevelColour(){
         Music.board.loop();
    }  
    //Colour Board Render
    @Override
    public void renderBoard(Screen screen){
        //Colour 
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                    //red = 500
                    if(colour[x][y] == 0){
                        screen.render((x * 8) + 50, (y * 8) + 50, 0, Colour.get(000, 000, 510, 510), 0);
                    }
                    //blue = 272
                    if(colour[x][y] == 1){
                        screen.render((x * 8) + 50, (y * 8)+ 50, 0, Colour.get(000, 000, 115, 115), 0);
                    }
                    //Yellow = 444
                    if(colour[x][y] == 2){
                        screen.render((x * 8) + 50, (y * 8) + 50, 0, Colour.get(000, 000, 550, 550), 0);
                    }
              }
        }
        //Cover 
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                    if(cover[x][y] != 1){ 
                         screen.render((x * 8) + 50, (y * 8) + 50, 1, Colour.get(000, 000, 222, 222), 0);  
                    }
              }
        }
        //Colour Selection
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(selectedX == x && selectedY == y && game.alive == true){
                        screen.render((x * 8) + 50,(y * 8) + 50, 1, Colour.get(-1, 555, 555, 555), 0);
                  }
              }
         }
    }  
    //Ticks
    @Override
    public void tick(){ 
        //Selctions
        if(selectedX >= width){
            selectedX = 0;
        }
        
        if(selectedY >= height){
            selectedY = 0;
        }
        
        if(selectedX < 0){
            selectedX = width;
        }
        
        if(selectedY < 0){
            selectedY = height;
        }
        
        
        if(input.left.clicked){
            selectedX--;
        }
        
        if(input.right.clicked){
            selectedX++;
        }
        
        
        if(input.up.clicked){
            selectedY--;
        }
        
        if(input.down.clicked){
            selectedY++;
        }
        //Input Reset 
        if(input.reset.clicked){
             game.reset();
             game.setMenu(null);
        }
        //Input pause 
        if(input.pause.clicked){
            //Set Pause Menu
            game.setMenu(new PauseMenu());       
        }      
        //Input enter
        if(input.enter.clicked){
            //Check if Mine Exist
            if(game.alive == false){
                game.setMenu(new LostMenu());
            }
            //Check if Mine Exist
            if(checkColour(selectedX, selectedY)){
                Music.board.stop();
                showMine();
                game.lost();  
            } else{
                Music.click.play();
                unCoverColour(selectedX, selectedY);      
            }
        } 
        //Check if won
        if(won()){
            game.won();
        }     
    }  
}
