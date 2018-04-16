package cookie;

import java.awt.event.*;

public class UpgradeScreen {

    private CButton upgradeCookies;
    private CButton upgradeSign;
    private CButton upgradeLocation;
    private CButton miniGameMenuButton;

    private CLabel upgradeScreenBackground;
    private CLabel displayCookie1;
    private CLabel displayCookie2;
    private CLabel displayCookie3;
    private CLabel displayCookie4;
    private CLabel displayCookie5;
    private CLabel displayCookie6;
    private CLabel displayCookie7;
    private CLabel displayCookie8;

    private CLabel displaySign1;
    private CLabel displaySign2;
    private CLabel displaySign3;

    private CLabel displayLocation1;
    private CLabel displayLocation2;
    private CLabel displayLocation3;

    private CLabel unlockC1;
    private CLabel unlockC2;
    private CLabel unlockC3;
    private CLabel unlockC4;
    private CLabel unlockC5;
    private CLabel unlockC6;
    private CLabel unlockC7;
    private CLabel unlockC8;

    private CLabel unlockS1;
    private CLabel unlockS2;
    private CLabel unlockS3;

    private CLabel unlockL1;
    private CLabel unlockL2;
    private CLabel unlockL3;

    private CLabel priceCookie4;
    private CLabel priceCookie5;
    private CLabel priceCookie6;
    private CLabel priceCookie7;
    private CLabel priceCookie8;

    private CLabel priceSign1;
    private CLabel priceSign2;
    private CLabel priceSign3;

    private CLabel priceLocation1;
    private CLabel priceLocation2;
    private CLabel priceLocation3;
    
    private CLabel jar;
    private CLabel greenBar;
    private CLabel pinkBar;
    private CLabel unicorn;

    private int cookieUpgradeCounter = 3;
    private int signUpgradeCounter = 1;
    private int locationUpgradeCounter = 1;

    private final double cookie4Price = 25;
    private final double cookie5Price = 40;
    private final double cookie6Price = 60;
    private final double cookie7Price = 80;
    private final double cookie8Price = 100;
    
    private final double sign2Price = 30;
    private final double sign3Price = 60;
    
    private final double location2Price = 125;
    private final double location3Price = 175;
    

