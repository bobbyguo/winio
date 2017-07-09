package winio;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.W32APIOptions;

public interface WinIo extends Library {
	String arch = System.getProperty("os.arch");
	String winio = "x86".equals(arch) ? "WinIo32" : "WinIo64";
	WinIo INSTANCE = (WinIo) Native.loadLibrary(winio, WinIo.class, W32APIOptions.DEFAULT_OPTIONS);

	int CONTROL_PORT = 0x64;
	int DATA_PORT = 0x60;

	boolean InitializeWinIo();

	void ShutdownWinIo();

	boolean GetPortVal(int portAddr, Pointer pPortVal, int size);

	boolean SetPortVal(int portAddr, int portVal, int size);
	
}
