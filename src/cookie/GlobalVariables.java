package cookie;

import java.text.NumberFormat;
import java.awt.*;
import javax.swing.ImageIcon;

public class GlobalVariables {

    // GLOBAL BECAUSE THEY TRANSCEND MORE THAN ONE SCREEN (MINIGAME, PROFIT, UPGRADE, ETC.)
    private CFrame frame; // THE FRAME
    private CLabel bank; // THE COMPONTENT TO SHOW THE USER'S CURRENT MONEY IN THE TOP LEFT CORNER
    private CLabel sign; // THE COMPONENT TO SHOW THE CURRENT SIGN IN THE CENTER OF THE TOP
    private CLabel calendar; // THE COMPONENT TO SHOW THE CURRENT WEEK IN THE TOP RIGHT CORNER

    // PRICES OF EACH COOKIE
    private final double cookie1 = 1; // DO-SI-DO
    private final double cookie2 = 1; // SAVANNAH SMILE
    private final double cookie3 = 1; // CHOCO CHIP
    private final double cookie4 = 2; // THICK MINT
    private final double cookie5 = 3; // BUCK-EYE
    private final double cookie6 = 4; // PECAN SANDY
    private final double cookie7 = 5; // COCONUT SUPREME
    private final double cookie8 = 6; // SMORE BITES

    // KEEP TRACK OF THE DIFFERENT STANDS
    private final int stand1 = 0; // INITIAL STAND
    private final int stand2 = 1; // FIRST UPGRADABLE STAND
    private final int stand3 = 2; // FINAL UPGRADABLE STAND

    // THE LOCATION MATRIX
    private final int location1[] = {1, 2, 3, 4, 5, 6};
    private final int location2[] = {4, 5, 6, 7, 8, 9};
    private final int location3[] = {7, 8, 9, 10, 11, 12};

    private final String sign1Path = "/images/sign1.png";
    private final String sign2Path = "/images/sign2.png";
    private final String sign3Path = "/images/sign3.png";
    
    // DISPLAY MONEY WITH DOLLAR SIGN, DECIMAL, AND 2 DECIMAL PLACES
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    // GENERAL GLOBAL VARIABLES
    private int difficulty; // KEEP TRACK OF THE SELECTED DIFFICULTY
    private double profit; // KEEP TRACK OF THE PROFIT
    private double previousTotal; // KEEP TRACK OF LAST WEEK'S TOTAL
    private double currentTotal; // KEEP TRACK OF THE USER'S CURRENT BALANCE
    private double endGoal; // KEEP TRACK OF THE END GOAL
    private int currentWeek; // KEEP TRACK OF THE CURRENT WEEK

    // MAKE CALCULATIONS ONLY WITH THESE CURRENT UNLOCKED COOKIES
    private double cookieA; // KEEP TRACK OF THE VALUE OF THE FIRST COOKIE (COOKIE ALPHA)
    private double cookieB; // KEEP TRACK OF THE VALUE OF THE SECOND COOKIE (COOKIE BETA)
    private double cookieC; // KEEP TRACK OF THE VALUE OF THE THIRD COOKIE (COOKIE CHARLIE)

    // CURRENT STAND AND LOCATION
    private int activeStand;
    private int[] activeLocation;
    
    private boolean cookie1Unlocked = true;
    private boolean cookie2Unlocked = true;
    private boolean cookie3Unlocked = true;
    private boolean cookie4Unlocked = false;
    private boolean cookie5Unlocked = false;
    private boolean cookie6Unlocked = false;
    private boolean cookie7Unlocked = false;
    private boolean cookie8Unlocked = false;
    
    private boolean sign1Unlocked = true;
    private boolean sign2Unlocked = false;
    private boolean sign3Unlocked = false;
    
    private boolean location1Unlocked = true;
    private boolean location2Unlocked = false;
    private boolean location3Unlocked = false;
    
    private int specialEventCounter = 0;

    private int weekDecayCounter = 0;
    
    private double progress = 1;
    
