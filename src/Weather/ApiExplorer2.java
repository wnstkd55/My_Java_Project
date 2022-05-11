package Weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiExplorer2 {
	private static final String SERVICE_KEY = "ABwQU4BdhwGQdV3Yxho3jb0qPCed0bVrxoScthUlcsmf7WjZ6FQWn4MjP3MCduihJO4Bc0BpsBNY62ROfyJb%2Bg%3D%3D";
	private static final String pageNO = "1";
	private static final String numOfRows = "61";
	private static final String TODAY = new SimpleDateFormat("yyyyMMdd").format(new Date());
	private static final String TODAY_HOUR = Integer.toString((Integer.parseInt(new SimpleDateFormat("HH").format(new Date()))*100));
	private static final String coordy_X = "59";
	private static final String coordy_Y = "124";	//서울 독산4동 
	
    public static void ApiExplorer2(){
    	String result = "";
    	try {
    		 URL url = new URL("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"+
                     "?serviceKey=" + SERVICE_KEY +
                     "&pageNo=" + pageNO +
                     "&numOfRows=" + numOfRows +
                     "&base_date=" + TODAY +
                     "&base_time=" + TODAY_HOUR +
                     "&nx=" + coordy_X +
                     "&ny=" + coordy_Y +
                     "&dataType=JSON");
    		// 버퍼 데이터(응답 메세지)를 읽어서 result에 저장
             // result에는 XML 형식의 응답 데이터가 String으로 저장되어 있음
             BufferedReader bf;
             bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
             result = bf.readLine();
             
             JSONObject jsonObject = new JSONObject(result);
             
             JSONObject response = (JSONObject)jsonObject.get("response");
             JSONObject body = (JSONObject)response.get("body");
             JSONObject items = (JSONObject)body.get("items");
             JSONArray itemArr = (JSONArray)items.get("item");
             
             System.out.println("====== 서울 독산4동의 날씨 ========");
             for(int i = 0; i<itemArr.length(); i++) {
            	 JSONObject item = (JSONObject)itemArr.get(i);
            	 System.out.println("날짜: "+item.get("baseDate"));
            	 System.out.println("시간: "+item.get("baseTime"));
            	 System.out.println("카테고리: "+item.get("category"));
            	 System.out.println("예측시간: "+item.get("fcstTime"));
            	 System.out.println("측정값: "+item.get("fcstValue"));
            	 System.out.println("-------------------------");
             }
    		 		
             
             
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
       
       
 
        //base_date => today		base_time	=> today_hour	nx => coordy_X 	ny=>coordy_Y
    }
    
}