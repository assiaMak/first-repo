package com.mycompany.myapp.tools;

import java.io.IOException;

/**
 * @author admin
 * 
 */
public final class SoapConnectionUtil {

	private SoapConnectionUtil() {
		super();
	}

	/**
	 * @param messageFragment
	 * @return
	 * @throws IOException
	 */
	public static String fixSOAPRequestMessage(String messageFragment)
			throws IOException {
		String lvMessageFragment = messageFragment.substring(56);
		String top = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n"
				+ "  <soap12:Body>\n";
		String bottom = "  </soap12:Body>\n" + "</soap12:Envelope>";
		String wholeMessage = top + lvMessageFragment + bottom;
		return wholeMessage;
	}
	
	/**
	 * @param messageFragment
	 * @return
	 * @throws IOException
	 */
	public static String stripSOAPReplyMessage (String messageFragment) throws IOException {
        String strippedMessage = messageFragment;
        String badString = "xsi:nil=\"true\"";
        strippedMessage = strippedMessage.replaceAll(badString, "");   
        strippedMessage = strippedMessage.substring(216, strippedMessage.length()-28);
        return strippedMessage;
    }
}
