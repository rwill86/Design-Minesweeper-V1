/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweepers.Level;

import minesweepers.GUI.Screen;
import minesweepers.Input;
import minesweepers.MineSweepers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class LevelTest {
    
    public LevelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class Level.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        int width = 0;
        int height = 0;
        int level = 0;
        MineSweepers game = null;
        Input input = null;
        Level instance = new Level();
        instance.init(width, height, level, game, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tick method, of class Level.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Level instance = new Level();
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of won method, of class Level.
     */
    @Test
    public void testWon() {
        System.out.println("won");
        Level instance = new Level();
        boolean expResult = false;
        boolean result = instance.won();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlag method, of class Level.
     */
    @Test
    public void testSetFlag() {
        System.out.println("setFlag");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        instance.setFlag(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMine method, of class Level.
     */
    @Test
    public void testSetMine() {
        System.out.println("setMine");
        int num = 0;
        Level instance = new Level();
        instance.setMine(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColour method, of class Level.
     */
    @Test
    public void testSetColour() {
        System.out.println("setColour");
        Level instance = new Level();
        instance.setColour();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMine method, of class Level.
     */
    @Test
    public void testCheckMine() {
        System.out.println("checkMine");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        boolean expResult = false;
        boolean result = instance.checkMine(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkColour method, of class Level.
     */
    @Test
    public void testCheckColour() {
        System.out.println("checkColour");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        boolean expResult = false;
        boolean result = instance.checkColour(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMine method, of class Level.
     */
    @Test
    public void testShowMine() {
        System.out.println("showMine");
        Level instance = new Level();
        instance.showBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unCoverColour method, of class Level.
     */
    @Test
    public void testUnCoverColour() {
        System.out.println("unCoverColour");
        int x = 0;
        int y = 0;
        int c = 0;
        Level instance = new Level();
        instance.unCoverColour(c,x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unCover method, of class Level.
     */
    @Test
    public void testUnCover() {
        System.out.println("unCover");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        instance.unCover(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCover method, of class Level.
     */
    @Test
    public void testCheckCover() {
        System.out.println("checkCover");
        Level instance = new Level();
        boolean expResult = false;
        boolean result = false;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validMove method, of class Level.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        boolean expResult = false;
        boolean result = instance.validMove(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardNumber method, of class Level.
     */
    @Test
    public void testSetBoardNumber() {
        System.out.println("setBoardNumber");
        Level instance = new Level();
        instance.setBoardNumber();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class Level.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int x = 0;
        int y = 0;
        Level instance = new Level();
        int expResult = 0;
        int result = instance.setNumber(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renderFace method, of class Level.
     */
    @Test
    public void testRenderFace() {
        System.out.println("renderFace");
        Screen screen = null;
        Level instance = new Level();
        instance.renderFace(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renderBackground method, of class Level.
     */
    @Test
    public void testRenderBackground() {
        System.out.println("renderBackground");
        Screen screen = null;
        Level instance = new Level();
        instance.renderBackground(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renderBoard method, of class Level.
     */
    @Test
    public void testRenderBoard() {
        System.out.println("renderBoard");
        Screen screen = null;
        Level instance = new Level();
        instance.renderBoard(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
