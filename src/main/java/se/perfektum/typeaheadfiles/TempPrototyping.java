package se.perfektum.typeaheadfiles;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;

/**
 * Created by stenman on 2017-05-28.
 */
public class TempPrototyping implements NativeKeyListener {

    // jntativehook test 1
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//
//            System.exit(1);
//        }
//
//        GlobalScreen.addNativeKeyListener(new TempPrototyping());
    }




    // JKeyMaster test 1
//    public static void main(String[] args) {
//        final Provider provider = Provider.getCurrentProvider(false);
//
//        provider.register(KeyStroke.getKeyStroke("control alt F"), new HotKeyListener() {
//            public void onHotKey(HotKey hotKey) {
//                System.out.println(hotKey);
//                provider.reset();
//                provider.stop();
//            }
//        });
//        while (true) {
//        }
//        HotKeyListener listener = new HotKeyListener() {
//            public void onHotKey(HotKey hotKey) {
//                System.out.println(hotKey);
//            }
//        };
//        provider.register(KeyStroke.getKeyStroke("control shift 1"), listener);
//        provider.register(KeyStroke.getKeyStroke("control shift released 1"), listener);
//    }

    //JNA TEST 1
//    private static final int VK_LEFT = 0x25;

//    public static void main(String args[]) {
//        System.out.println("Starting service");
//        User32 user32 = User32.INSTANCE;
//
//        int id = 9999;
//
//        if (!user32.RegisterHotKey(Pointer.NULL, 1, User32.MOD_ALT | User32.MOD_CONTROL, VK_LEFT)) {
//            System.out.println("Could not register hot key!");
//            System.exit(1);
//        }
//
//        int count = 0;
//        while (count < 3) {
//            System.out.println("Waiting for hot key to be pressed...");
//            int hej = user32.MsgWaitForMultipleObjects(0, Pointer.NULL, true, User32.INFINITE, User32.QS_HOTKEY);
//            System.out.println("Hot key pressed! hej = " + hej);
//            count++;
//        }


    // JNA TEST 2
//        if (!user32.RegisterHotKey(null, id, User32.MOD_ALT | User32.MOD_NOREPEAT, VK_LEFT)) {
//            System.out.println("Error");
//            return;
//        }
//
//        Pointer<MSG> msgPointer = Pointer.createConstant(MSG.class);
//
//        try {
//            while (!user32.GetMessage(msgPointer, null, 0, 0)) {
//                MSG msg = msgPointer.get();
//                if (msg.message() == WM_HOTKEY && msg.wParam() == id) {
//                    System.out.println("YEAH");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
////            UnregisterHotKey(null, id);
//        }
//    }
}
