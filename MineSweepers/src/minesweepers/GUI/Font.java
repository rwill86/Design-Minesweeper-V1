
package minesweepers.GUI;

 //@author MrRit

public class Font{
    private static String chars = "" + 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ      " + 
			"0123456789.,!?'\"-+=/\\%()<>:;     ";
    //Draw Font 
    public static void draw(String text, Screen screen, int x, int y, int colour){
        text = text.toUpperCase();
	for(int i = 0; i < text.length(); i++) {
	    int ix = chars.indexOf(text.charAt(i));
	    if(ix >= 0){
                //Render Font on Screen 
		screen.render(x + i * 8, y, ix + 30 * 32, colour, 0);
	    }
	}
    }
}
