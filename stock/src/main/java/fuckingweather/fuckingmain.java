package fuckingweather;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fuckingmain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
         String URL = "https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
         Document doc = Jsoup.connect(URL).get();
         Elements elements = doc.select("location");
         
         String city;
         String time;
         String weather;
         String min;
         String max;
         
         for( Element element : elements ) {
            city = element.select("city").text();
            
            Elements date = element.select("data");
            		
            for( Element data : date) {
            	time = data.select("tmEf").text();
                weather = data.select("wf").text();
                min = data.select("tmn").text();
                max = data.select("tmx").text();
                
//                String[] hour = time.split("\\s");
                
//                System.out.printf("도시 :%s, 시간:%s, 날씨:%s, 최저:%s, 최고:%s\n\n\n", city, time, weather, min, max);
            }
            
            
            
//            System.out.printf("시간:%s 날씨:%s 최저:%s 최고:%s\n\n\n", time, weather, min, max);
         } // for end   
         
      } catch (Exception e) {
         System.out.println("크롤링 실패 : " + e);
      } // end

   }

}