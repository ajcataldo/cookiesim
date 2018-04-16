/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookie;

import java.awt.Color;
import java.awt.event.*;

public class RandomEvent {
    private CLabel randomEventBackground;
    private CLabel prompt;
    private CLabel warning;
    private CButton yes;
    private CButton no;
    
    private boolean randomEventActive = false;
    
    public RandomEvent() {
        randomEventBackground = new CLabel(0,0,800,600);
        randomEventBackground.setImage("/images/parade.png");
        randomEventBackground.setVisible(false);
        
        prompt = new CLabel(0,100,800,200);
        prompt.setForeground(Color.WHITE);
        prompt.setText("The parade is coming to town! Would you like to sell your cookies there?");
        prompt.setVisible(false);
        
        warning = new CLabel(0,200,800,200);
        warning.setForeground(Color.WHITE);
        warning.setText("(You have a chance to make more or less money than you would in a regular week.)");
        warning.setVisible(false);
        
        yes = new CButton(500, 537, 100, 50);
        yes.setImage("/images/yes.png");
        yes.setVisible(false);
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cookie.getMGS().generateCustomerOrder();
                Cookie.getGV().goToMiniGameScreen();
                Cookie.getMGS().getScenery().setImage("/images/parade.png");
                randomEventActive = true;
            }
        });
        
        no = new CButton(200, 537, 100, 50);
        no.setImage("/images/no.png");
        no.setVisible(false);
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cookie.getMGS().generateCustomerOrder();
                Cookie.getGV().goToMiniGameScreen();
            }
        });
    }
    
    public CLabel getRandomEventBackground() {
        return randomEventBackground;
    }
    
    public CLabel getPrompt() {
        return prompt;
    }
    
    public CLabel getWarning() {
        return warning;
    }
    
    public CButton getYes() {
        return yes;
    }
    
    public CButton getNo() {
        return no;
    }
    
    public boolean isRandomEventActive() {
        return randomEventActive;
    }
    
    public void setRandomEventActive(boolean rea) {
        randomEventActive = rea;
    }
}
