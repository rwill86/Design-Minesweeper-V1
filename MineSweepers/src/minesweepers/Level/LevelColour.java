
package minesweepers.Level;

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
    //Colour Background
    @Override
    public void renderBackground(Screen screen){
        screen.clear(0);
        //Background of Board
        for(int y = -1; y <= height; y++){
             for(int x = -1; x <= width ; x++){
                screen.render((x * 8) + 50, (y * 8) + 50, 17, Colour.get(000, 000, 222, 222), 0);
             }     
        }
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
        //Board
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                    //Cover
                    if(cover[x][y] != 1){ 
                         screen.render((x * 8) + 50, (y * 8) + 50, 1, Colour.get(000, 000, 222, 222), 0);  
                    }
                    //Selection
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
            //Check player is alive
            if(game.alive == false){
                game.setMenu(new LostMenu());
            }
            //Check if k Colour Exist
            if(checkColour(selectedX, selectedY)){
                Music.board.stop();
                //Show Board
                showBoard();
                //Lost Game
                game.lost();  
            } else{
                Music.click.play();
                //Update score
                game.score++;
                int cur = colour[selectedX][selectedY];
                unCoverColour(cur, selectedX, selectedY);      
            }
        } 
        //Check if won
        if(wonColour()){
            game.won();
        }     
    }  
}
