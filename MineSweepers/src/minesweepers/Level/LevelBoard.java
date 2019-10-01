
package minesweepers.Level;

import minesweepers.GUI.Colour;
import minesweepers.GUI.Screen;
import minesweepers.Menus.LostMenu;
import minesweepers.Menus.PauseMenu;
import minesweepers.Music;

//@author MrRit

public class LevelBoard extends Level{
    public LevelBoard(){
        Music.board.loop();
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
        //Input flag 
        if(input.flag.clicked){
            //Set Flag
            setFlag(selectedX, selectedY);       
        }
        //Input pause 
        if(input.pause.clicked){
            //Set Pause Menu
            game.setMenu(new PauseMenu());       
        }      
        //Input switch mode 
        if(input.switchmode.clicked){
            //Set mode
            if(game.mode){ 
                game.mode = false;
            } else{
                game.mode = true;
                
            }           
        }
        //Input enter
        if(input.enter.clicked){
            //Check player is alive
            if(game.alive == false){
                Music.bomb.stop();
                game.setMenu(new LostMenu());
            }
            //Check if Mine Exist
            if(checkMine(selectedX, selectedY)){
                Music.board.stop();
                flag[selectedX][selectedY] = 0;
                //Show Board
                showBoard();
                //Lost Game
                game.lost();             
            } else{
                //check if cover is empty
                if(checkCover(selectedX, selectedY)){
                    Music.click.play();
                    flag[selectedX][selectedY] = 0;
                    cover[selectedX][selectedY] = 1;
                    //Add to score
                    if(board[selectedX][selectedY] == 1){
                        game.score += 1 * game.levelNumber;
                    }
                    
                    if(board[selectedX][selectedY] == 2){
                        game.score += 2 * game.levelNumber;
                    }
                    
                    if(board[selectedX][selectedY] == 3){
                        game.score += 3 * game.levelNumber;
                    }
                    
                    if(board[selectedX][selectedY] == 4){
                        game.score += 4 * game.levelNumber;
                    }
                    //Check all 0 values
                    if(board[selectedX][selectedY] == 0){
                       //Update game score
                       game.score++;
                       //Uncover
                       unCover(selectedX, selectedY);
                    }
                }
            }
        } 
        //Check if won
        if(won()){
            game.won();
        }     
    }   
    //Render Board
    @Override
    public void renderBoard(Screen screen){
         if(game.mode == false){
         //Board Numbers
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(board[x][y] == 0){
                     screen.render((x * 8) + 50, (y * 8) + 50, 0, Colour.get(000, 000, 000, 000), 0);
                  }
                  
                  if(board[x][y] == 1){
                      screen.render((x * 8) + 50, (y * 8) + 50, 2, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 2){
                      screen.render((x * 8) + 50, (y * 8) + 50, 3, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 3){
                      screen.render((x * 8) + 50, (y * 8) + 50, 4, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 4){
                      screen.render((x * 8) + 50, (y * 8) + 50, 5, Colour.get(000, 000, 000, 500), 0);
                  }
            }
         }
         //Board
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  //Mines
                  if(mine[x][y] == 1){
                      screen.render((x * 8) + 50,(y * 8) + 50, 16, Colour.get(000, 500, 000, 500), 0);
                  }
                  //Cover
                  if(cover[x][y] != 1){  
                       screen.render((x * 8) + 50, (y * 8) + 50, 9, Colour.get(500, 500, 000, 000), 0);
                  }
                  //Flag
                  if(flag[x][y] == 1){
                       screen.render((x * 8) + 50, (y * 8) + 50, 8, Colour.get(000, 000, 000, 500), 0);
                  }
                  //Selection
                  if(selectedX == x && selectedY == y && game.alive == true){
                       screen.render((x * 8) + 50, (y * 8) + 50, 7, Colour.get(-1, 555, 555, 555), 0);
                  }
              }
         }
         } else {
         //Comb Board Number
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(board[x][y] == 0){
                    if(y % 2 == 0){
                         screen.render((x * 8) + 50, (y * 8) + 50, 0, Colour.get(000, 000, 000, 000), 0);
                     } else{
                        screen.render((x * 8) + 54, (y * 8) + 50, 0, Colour.get(000, 000, 000, 000), 0);   
                     }
                  }
                  
                  if(board[x][y] == 1){
                      if(y % 2 == 0){
                          screen.render((x * 8) + 50, (y * 8) + 50, 2, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 54, (y * 8) + 50, 2, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 2){
                      if(y % 2 == 0){
                          screen.render((x * 8) + 50, (y * 8) + 50, 3, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 54, (y * 8) + 50, 3, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 3){
                     if(y % 2 == 0){
                          screen.render((x * 8) + 50, (y * 8) + 50, 4, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 54, (y * 8) + 50, 4, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 4){
                     if(y % 2 == 0){
                          screen.render((x * 8) + 50, (y * 8) + 50, 4, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 54, (y * 8) + 50, 4, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
            }
         }
         //Board
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  //Mines
                  if(mine[x][y] == 1){       
                      if(y % 2 == 0){
                         screen.render((x * 8) + 50, (y * 8) + 50, 16, Colour.get(000, 000, 000, 500), 0);
                      } else{
                        screen.render((x * 8) + 54, (y * 8) + 50, 16, Colour.get(000, 000, 000, 500), 0);
                      } 
                  }
                  //Cover
                  if(cover[x][y] != 1){
                      if(y % 2 == 0){
                         screen.render((x * 8) + 50, (y * 8) + 50, 14, Colour.get(000, 500, 000, 500), 0);
                      } else{
                         screen.render((x * 8) + 54, (y * 8) + 50, 14, Colour.get(000, 500, 000, 500), 0);
                      }
                  }
                  //Flag      
                  if(flag[x][y] == 1){
                      if(y % 2 == 0){
                         screen.render((x * 8) + 50, (y * 8) + 50, 8, Colour.get(000, 000, 000, 500), 0);
                      } else{
                         screen.render((x * 8) + 54, (y * 8) + 50, 8, Colour.get(000, 000, 000, 500), 0);
                      }
                  }
                  //Selection
                  if(selectedX == x && selectedY == y && game.alive == true){
                      if(y % 2 == 0){
                         screen.render((x * 8) + 50, (y * 8) + 50, 15, Colour.get(-1, 555, 222, 555), 0);
                      } else{
                          screen.render((x * 8) + 54, (y * 8) + 50, 15, Colour.get(-1, 555, 222, 555), 0);
                      }
                  }      
                }
             }
         }
    }         
}