    // CONSTRUCTOR
    public GlobalVariables() {
        // INITIALIZE VARIABLES
        profit = 0;
        currentWeek = 1;
        activeStand = 0;
        activeLocation = location1;

        // DEFAULT THE CURRENT COOKIES TO THE FIRST THREE COOKIES
        cookieA = cookie1;
        cookieB = cookie2;
        cookieC = cookie3;

        // CREATE COMPONENTS
        frame = new CFrame("Cookie Scout");

        sign = new CLabel(250, 0, 300, 75);
        sign.setImage(sign1Path);
        sign.setVisible(false);

        calendar = new CLabel(550, 5, 250, 75);
        calendar.setForeground(Color.white);
        calendar.setText("Week: " + Integer.toString(currentWeek));
        calendar.setVisible(false);

        bank = new CLabel(0, 5, 250, 75);
        bank.setForeground(Color.white);
        bank.setText("Bank:" + currencyFormat.format(currentTotal));
        bank.setVisible(false);
    }

    // GO TO THE MINIGAME SCREEN
    public void goToMiniGameScreen() {
        bank.setVisible(true); // DON'T NEED TO CALL UPON THE STATIC METHOD IN THE MAIN CLASS (Cookie.get*()...) BECAUSE THIS IS AN INSTANCE OF GlobalVariables CLASS
        sign.setVisible(true);
        calendar.setVisible(true);

        Cookie.getTS().getTitleScreenBackground().setVisible(false); // NEED TO CALL UPON THE STATIC METHOD IN THE MAIN CLASS (Cookie.getTS()...) BECAUSE THIS IS NOT AN INSTANCE OF GlobalVariables CLASS
        Cookie.getTS().getEasyButton().setVisible(false);
        Cookie.getTS().getMediumButton().setVisible(false);
        Cookie.getTS().getHardButton().setVisible(false);
        
        Cookie.getUS().getUpgradeCookies().setVisible(false);
        Cookie.getUS().getUpgradeSign().setVisible(false);
        Cookie.getUS().getUpgradeLocation().setVisible(false);
        Cookie.getUS().getMiniGameMenuButton().setVisible(false);
        
        Cookie.getUS().getUpgradeScreenBackground().setVisible(false);
        Cookie.getUS().getDisplayCookie1().setVisible(false);
        Cookie.getUS().getDisplayCookie2().setVisible(false);
        Cookie.getUS().getDisplayCookie3().setVisible(false);
        Cookie.getUS().getDisplayCookie4().setVisible(false);
        Cookie.getUS().getDisplayCookie5().setVisible(false);
        Cookie.getUS().getDisplayCookie6().setVisible(false);
        Cookie.getUS().getDisplayCookie7().setVisible(false);
        Cookie.getUS().getDisplayCookie8().setVisible(false);
        
        Cookie.getUS().getDisplaySign1().setVisible(false);
        Cookie.getUS().getDisplaySign2().setVisible(false);
        Cookie.getUS().getDisplaySign3().setVisible(false);
        
        Cookie.getUS().getDisplayLocation1().setVisible(false);
        Cookie.getUS().getDisplayLocation2().setVisible(false);
        Cookie.getUS().getDisplayLocation3().setVisible(false);
        
        Cookie.getUS().getUnlockC1().setVisible(false);
        Cookie.getUS().getUnlockC2().setVisible(false);
        Cookie.getUS().getUnlockC3().setVisible(false);
        Cookie.getUS().getUnlockC4().setVisible(false);
        Cookie.getUS().getUnlockC5().setVisible(false);
        Cookie.getUS().getUnlockC6().setVisible(false);
        Cookie.getUS().getUnlockC7().setVisible(false);
        Cookie.getUS().getUnlockC8().setVisible(false);
        
        Cookie.getUS().getUnlockS1().setVisible(false);
        Cookie.getUS().getUnlockS2().setVisible(false);
        Cookie.getUS().getUnlockS3().setVisible(false);
        
        Cookie.getUS().getUnlockL1().setVisible(false);
        Cookie.getUS().getUnlockL2().setVisible(false);
        Cookie.getUS().getUnlockL3().setVisible(false);
        
        Cookie.getUS().getPriceCookie4().setVisible(false);
        Cookie.getUS().getPriceCookie5().setVisible(false);
        Cookie.getUS().getPriceCookie6().setVisible(false);
        Cookie.getUS().getPriceCookie7().setVisible(false);
        Cookie.getUS().getPriceCookie8().setVisible(false);
        
        Cookie.getUS().getPriceSign1().setVisible(false);
        Cookie.getUS().getPriceSign2().setVisible(false);
        Cookie.getUS().getPriceSign3().setVisible(false);
        
        Cookie.getUS().getPriceLocation2().setVisible(false);
        Cookie.getUS().getPriceLocation3().setVisible(false);
        
        Cookie.getRE().getRandomEventBackground().setVisible(false);
        Cookie.getRE().getPrompt().setVisible(false);
        Cookie.getRE().getWarning().setVisible(false);
        Cookie.getRE().getYes().setVisible(false);
        Cookie.getRE().getNo().setVisible(false);
        
        Cookie.getUS().getJar().setVisible(false);
        Cookie.getUS().getUnicorn().setVisible(false);
        Cookie.getUS().getGreenBar().setVisible(false);
        Cookie.getUS().getPinkBar().setVisible(false);

        Cookie.getMGS().getMiniGameBackground().setVisible(true);
        Cookie.getMGS().getScenery().setVisible(true);
        Cookie.getMGS().getClear().setVisible(true);
        Cookie.getMGS().getSubmit().setVisible(true);
        Cookie.getMGS().getCookieMenuAlpha().setVisible(true);
        Cookie.getMGS().getCookieMenuBeta().setVisible(true);
        Cookie.getMGS().getCookieMenuCharlie().setVisible(true);
        Cookie.getMGS().getLblCookieAlpha().setVisible(true);
        Cookie.getMGS().getLblCookieBeta().setVisible(true);
        Cookie.getMGS().getLblCookieCharlie().setVisible(true);
        Cookie.getMGS().getLblCustomerFirstCookie().setVisible(true);
        Cookie.getMGS().getLblCustomerSecondCookie().setVisible(true);
        Cookie.getMGS().getLblCustomerThirdCookie().setVisible(true);
        Cookie.getMGS().getCustomer().setVisible(true);
        Cookie.getMGS().getThoughtBubble().setVisible(true);
    }

