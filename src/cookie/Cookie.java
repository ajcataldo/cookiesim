package cookie;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.midi.*;
import javax.sound.sampled.*;

public class Cookie {

    private static GlobalVariables gv;
    private static TitleScreen ts;
    private static MiniGameScreen mgs;
    private static ProfitScreen ps;
    private static UpgradeScreen us;
    private static RandomEvent re;

    public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException { // EXCEPTIONS NECESSARY TO SUPPORT SOUND

        // CREATE INSTANCES OF EACH OF THE FOLLOWING TO INITIALIZED/DEFINE ALL VARIABLES AND GRAPHICAL COMPONENTS
        gv = new GlobalVariables(); // DEALS WITH ALL GLOBAL VARIABLES AND GLOBAL COMPONENTS
        ts = new TitleScreen(); // DEALS WITH ALL THE VARIABLES AND COMPONENTS SPECIFIC TO THE TITLE SCREEN
        mgs = new MiniGameScreen(); // DEALS WITH ALL THE VARIABLES AND COMPONENTS SPECIFIC TO THE MINIGAME SCREEN
        ps = new ProfitScreen(); // DEALS WITH ALL THE VARIABLES AND COMPONENTS SPECIFIC TO THE PROFIT SCREEN
        us = new UpgradeScreen();
        re = new RandomEvent();

        // NEED TO ADD EACH COMPONENT HERE IN ORDER TO LAY THEM IN THE CORRECT ORDER (SO THAT NOTHING IS HIDDEN BEHIND OTEHR OBJECTS)
        
        gv.getFrame().add(ps.getFinalScreen());
        gv.getFrame().add(re.getPrompt());
        gv.getFrame().add(re.getWarning());
        gv.getFrame().add(re.getYes());
        gv.getFrame().add(re.getNo());
        gv.getFrame().add(re.getRandomEventBackground());
        gv.getFrame().add(us.getPriceCookie4());
        gv.getFrame().add(us.getPriceCookie5());
        gv.getFrame().add(us.getPriceCookie6());
        gv.getFrame().add(us.getPriceCookie7());
        gv.getFrame().add(us.getPriceCookie8());
        gv.getFrame().add(us.getPriceSign1());
        gv.getFrame().add(us.getPriceSign2());
        gv.getFrame().add(us.getPriceSign3());
        gv.getFrame().add(us.getPriceLocation2());
        gv.getFrame().add(us.getPriceLocation3());
        gv.getFrame().add(us.getJar());
        gv.getFrame().add(us.getUnicorn());
        gv.getFrame().add(us.getGreenBar());
        gv.getFrame().add(us.getPinkBar());
        gv.getFrame().add(us.getUnlockC1());
        gv.getFrame().add(us.getUnlockC2());
        gv.getFrame().add(us.getUnlockC3());
        gv.getFrame().add(us.getUnlockC4());
        gv.getFrame().add(us.getUnlockC5());
        gv.getFrame().add(us.getUnlockC6());
        gv.getFrame().add(us.getUnlockC7());
        gv.getFrame().add(us.getUnlockC8());
        gv.getFrame().add(us.getUnlockS1());
        gv.getFrame().add(us.getUnlockS2());
        gv.getFrame().add(us.getUnlockS3());
        gv.getFrame().add(us.getUnlockL1());
        gv.getFrame().add(us.getUnlockL2());
        gv.getFrame().add(us.getUnlockL3());
        gv.getFrame().add(us.getUpgradeCookies());
        gv.getFrame().add(us.getUpgradeSign());
        gv.getFrame().add(us.getUpgradeLocation());
        gv.getFrame().add(us.getMiniGameMenuButton());
        gv.getFrame().add(us.getDisplayCookie1());
        gv.getFrame().add(us.getDisplayCookie2());
        gv.getFrame().add(us.getDisplayCookie3());
        gv.getFrame().add(us.getDisplayCookie4());
        gv.getFrame().add(us.getDisplayCookie5());
        gv.getFrame().add(us.getDisplayCookie6());
        gv.getFrame().add(us.getDisplayCookie7());
        gv.getFrame().add(us.getDisplayCookie8());
        gv.getFrame().add(us.getDisplaySign1());
        gv.getFrame().add(us.getDisplaySign2());
        gv.getFrame().add(us.getDisplaySign3());
        gv.getFrame().add(us.getDisplayLocation1());
        gv.getFrame().add(us.getDisplayLocation2());
        gv.getFrame().add(us.getDisplayLocation3());
        gv.getFrame().add(gv.getBank());
        gv.getFrame().add(gv.getCalendar());
        gv.getFrame().add(gv.getSign());        
        gv.getFrame().add(us.getUpgradeScreenBackground());
        gv.getFrame().add(ps.getUpgradeMenuButton());
        gv.getFrame().add(ps.getFeedback());
        gv.getFrame().add(ps.getEnterAnswer());
        gv.getFrame().add(ps.getHardQueryTop());
        gv.getFrame().add(ps.getMediumQueryTop());
        gv.getFrame().add(ps.getEasyQueryTop());
        gv.getFrame().add(ps.getHardQueryBottom());
        gv.getFrame().add(ps.getMediumQueryBottom());
        gv.getFrame().add(ps.getEasyQueryBottom());
        gv.getFrame().add(ps.getLastWeekTotal());
        gv.getFrame().add(ps.getCalculator());
        gv.getFrame().add(ps.getProfitScreenBackground());
        gv.getFrame().add(mgs.getLblCustomerThirdCookie());
        gv.getFrame().add(mgs.getLblCustomerSecondCookie());
        gv.getFrame().add(mgs.getLblCustomerFirstCookie());
        gv.getFrame().add(mgs.getWrong());
        gv.getFrame().add(mgs.getLblUserThirdCookie());
        gv.getFrame().add(mgs.getLblUserSecondCookie());
        gv.getFrame().add(mgs.getLblUserFirstCookie());
        gv.getFrame().add(mgs.getLblCookieCharlie());
        gv.getFrame().add(mgs.getLblCookieBeta());
        gv.getFrame().add(mgs.getLblCookieAlpha());
        gv.getFrame().add(mgs.getCookieMenuCharlie());
        gv.getFrame().add(mgs.getCookieMenuBeta());
        gv.getFrame().add(mgs.getCookieMenuAlpha());
        gv.getFrame().add(mgs.getSubmit());
        gv.getFrame().add(mgs.getClear());
        gv.getFrame().add(mgs.getThoughtBubble());
        gv.getFrame().add(mgs.getMiniGameBackground());
        gv.getFrame().add(mgs.getCustomer());
        gv.getFrame().add(mgs.getScenery());
        gv.getFrame().add(ts.getHardButton());
        gv.getFrame().add(ts.getMediumButton());
        gv.getFrame().add(ts.getEasyButton());
        gv.getFrame().add(ts.getTitleScreenBackground());
        gv.getFrame().setVisible(true);
        
        
        gv.getFrame().addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                Cookie.size();
            }

