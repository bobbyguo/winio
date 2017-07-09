package winio;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;

public class User32Util {
	public static WinDef.LPARAM buildLPARAM(int vk, int flag) {
		StringBuffer buffer = new StringBuffer();
		switch (flag) {
		case User32.WM_KEYDOWN:
			buffer.append("00");
			break;
		case User32.WM_KEYUP:
			buffer.append("c0");
			break;
		default:
			throw new RuntimeException("invalid flag");
		}
		buffer.append(Integer.toHexString(User32.INSTANCE.MapVirtualKey(vk, 0)));
		buffer.append("0001");

		return new WinDef.LPARAM(Long.parseLong(buffer.toString(), 16));
	}

	public static void KBCWait4IBE() throws Exception {
		int val;
		do {
			Pointer p = new Memory(8);
			if (!WinIo.INSTANCE.GetPortVal(WinIo.CONTROL_PORT, p, 1)) {
				System.err.println("Cannot get the Port");
			}

			val = p.getInt(0);

		} while ((0x2 & val) > 0);
	}
}