    // GO TO THE PROFIT SCREEN
    public void goToProfitScreen() {
        sign.setVisible(false);

        Cookie.getMGS().getMiniGameBackground().setVisible(false);
        Cookie.getMGS().getScenery().setVisible(false);
        Cookie.getMGS().getClear().setVisible(false);
        Cookie.getMGS().getSubmit().setVisible(false);
        Cookie.getMGS().getCookieMenuAlpha().setVisible(false);
        Cookie.getMGS().getCookieMenuBeta().setVisible(false);
        Cookie.getMGS().getCookieMenuCharlie().setVisible(false);
        Cookie.getMGS().getLblCookieAlpha().setVisible(false);
        Cookie.getMGS().getLblCookieBeta().setVisible(false);
        Cookie.getMGS().getLblCookieCharlie().setVisible(false);
        Cookie.getMGS().getLblCustomerFirstCookie().setVisible(false);
        Cookie.getMGS().getLblCustomerSecondCookie().setVisible(false);
        Cookie.getMGS().getLblCustomerThirdCookie().setVisible(false);
        Cookie.getMGS().getCustomer().setVisible(false);
        Cookie.getMGS().getThoughtBubble().setVisible(false);

        Cookie.getPS().getProfitScreenBackground().setVisible(true);
        Cookie.getPS().getCalculator().setVisible(true);
        Cookie.getPS().getLastWeekTotal().setVisible(true);
        Cookie.getPS().getEnterAnswer().setVisible(true);
        Cookie.getPS().getFeedback().setVisible(true);
        Cookie.getPS().getFeedback().setText(null);

        Cookie.getPS().setHiddenCustomers((int) (Math.random() * 6) + 1);
        Cookie.getPS().setQueryProfitMoney(getMainCookie() * 3);
        Cookie.getPS().setQueryAnswer(Cookie.getPS().getHiddenCustomers() * Cookie.getPS().getQueryProfitMoney());

        switch (difficulty) {
            case 1:
                Cookie.getPS().getEasyQueryTop().setVisible(true);
                Cookie.getPS().getEasyQueryBottom().setVisible(true);
                Cookie.getPS().getEasyQueryTop().setText("Calculate your profit for this week.");
                Cookie.getPS().getEasyQueryBottom().setText("(Hint: Bank - Last Week's Total)");
                break;
            case 2:
                Cookie.getPS().getMediumQueryTop().setVisible(true);
                Cookie.getPS().getMediumQueryBottom().setVisible(true);
                if (Cookie.getPS().getHiddenCustomers() == 1) {
                    Cookie.getPS().getMediumQueryTop().setText("One day this week, you had 1 person show up.");
                    Cookie.getPS().getMediumQueryBottom().setText("If they spent " + currencyFormat.format(Cookie.getPS().getQueryProfitMoney()) + ", how much did you make that day?");
                } else {
                    Cookie.getPS().getMediumQueryTop().setText("One day this week, you had " + Cookie.getPS().getHiddenCustomers() + " people show up.");
                    Cookie.getPS().getMediumQueryBottom().setText("If they each spent " + currencyFormat.format(Cookie.getPS().getQueryProfitMoney()) + ", how much did you make that day?");
                }
                break;
            case 3:
                Cookie.getPS().getHardQueryTop().setVisible(true);
                Cookie.getPS().getHardQueryBottom().setVisible(true);
                Cookie.getPS().getHardQueryTop().setText("One day this week, you made " + currencyFormat.format(Cookie.getPS().getQueryAnswer()) + ".");
                Cookie.getPS().getHardQueryBottom().setText("If every customer spent " + currencyFormat.format(Cookie.getPS().getQueryProfitMoney()) + " each, how many customers did you have?");
                break;
        }
    }
    
