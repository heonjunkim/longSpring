package com.biz.data.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.BisDestVO;
import com.biz.data.model.BisStationData;
import com.biz.data.model.BisStationList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BisServiceImplV1 implements BisService {
	
	public List<BisStationData> getStation() {
		
		// 공공DB로부터 데이터를 수집하는 용도의 클래스
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<BisStationList> resList = null;
		
		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?ServiceKey=" + DataGoConfig.SEVICE_KEY;

		
// 		별도로 클래스를 만들어 interceptor를 설정하는 방법		
// request body, excution등을 주입해주어야 해서 매우 복잡하다
//		RestTempInterceptor rtInter = new RestTempInterceptor();
//		restTemp.getInterceptors().add(
//					rtInter.intercept(request, body, execution)
//				)
		
		/**
		 * ClientHttpRequestInterceptor interface를 사용하여
		 * 익명클래스를 선언하기
		 */
//		restTemp.getInterceptors().add(new ClientHttpRequestInterceptor() {
//			
//			@Override
//			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//					throws IOException {
//				ClientHttpResponse response = execution.execute(request, body);
//				response.getHeaders().setContentType(MediaType.APPLICATION_JSON);			
//				return response;
//			}
//		});
		
		// java Lambda 형식으로 구현한 Interceptor
		// java Lambda 구현을 위해서는 Interface 가 필수적으로 요구 된다.
		restTemp.getInterceptors().add((request,body, execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});
		
		try {
			URI bisURI = new URI(apiURI);
			resList = restTemp.exchange(bisURI,
					HttpMethod.GET, null, BisStationList.class);
			//log.debug(resList.getBody().STATION_LIST.toString());
			return resList.getBody().STATION_LIST;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return null;
	}

	public String getString() {
		// 공공DB로부터 데이터를 수집하는 용도의 클래스
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<String> resString = null;
		
		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?serviceKey=" + DataGoConfig.SEVICE_KEY;
		try {
			URI bisURI = new URI(apiURI);
			resString = restTemp.exchange(bisURI,
					HttpMethod.GET,
					null,
					String.class);
			log.debug(resString.getBody());
			// return resList.getBody();

			return resString.getBody();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return null;

	}

	@Override
	public List<BisDestVO> busstop(String station) {
		
		String queryString = DataGoConfig.BIS_DEST_URL;
		queryString += "?servicekey=" +DataGoConfig.SEVICE_KEY;
		queryString += "&BUSSTOP_ID=" +	 station;
		
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<BisStationList> bisArrList;
		URI apiURI = null;
		
		try {
			apiURI = new URI(queryString);
			bisArrList = restTemp.exchange(
					apiURI, HttpMethod.GET,
							null, BisArriveList.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}