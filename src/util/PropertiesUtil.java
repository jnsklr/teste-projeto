package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	private Properties properties;
	//private String nomeProperties = "SEU ARQUIVO.properties";

	public PropertiesUtil(String nomeProperties) {
		properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream(nomeProperties);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValor(String chave) {
		return (String) properties.getProperty(chave);
	}
}
