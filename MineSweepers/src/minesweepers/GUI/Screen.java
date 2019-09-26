
package minesweepers.GUI;

 //@author MrRit

public class Screen{
    public final int width;
    public final int height;
    public int[] pixels;
    private SpriteSheet sheet;
    int xOffset;
    int yOffset;
    static final int BIT_MIRROR_X = 0x01;
    static final int BIT_MIRROR_Y = 0x02; 
    //Setup Screen
    public Screen(int width, int height, SpriteSheet sheet){
        this.width = width;
        this.height = height;
        this.sheet = sheet;
        pixels = new int[width * height];
    }
    //Clear Screen
    public void clear(int colour){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = colour;
        }
    }
    //Render Screen
    public void render(int xp, int yp, int tile, int colours, int bits){
        xp -= xOffset;
	yp -= yOffset;
	boolean mirrorX = (bits & BIT_MIRROR_X) > 0;
	boolean mirrorY = (bits & BIT_MIRROR_Y) > 0;
        int xTile = tile % 32;
        int yTile = tile / 32;
	int toffs = xTile * 8 + yTile * 8 * sheet.width;
        //Start rending
	for (int y = 0; y < 8; y++) {
            int ys = y;
            if(mirrorY){
                ys = 7 - y;
            }
            if(y + yp < 0 || y + yp >= height){
                continue;
            }
            
            for(int x = 0; x < 8; x++){
                if(x + xp < 0 || x + xp >= width){
                    continue;
                }
                int xs = x;
                if(mirrorX){
                    xs = 7 - x;
                }
                int col = (colours >> (sheet.pixels[xs + ys * sheet.width + toffs] * 8)) & 255;
		if (col < 255){
                    pixels[(x + xp) + (y + yp) * width] = col;
                }
	    }
	}
     }
}
   