package com.asymmetriccat.covid19.config;



import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;

import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;


import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.function.Supplier;

@Configuration
public class Config {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
//        final String pw ="ilikejava";
//        char[] password = pw.toCharArray();

        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        javax.net.ssl.SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);


//        SSLContext sslContext = SSLContextBuilder.create()
//                .loadKeyMaterial(keyStore("classpath:keystore.jks", password), password)
//                .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();

 //       HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();
 //       HttpComponentsClientHttpRequestFactory cf =new HttpComponentsClientHttpRequestFactory(client);
        return builder
                .requestFactory(() -> requestFactory)
                .build();
    }

//    private KeyStore keyStore(String file, char[] password) throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        File key = ResourceUtils.getFile(file);
//        try (InputStream in = new FileInputStream(key)) {
//            keyStore.load(in, password);
//        }
//        return keyStore;
//    }
}