            // NECESSARY BECAUSE IF YOU HAVE ONE COMPONENT EVENT, YOU NEED THE REST
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });

        // PLAY BACKGROUND MUSIC
        try {
            java.net.URL url = Cookie.class.getResource("/sounds/backgroundMusic.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // GIVE ACCESS TO INITIALIZED VARIABLES TO ALL CLASSES
    public static GlobalVariables getGV() {
        return gv;
    }

    public static TitleScreen getTS() {
        return ts;
    }

    public static MiniGameScreen getMGS() {
        return mgs;
    }

    public static ProfitScreen getPS() {
        return ps;
    }
    
    public static UpgradeScreen getUS() {
        return us;
    }
    
    public static RandomEvent getRE() {
        return re;
    }

    public static void size() {
        Dimension window = gv.getFrame().getContentPane().getSize(); // GET SCREEN SIZE
        int w = window.width;
        int h = window.height;
        try {
            gv.getBank().scaleMiniGameHeading(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            gv.getSign().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            gv.getCalendar().scaleMiniGameHeading(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ts.getTitleScreenBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ts.getEasyButton().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ts.getMediumButton().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ts.getHardButton().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getMiniGameBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getScenery().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getThoughtBubble().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getClear().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getSubmit().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getCookieMenuAlpha().scaleSpecial(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getCookieMenuBeta().scaleSpecial(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getCookieMenuCharlie().scaleSpecial(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCookieAlpha().scaleCookieNames(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCookieBeta().scaleCookieNames(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCookieCharlie().scaleCookieNames(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblUserFirstCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblUserSecondCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblUserThirdCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getWrong().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCustomerFirstCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCustomerSecondCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getLblCustomerThirdCookie().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            mgs.getCustomer().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getProfitScreenBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getCalculator().scale(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB0().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB4().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB5().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB6().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB7().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB8().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getB9().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getBClear().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getBDot().scaleI(w, h);
        } catch (NullPointerException npe) {
        }        
        try {
            ps.getLastWeekTotal().scaleProfitHeading(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getTitleBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getUpgradeMenuButton().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getEnterAnswer().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL0().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL1().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL2().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL3().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL4().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL5().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL6().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL7().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL8().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getL9().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getLClear().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getLDot().scaleCalc(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getTitle().scaleTitle(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getEasyQueryTop().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getMediumQueryTop().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getHardQueryTop().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getEasyQueryBottom().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getMediumQueryBottom().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getHardQueryBottom().scalePrompt(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getFeedback().scaleFeedback(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUpgradeCookies().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUpgradeSign().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUpgradeLocation().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getMiniGameMenuButton().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie4().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie5().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie6().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie7().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayCookie8().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplaySign1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplaySign2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplaySign3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayLocation1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayLocation2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getDisplayLocation3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC4().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC5().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC6().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC7().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockC8().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockS1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockS2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockS3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockL1().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockL2().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnlockL3().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUpgradeScreenBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        /*
        try {
            us.getPriceCookie1().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie2().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie3().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
*/
        try {
            us.getPriceCookie4().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie5().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie6().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie7().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceCookie8().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceSign1().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceSign2().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceSign3().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceLocation2().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPriceLocation3().scalePrices(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            re.getRandomEventBackground().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            re.getPrompt().scaleRandomEventText(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            re.getWarning().scaleRandomEventText(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            re.getYes().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            re.getNo().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            ps.getFinalScreen().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getJar().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getUnicorn().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getPinkBar().scaleI(w, h);
        } catch (NullPointerException npe) {
        }
        try {
            us.getGreenBar().scaleGreenBarLength(w, h);
        } catch (NullPointerException npe) {
        }        
    }
}
