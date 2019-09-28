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
public class LevelColourTest {
    
    public LevelColourTest() {
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
     * Test of renderBoard method, of class LevelColour.
     */
    @Test
    public void testRenderBoard() {
        System.out.println("renderBoard");
        Screen screen = null;
        LevelColour instance = new LevelColour();
        instance.renderBoard(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tick method, of class LevelColour.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        LevelColour instance = new LevelColour();
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
