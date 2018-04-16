
package cookie;

import java.awt.*;
import javax.swing.*;

public class CPanel extends JPanel {
    double origX;
    double origY;
    double scaleX;
    double scaleY;
    double newLeft;
    double newTop;
    double newWidth;
    double newHeight;
    
    public CPanel(int left, int top, int width, int height){
        origX = left / 800.0;
        origY = top / 600.0;
        scaleX = width / 800.0;
        scaleY = height / 600.0;
        setBounds(left, top, width, height);
        setLayout(null);
    }
    
    public void scale(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);
    }
}
