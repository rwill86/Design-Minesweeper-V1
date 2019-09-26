
package minesweepers.Level;

import java.util.Random;
import minesweepers.GUI.Colour;
import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.Menus.HelpMenu;
import minesweepers.Menus.LostMenu;
import minesweepers.Menus.PauseMenu;
import minesweepers.MineSweepers;

// @author MrRit

public class Level{
    private Random random = new Random();
    private Input input;
    private MineSweepers game; 
    public int width;
    public int height;
    public int[][] board;
    public int[][] cover;
    public int[][] flag; 
    public int[][] mine;
    public int[][] colour;
    public int level;
    public int selectedX = 0;
    public int selectedY = 0;
    //Init level
    public Level(int width, int height, int level, Input input, MineSweepers game){
        this.width = width;
        this.height = height;
        this.level = level;
        this.input = input;
        this.game = game;
        board = new int[width][height];
        mine = new int[width][height];
        cover = new int[width][height];
        flag = new int[width][height];
        colour = new int[width][height];
        //Set board
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  board[x][y] = 0;
                  mine[x][y] = 0;
                  flag[x][y] = 0;
                  cover[x][y] = 0;
                  colour[x][y] = 0;
              }
         }
    }
    //Ticks
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
        //Input help
        if(input.help.clicked){
             game.setMenu(new HelpMenu());   
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
            //Check if Mine Exist
            if(game.alive == false){
                game.setMenu(new LostMenu());
            }
            //Check if Mine Exist
            if(checkMine(selectedX, selectedY)){
                flag[selectedX][selectedY] = 0;
                showMine();
                game.lost();
                
            } else{
                flag[selectedX][selectedY] = 0;
                //check if cover is empty
                if(checkCover()){
                    cover[selectedX][selectedY] = 1;
                    //Add to score
                    if(board[selectedX][selectedY] == 1){
                        game.score += 1;
                    }
                    
                    if(board[selectedX][selectedY] == 2){
                        game.score += 2;
                    }
                    
                    if(board[selectedX][selectedY] == 3){
                        game.score += 3;
                    }
                    
                    if(board[selectedX][selectedY] == 4){
                        game.score += 4;
                    }
                    //Uncover
                    unCover(selectedX, selectedY);
                }       
            }
        } 
        //Check if won
        if(won()){
            game.won();
        }     
    }
    //Won
    public boolean won(){
        int count = 0;
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                if(cover[x][y] == 0){
                    count++;
                }            
             }
        }
        if(game.mines == count){
            return true;
        }
        return false;
    }
    //Set Flag
    public void setFlag(int x, int y){
        if(checkCover()){
            if(flag[x][y] == 1){
                //unplace flag
                flag[x][y] = 0;
             } else{
               //Place flag
               flag[x][y] = 1;
            }
        }
    }
    //Set Mine
    public void setMine(int num){
         for(int i = 0; i < num; i++){
             int x = random.nextInt(width);
             int y = random.nextInt(height);
             mine[x][y] = 1; 
         }
    }
    //Check Mine
    public boolean checkMine(int x, int y){
        if(mine[x][y] == 1){
            return true;
        }
        return false;        
    }
    //Show Mine
    public void showMine(){
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                  cover[x][y] = 1;
             }
         }
    }
    //unCover
    public void unCover(int x, int y){   
        if(board[x][y] == 0){
            if(validMove(x - 1, y) && checkMine(x - 1, y) == false){
                if(board[x - 1][y] == 0){
                    cover[x - 1][y] = 1;
                    //Update game score
                    game.score++;
                }
            }
        
            if(validMove(x + 1, y) && checkMine(x + 1, y) == false){
                if(board[x + 1][y] == 0){
                    cover[x + 1][y] = 1;
                    //Update game score
                    game.score++;
                    unCover(x + 1, y);
                }  
            }
        
            if(validMove(x, y - 1) && checkMine(x, y - 1) == false){
                if(board[x][y - 1] == 0){
                   cover[x][y - 1] = 1; 
                   //Update game score
                    game.score++;
                }
            }
        
            if(validMove(x, y + 1) && checkMine(x, y + 1) == false){
                if(board[x][y + 1] == 0){
                    cover[x][y + 1] = 1;
                    //Update game score
                    game.score++;
                    unCover(x, y + 1);
                }  
            }
        
            if(validMove(x - 1, y + 1) && checkMine(x - 1, y + 1) == false){
                if(board[x - 1][y + 1] == 0){
                    cover[x - 1][y + 1] = 1;
                    //Update game score
                    game.score++;
                }  
            }
        
            if(validMove(x - 1, y - 1) && checkMine(x - 1, y - 1) == false){
                if(board[x - 1][y - 1] == 0){
                    cover[x - 1][y - 1] = 1;
                    //Update game score
                    game.score++;
                }  
            }
        
            if(validMove(x + 1, y + 1) && checkMine(x + 1, y + 1) == false){
                if(board[x + 1][y + 1] == 0){
                    cover[x + 1][y + 1] = 1;
                    //Update game score
                    game.score++;
                    unCover(x + 1, y + 1);
                    
                }  
            }
        
            if(validMove(x + 1, y - 1) && checkMine(x + 1, y - 1) == false){
                if(board[x + 1][y - 1] == 0){
                    //Update game score
                    game.score++;
                    cover[x + 1][y - 1] = 1;
                }  
            }
        }
    }
    //
    //Check Cover
    public boolean checkCover(){
         for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                  if(cover[x][y] == 0){
                      return true;
                  }            
             }
         }
         return false;
    }   
    //valid Move
    public boolean validMove(int x, int y){
        return (x >= 0) && (x < width) && (y >= 0) && (y < height); 
    }
    //Set Board Numbers
    public void setBoardNumber(){
        for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  int count = setNumber(x, y);
                  board[x][y] = count;
            }
         }
    }
    //Set Number
    public int setNumber(int x, int y){
        int count = 0;
        
        if(validMove(x - 1, y) && checkMine(x - 1, y)){
            count++;
        }
        
        if(validMove(x + 1, y) && checkMine(x + 1, y)){
            count++;
        }
        
        if(validMove(x, y - 1) && checkMine(x, y - 1)){
            count++;
        }
        
        if(validMove(x, y + 1) && checkMine(x, y + 1)){
            count++;
        }
        
        if(validMove(x - 1, y + 1) && checkMine(x - 1, y + 1)){
            count++;
        }
        
        if(validMove(x - 1, y - 1) && checkMine(x - 1, y - 1)){
            count++;
        }
        
        if(validMove(x + 1, y + 1) && checkMine(x + 1, y + 1)){
            count++;
        }
        
        if(validMove(x + 1, y - 1) && checkMine(x + 1, y - 1)){
            count++;
        }
        return count;
    }
    //Render Face
    public void renderFace(Screen screen){
       screen.render(screen.width / 2, screen.height - 8, 11, Colour.get(000, 222, 222, 555), 0);
    }
    //Render Background
    public void renderBackground(Screen screen){
        screen.clear(0);
        //Border
        for(int y = 0; y < height + 1; y++){
            for(int x = 0; x < width + 1; x++){
                 screen.render(x * 8, y * 8, 10, Colour.get(000, 400, 400, 400), 0);
            }     
        }
    }
    //Colour Board Render
    public void renderColourBoard(Screen screen){
        screen.render(1 * 8, 1 * 8, 0, Colour.get(000, 000, 000, 000), 0);
        //red = 500 //blue = 272 //Yellow = 
        
    }
    //Comb Board Render 
    public void renderCombBoard(Screen screen){
         //Comb Board
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(board[x][y] == 0){
                    if(y % 2 == 0){
                         screen.render(x * 8, y * 8, 0, Colour.get(000, 000, 000, 000), 0);
                     } else{
                        screen.render((x * 8) + 4, y * 8, 0, Colour.get(000, 000, 000, 000), 0);   
                     }
                  }
                  
                  if(board[x][y] == 1){
                      if(y % 2 == 0){
                          screen.render(x * 8, y * 8, 2, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 4, y * 8, 2, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 2){
                      if(y % 2 == 0){
                          screen.render(x * 8, y * 8, 3, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 4, y * 8, 3, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 3){
                     if(y % 2 == 0){
                          screen.render(x * 8, y * 8, 4, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 4, y * 8, 4, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
                  
                  if(board[x][y] == 4){
                     if(y % 2 == 0){
                          screen.render(x * 8, y * 8, 4, Colour.get(000, 000, 000, 500), 0);
                      } else{
                          screen.render((x * 8) + 4, y * 8, 4, Colour.get(000, 000, 000, 500), 0);   
                      }
                  }
            }
         }
         //Comb Mines
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(mine[x][y] == 1){
                      if(y % 2 == 0){
                         screen.render(x * 8, y * 8, 1, Colour.get(000, 000, 000, 500), 0);
                      } else{
                        screen.render((x * 8) + 4, y * 8, 1, Colour.get(000, 000, 000, 500), 0);
                      }     
                  }
              }
         }
         //Comb Cover
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(cover[x][y] != 1){
                      if(y % 2 == 0){
                         screen.render(x * 8, y * 8, 14, Colour.get(000, 510, 000, 510), 0);
                      } else{
                         screen.render((x * 8) + 4, y * 8, 14, Colour.get(000, 500, 000, 500), 0);
                      }
                 }
              }
         }
         //Comb Flag
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(flag[x][y] == 1){
                      if(y % 2 == 0){
                         screen.render(x * 8, y * 8, 8, Colour.get(000, 000, 000, 500), 0);
                      } else{
                         screen.render((x * 8) + 4, y * 8, 8, Colour.get(000, 000, 000, 500), 0);
                      }
                  }
              }
         }       
         //Comb Selection
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(selectedX == x && selectedY == y && game.alive == true){
                      if(y % 2 == 0){
                         screen.render(x * 8, y * 8, 15, Colour.get(-1, 555, 222, 555), 0);
                      } else{
                          screen.render((x * 8) + 4, y * 8, 15, Colour.get(-1, 555, 222, 555), 0);
                      }
                  }
              }
         }
    }
    //Render Board
    public void renderBoard(Screen screen){
         //Board
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(board[x][y] == 0){
                     screen.render((x * 8), y * 8, 0, Colour.get(000, 000, 000, 000), 0);
                  }
                  
                  if(board[x][y] == 1){
                      screen.render(x * 8, y * 8, 2, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 2){
                      screen.render(x * 8, y * 8, 3, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 3){
                      screen.render(x * 8, y * 8, 4, Colour.get(000, 000, 000, 500), 0);
                  }
                  
                  if(board[x][y] == 4){
                      screen.render(x * 8, y * 8, 5, Colour.get(000, 000, 000, 500), 0);
                  }
            }
         }
         //Mines
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(mine[x][y] == 1){
                    screen.render(x * 8, y * 8, 1, Colour.get(000, 000, 000, 500), 0);
                  }
              }
         }
         //Cover
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(cover[x][y] != 1){  
                        screen.render(x * 8, y * 8, 9, Colour.get(500, 510, 000, 000), 0);
                   }
              }
         }
         //Flag
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(flag[x][y] == 1){
                      screen.render(x * 8, y * 8, 8, Colour.get(000, 000, 000, 500), 0);
                  }
              }
         }       
         //Selection
         for(int y = 0; y < height; y++){
              for(int x = 0; x < width; x++){
                  if(selectedX == x && selectedY == y && game.alive == true){
                      screen.render(x * 8, y * 8, 7, Colour.get(-1, 222, 222, 555), 0);
                  }
              }
         }
    }
 }