    public void goToUpgradeScreen() {
        Cookie.getPS().getProfitScreenBackground().setVisible(false);
        Cookie.getPS().getCalculator().setVisible(false);
        Cookie.getPS().getLastWeekTotal().setVisible(false);
        Cookie.getPS().getEnterAnswer().setVisible(false);
        Cookie.getPS().getFeedback().setVisible(false);
        Cookie.getPS().getUpgradeMenuButton().setVisible(false);
        
        switch (difficulty) {
            case 1:
                Cookie.getPS().getEasyQueryTop().setVisible(false);
                Cookie.getPS().getEasyQueryBottom().setVisible(false);
                break;
            case 2:
                Cookie.getPS().getMediumQueryTop().setVisible(false);
                Cookie.getPS().getMediumQueryBottom().setVisible(false);
                break;
            case 3:
                Cookie.getPS().getHardQueryTop().setVisible(false);
                Cookie.getPS().getHardQueryBottom().setVisible(false);
                break;
        }
        
        Cookie.getUS().getUpgradeCookies().setVisible(true);
        Cookie.getUS().getUpgradeSign().setVisible(true);
        Cookie.getUS().getUpgradeLocation().setVisible(true);
        Cookie.getUS().getMiniGameMenuButton().setVisible(true);
        
        Cookie.getUS().getUpgradeScreenBackground().setVisible(true);
        Cookie.getUS().getDisplayCookie1().setVisible(true);
        Cookie.getUS().getDisplayCookie2().setVisible(true);
        Cookie.getUS().getDisplayCookie3().setVisible(true);
        Cookie.getUS().getDisplayCookie4().setVisible(true);
        Cookie.getUS().getDisplayCookie5().setVisible(true);
        Cookie.getUS().getDisplayCookie6().setVisible(true);
        Cookie.getUS().getDisplayCookie7().setVisible(true);
        Cookie.getUS().getDisplayCookie8().setVisible(true);
        
        Cookie.getUS().getDisplaySign1().setVisible(true);
        Cookie.getUS().getDisplaySign2().setVisible(true);
        Cookie.getUS().getDisplaySign3().setVisible(true);
        
        Cookie.getUS().getDisplayLocation1().setVisible(true);
        Cookie.getUS().getDisplayLocation2().setVisible(true);
        Cookie.getUS().getDisplayLocation3().setVisible(true);
        
        Cookie.getUS().getUnlockC1().setVisible(cookie1Unlocked);
        Cookie.getUS().getUnlockC2().setVisible(cookie2Unlocked);
        Cookie.getUS().getUnlockC3().setVisible(cookie3Unlocked);
        Cookie.getUS().getUnlockC4().setVisible(cookie4Unlocked);
        Cookie.getUS().getUnlockC5().setVisible(cookie5Unlocked);
        Cookie.getUS().getUnlockC6().setVisible(cookie6Unlocked);
        Cookie.getUS().getUnlockC7().setVisible(cookie7Unlocked);
        Cookie.getUS().getUnlockC8().setVisible(cookie8Unlocked);
        
        Cookie.getUS().getUnlockS1().setVisible(sign1Unlocked);
        Cookie.getUS().getUnlockS2().setVisible(sign2Unlocked);
        Cookie.getUS().getUnlockS3().setVisible(sign3Unlocked);
        
        Cookie.getUS().getUnlockL1().setVisible(location1Unlocked);
        Cookie.getUS().getUnlockL2().setVisible(location2Unlocked);
        Cookie.getUS().getUnlockL3().setVisible(location3Unlocked);
        
        Cookie.getUS().getPriceCookie4().setVisible(!cookie4Unlocked);
        Cookie.getUS().getPriceCookie5().setVisible(!cookie5Unlocked);
        Cookie.getUS().getPriceCookie6().setVisible(!cookie6Unlocked);
        Cookie.getUS().getPriceCookie7().setVisible(!cookie7Unlocked);
        Cookie.getUS().getPriceCookie8().setVisible(!cookie8Unlocked);
        
        Cookie.getUS().getPriceSign1().setVisible(!sign1Unlocked);
        Cookie.getUS().getPriceSign2().setVisible(!sign2Unlocked);
        Cookie.getUS().getPriceSign3().setVisible(!sign3Unlocked);
        
        Cookie.getUS().getPriceLocation2().setVisible(!location2Unlocked);
        Cookie.getUS().getPriceLocation3().setVisible(!location3Unlocked);
        
        Cookie.getUS().getJar().setVisible(true);
        Cookie.getUS().getUnicorn().setVisible(true);
        
        Cookie.getUS().getGreenBar().setVisible(true);
        
        Cookie.getUS().getPinkBar().setVisible(true);
    }
    
