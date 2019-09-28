/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweepers.Menus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author User
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({minesweepers.Menus.HelpMenuTest.class, minesweepers.Menus.LostMenuTest.class, minesweepers.Menus.MenuTest.class, minesweepers.Menus.TitleMenuTest.class, minesweepers.Menus.PauseMenuTest.class, minesweepers.Menus.WonMenuTest.class})
public class MenusSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
