package se.perfektum.typeaheadfiles;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyListener implements NativeKeyListener{
    private static final Logger logger = LoggerFactory.getLogger(KeyListener.class);

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        logger.debug("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        logger.debug("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_X) {
            try {
                logger.debug("Hot key pressed! Starting GUI...");
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        logger.debug("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}
