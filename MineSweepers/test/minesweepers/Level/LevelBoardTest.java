/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweepers.Level;

import minesweepers.GUI.Screen;
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
public class LevelBoardTest {
    
    public LevelBoardTest() {
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
     * Test of tick method, of class LevelBoard.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        LevelBoard instance = new LevelBoard();
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renderBoard method, of class LevelBoard.
     */
    @Test
    public void testRenderBoard() {
        System.out.println("renderBoard");
        Screen screen = null;
        LevelBoard instance = new LevelBoard();
        instance.renderBoard(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
