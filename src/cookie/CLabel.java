package cookie;

import java.awt.*;
import javax.swing.*;

public class CLabel extends JLabel {

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
    public CLabel(int left, int top, int width, int height) {
        origX = left / 800.0;
        origY = top / 600.0;
        scaleX = width / 800.0;
        scaleY = height / 600.0;
        setBounds(left, top, width, height);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    // ADD AN IMAGE TO THE LABEL
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

    public void scaleMiniGameHeading(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 515 && getHeight() > 100) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 75));
        } else if (getWidth() > 515 && getHeight() > 70) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 60));
        } else if (getWidth() > 240 && getHeight() > 70) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 35));
        } else if (getWidth() > 200 && getHeight() > 50) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 190) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 25));
        } else if (getWidth() > 150) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 15));
        }
    }

    public void scaleCookieNames(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);
        
        if (getWidth() > 515 && getHeight() > 50) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 50));
        } else if (getWidth() > 415 && getHeight() > 40) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 40));
        } else if (getWidth() > 300 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 210 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        } else if (getWidth() > 165 && getHeight() > 15) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 14));
        } else if (getWidth() > 120) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 10));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 8));
        }
    }

    public void scaleProfitHeading(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 565 && getHeight() > 100) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 45));
        } else if (getWidth() > 400 && getHeight() > 70) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 350) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 25));
        } else if (getWidth() > 250) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        } else if (getWidth() > 190) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 15));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 10));
        }
    }

    public void scaleCalc(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 96 && getHeight() > 46) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 45));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        }
    }

    public void scaleTitle(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 292 && getHeight() > 46) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 45));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        }
    }

    public void scalePrompt(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 1050 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 700 && getHeight() > 20) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        } else if (getWidth() > 570) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 16));
        } else if (getWidth() > 490) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 14));
        } else if (getWidth() > 430) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 12));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 10));
        }
    }

    public void scaleFeedback(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 1050 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 700 && getHeight() > 20) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        } else if (getWidth() > 570) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 16));
        } else if (getWidth() > 490) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 14));
        } else if (getWidth() > 430) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 12));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 10));
        }
    }

    public void scalePrices(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 110 && getHeight() > 46) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 42));
        } else if (getWidth() > 90 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 32));
        } else if (getWidth() > 72 && getHeight() > 16) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 17));
        } else if (getWidth() > 60 && getHeight() > 16) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 13));
        } else if (getWidth() > 50) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 11));
        } else if (getWidth() > 45) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 9));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 7));
        }
    }

    public void scaleRandomEventText(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);

        if (getWidth() > 1050 && getHeight() > 30) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 30));
        } else if (getWidth() > 700 && getHeight() > 20) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 16));
        } else if (getWidth() > 570) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 14));
        } else if (getWidth() > 490) {
            setFont(new Font("Kristen ITC", Font.PLAIN, 12));
        } else {
            setFont(new Font("Kristen ITC", Font.PLAIN, 10));
        }
    }

    public void scaleGreenBarLength(int x, int y) {
        newLeft = x * origX;
        newTop = y * origY;
        newWidth = x * scaleX;
        newHeight = y * scaleY;

        Cookie.getGV().setProgress(Cookie.getGV().getCurrentTotal() / 500);

        newWidth = Cookie.getGV().getProgress() * Cookie.getUS().getPinkBar().getWidth();
        
        if (newWidth < 1) {
            newWidth = 1;
        }
        
        Image image = new ImageIcon(getClass().getResource(path)).getImage();
        setIcon(new ImageIcon(image.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_DEFAULT)));
        setBounds((int) newLeft, (int) newTop, (int) newWidth, (int) newHeight);
    }
}
