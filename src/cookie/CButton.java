package cookie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CButton extends JButton {

    String path;
    double origX;
    double origY;
    double scaleX;
    double scaleY;
    double newLeft;
    double newTop;
    double newWidth;
    double newHeight;

    // CONSTRUCTOR
    public CButton(int left, int top, int width, int height) {
        origX = left / 800.0;
        origY = top / 600.0;
        scaleX = width / 800.0;
        scaleY = height / 600.0;
        setBounds(left, top, width, height);
        setContentAreaFilled(false);
        setBorderPainted(false);
        addActionListener(new ActionListener() { // WE ARE ABLE TO ASSIGN BUTTON ACTIONS RIGHT WHERE WE CREATE THEM
            public void actionPerformed(ActionEvent e) {
                Cookie.size();
            }
        });
    }

    // ADD IMAGE TO THE BUTTON
    public void setImage(String p) {
        path = p;
        setIcon(new ImageIcon(getClass().getResource(path)));
    }

    public void scaleI(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        Image image = new ImageIcon(getClass().getResource(path)).getImage();
        setIcon(new ImageIcon(image.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_DEFAULT)));
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);
    }

    public void scaleSpecial(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;

        Image image = new ImageIcon(getClass().getResource(path)).getImage();
        if (newHeight > 64) {
            newHeight = 64;
        }
        setIcon(new ImageIcon(image.getScaledInstance((int) newHeight, (int) newHeight, Image.SCALE_DEFAULT)));
        setBounds((int) (newLeft - 15), (int) newTop, (int) newWidth, (int) newHeight);
    }
}
