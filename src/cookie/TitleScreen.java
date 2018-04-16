package cookie;

import java.awt.event.*;

public class TitleScreen {

    // GRAPHICS FOR THE TITLE SCREEN
    private CLabel titleScreenBackground;
    private CButton easyButton;
    private CButton mediumButton;
    private CButton hardButton;

    public TitleScreen() {

        titleScreenBackground = new CLabel(0, 0, 800, 600);
        titleScreenBackground.setImage("/images/mainMenu.png");

        easyButton = new CButton(38, 442, 221, 111);
        easyButton.setImage("/images/easy.png");
        easyButton.addActionListener(new ActionListener() { // WE ARE ABLE TO ASSIGN BUTTON ACTIONS RIGHT WHERE WE CREATE THEM
            public void actionPerformed(ActionEvent e) {
                Cookie.getGV().goToMiniGameScreen();
                Cookie.getGV().setDifficulty(1);
                Cookie.getGV().setCurrentTotal(10);
                Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                Cookie.getGV().setEndGoal(500);
                Cookie.getMGS().generateCustomerOrder();
            }
        });

        mediumButton = new CButton(294, 442, 220, 111);
        mediumButton.setImage("/images/medium.png");
        mediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cookie.getGV().goToMiniGameScreen();
                Cookie.getGV().setDifficulty(2);
                Cookie.getGV().setCurrentTotal(5);
                Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                Cookie.getGV().setEndGoal(500);
                Cookie.getMGS().generateCustomerOrder();
            }
        });

        hardButton = new CButton(546, 442, 220, 111);
        hardButton.setImage("/images/hard.png");
        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cookie.getGV().goToMiniGameScreen();
                Cookie.getGV().setDifficulty(3);
                Cookie.getGV().setCurrentTotal(0);
                Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                Cookie.getGV().setEndGoal(500);
                Cookie.getMGS().generateCustomerOrder();
            }
        });
    }

    // GETTERS
    public CLabel getTitleScreenBackground() {
        return titleScreenBackground;
    }

    public CButton getEasyButton() {
        return easyButton;
    }

    public CButton getMediumButton() {
        return mediumButton;
    }

    public CButton getHardButton() {
        return hardButton;
    }
}
