
package minesweepers.Level;

import java.util.Random;
import minesweepers.GUI.Colour;
import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.MineSweepers;

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
    public int k;
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
    //Won Colour
    public boolean wonColour(){
        int kcount = 0;
        int ccount = 0;
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                if(k == colour[x][y]){
                    kcount++;
                }            
             }
        }
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                if(cover[x][y] == 0){
                    ccount++;
                }            
             }
        }
        if(kcount == ccount){
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
         k = random.nextInt(3);
         for(int i = 0; i < height; i++){
             for(int j = 0; j < width; j++){
                 int colourcode = random.nextInt(3);
                 colour[i][j] = colourcode; 
             }
         }
         //Neightbourhood
         for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                 if(validMove(x - 1, y) && colour[x - 1][y] == colour[x][y]){      
                    colour[x - 1][y] = random.nextInt(3);
                 }
        
                 if(validMove(x + 1, y) && colour[x + 1][y] == colour[x][y]){
                     colour[x + 1][y] = random.nextInt(3);
                 }
                 
                 if(validMove(x, y + 1) && colour[x][y + 1] == colour[x][y]){
                     colour[x][y + 1] = random.nextInt(3);
                 }
                 
                 if(validMove(x, y - 1) && colour[x][y - 1] == colour[x][y]){
                     colour[x][y - 1] = random.nextInt(3);
                 }
                 
                 if(validMove(x + 1, y + 1) && colour[x + 1][y + 1] == colour[x][y]){
                     colour[x + 1][y + 1] = random.nextInt(3);
                 }
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
    //Show Board
    public void showBoard(){
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++){
                  flag[x][y] = 0;
                  cover[x][y] = 1;
             }
         }
    }
    //uncover Colour
    public boolean unCoverColour(int cur, int x, int y){
        if(validMove(x, y) == false){
            return false;
        } 
        
        if(colour[x][y] != cur){
            return false;
        }
        
        cover[x][y] = 1;
        unCoverColour(cur, x + 1, y);
        unCoverColour(cur, x, y + 1);
        unCoverColour(cur, x + 1, y + 1);
        return false;
    }
    //unCover
    public boolean unCover(int x, int y){  
        if(validMove(x, y) == false){
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
        flag[x][y] = 0;
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
        return x >= 0 && x < width && y >= 0 && y < height;
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
    }
    //Render Board
    public void renderBoard(Screen screen){
    }
 }


