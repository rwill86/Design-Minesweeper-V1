/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweepers.Menus;

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
public class MenuTest {
    
    public MenuTest() {
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
     * Test of init method, of class Menu.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        MineSweepers game = null;
        Input input = null;
        Menu instance = new Menu();
        instance.init(game, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tick method, of class Menu.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Menu instance = new Menu();
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of render method, of class Menu.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        Screen screen = null;
        Menu instance = new Menu();
        instance.render(screen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
