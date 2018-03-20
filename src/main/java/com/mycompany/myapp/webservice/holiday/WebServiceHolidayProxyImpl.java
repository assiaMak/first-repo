package com.mycompany.myapp.webservice.holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.holidaywebservice.holidayservice_v2.GetHolidayDate;
import com.holidaywebservice.holidayservice_v2.GetHolidayDateResponse;
import com.mycompany.myapp.tools.MyAppConstantes;
import com.mycompany.myapp.tools.SoapConnectionUtil;

/**
 * @author admin
 *
 */
@Component
public class WebServiceHolidayProxyImpl implements WebServiceHolidayProxy{
	
	Logger Log = LoggerFactory.getLogger("WebServiceHolidayProxyImpl");
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;

	/* (non-Javadoc)
	 * @see com.mycompany.myapp.webservice.holiday.WebServiceHolidayProxy#callGetHolidayDate(com.mycompany.myapp.webservice.holiday.WsGetHolidayDateIn)
	 */
	public GetHolidayDateResponse callGetHolidayDateSoap(
			GetHolidayDate wsGetHolidayDateIn) {
		HttpURLConnection connexion = null;
		try {
			connexion = getConnexion(messageSource.getMessage("webServiceHoliday.soap.action", null, null), true, true);
			
			JAXBContext contextForRequest =  JAXBContext.newInstance(GetHolidayDate.class);
			Marshaller marshaller = contextForRequest.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter st = new StringWriter(); 
	        marshaller.marshal(wsGetHolidayDateIn, st);
	        String xmlRequest = SoapConnectionUtil.fixSOAPRequestMessage(st.toString());
	        
	        System.out.println("xmlRequest : \n" + xmlRequest);
	        
			// Send the request
			OutputStreamWriter wr = new OutputStreamWriter(connexion.getOutputStream());
			wr.write(xmlRequest);
			wr.flush();
			// Read the response
			System.out.println("getResponseCode : " + connexion.getResponseCode());
			
			BufferedReader responseReader = new BufferedReader(new java.io.InputStreamReader(connexion.getInputStream()));
			String xmlResponse = "";
			String line;
			while ((line = responseReader.readLine()) != null) {
				xmlResponse += line;
			}
			
	        System.out.println("xmlResponse : \n" + xmlResponse);
	        xmlResponse = SoapConnectionUtil.stripSOAPReplyMessage(xmlResponse);
	        System.out.println("xmlResponse : \n" + xmlResponse);
			
	        JAXBContext contextForResponse =  JAXBContext.newInstance(GetHolidayDateResponse.class);
	        Unmarshaller unmarshaller = contextForResponse.createUnmarshaller();
	        return (GetHolidayDateResponse) unmarshaller.unmarshal(new StringReader(xmlResponse));
			
		} catch (MalformedURLException e) {
			Log.error("L'URL est mal formée : " + e.getMessage());
		} catch (IOException e) {
			Log.error("Problème de lecture de réponse : " + e.getMessage());
			Log.error("Erreur serveur : " + connexion.getErrorStream());
			
			if(null != connexion.getHeaderField("Set-Cookie")){
				Log.debug("Cookies existante : " + connexion.getHeaderField("Set-Cookie"));
			}
		} catch (JAXBException e) {
			Log.error("Erreur JAXB : " + e.getMessage());
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.mycompany.myapp.webservice.holiday.WebServiceHolidayProxy#callGetHolidayDate(com.mycompany.myapp.webservice.holiday.WsGetHolidayDateIn)
	 */
	public GetHolidayDateResponse callGetHolidayDateHttpPost(
			GetHolidayDate wsGetHolidayDateIn) {
		HttpURLConnection connexion = null;
		try {
			Map<String, String> propertiesMap = new HashMap<String, String>();
			propertiesMap.put("Content-Type", "application/x-www-form-urlencoded");
			propertiesMap.put("countryCode", wsGetHolidayDateIn.getCountryCode().name());
			propertiesMap.put("holidayCode", wsGetHolidayDateIn.getHolidayCode());
			propertiesMap.put("year", ""+wsGetHolidayDateIn.getYear());
			
			connexion = getConnexion("webServiceHoliday.post.url", propertiesMap, true, false);
			
			// Read the response
			System.out.println("getResponseCode : " + connexion.getResponseCode());
			
			BufferedReader responseReader = new BufferedReader(new java.io.InputStreamReader(connexion.getInputStream()));
			String xmlResponse = "";
			String line;
			while ((line = responseReader.readLine()) != null) {
				xmlResponse += line;
			}
			
	        System.out.println("xmlResponse : \n" + xmlResponse);
	        xmlResponse = SoapConnectionUtil.stripSOAPReplyMessage(xmlResponse);
	        System.out.println("xmlResponse : \n" + xmlResponse);
			
	        JAXBContext contextForResponse =  JAXBContext.newInstance(GetHolidayDateResponse.class);
	        Unmarshaller unmarshaller = contextForResponse.createUnmarshaller();
	        return (GetHolidayDateResponse) unmarshaller.unmarshal(new StringReader(xmlResponse));
			
		} catch (MalformedURLException e) {
			Log.error("L'URL est mal formée : " + e.getMessage());
		} catch (IOException e) {
			Log.error("Problème de lecture de réponse : " + e.getMessage());
			Log.error("Erreur serveur : " + connexion.getErrorStream());
			
			if(null != connexion.getHeaderField("Set-Cookie")){
				Log.debug("Cookies existante : " + connexion.getHeaderField("Set-Cookie"));
			}
		} catch (JAXBException e) {
			Log.error("Erreur JAXB : " + e.getMessage());
		}
		
		return null;
	}
	
	private HttpURLConnection getConnexion(String urlPropertie, Map<String, String> propertiesMap, boolean isDoInput, boolean isDoOutPut) throws IOException {
		URL webSerUrl = new URL(messageSource.getMessage(urlPropertie, null, null));
		HttpURLConnection connexion = (HttpURLConnection) webSerUrl.openConnection();
		connexion.setDoInput(isDoInput);
		connexion.setDoOutput(isDoOutPut);
		connexion.setRequestMethod("POST");
		if(null != propertiesMap && null != propertiesMap.keySet()){
			for(String key : propertiesMap.keySet()){
				connexion.setRequestProperty(key, propertiesMap.get(key));
			}
			
			String urlParameters = webSerUrl.getQuery();
			if (urlParameters == null){
				urlParameters = "";
			}
			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			if (postDataLength > 0) {
				connexion.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			}
		}
		return connexion;
		
	}

	private HttpURLConnection getConnexion(String soapAction, boolean isDoInput, boolean isDoOutPut) throws IOException {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		propertiesMap.put("Content-Type", MyAppConstantes.XML_CONTENT_TYPE);
		propertiesMap.put("SOAPAction", soapAction);
		
		return getConnexion("webServiceHoliday.soap.url", propertiesMap, isDoInput, isDoOutPut);
	}

}
