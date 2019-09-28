
package minesweepers.Level;

import java.util.Random;
import minesweepers.GUI.Colour;
import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.MineSweepers;
import minesweepers.Music;

// @author MrRit

public class Level{
    private Random random = new Random();
    protected Input input;
    protected MineSweepers game; 
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
    public int mines = 10;
    public int k = 1;
    //Init level
    public void init(int width, int height, int level, MineSweepers game, Input input){
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
        k = random.nextInt(3);
        setColour();
    }
    //Ticks
    public void tick(){    
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
        if(checkCover(x, y)){
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
         int i = 0;
         while(i < num){
             int x = random.nextInt(width);
             int y = random.nextInt(height); 
             if(checkMine(x, y)){
                mine[x][y] = 0;
                i--;
             } else{
                 mine[x][y] = 1;
                 i++;
             }
         }
    }
    //set Colour
    public void setColour(){
         for(int i = 0; i < width; i++){
             for(int j = 0; j < width; j++){
                 int colourcode = random.nextInt(3);
                 colour[i][j] = colourcode; 
             }
         }
    } 
    //Check Mine
    public boolean checkMine(int x, int y){
        if(mine[x][y] == 1){
            return true;
        }
        return false;        
    }
    //Check Colour
    public boolean checkColour(int x, int y){
         if(colour[x][y] == k){
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
    //uncover Colour
    public void unCoverColour(int x, int y){
         game.score++;
         cover[x][y] = 1;
    }
    //unCover
    public boolean unCover(int x, int y){  
        if(validMove(x, y)){
            return false;
        } 
        
        if(checkMine(x, y)){
            return false;
        }
        
        if(board[x][y] != 0){
            cover[x][y] = 1;
            return false;
        } 
        cover[x][y] = 1;
        unCover(x + 1, y);
        unCover(x, y + 1);
        unCover(x + 1, y + 1);
        return false;
    }
    //Check Cover
    public boolean checkCover(int x, int y){
         if(cover[x][y] == 0 && cover[x][y] != 1){
             return true;
         } else{
             return false;
         }
    }   
    //Valid Move Range
    public boolean validMove(int x, int y){
        return x <= -1 || x >= width || y <= -1 || y >= height; 
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
        
        if(validMove(x - 1, y) == false && checkMine(x - 1, y)){
            count++;
        }
        
        if(validMove(x + 1, y) == false && checkMine(x + 1, y)){
            count++;
        }
        
        if(validMove(x, y - 1) == false && checkMine(x, y - 1)){
            count++;
        }
        
        if(validMove(x, y + 1) == false && checkMine(x, y + 1)){
            count++;
        }
        
        if(validMove(x - 1, y + 1) == false && checkMine(x - 1, y + 1)){
            count++;
        }
        
        if(validMove(x - 1, y - 1) == false && checkMine(x - 1, y - 1)){
            count++;
        }
        
        if(validMove(x + 1, y + 1) == false && checkMine(x + 1, y + 1)){
            count++;
        }
        
        if(validMove(x + 1, y - 1) == false && checkMine(x + 1, y - 1)){
            count++;
        }
        //Return count;
        return count;
    }
    //Render Face
    public void renderFace(Screen screen){
       if(game.alive == false){
           screen.render(screen.width / 2, screen.height - 10, 13, Colour.get(000, 555, 555, 555), 0);
       } else{
           screen.render(screen.width / 2, screen.height - 10, 11, Colour.get(000, 555, 555, 555), 0);
       }
    }
    //Render Background
    public void renderBackground(Screen screen){
        screen.clear(0);
        if(game.colourmode == false){
            //Border
            for(int y = -1; y < height + 1; y++){
                 for(int x = -1; x < width + 1; x++){
                     screen.render((x * 8) + 50, (y * 8) + 50, 10, Colour.get(000, 400, 400, 400), 0);
                 }     
            }
        } else {
            for(int y = -1; y <= height; y++){
                 for(int x = -1; x <= width ; x++){
                     screen.render((x * 8) + 50, (y * 8) + 50, 10, Colour.get(000, 222, 222, 222), 0);
                 }     
            }
        }
    }
    //Render Board
    public void renderBoard(Screen screen){
    }
 }


