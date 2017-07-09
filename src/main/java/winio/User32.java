package winio;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary,
        com.sun.jna.platform.win32.User32 {
    /** Instance of USER32.DLL for use in accessing native functions. */
    User32 INSTANCE = (User32) Native.loadLibrary(
            "user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

    /**
     * Translates (maps) a virtual-key code into a scan code or
     * character value, or translates a scan code into a virtual-key
     * code.
     *
     * @param uCode The virtual key code or scan code for a key.
     * @param uMapType The translation to be performed.
     *                 virtual-key -> scan      0
     *                 scan -> virtual-key      1
     *                 virtual-key -> ASCII     2
     * @return The return value is either a scan code, a virtual-key
     *  code, or a character value, depending on the value of uCode and
     *  uMapType. If there is no translation, the return value is zero.
     */
	int MapVirtualKey(int uCode, int uMapType);
}
