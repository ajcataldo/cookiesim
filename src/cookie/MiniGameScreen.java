package cookie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniGameScreen {

    // MINIGAME COMPONENTS
    private CLabel miniGameBackground;
    private CLabel scenery;

    // SHOW THE CUSTOMER'S ORDER
    private CLabel lblCustomerFirstCookie;
    private CLabel lblCustomerSecondCookie;
    private CLabel lblCustomerThirdCookie;

    // SHOW THE USER'S SELECTIONS
    private CLabel lblUserFirstCookie;
    private CLabel lblUserSecondCookie;
    private CLabel lblUserThirdCookie;

    // SHOW THE CUSTOMER
    private CLabel customer;

    // SHOW THE THOUGHT BUBBLE
    private CLabel thoughtBubble;

    // SHOW THE COOKIE SELECTION IN THE TOP LEFT
    private CButton cookieMenuAlpha;
    private CButton cookieMenuBeta;
    private CButton cookieMenuCharlie;
    private CLabel lblCookieAlpha;
    private CLabel lblCookieBeta;
    private CLabel lblCookieCharlie;

    // CLEAR AND SUBMIT BUTTONS AND RED X
    private CButton clear;
    private CButton submit;
    private CLabel wrong;

    private final String firstSceneryPath = "/images/curb.png";
    private final String secondSceneryPath = "/images/bigGsHouse.png";
    private final String thirdSceneryPath = "/images/park.png";
    private final String fourthSceneryPath = "/images/parade.png";

    // FILE PATHS FOR THE IMAGES OF THE COOKIES
    private final String firstMenuCookiePath = "/images/pbEnjoy.png";
    private final String secondMenuCookiePath = "/images/powderedPuff.png";
    private final String thirdMenuCookiePath = "/images/chocoChip.png";
    private final String fourthMenuCookiePath = "/images/thickMint.png";
    private final String fifthMenuCookiePath = "/images/buckEye.png";
    private final String sixthMenuCookiePath = "/images/pecanSandy.png";
    private final String seventhMenuCookiePath = "/images/coconutSupreme.png";
    private final String eighthMenuCookiePath = "/images/smoreBites.png";

    // FILE PATHS FOR THE IMAGES OF THE CUSTOMERS
    private final String firstCustomerPath = "/images/child1.png";
    private final String secondCustomerPath = "/images/child2.png";
    private final String thirdCustomerPath = "/images/man1.png";
    private final String fourthCustomerPath = "/images/man2.png";
    private final String fifthCustomerPath = "/images/man3.png";
    private final String sixthCustomerPath = "/images/woman1.png";
    private final String seventhCustomerPath = "/images/woman2.png";
    private final String eighthCustomerPath = "/images/woman3.png";

    // DISPLAY NAMES OF THE COOKIES
    private final String firstMenuCookieText = "PB Enjoy";
    private final String secondMenuCookieText = "Powdered Puff";
    private final String thirdMenuCookieText = "Choco Chip";
    private final String fourthMenuCookieText = "Thick Mint";
    private final String fifthMenuCookieText = "Buck-Eye";
    private final String sixthMenuCookieText = "Pecan Sandy";
    private final String seventhMenuCookieText = "Coconut Supreme";
    private final String eighthMenuCookieText = "Smore Bites";

    private String thoughtBubblePath1 = firstMenuCookiePath;
    private String thoughtBubblePath2 = secondMenuCookiePath;
    private String thoughtBubblePath3 = thirdMenuCookiePath;

    // VARIABLES SPECIFIC TO THE MINIGAME SCREEN
    private int miniGameRoundCounter;

    // KEEP TRACK OF HOW MANY OF EACH COOKIE THE CUSTOMER WANTS
    private int customerFirstCookieCount;
    private int customerSecondCookieCount;
    private int customerThirdCookieCount;

    // KEEP TRACK OF HOW MANY OF EACH COOKIE THE USER SELECTED
    private int userFirstCookieCount;
    private int userSecondCookieCount;
    private int userThirdCookieCount;

    // THE USER HASN'T YET SELECTED ANY COOKIE
    private boolean boolFirstChoice;
    private boolean boolSecondChoice;
    private boolean boolThirdChoice;

    // KEEP TRACK OF THE COOKIE IMAGES TO DISPLAY IN THE THOUGHT BUBBLE
    private String[] customerOrderPath;

    public MiniGameScreen() {
        // INITIALIZE VARIBLES
        miniGameRoundCounter = 0;
        boolFirstChoice = false;
        boolSecondChoice = false;
        boolThirdChoice = false;
        customerOrderPath = new String[3];

        // CREATE COMPONENTS
        miniGameBackground = new CLabel(0, 0, 800, 600);
        miniGameBackground.setImage("/images/miniGameBackground.png");
        miniGameBackground.setVisible(false);

        scenery = new CLabel(0, 75, 800, 400);
        scenery.setImage(firstSceneryPath);
        scenery.setVisible(false);

        lblUserFirstCookie = new CLabel(234, 480, 32, 32);
        lblUserFirstCookie.setVisible(false);

        lblUserSecondCookie = new CLabel(384, 480, 32, 32);
        lblUserSecondCookie.setVisible(false);

        lblUserThirdCookie = new CLabel(534, 480, 32, 32);
        lblUserThirdCookie.setVisible(false);

        lblCustomerFirstCookie = new CLabel(543, 208, 32, 32);
        lblCustomerFirstCookie.setVisible(false);

        lblCustomerSecondCookie = new CLabel(587, 208, 32, 32);
        lblCustomerSecondCookie.setVisible(false);

        lblCustomerThirdCookie = new CLabel(631, 208, 32, 32);
        lblCustomerThirdCookie.setVisible(false);

        thoughtBubble = new CLabel(500, 175, 194, 123);
        thoughtBubble.setImage("/images/thoughtBubble.png");
        thoughtBubble.setVisible(false);

        customer = new CLabel(330, 210, 140, 260);
        customer.setImage(thirdCustomerPath);
        customer.setVisible(false);

        cookieMenuAlpha = new CButton(25, 166, 258, 32);
        cookieMenuAlpha.setImage(firstMenuCookiePath);
        cookieMenuAlpha.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieAlpha = new CLabel(65, 166, 218, 32);
        lblCookieAlpha.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieAlpha.setText(firstMenuCookieText);
        lblCookieAlpha.setVisible(false);
        cookieMenuAlpha.setVisible(false);
        cookieMenuAlpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!boolThirdChoice) {
                    if (boolFirstChoice) {
                        if (boolSecondChoice) {
                            lblUserThirdCookie.setImage(thoughtBubblePath1);
                            lblUserThirdCookie.setVisible(true);
                            boolThirdChoice = true;
                            userFirstCookieCount++;
                        } else {
                            lblUserSecondCookie.setImage(thoughtBubblePath1);
                            lblUserSecondCookie.setVisible(true);
                            boolSecondChoice = true;
                        }
                    } else {
                        lblUserFirstCookie.setImage(thoughtBubblePath1);
                        lblUserFirstCookie.setVisible(true);
                        boolFirstChoice = true;
                    }
                }
                if (!boolThirdChoice) {
                    userFirstCookieCount++;
                }
            }
        });

        cookieMenuBeta = new CButton(25, 237, 258, 32);
        cookieMenuBeta.setImage(secondMenuCookiePath);
        cookieMenuBeta.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieBeta = new CLabel(65, 237, 218, 32);
        lblCookieBeta.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieBeta.setText(secondMenuCookieText);
        lblCookieBeta.setVisible(false);
        cookieMenuBeta.setVisible(false);
        cookieMenuBeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!boolThirdChoice) {
                    if (boolFirstChoice) {
                        if (boolSecondChoice) {
                            lblUserThirdCookie.setImage(thoughtBubblePath2);
                            lblUserThirdCookie.setVisible(true);
                            boolThirdChoice = true;
                            userSecondCookieCount++;
                        } else {
                            lblUserSecondCookie.setImage(thoughtBubblePath2);
                            lblUserSecondCookie.setVisible(true);
                            boolSecondChoice = true;
                        }
                    } else {
                        lblUserFirstCookie.setImage(thoughtBubblePath2);
                        lblUserFirstCookie.setVisible(true);
                        boolFirstChoice = true;
                    }
                }
                if (!boolThirdChoice) {
                    userSecondCookieCount++;
                }
            }
        });

        cookieMenuCharlie = new CButton(25, 308, 258, 32);
        cookieMenuCharlie.setImage(thirdMenuCookiePath);
        cookieMenuCharlie.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieCharlie = new CLabel(65, 308, 218, 32);
        lblCookieCharlie.setHorizontalAlignment(SwingConstants.LEFT);
        lblCookieCharlie.setText(thirdMenuCookieText);
        lblCookieCharlie.setVisible(false);
        cookieMenuCharlie.setVisible(false);
        cookieMenuCharlie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!boolThirdChoice) {
                    if (boolFirstChoice) {
                        if (boolSecondChoice) {
                            lblUserThirdCookie.setImage(thoughtBubblePath3);
                            lblUserThirdCookie.setVisible(true);
                            boolThirdChoice = true;
                            userThirdCookieCount++;
                        } else {
                            lblUserSecondCookie.setImage(thoughtBubblePath3);
                            lblUserSecondCookie.setVisible(true);
                            boolSecondChoice = true;
                        }
                    } else {
                        lblUserFirstCookie.setImage(thoughtBubblePath3);
                        lblUserFirstCookie.setVisible(true);
                        boolFirstChoice = true;
                    }
                }
                if (!boolThirdChoice) {
                    userThirdCookieCount++;
                }
            }
        });

        clear = new CButton(200, 537, 100, 50);
        clear.setImage("/images/clear.png");
        clear.setVisible(false);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblUserFirstCookie.setVisible(false);
                lblUserSecondCookie.setVisible(false);
                lblUserThirdCookie.setVisible(false);
                boolFirstChoice = false;
                boolSecondChoice = false;
                boolThirdChoice = false;
                userFirstCookieCount = 0;
                userSecondCookieCount = 0;
                userThirdCookieCount = 0;
            }
        });

        submit = new CButton(500, 537, 100, 50);
        submit.setImage("/images/submit.png");
        submit.setVisible(false);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (customerFirstCookieCount == userFirstCookieCount && customerSecondCookieCount == userSecondCookieCount && customerThirdCookieCount == userThirdCookieCount) {
                    wrong.setVisible(false);
                    miniGameRoundCounter++;
                    customerFirstCookieCount = 0;
                    customerSecondCookieCount = 0;
                    customerThirdCookieCount = 0;
                    lblUserFirstCookie.setVisible(false);
                    lblUserSecondCookie.setVisible(false);
                    lblUserThirdCookie.setVisible(false);
                    boolFirstChoice = false;
                    boolSecondChoice = false;
                    boolThirdChoice = false;
                    userFirstCookieCount = 0;
                    userSecondCookieCount = 0;
                    userThirdCookieCount = 0;
                    if (miniGameRoundCounter == 2) {
                        Cookie.getGV().goToProfitScreen();
                        miniGameRoundCounter = 0;
                       // Cookie.getGV().setProfit(Cookie.getGV().calcProfit());
                        Cookie.getGV().setPreviousTotal(Cookie.getGV().getCurrentTotal());
                        
                        
                        Cookie.getGV().setWeekDecayCounter(Cookie.getGV().getWeekDecayCounter() + 1);
                        //LocationWeekDecay counting
                        if(Cookie.getGV().getWeekDecayCounter() >= 9 && Cookie.getGV().getCurrentTotal() > 15){
                            Cookie.getGV().setProfit(Cookie.getGV().calcProfit()-15.0);
                            
                        }
                        else if(Cookie.getGV().getWeekDecayCounter() >= 5 && Cookie.getGV().getCurrentTotal() > 5){
                            Cookie.getGV().setProfit(Cookie.getGV().calcProfit()-5.0);
                        }
                        else{
                            Cookie.getGV().setProfit(Cookie.getGV().calcProfit());
                        }
                        
                        Cookie.getGV().setWeekDecayCounter(Cookie.getGV().getWeekDecayCounter() + 1);
                        Cookie.getGV().setProfit(Cookie.getGV().calcProfit());
                        if (Cookie.getRE().isRandomEventActive()) {
                            if (Cookie.getGV().getSpecialEventCounter() >= Cookie.getGV().getCurrentWeek() - 1) {
                                Cookie.getGV().setProfit(Cookie.getGV().calcProfit() + 25.00);
                            } else if (Cookie.getGV().getCurrentTotal() > 25) {
                                Cookie.getGV().setProfit(Cookie.getGV().calcProfit() - 25.00);
                            }
                        }
                        Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() + Cookie.getGV().getProfit());
                        Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                        Cookie.getPS().getTitle().setText("0");
                        Cookie.getPS().getLastWeekTotal().setText("Last Week's Total:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getPreviousTotal()));
                    } else {
                        generateCustomerOrder();
                    }
                } else {
                    wrong.setVisible(true);
                }
            }
        });

        wrong = new CLabel(375, 537, 50, 50);
        wrong.setImage("/images/redX.png");
        wrong.setVisible(false);
    }

    public void generateCustomerOrder() {
        for (int i = 0; i < 3; i++) {
            int r = (int) (Math.random() * 3 + 1);
            switch (r) {
                case 1:
                    customerFirstCookieCount++;
                    customerOrderPath[i] = thoughtBubblePath1;
                    break;
                case 2:
                    customerSecondCookieCount++;
                    customerOrderPath[i] = thoughtBubblePath2;
                    break;
                default:
                    customerThirdCookieCount++;
                    customerOrderPath[i] = thoughtBubblePath3;
                    break;
            }
        }
        lblCustomerFirstCookie.setImage(customerOrderPath[0]);
        lblCustomerSecondCookie.setImage(customerOrderPath[1]);
        lblCustomerThirdCookie.setImage(customerOrderPath[2]);
        int s = (int) (Math.random() * 8 + 1);
        switch (s) {
            case 1:
                customer.setImage(firstCustomerPath);
                break;
            case 2:
                customer.setImage(secondCustomerPath);
                break;
            case 3:
                customer.setImage(thirdCustomerPath);
                break;
            case 4:
                customer.setImage(fourthCustomerPath);
                break;
            case 5:
                customer.setImage(fifthCustomerPath);
                break;
            case 6:
                customer.setImage(sixthCustomerPath);
                break;
            case 7:
                customer.setImage(seventhCustomerPath);
                break;
            default:
                customer.setImage(eighthCustomerPath);
                break;
        }
    }

    // GETTERS AND SETTERS
    public CLabel getMiniGameBackground() {
        return miniGameBackground;
    }

    public CLabel getScenery() {
        return scenery;
    }

    public CLabel getLblCustomerFirstCookie() {
        return lblCustomerFirstCookie;
    }

    public CLabel getLblCustomerSecondCookie() {
        return lblCustomerSecondCookie;
    }

    public CLabel getLblCustomerThirdCookie() {
        return lblCustomerThirdCookie;
    }

    public CLabel getLblUserFirstCookie() {
        return lblUserFirstCookie;
    }

    public CLabel getLblUserSecondCookie() {
        return lblUserSecondCookie;
    }

    public CLabel getLblUserThirdCookie() {
        return lblUserThirdCookie;
    }

    public CLabel getCustomer() {
        return customer;
    }

    public CLabel getThoughtBubble() {
        return thoughtBubble;
    }

    public CButton getCookieMenuAlpha() {
        return cookieMenuAlpha;
    }

    public CButton getCookieMenuBeta() {
        return cookieMenuBeta;
    }

    public CButton getCookieMenuCharlie() {
        return cookieMenuCharlie;
    }

    public CLabel getLblCookieAlpha() {
        return lblCookieAlpha;
    }

    public CLabel getLblCookieBeta() {
        return lblCookieBeta;
    }

    public CLabel getLblCookieCharlie() {
        return lblCookieCharlie;
    }

    public CButton getClear() {
        return clear;
    }

    public CButton getSubmit() {
        return submit;
    }

    public CLabel getWrong() {
        return wrong;
    }

    public String getFirstMenuCookiePath() {
        return firstMenuCookiePath;
    }

    public String getSecondMenuCookiePath() {
        return secondMenuCookiePath;
    }

    public String getThirdMenuCookiePath() {
        return thirdMenuCookiePath;
    }

    public String getFourthMenuCookiePath() {
        return fourthMenuCookiePath;
    }

    public String getFifthMenuCookiePath() {
        return fifthMenuCookiePath;
    }

    public String getSixthMenuCookiePath() {
        return sixthMenuCookiePath;
    }

    public String getSeventhMenuCookiePath() {
        return seventhMenuCookiePath;
    }

    public String getEighthMenuCookiePath() {
        return eighthMenuCookiePath;
    }

    public String getFirstMenuCookieText() {
        return firstMenuCookieText;
    }

    public String getSecondMenuCookieText() {
        return secondMenuCookieText;
    }

    public String getThirdMenuCookieText() {
        return thirdMenuCookieText;
    }

    public String getFourthMenuCookieText() {
        return fourthMenuCookieText;
    }

    public String getFifthMenuCookieText() {
        return fifthMenuCookieText;
    }

    public String getSixthMenuCookieText() {
        return sixthMenuCookieText;
    }

    public String getSeventhMenuCookieText() {
        return seventhMenuCookieText;
    }

    public String getEighthMenuCookieText() {
        return eighthMenuCookieText;
    }

    public String getFirstCustomerPath() {
        return firstCustomerPath;
    }

    public String getSecondCustomerPath() {
        return secondCustomerPath;
    }

    public String getThirdCustomerPath() {
        return thirdCustomerPath;
    }

    public String getFourthCustomerPath() {
        return fourthCustomerPath;
    }

    public String getFifthCustomerPath() {
        return fifthCustomerPath;
    }

    public String getSixthCustomerPath() {
        return sixthCustomerPath;
    }

    public String getSeventhCustomerPath() {
        return seventhCustomerPath;
    }

    public String getEighthCustomerPath() {
        return eighthCustomerPath;
    }

    public int getMiniGameRoundCounter() {
        return miniGameRoundCounter;
    }

    public void setMiniGameRoundCounter(int mgrc) {
        miniGameRoundCounter = mgrc;
    }

    public int getCustomerFirstCookieCount() {
        return customerFirstCookieCount;
    }

    public void setCustomerFirstCookieCount(int cfcc) {
        customerFirstCookieCount = cfcc;
    }

    public int getCustomerSecondCookieCount() {
        return customerSecondCookieCount;
    }

    public void setCustomerSecondCookieCount(int cscc) {
        customerSecondCookieCount = cscc;
    }

    public int getCustomerThirdCookieCount() {
        return customerThirdCookieCount;
    }

    public void setCustomerThirdCookieCount(int ctcc) {
        customerThirdCookieCount = ctcc;
    }

    public int getUserFirstCookieCount() {
        return userFirstCookieCount;
    }

    public void setUserFirstCookieCount(int ufcc) {
        userFirstCookieCount = ufcc;
    }

    public int getUserSecondCookieCount() {
        return userFirstCookieCount;
    }

    public void setUserSecondCookieCount(int uscc) {
        userSecondCookieCount = uscc;
    }

    public int getUserThirdCookieCount() {
        return userThirdCookieCount;
    }

    public void setUserThirdCookieCount(int utcc) {
        userThirdCookieCount = utcc;
    }

    public boolean getBoolFirstChoice() {
        return boolFirstChoice;
    }

    public void setBoolFirstChoice(boolean bfc) {
        boolFirstChoice = bfc;
    }

    public boolean getBoolSecondChoice() {
        return boolSecondChoice;
    }

    public void setBoolSecondChoice(boolean bsc) {
        boolSecondChoice = bsc;
    }

    public boolean getBoolThirdChoice() {
        return boolThirdChoice;
    }

    public void setBoolThirdChoice(boolean btc) {
        boolThirdChoice = btc;
    }

    public String getCustomerOrderPath1() {
        return customerOrderPath[0];
    }

    public String getCustomerOrderPath2() {
        return customerOrderPath[1];
    }

    public String getCustomerOrderPath3() {
        return customerOrderPath[2];
    }

    public void setCustomerOrderPath1(String cop1) {
        customerOrderPath[0] = cop1;
    }

    public void setCustomerOrderPath2(String cop2) {
        customerOrderPath[1] = cop2;
    }

    public void setCustomerOrderPath3(String cop3) {
        customerOrderPath[2] = cop3;
    }

    public String getThoughtBubblePath1() {
        return thoughtBubblePath1;
    }

    public String getThoughtBubblePath2() {
        return thoughtBubblePath2;
    }

    public String getThoughtBubblePath3() {
        return thoughtBubblePath3;
    }

    public void setThoughtBubblePath1(String tbp1) {
        thoughtBubblePath1 = tbp1;
    }

    public void setThoughtBubblePath2(String tbp2) {
        thoughtBubblePath2 = tbp2;
    }

    public void setThoughtBubblePath3(String tbp3) {
        thoughtBubblePath3 = tbp3;
    }
    
    public String getFirstSceneryPath() {
        return firstSceneryPath;
    }
    
    public String getSecondSceneryPath() {
        return secondSceneryPath;
    }
    
    public String getThirdSceneryPath() {
        return thirdSceneryPath;
    }
    
    public String getFourthSceneryPath() {
        return fourthSceneryPath;
    }
}
