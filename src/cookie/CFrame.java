package cookie;

import java.awt.*;
import javax.swing.*;

public class CFrame extends JFrame {

    public CFrame(String title) {
        setTitle(title); // THE TITLE DISPLAYED AT THE TOP OF THE WINDOW
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // GET SCREEN SIZE
        setSize(800, 622); // THE SIZE OF OUR PROGRAM WINDOW
        setLocation(screenSize.width / 2 - 400, screenSize.height / 2 - 325); // PUT WINDOW AT CENTER OF SCREEN
        setMinimumSize(new Dimension(400, 300));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(Cookie.class.getResource("/images/cursor.png")).getImage(), new Point(0, 0), "cursor")); // USE CUSTOM CURSOR
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // NO ONE REALLY KNOWS WHAT THIS DOES. WE JUST KNOW TO ADD IT.
        setLayout(null); // ABSOLUTE POSITIONING SO THAT WE CAN OVERLAY CONTAINTERS (JLABELS, JBUTTONS, ETC.) EASILY
    }
}
