package gov.nsf.psm.foundation.restclient;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author ybansal
 *
 */
public class NsfRestTemplate {

	/**
	 * @param restRequest
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	static public RestTemplate setupRestTemplate(boolean isAuthRequired, int requestTimeout)
			throws KeyStoreException, KeyManagementException, NoSuchAlgorithmException {
		RestTemplate restTemplate = new RestTemplate();
		if (isAuthRequired) {
			final TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
				public final boolean isTrusted(final X509Certificate[] certificate, final String authType) {
					return true;
				}
			};
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, acceptingTrustStrategy).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

			requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			requestFactory.setReadTimeout(requestTimeout);
			restTemplate.setRequestFactory(requestFactory);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		}
		return restTemplate;
	}

	static public HttpEntity<String> createHttpEntityWithAuthentication(String userName, String password) {
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", authHeader);
		return new HttpEntity<String>(headers);
	}

}