    public void goToRandomEvent() {
        bank.setVisible(true); // DON'T NEED TO CALL UPON THE STATIC METHOD IN THE MAIN CLASS (Cookie.get*()...) BECAUSE THIS IS AN INSTANCE OF GlobalVariables CLASS
        sign.setVisible(true);
        calendar.setVisible(true);

        Cookie.getTS().getTitleScreenBackground().setVisible(false); // NEED TO CALL UPON THE STATIC METHOD IN THE MAIN CLASS (Cookie.getTS()...) BECAUSE THIS IS NOT AN INSTANCE OF GlobalVariables CLASS
        Cookie.getTS().getEasyButton().setVisible(false);
        Cookie.getTS().getMediumButton().setVisible(false);
        Cookie.getTS().getHardButton().setVisible(false);
        
        Cookie.getUS().getUpgradeCookies().setVisible(false);
        Cookie.getUS().getUpgradeSign().setVisible(false);
        Cookie.getUS().getUpgradeLocation().setVisible(false);
        Cookie.getUS().getMiniGameMenuButton().setVisible(false);
        
        Cookie.getUS().getUpgradeScreenBackground().setVisible(false);
        Cookie.getUS().getDisplayCookie1().setVisible(false);
        Cookie.getUS().getDisplayCookie2().setVisible(false);
        Cookie.getUS().getDisplayCookie3().setVisible(false);
        Cookie.getUS().getDisplayCookie4().setVisible(false);
        Cookie.getUS().getDisplayCookie5().setVisible(false);
        Cookie.getUS().getDisplayCookie6().setVisible(false);
        Cookie.getUS().getDisplayCookie7().setVisible(false);
        Cookie.getUS().getDisplayCookie8().setVisible(false);
        
        Cookie.getUS().getDisplaySign1().setVisible(false);
        Cookie.getUS().getDisplaySign2().setVisible(false);
        Cookie.getUS().getDisplaySign3().setVisible(false);
        
        Cookie.getUS().getDisplayLocation1().setVisible(false);
        Cookie.getUS().getDisplayLocation2().setVisible(false);
        Cookie.getUS().getDisplayLocation3().setVisible(false);
        
        Cookie.getUS().getUnlockC1().setVisible(false);
        Cookie.getUS().getUnlockC2().setVisible(false);
        Cookie.getUS().getUnlockC3().setVisible(false);
        Cookie.getUS().getUnlockC4().setVisible(false);
        Cookie.getUS().getUnlockC5().setVisible(false);
        Cookie.getUS().getUnlockC6().setVisible(false);
        Cookie.getUS().getUnlockC7().setVisible(false);
        Cookie.getUS().getUnlockC8().setVisible(false);
        
        Cookie.getUS().getUnlockS1().setVisible(false);
        Cookie.getUS().getUnlockS2().setVisible(false);
        Cookie.getUS().getUnlockS3().setVisible(false);
        
        Cookie.getUS().getUnlockL1().setVisible(false);
        Cookie.getUS().getUnlockL2().setVisible(false);
        Cookie.getUS().getUnlockL3().setVisible(false);
        
        Cookie.getUS().getPriceCookie4().setVisible(false);
        Cookie.getUS().getPriceCookie5().setVisible(false);
        Cookie.getUS().getPriceCookie6().setVisible(false);
        Cookie.getUS().getPriceCookie7().setVisible(false);
        Cookie.getUS().getPriceCookie8().setVisible(false);
        
        Cookie.getUS().getPriceSign1().setVisible(false);
        Cookie.getUS().getPriceSign2().setVisible(false);
        Cookie.getUS().getPriceSign3().setVisible(false);
        
        Cookie.getUS().getPriceLocation2().setVisible(false);
        Cookie.getUS().getPriceLocation3().setVisible(false);
        
        Cookie.getRE().getPrompt().setVisible(true);
        Cookie.getRE().getWarning().setVisible(true);
        Cookie.getRE().getRandomEventBackground().setVisible(true);
        Cookie.getRE().getYes().setVisible(true);
        Cookie.getRE().getNo().setVisible(true);
    }