    public UpgradeScreen() {
        upgradeScreenBackground = new CLabel(0, 0, 800, 600);
        upgradeScreenBackground.setImage("/images/upgradeScreenBackground.png");
        upgradeScreenBackground.setVisible(false);

        upgradeCookies = new CButton(20, 95, 100, 30);
        upgradeCookies.setImage("/images/upgrade.png");
        upgradeCookies.setVisible(false);
        upgradeCookies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                switch (cookieUpgradeCounter) {
                    case 3:
                        if (Cookie.getGV().getCurrentTotal() >= cookie4Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setCookie4Unlocked(true);
                            unlockC4.setVisible(true);
                            priceCookie4.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - cookie4Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().setCookieA(Cookie.getGV().getCookie4());
                            Cookie.getMGS().getCookieMenuAlpha().setImage(Cookie.getMGS().getFourthMenuCookiePath());
                            Cookie.getMGS().setThoughtBubblePath1(Cookie.getMGS().getFourthMenuCookiePath());
                            Cookie.getMGS().getLblCookieAlpha().setText(Cookie.getMGS().getFourthMenuCookieText());
                            cookieUpgradeCounter++;
                        }
                        break;
                    case 4:
                        if (Cookie.getGV().getCurrentTotal() > cookie5Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setCookie5Unlocked(true);
                            unlockC5.setVisible(true);
                            priceCookie5.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - cookie5Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().setCookieA(Cookie.getGV().getCookie5());
                            Cookie.getMGS().getCookieMenuBeta().setImage(Cookie.getMGS().getFifthMenuCookiePath());
                            Cookie.getMGS().setThoughtBubblePath2(Cookie.getMGS().getFifthMenuCookiePath());
                            Cookie.getMGS().getLblCookieBeta().setText(Cookie.getMGS().getFifthMenuCookieText());
                            cookieUpgradeCounter++;
                        }
                        break;
                    case 5:
                        if (Cookie.getGV().getCurrentTotal() > cookie6Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setCookie6Unlocked(true);
                            unlockC6.setVisible(true);
                            priceCookie6.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - cookie6Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().setCookieA(Cookie.getGV().getCookie6());
                            Cookie.getMGS().getCookieMenuCharlie().setImage(Cookie.getMGS().getSixthMenuCookiePath());
                            Cookie.getMGS().setThoughtBubblePath3(Cookie.getMGS().getSixthMenuCookiePath());
                            Cookie.getMGS().getLblCookieCharlie().setText(Cookie.getMGS().getSixthMenuCookieText());
                            cookieUpgradeCounter++;
                        }
                        break;
                    case 6:
                        if (Cookie.getGV().getCurrentTotal() > cookie7Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setCookie7Unlocked(true);
                            unlockC7.setVisible(true);
                            priceCookie7.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - cookie7Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().setCookieA(Cookie.getGV().getCookie7());
                            Cookie.getMGS().getCookieMenuAlpha().setImage(Cookie.getMGS().getSeventhMenuCookiePath());
                            Cookie.getMGS().setThoughtBubblePath1(Cookie.getMGS().getSeventhMenuCookiePath());
                            Cookie.getMGS().getLblCookieAlpha().setText(Cookie.getMGS().getSeventhMenuCookieText());
                            cookieUpgradeCounter++;
                        }
                        break;
                    case 7:
                        if (Cookie.getGV().getCurrentTotal() > cookie8Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setCookie8Unlocked(true);
                            unlockC8.setVisible(true);
                            priceCookie8.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - cookie8Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().setCookieA(Cookie.getGV().getCookie8());
                            Cookie.getMGS().getCookieMenuBeta().setImage(Cookie.getMGS().getEighthMenuCookiePath());
                            Cookie.getMGS().setThoughtBubblePath2(Cookie.getMGS().getEighthMenuCookiePath());
                            Cookie.getMGS().getLblCookieBeta().setText(Cookie.getMGS().getEighthMenuCookieText());
                            cookieUpgradeCounter++;
                        }
                        break;
                }
            }
        });

        upgradeSign = new CButton(20, 245, 100, 30);
        upgradeSign.setImage("/images/upgrade.png");
        upgradeSign.setVisible(false);
        upgradeSign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (signUpgradeCounter) {
                    case 1:
                        if (Cookie.getGV().getCurrentTotal() >= sign2Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setSign2Unlocked(true);
                            Cookie.getGV().setActiveStand(Cookie.getGV().getStand2());
                            unlockS2.setVisible(true);
                            priceSign2.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - sign2Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().getSign().setImage(Cookie.getGV().getSign2Path());
                            signUpgradeCounter++;
                        }
                        break;
                    case 2:
                        if (Cookie.getGV().getCurrentTotal() >= sign3Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setSign3Unlocked(true);
                            Cookie.getGV().setActiveStand(Cookie.getGV().getStand3());
                            unlockS3.setVisible(true);
                            priceSign3.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - sign3Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getGV().getSign().setImage(Cookie.getGV().getSign3Path());
                            signUpgradeCounter++;
                        }
                        break;
                }
            }
        });

        upgradeLocation = new CButton(20, 395, 100, 30);
        upgradeLocation.setImage("/images/upgrade.png");
        upgradeLocation.setVisible(false);
        upgradeLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (locationUpgradeCounter) {
                    case 1:
                        if (Cookie.getGV().getCurrentTotal() >= location2Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setLocation2Unlocked(true);
                            Cookie.getGV().setActiveLocation(Cookie.getGV().getLocation2());
                            unlockL2.setVisible(true);
                            priceLocation2.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - location2Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getMGS().getScenery().setImage(Cookie.getMGS().getSecondSceneryPath());
                            locationUpgradeCounter++;
                            Cookie.getGV().setWeekDecayCounter(0);
                        }
                        break;
                    case 2:
                        if (Cookie.getGV().getCurrentTotal() >= location3Price) {
                            Cookie.getGV().setSpecialEventCounter(Cookie.getGV().getSpecialEventCounter() + 1);
                            Cookie.getGV().setLocation3Unlocked(true);
                            Cookie.getGV().setActiveLocation(Cookie.getGV().getLocation3());
                            unlockL3.setVisible(true);
                            priceLocation3.setVisible(false);
                            Cookie.getGV().setCurrentTotal(Cookie.getGV().getCurrentTotal() - location3Price);
                            Cookie.getGV().getBank().setText("Bank:" + Cookie.getGV().getCurrencyFormat().format(Cookie.getGV().getCurrentTotal()));
                            Cookie.getMGS().getScenery().setImage(Cookie.getMGS().getThirdSceneryPath());
                            locationUpgradeCounter++;
                            Cookie.getGV().setWeekDecayCounter(0);
                        }
                        break;
                }
            }
        });

        miniGameMenuButton = new CButton(275, 545, 250, 35);
        miniGameMenuButton.setImage("/images/beginNW.png");
        miniGameMenuButton.setVisible(false);
        miniGameMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Cookie.getGV().getCurrentWeek() == 4 || Cookie.getGV().getCurrentWeek() == 9) {
                    Cookie.getGV().goToRandomEvent();
                    Cookie.getGV().setCurrentWeek(Cookie.getGV().getCurrentWeek() + 1);
                    Cookie.getGV().getCalendar().setText("Week: " + Integer.toString(Cookie.getGV().getCurrentWeek()));
                } else {
                    Cookie.getMGS().generateCustomerOrder();
                    Cookie.getGV().setCurrentWeek(Cookie.getGV().getCurrentWeek() + 1);
                    Cookie.getGV().goToMiniGameScreen();
                    Cookie.getGV().getCalendar().setText("Week: " + Integer.toString(Cookie.getGV().getCurrentWeek()));
                    if (locationUpgradeCounter == 1) {
                        Cookie.getMGS().getScenery().setImage(Cookie.getMGS().getFirstSceneryPath());
                    } else if (locationUpgradeCounter == 2) {
                        Cookie.getMGS().getScenery().setImage(Cookie.getMGS().getSecondSceneryPath());
                    } else {
                        Cookie.getMGS().getScenery().setImage(Cookie.getMGS().getThirdSceneryPath());
                    }
                }
                
            }
        });

        displayCookie1 = new CLabel(140, 95, 32, 32);
        displayCookie1.setImage(Cookie.getMGS().getFirstMenuCookiePath());
        displayCookie1.setVisible(false);

        displayCookie2 = new CLabel(305, 95, 32, 32);
        displayCookie2.setImage(Cookie.getMGS().getSecondMenuCookiePath());
        displayCookie2.setVisible(false);

        displayCookie3 = new CLabel(470, 95, 32, 32);
        displayCookie3.setImage(Cookie.getMGS().getThirdMenuCookiePath());
        displayCookie3.setVisible(false);

        displayCookie4 = new CLabel(635, 95, 32, 32);
        displayCookie4.setImage(Cookie.getMGS().getFourthMenuCookiePath());
        displayCookie4.setVisible(false);

        displayCookie5 = new CLabel(140, 170, 32, 32);
        displayCookie5.setImage(Cookie.getMGS().getFifthMenuCookiePath());
        displayCookie5.setVisible(false);

        displayCookie6 = new CLabel(305, 170, 32, 32);
        displayCookie6.setImage(Cookie.getMGS().getSixthMenuCookiePath());
        displayCookie6.setVisible(false);

        displayCookie7 = new CLabel(470, 170, 32, 32);
        displayCookie7.setImage(Cookie.getMGS().getSeventhMenuCookiePath());
        displayCookie7.setVisible(false);

        displayCookie8 = new CLabel(635, 170, 32, 32);
        displayCookie8.setImage(Cookie.getMGS().getEighthMenuCookiePath());
        displayCookie8.setVisible(false);

        displaySign1 = new CLabel(140, 245, 200, 50);
        displaySign1.setImage("/images/sign1.png");
        displaySign1.setVisible(false);

        displaySign2 = new CLabel(360, 245, 200, 50);
        displaySign2.setImage("/images/sign2.png");
        displaySign2.setVisible(false);

        displaySign3 = new CLabel(580, 245, 200, 50);
        displaySign3.setImage("/images/sign3.png");
        displaySign3.setVisible(false);

        displayLocation1 = new CLabel(140, 395, 75, 75);
        displayLocation1.setImage("/images/road.png");
        displayLocation1.setVisible(false);

        displayLocation2 = new CLabel(360, 395, 75, 75);
        displayLocation2.setImage("/images/house.png");
        displayLocation2.setVisible(false);

        displayLocation3 = new CLabel(580, 395, 75, 75);
        displayLocation3.setImage("/images/tree.png");
        displayLocation3.setVisible(false);

        unlockC1 = new CLabel(196, 105, 84, 11);
        unlockC1.setImage("/images/unlocked.png");
        unlockC1.setVisible(false);

        unlockC2 = new CLabel(361, 105, 84, 11);
        unlockC2.setImage("/images/unlocked.png");
        unlockC2.setVisible(false);

        unlockC3 = new CLabel(526, 105, 84, 11);
        unlockC3.setImage("/images/unlocked.png");
        unlockC3.setVisible(false);

        unlockC4 = new CLabel(691, 105, 84, 11);
        unlockC4.setImage("/images/unlocked.png");
        unlockC4.setVisible(false);

        unlockC5 = new CLabel(196, 180, 84, 11);
        unlockC5.setImage("/images/unlocked.png");
        unlockC5.setVisible(false);

        unlockC6 = new CLabel(361, 180, 84, 11);
        unlockC6.setImage("/images/unlocked.png");
        unlockC6.setVisible(false);

        unlockC7 = new CLabel(526, 180, 84, 11);
        unlockC7.setImage("/images/unlocked.png");
        unlockC7.setVisible(false);

        unlockC8 = new CLabel(691, 180, 84, 11);
        unlockC8.setImage("/images/unlocked.png");
        unlockC8.setVisible(false);

        unlockS1 = new CLabel(198, 310, 84, 11);
        unlockS1.setImage("/images/unlocked.png");
        unlockS1.setVisible(false);

        unlockS2 = new CLabel(418, 310, 84, 11);
        unlockS2.setImage("/images/unlocked.png");
        unlockS2.setVisible(false);

        unlockS3 = new CLabel(638, 310, 84, 11);
        unlockS3.setImage("/images/unlocked.png");
        unlockS3.setVisible(false);

        unlockL1 = new CLabel(220, 427, 84, 11);
        unlockL1.setImage("/images/unlocked.png");
        unlockL1.setVisible(false);

        unlockL2 = new CLabel(440, 427, 84, 11);
        unlockL2.setImage("/images/unlocked.png");
        unlockL2.setVisible(false);

        unlockL3 = new CLabel(660, 427, 84, 11);
        unlockL3.setImage("/images/unlocked.png");
        unlockL3.setVisible(false);

        priceCookie4 = new CLabel(691, 94, 84, 32);
        priceCookie4.setText(Cookie.getGV().getCurrencyFormat().format(cookie4Price));
        priceCookie4.setVisible(false);

        priceCookie5 = new CLabel(196, 169, 84, 32);
        priceCookie5.setText(Cookie.getGV().getCurrencyFormat().format(cookie5Price));
        priceCookie5.setVisible(false);

        priceCookie6 = new CLabel(361, 169, 84, 32);
        priceCookie6.setText(Cookie.getGV().getCurrencyFormat().format(cookie6Price));
        priceCookie6.setVisible(false);

        priceCookie7 = new CLabel(526, 169, 84, 32);
        priceCookie7.setText(Cookie.getGV().getCurrencyFormat().format(cookie7Price));
        priceCookie7.setVisible(false);

        priceCookie8 = new CLabel(691, 169, 84, 32);
        priceCookie8.setText(Cookie.getGV().getCurrencyFormat().format(cookie8Price));
        priceCookie8.setVisible(false);

        priceSign1 = new CLabel(198, 299, 84, 32);
        priceSign1.setText("$10.00");
        priceSign1.setVisible(false);

        priceSign2 = new CLabel(418, 299, 84, 32);
        priceSign2.setText(Cookie.getGV().getCurrencyFormat().format(sign2Price));
        priceSign2.setVisible(false);

        priceSign3 = new CLabel(638, 299, 84, 32);
        priceSign3.setText(Cookie.getGV().getCurrencyFormat().format(sign3Price));
        priceSign3.setVisible(false);

        priceLocation2 = new CLabel(440, 416, 84, 32);
        priceLocation2.setText(Cookie.getGV().getCurrencyFormat().format(location2Price));
        priceLocation2.setVisible(false);

        priceLocation3 = new CLabel(660, 416, 84, 32);
        priceLocation3.setText(Cookie.getGV().getCurrencyFormat().format(location3Price));
        priceLocation3.setVisible(false);
        
        jar = new CLabel(265, 0, 60, 75);
        jar.setImage("/images/jar.png");
        jar.setVisible(false);
        
        unicorn = new CLabel(490, 0, 76, 75);
        unicorn.setImage("/images/unicorn.png");
        unicorn.setVisible(false);
        
        greenBar = new CLabel(335, 25, 140, 25);
        greenBar.setImage("/images/green.png");
        greenBar.setVisible(false);
        
        pinkBar = new CLabel(335, 25, 140, 25);
        pinkBar.setImage("/images/pink.png");
        pinkBar.setVisible(false);
    }

    public CButton getUpgradeCookies() {
        return upgradeCookies;
    }

    public CButton getUpgradeSign() {
        return upgradeSign;
    }

    public CButton getUpgradeLocation() {
        return upgradeLocation;
    }

    public CButton getMiniGameMenuButton() {
        return miniGameMenuButton;
    }

    public CLabel getUpgradeScreenBackground() {
        return upgradeScreenBackground;
    }

    public CLabel getDisplayCookie1() {
        return displayCookie1;
    }

    public CLabel getDisplayCookie2() {
        return displayCookie2;
    }

    public CLabel getDisplayCookie3() {
        return displayCookie3;
    }

    public CLabel getDisplayCookie4() {
        return displayCookie4;
    }

    public CLabel getDisplayCookie5() {
        return displayCookie5;
    }

    public CLabel getDisplayCookie6() {
        return displayCookie6;
    }

    public CLabel getDisplayCookie7() {
        return displayCookie7;
    }

    public CLabel getDisplayCookie8() {
        return displayCookie8;
    }

    public CLabel getDisplaySign1() {
        return displaySign1;
    }

    public CLabel getDisplaySign2() {
        return displaySign2;
    }

    public CLabel getDisplaySign3() {
        return displaySign3;
    }

    public CLabel getDisplayLocation1() {
        return displayLocation1;
    }

    public CLabel getDisplayLocation2() {
        return displayLocation2;
    }

    public CLabel getDisplayLocation3() {
        return displayLocation3;
    }

    public CLabel getUnlockC1() {
        return unlockC1;
    }

    public CLabel getUnlockC2() {
        return unlockC2;
    }

    public CLabel getUnlockC3() {
        return unlockC3;
    }

    public CLabel getUnlockC4() {
        return unlockC4;
    }

    public CLabel getUnlockC5() {
        return unlockC5;
    }

    public CLabel getUnlockC6() {
        return unlockC6;
    }

    public CLabel getUnlockC7() {
        return unlockC7;
    }

    public CLabel getUnlockC8() {
        return unlockC8;
    }

    public CLabel getUnlockS1() {
        return unlockS1;
    }

    public CLabel getUnlockS2() {
        return unlockS2;
    }

    public CLabel getUnlockS3() {
        return unlockS3;
    }

    public CLabel getUnlockL1() {
        return unlockL1;
    }

    public CLabel getUnlockL2() {
        return unlockL2;
    }

    public CLabel getUnlockL3() {
        return unlockL3;
    }

    public CLabel getPriceCookie4() {
        return priceCookie4;
    }

    public CLabel getPriceCookie5() {
        return priceCookie5;
    }

    public CLabel getPriceCookie6() {
        return priceCookie6;
    }

    public CLabel getPriceCookie7() {
        return priceCookie7;
    }

    public CLabel getPriceCookie8() {
        return priceCookie8;
    }

    public CLabel getPriceSign1() {
        return priceSign1;
    }

    public CLabel getPriceSign2() {
        return priceSign2;
    }

    public CLabel getPriceSign3() {
        return priceSign3;
    }

    public CLabel getPriceLocation1() {
        return priceLocation1;
    }

    public CLabel getPriceLocation2() {
        return priceLocation2;
    }

    public CLabel getPriceLocation3() {
        return priceLocation3;
    }
    
    public int getSignUpgradeCounter() {
        return signUpgradeCounter;
    }
    
    public int getLocationUpgradeCounter() {
        return locationUpgradeCounter;
    }
    
    public CLabel getJar() {
        return jar;
    }
    
    public CLabel getUnicorn() {
        return unicorn;
    }
    
    public CLabel getGreenBar() {
        return greenBar;
    }
    
    public CLabel getPinkBar() {
        return pinkBar;
    }
}
