package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jean-Louis
 */
public class FocusOnGameScreen extends MouseAdapter {
    
    private Component target;
   
    /**
     *Constructor of class FocusOnGameScreen (which is a subclass to MouseAdapter, an abstract adapter class that receives and processes mouse events)
     * @param t any class which "extends" MouseAdapter (ie: inherits features of this abstract class) must be a variable of Component class, an object having a graphical representation that can be displayed on the screen and that can interact with the user. 
     * Examples of components are the buttons, checkboxes, and scrollbars of a typical graphical user interface.
     * The Component class is the abstract superclass of the nonmenu-related Abstract Window Toolkit components
     * This Component class "extends" Object class.
     */
    public FocusOnGameScreen(Component t) {       
        this.target = t;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {       
        target.requestFocus();
    }
}