    // CALCULTE THE PROFIT
    public double calcProfit() {
        double cookie = getMainCookie();
        double weekProfit = 0;

        int stand = getActiveStand();
        
        int[] location = getActiveLocation();
        int i;
        //simulated week
        for (i = 0; i < 6; i++) {
            int visitorSim = (int) (Math.random() * 5);
            weekProfit = weekProfit + (cookie * location[visitorSim] + stand);
        }
        
        return weekProfit;
    }

    // RETURNS THE MOST EXPENSIVE COOKIE
    public double getMainCookie() {
        if (getCookieA() > getCookieB() && getCookieA() > getCookieC()) {
            return getCookieA();
        } else if (getCookieB() > getCookieC()) {
            return getCookieB();
        } else {
            return getCookieC();
        }
    }

    // GETTERS AND SETTERS
    public int getWeekDecayCounter(){
    return weekDecayCounter;    
    }
    public void setWeekDecayCounter(int wdc){
        weekDecayCounter = wdc;
    }
    
    
    public CFrame getFrame() {
        return frame;
    }

    public CLabel getBank() {
        return bank;
    }

    public CLabel getSign() {
        return sign;
    }

    public CLabel getCalendar() {
        return calendar;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int d) {
        difficulty = d;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double p) {
        profit = p;
    }

    public double getPreviousTotal() {
        return previousTotal;
    }

    public void setPreviousTotal(double pt) {
        previousTotal = pt;
    }

    public double getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(double ct) {
        currentTotal = ct;
    }

