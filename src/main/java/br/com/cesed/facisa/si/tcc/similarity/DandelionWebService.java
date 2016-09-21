package br.com.cesed.facisa.si.tcc.similarity;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import br.com.cesed.facisa.si.tcc.isimilarity.SimilarityWebService;

public class DandelionWebService implements SimilarityWebService{
	

	@Override
	public String responseWebService(String url) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String status = HttpStatus.INTERNAL_SERVER_ERROR.toString();
		
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);

            status = response1.getStatusLine().toString();
            
            System.out.println(response1.getStatusLine());
            
            
            HttpEntity entity1 = response1.getEntity();
            EntityUtils.consume(entity1);
                
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } finally {
            httpclient.close();			
        }
		return status;
	} 
	
	

}
