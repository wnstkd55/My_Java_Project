package Weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiExplorer2_mo {
	private static final String SERVICE_KEY = "ABwQU4BdhwGQdV3Yxho3jb0qPCed0bVrxoScthUlcsmf7WjZ6FQWn4MjP3MCduihJO4Bc0BpsBNY62ROfyJb%2Bg%3D%3D";
	private static final String pageNO = "1";
	private static final String numOfRows = "60";		//기준시간으로부터 최대 데이터수
	private static final String TODAY = new SimpleDateFormat("yyyyMMdd").format(new Date());
	private static final String TODAY_HOUR = Integer.toString((Integer.parseInt(new SimpleDateFormat("HH00").format(new Date()))));
	private static final String TIME_MO = "0700";
	private static final String coordy_X = "59";		
	private static final String coordy_Y = "124";	//서울 독산4동 
	
    public static void ApiExplorer_mo(){
    	String result = "";
    	try {
    		 URL url = new URL("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"+
                     "?serviceKey=" + SERVICE_KEY +
                     "&pageNo=" + pageNO +
                     "&numOfRows=" + numOfRows +
                     "&base_date=" + TODAY +
                     "&base_time="+ TIME_MO +
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
            	 String date = (String) item.get("baseDate");	// 날짜를 담는 변수 생성
            	 String cata = (String) item.get("category");	// 카테고리를 담는 변수 생성
            	 String f_time = (String)item.get("fcstTime");	// 예측시간을 담는 변수 생성
            	 String value = (String)item.get("fcstValue");	// 측정 값을 담는 변수 생성
            	 if(cata.equals("T1H")) {
            		 cata = "기온";
            		 value = value+"℃";
            	 }else if(cata.equals("RN1")) {
            		 cata = "1시간 강수량";
            	 }else if(cata.equals("SKY")) {
            		 cata = "하늘 상태";
            		 if(Integer.parseInt(value)>=0 && Integer.parseInt(value)<=5) {
            			 value = "맑음";
            		 }else if(Integer.parseInt(value)>=6 && Integer.parseInt(value)<=8) {
            			 value = "구름 많음";
            		 }else if(Integer.parseInt(value)>=9 && Integer.parseInt(value)<=10) {
            			 value = "흐림";
            		 }
            	 }else if(cata.equals("UUU")) {
//            		 cata = "동서바람성분";
//            		 value = value+"m/s";
            		 return;
            	 }else if(cata.equals("VVV")) {
//            		 cata = "남북바람성분";
//            		 value = value+"m/s";
            		 return;
            	 }else if(cata.equals("REH")) {
            		 cata = "습도";
            		 value = value+"%";
            	 }else if(cata.equals("PTY")) {
            		 cata = "강수형태";
            		 if(value.equals("0")) {
            			 value = "없음";
            		 }else if(value.equals("1")) {
            			 value = "비";
            		 }else if(value.equals("2")) {
            			 value = "비/눈";
            		 }else if(value.equals("3")) {
            			 value = "눈";
            		 }else if(value.equals("5")) {
            			 value = "빗방울";
            		 }else if(value.equals("6")) {
            			 value = "빗방울눈날림";
            		 }else if(value.equals("7")) {
            			 value = "눈날림";
            		 }
            	 }else if(cata.equals("LGT")) {
            		 cata = "낙뢰";
            	 }else if(cata.equals("VEC")) {
            		 cata = "풍향";
            		 if(Integer.parseInt(value)>=0 && Integer.parseInt(value)<45) {
            			 value = "북 ~ 북동";
            		 }else if(Integer.parseInt(value)>=45 && Integer.parseInt(value)<90) {
            			 value = "북동 ~ 동";
            		 }else if(Integer.parseInt(value)>=90 && Integer.parseInt(value)<135) {
            			 value = "동 ~ 동남";
            		 }else if(Integer.parseInt(value)>=135 && Integer.parseInt(value)<180) {
            			 value = "동남 ~ 남";
            		 }else if(Integer.parseInt(value)>=180 && Integer.parseInt(value)<225) {
            			 value = "남 ~ 남서";
            		 }else if(Integer.parseInt(value)>=225 && Integer.parseInt(value)<270) {
            			 value = "남서 ~ 서";
            		 }else if(Integer.parseInt(value)>=270 && Integer.parseInt(value)<315) {
            			 value = "서 ~ 북서";
            		 }else if(Integer.parseInt(value)>=315 && Integer.parseInt(value)<360) {
            			 value = "북서 ~ 북";
            		 }
            		
            	 }else if(cata.equals("WSD")) {
            		 cata = "풍속";
            		 if(Integer.parseInt(value) < 4) {
            			 value = "풍속 "+value+"m/s 로 바람이 약합니다.";
            		 }else if(Integer.parseInt(value)>=4 && Integer.parseInt(value)<9) {
            			 value = "풍속 "+value+"m/s 로 바람이 약간 강합니다.";
            		 }else if(Integer.parseInt(value)>=9 && Integer.parseInt(value)<14) {
            			 value = "풍속 "+value+"m/s 로 바람이 강합니다.";
            		 }else if(Integer.parseInt(value)>=14) {
            			 value = "풍속 "+value+"m/s 로 바람이 매우 강합니다.";
            		 }
            	 }
            	 if(f_time.equals("1100")) {
            	 System.out.println("날짜: "+date);
            	 //System.out.println("시간: "+item.get("baseTime"));
            	 System.out.println("카테고리: "+cata);
            	 System.out.println("예측시간: "+f_time);
            	 System.out.println("측정값: "+ value);
            	 System.out.println("-------------------------");
            	 }
            }
    		 		
             
             
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
 
        //base_date => today		base_time	=> today_hour	nx => coordy_X 	ny=>coordy_Y
    }
    
}