    public double getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(double eg) {
        endGoal = eg;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(int cw) {
        currentWeek = cw;
    }

    public double getCookieA() {
        return cookieA;
    }

    public void setCookieA(double ca) {
        cookieA = ca;
    }

    public double getCookieB() {
        return cookieB;
    }

    public void setCookieB(double cb) {
        cookieA = cb;
    }

    public double getCookieC() {
        return cookieC;
    }

    public void setCookieC(double cc) {
        cookieA = cc;
    }

    public int getActiveStand() {
        return activeStand;
    }

    public void setActiveStand(int as) {
        activeStand = as;
    }

    public int[] getActiveLocation() {
        return activeLocation;
    }

    public void setActiveLocation(int[] al) {
        activeLocation = al;
    }

    public double getCookie1() {
        return cookie1;
    }

    public double getCookie2() {
        return cookie2;
    }

    public double getCookie3() {
        return cookie3;
    }

    public double getCookie4() {
        return cookie4;
    }

    public double getCookie5() {
        return cookie5;
    }

    public double getCookie6() {
        return cookie6;
    }

    public double getCookie7() {
        return cookie7;
    }

    public double getCookie8() {
        return cookie8;
    }

    public int getStand1() {
        return stand1;
    }

    public int getStand2() {
        return stand2;
    }

    public int getStand3() {
        return stand3;
    }

    public int[] getLocation1() {
        return location1;
    }

    public int[] getLocation2() {
        return location2;
    }

    public int[] getLocation3() {
        return location3;
    }

    public NumberFormat getCurrencyFormat() {
        return currencyFormat;
    }
    
    public boolean isCookie1Unlocked() {
        return cookie1Unlocked;
    }
    
    public boolean isCookie2Unlocked() {
        return cookie2Unlocked;
    }
    
    public boolean isCookie3Unlocked() {
        return cookie3Unlocked;
    }
    
    public boolean isCookie4Unlocked() {
        return cookie4Unlocked;
    }
    
    public boolean isCookie5Unlocked() {
        return cookie5Unlocked;
    }
    
    public boolean isCookie6Unlocked() {
        return cookie6Unlocked;
    }
    
    public boolean isCookie7Unlocked() {
        return cookie7Unlocked;
    }
    
    public boolean isCookie8Unlocked() {
        return cookie8Unlocked;
    }
    
    public boolean isSign1Unlocked() {
        return sign1Unlocked;
    }
    
    public boolean isSign2Unlocked() {
        return sign2Unlocked;
    }
    
    public boolean isSign3Unlocked() {
        return sign3Unlocked;
    }
    
    public boolean isLocation1Unlocked() {
        return location1Unlocked;
    }
    
    public boolean isLocation2Unlocked() {
        return location2Unlocked;
    }
    
    public boolean isLocation3Unlocked() {
        return location3Unlocked;
    }
    
    public void setCookie1Unlocked(boolean c1u) {
        cookie1Unlocked = c1u;
    }
    
    public void setCookie2Unlocked(boolean c2u) {
        cookie2Unlocked = c2u;
    }
    
    public void setCookie3Unlocked(boolean c3u) {
        cookie3Unlocked = c3u;
    }
    
    public void setCookie4Unlocked(boolean c4u) {
        cookie4Unlocked = c4u;
    }
    
    public void setCookie5Unlocked(boolean c5u) {
        cookie5Unlocked = c5u;
    }
    
    public void setCookie6Unlocked(boolean c6u) {
        cookie6Unlocked = c6u;
    }
    
    public void setCookie7Unlocked(boolean c7u) {
        cookie7Unlocked = c7u;
    }
    
    public void setCookie8Unlocked(boolean c8u) {
        cookie8Unlocked = c8u;
    }
    
    public void setSign1Unlocked(boolean s1u) {
        sign1Unlocked = s1u;
    }
    
    public void setSign2Unlocked(boolean s2u) {
        sign2Unlocked = s2u;
    }
    
    public void setSign3Unlocked(boolean s3u) {
        sign3Unlocked = s3u;
    }
    
    public void setLocation1Unlocked(boolean l1u) {
        location1Unlocked = l1u;
    }
    
    public void setLocation2Unlocked(boolean l2u) {
        location2Unlocked = l2u;
    }
    
    public void setLocation3Unlocked(boolean l3u) {
        location3Unlocked = l3u;
    }
    
    public String getSign1Path() {
        return sign1Path;
    }
    
    public String getSign2Path() {
        return sign2Path;
    }
    
    public String getSign3Path() {
        return sign3Path;
    }

    public int getSpecialEventCounter() {
        return specialEventCounter;
    }
    
    public void setSpecialEventCounter(int sec) {
        specialEventCounter = sec;
    }
    
    public double getProgress() {
        return progress;
    }
    
    public void setProgress(double p) {
        progress = p;
    }
}
