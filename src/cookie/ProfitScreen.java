package cookie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProfitScreen {

    // ALL THE PROFIT SCREEN COMPONENTS
    private CLabel profitScreenBackground;
    private CLabel lastWeekTotal;
    private CLabel easyQueryTop;
    private CLabel easyQueryBottom;
    private CLabel mediumQueryTop;
    private CLabel mediumQueryBottom;
    private CLabel hardQueryTop;
    private CLabel hardQueryBottom;
    private CLabel feedback;
    private CButton upgradeMenuButton;
    private CButton enterAnswer;
    private CLabel finalScreen;

    // ALL THE COMPONENTS FOR THE CALCULATOR
    private CPanel calculator;
    private CLabel title;
    private CLabel titleBackground;
    private CButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDot, bClear;
    private CLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, lDot, lClear;
    private ActionListener dotActionListener;

    private String number = "";
    private Double value = 0.00;
    private int counter;
    private int hiddenCustomers;
    private double queryProfitMoney;
    private double queryAnswer;
    private double userGuess;

    public ProfitScreen() {
        profitScreenBackground = new CLabel(0, 0, 800, 600);
        profitScreenBackground.setImage("/images/profitMenu.png");
        profitScreenBackground.setVisible(false);

        lastWeekTotal = new CLabel(250, 4, 300, 75);
        lastWeekTotal.setForeground(Color.white);
        lastWeekTotal.setText("Last Week's Total:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getPreviousTotal()));
        lastWeekTotal.setVisible(false);

        easyQueryTop = new CLabel(0, 460, 800, 32);
        easyQueryTop.setVisible(false);
        
        easyQueryBottom = new CLabel(0, 493, 800, 32);
        easyQueryBottom.setVisible(false);

        mediumQueryTop = new CLabel(0, 460, 800, 32);
        mediumQueryTop.setVisible(false);
        
        mediumQueryBottom = new CLabel(0, 493, 800, 32);
        mediumQueryBottom.setVisible(false);

        hardQueryTop = new CLabel(0, 460, 800, 32);
        hardQueryTop.setVisible(false);
        
        hardQueryBottom = new CLabel(0, 493, 800, 32);
        hardQueryBottom.setVisible(false);

        feedback = new CLabel(0, 525, 700, 75);
        feedback.setForeground(Color.WHITE);
        feedback.setVisible(false);
        
        finalScreen = new CLabel(0,0,800,600);
        finalScreen.setVisible(false);

        upgradeMenuButton = new CButton(675, 537, 100, 50);
        upgradeMenuButton.setImage("/images/upgrade.png");
        upgradeMenuButton.setVisible(false);
        upgradeMenuButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Cookie.getGV().getCurrentTotal() >= Cookie.getGV().getEndGoal()) {
                    Cookie.getPS().getCalculator().setVisible(false);
                    finalScreen.setImage("/images/victoryScreech.png");
                    finalScreen.setVisible(true);
                } else if (Cookie.getGV().getCurrentWeek() == 12) {
                    Cookie.getPS().getCalculator().setVisible(false);
                    finalScreen.setImage("/images/gameOver.png");
                    finalScreen.setVisible(true);
                } else {
                    Cookie.getGV().goToUpgradeScreen();
                    Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                    Cookie.getRE().setRandomEventActive(false);
                }
            }
        });

        enterAnswer = new CButton(675, 537, 100, 50);
        enterAnswer.setImage("/images/submit.png");
        enterAnswer.setVisible(false);
        enterAnswer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (Cookie.getGV().getDifficulty()) {
                    case 1:
                        number = oneDot(number);
                        try {
                            value = Double.parseDouble(number);
                        } catch (NumberFormatException nfe) {
                            value = 0.0;
                        }
                        number = "";
                        counter = 0;
                        title.setText(Cookie.getGV().getCurrencyFormat().format(value));
                        bDot.addActionListener(dotActionListener);
                        userGuess = value;
                        if (Cookie.getGV().getProfit() == userGuess) {
                            feedback.setText("Congratulations, you are correct! Continue to the store!");
                        } else {
                            feedback.setText("Due to your error, you lost some money. Continue to the store.");
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - 5);
                        }
                        break;
                    case 2:
                        number = oneDot(number);
                        value = Double.parseDouble(number);
                        number = "";
                        counter = 0;
                        title.setText(Cookie.getGV().getCurrencyFormat().format(value));
                        bDot.addActionListener(dotActionListener);
                        userGuess = value;
                        if (queryAnswer == userGuess) {
                            feedback.setText("Congratulations, you are correct! Continue to the store!");
                        } else {
                            feedback.setText("Due to your error, you lost some money. Continue to the store.");
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - 10);
                        }
                        break;
                    case 3:
                        number = oneDot(number);
                        int valInt = Integer.parseInt(number);
                        number = "";
                        counter = 0;
                        title.setText(Integer.toString(valInt));
                        bDot.addActionListener(dotActionListener);
                        userGuess = valInt;
                        if (hiddenCustomers == userGuess) {
                            feedback.setText("Congratulations, you are correct! Continue to the store!");
                        } else {
                            feedback.setText("Due to your error, you lost some money. Continue to the store.");
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - 15);
                        }
                        break;
                }
                enterAnswer.setVisible(false);
                upgradeMenuButton.setVisible(true);
            }
        });

        // CREATE A PANEL FOR THE CALCULATOR. ADD COMPONENTS TO THE PANEL AND THEN ADD THE PANEL TO THE WINDOW (FRAME)
        calculator = new CPanel(250, 111, 300, 250);
        calculator.setVisible(false);

        title = new CLabel(0, 0, 300, 50);
        title.setText("0");

        titleBackground = new CLabel(0, 0, 300, 50);
        titleBackground.setImage("/images/title.png");

        // NEED TO ADD THE BUTTONS WITHOUT TEXT BECAUSE THE TEXT WILL JUST GO TO THE RIGHT OF THE IMAGE. THEREFORE, WE NEED TO CREATE LABELS AND SIMPLY OVERLAY THEM ONTO THE BUTTONS
        b0 = new CButton(100, 200, 100, 50);
        b0.setImage("/images/button.png");
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0" || number == "") {
                    number = "0";
                } else {
                    if (counter < 5) {
                        number += 0;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b1 = new CButton(0, 150, 100, 50);
        b1.setImage("/images/button.png");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "1";
                } else {
                    if (counter < 5) {
                        number += 1;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b2 = new CButton(100, 150, 100, 50);
        b2.setImage("/images/button.png");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "2";
                } else {
                    if (counter < 5) {
                        number += 2;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b3 = new CButton(200, 150, 100, 50);
        b3.setImage("/images/button.png");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "3";
                } else {
                    if (counter < 5) {
                        number += 3;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b4 = new CButton(0, 100, 100, 50);
        b4.setImage("/images/button.png");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "4";
                } else {
                    if (counter < 5) {
                        number += 4;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b5 = new CButton(100, 100, 100, 50);
        b5.setImage("/images/button.png");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "5";
                } else {
                    if (counter < 5) {
                        number += 5;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b6 = new CButton(200, 100, 100, 50);
        b6.setImage("/images/button.png");
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "6";
                } else {
                    if (counter < 5) {
                        number += 6;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b7 = new CButton(0, 50, 100, 50);
        b7.setImage("/images/button.png");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "7";
                } else {
                    if (counter < 5) {
                        number += 7;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b8 = new CButton(100, 50, 100, 50);
        b8.setImage("/images/button.png");
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "8";
                } else {
                    if (counter < 5) {
                        number += 8;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        b9 = new CButton(200, 50, 100, 50);
        b9.setImage("/images/button.png");
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (number == "0") {
                    number = "9";
                } else {
                    if (counter < 5) {
                        number += 9;
                    }
                    counter++;
                }
                title.setText(number);
            }
        });

        dotActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bDot.removeActionListener(dotActionListener);
                if (number == "") {
                    number += "0.";
                } else {
                    number += ".";
                }
                number = oneDot(number);
                title.setText(number);
            }
        };

        bDot = new CButton(200, 200, 100, 50);
        bDot.setImage("/images/button.png");
        bDot.addActionListener(dotActionListener);

        bClear = new CButton(0, 200, 100, 50);
        bClear.setImage("/images/button.png");
        bClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                number = "";
                counter = 0;
                title.setText("0");
                bDot.addActionListener(dotActionListener);
            }
        });

        // CREATE THE LABELS FOR TO GO ON TOP OF THE BUTTONS
        l0 = new CLabel(100, 200, 100, 50);
        l0.setText("0");

        l1 = new CLabel(0, 150, 100, 50);
        l1.setText("1");

        l2 = new CLabel(100, 150, 100, 50);
        l2.setText("2");

        l3 = new CLabel(200, 150, 100, 50);
        l3.setText("3");

        l4 = new CLabel(0, 100, 100, 50);
        l4.setText("4");

        l5 = new CLabel(100, 100, 100, 50);
        l5.setText("5");

        l6 = new CLabel(200, 100, 100, 50);
        l6.setText("6");

        l7 = new CLabel(0, 50, 100, 50);
        l7.setText("7");

        l8 = new CLabel(100, 50, 100, 50);
        l8.setText("8");

        l9 = new CLabel(200, 50, 100, 50);
        l9.setText("9");

        lDot = new CLabel(200, 200, 100, 50);
        lDot.setText(".");

        lClear = new CLabel(0, 200, 100, 50);
        lClear.setText("Clr");

        calculator.add(title);
        calculator.add(l0);
        calculator.add(l1);
        calculator.add(l2);
        calculator.add(l3);
        calculator.add(l4);
        calculator.add(l5);
        calculator.add(l6);
        calculator.add(l7);
        calculator.add(l8);
        calculator.add(l9);
        calculator.add(lDot);
        calculator.add(lClear);

        calculator.add(titleBackground);
        calculator.add(b7);
        calculator.add(b8);
        calculator.add(b9);
        calculator.add(b4);
        calculator.add(b5);
        calculator.add(b6);
        calculator.add(b1);
        calculator.add(b2);
        calculator.add(b3);
        calculator.add(bClear);
        calculator.add(b0);
        calculator.add(bDot);
    }

    // MAKE SURE THAT THE DECIMAL IS NOT ACCIDENTALLY PRESSED TWICE
    private String oneDot(String num) {
        String out = "";
        int dotCount = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '.') {
                dotCount++;
                if (dotCount < 2) {
                    out += num.charAt(i);
                }
            } else {
                out += num.charAt(i);
            }
        }
        return out;
    }

    // GETTERS AND SETTERS
    public CLabel getProfitScreenBackground() {
        return profitScreenBackground;
    }

    public CPanel getCalculator() {
        return calculator;
    }

    public CLabel getLastWeekTotal() {
        return lastWeekTotal;
    }

    public CLabel getEasyQueryTop() {
        return easyQueryTop;
    }
    
    public CLabel getEasyQueryBottom() {
        return easyQueryBottom;
    }

    public CLabel getMediumQueryTop() {
        return mediumQueryTop;
    }
    
    public CLabel getMediumQueryBottom() {
        return mediumQueryBottom;
    }

    public CLabel getHardQueryTop() {
        return hardQueryTop;
    }
    
    public CLabel getHardQueryBottom() {
        return hardQueryBottom;
    }

    public CLabel getFeedback() {
        return feedback;
    }

    public CButton getUpgradeMenuButton() {
        return upgradeMenuButton;
    }

    public CButton getEnterAnswer() {
        return enterAnswer;
    }

    public int getHiddenCustomers() {
        return hiddenCustomers;
    }

    public void setHiddenCustomers(int hc) {
        hiddenCustomers = hc;
    }

    public double getQueryProfitMoney() {
        return queryProfitMoney;
    }

    public void setQueryProfitMoney(double qpm) {
        queryProfitMoney = qpm;
    }

    public double getQueryAnswer() {
        return queryAnswer;
    }

    public void setQueryAnswer(double qa) {
        queryAnswer = qa;
    }

    public double getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(double ug) {
        userGuess = ug;
    }
    
    public CButton getB0() {
        return b0;
    }
    
    public CButton getB1() {
        return b1;
    }
    
    public CButton getB2() {
        return b2;
    }
    
    public CButton getB3() {
        return b3;
    }
    
    public CButton getB4() {
        return b4;
    }
    
    public CButton getB5() {
        return b5;
    }
    
    public CButton getB6() {
        return b6;
    }
    
    public CButton getB7() {
        return b7;
    }
    
    public CButton getB8() {
        return b8;
    }
    
    public CButton getB9() {
        return b9;
    }
    
    public CButton getBClear() {
        return bClear;
    }
    
    public CButton getBDot() {
        return bDot;
    }
    
    public CLabel getL0() {
        return l0;
    }
    
    public CLabel getL1() {
        return l1;
    }
    
    public CLabel getL2() {
        return l2;
    }
    
    public CLabel getL3() {
        return l3;
    }
    
    public CLabel getL4() {
        return l4;
    }
    
    public CLabel getL5() {
        return l5;
    }
    
    public CLabel getL6() {
        return l6;
    }
    
    public CLabel getL7() {
        return l7;
    }
    
    public CLabel getL8() {
        return l8;
    }
    
    public CLabel getL9() {
        return l9;
    }
    
    public CLabel getLClear() {
        return lClear;
    }
    
    public CLabel getLDot() {
        return lDot;
    }
    
    public CLabel getTitle() {
        return title;
    }
    
    public CLabel getTitleBackground() {
        return titleBackground;
    }
    
    public CLabel getFinalScreen() {
        return finalScreen;
    }
}
