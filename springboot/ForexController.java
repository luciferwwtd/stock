//package kr.co.swh.lecture.springboot;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//@RestController
//@RequestMapping("/api")
//public class ForexController {
//
//    @Autowired
//    private ExchangeValueRepository repository;
//    
//    @Autowired
//    private Environment environment;
//    
////    @Autowired
//    private ArrayList<ExchangeValue> Value;
//
//    @GetMapping("/currency-exchange/")
//    public List<ExchangeValue> retrieve1() {
//        List<ExchangeValue> exchangeValue = repository.findAll();
//
//        return exchangeValue;
//    }
//    
//    @GetMapping("/currency-exchange/{id}")
//    public ExchangeValue retrieve(@PathVariable String id) {
//
//    	System.out.println(environment.getProperty("Key1"));
//    	System.out.println(environment.getProperty("Key2"));
//        ExchangeValue exchangeValue = repository.findById(id).get();
//
//        return exchangeValue;
//    }
//    
//    @GetMapping("/")
//    public List<ExchangeValue> list() {
//        return Value;
//    }
//    
//    
////    @GetMapping("/hello")
////    public List<ExchangeValue> PostTest() {
////    	Document doc = Jsoup.connect("http://example.com/").get();
////    	String title = doc.title();
////    	
////    }
//    
////    @GetMapping("/travel/{placeName}")
////    public ArrayList<ArrayList<String>> Travel(@PathVariable String placeName) {
////    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
////    	ArrayList<String> i = new ArrayList<String>();
////    	
////    	
////    	ExchangeValue exchangeValue = repository.findById(placeName).get();
////    	for(int index=0; index<exchangeValue.length(); index++){
////    		i = exchangeValue[index];
////    		if (i[0] == placeName) {
////    			result.add(i);
////    		}
////    	}
////    	
////    	return result;
////    }
//    
//    
//    @GetMapping("/disease/{cityName}/{diseaseName}/{date}")
//    public void Disease(@PathVariable String cityName, @PathVariable String diseaseName, @PathVariable String date) {
//    	System.out.println("logged");
//    	Map<String, Integer> map = new HashMap<String, Integer>();
//    	map.put("서울", 11);
//    	map.put("부산", 26);
//    	map.put("대구", 27);
//    	map.put("인천", 28);
//    	map.put("광주", 29);
//    	map.put("대전", 30);
//    	map.put("울산", 31);
//    	map.put("경기", 41);
//    	map.put("강원", 42);
//    	map.put("충북", 43);
//    	map.put("충남", 44);
//    	map.put("전북", 45);
//    	map.put("전남", 46);
//    	map.put("경북", 47);
//    	map.put("경남", 48);
//    	map.put("제주", 49);
//    	map.put("전국", 99);
//    	
//    	Object useless = map.get(cityName);
//    	String cityCode = String.valueOf(useless);
//    	
//    	List<ExchangeValue> exchangeValue = repository.findAll();
//    	System.out.println(exchangeValue); // 어쩌라고 ㅅㅂ
//    	
//    	try {
//    		
//    	} catch (Throwable e) {
//    		e.printStackTrace();
//    	}
//    }
//    
//    @GetMapping("/city/{cityName}")
//    public ArrayList<ArrayList<String>> PostTest(@PathVariable String cityName) {
//    	System.out.println(cityName);
//    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//    	
//    	try {
//    		Connection conn = Jsoup.connect("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
//    		Document doc = conn.get();
//    		Elements eles = doc.select("location");
//    		
//    		for (Element ele : eles) {
//    			Elements city = ele.select("city");
//    			
//    			if (city.text().equals(cityName)) {
//    				
//    				Elements data = ele.select("data");
//        			
//        			for (Element dat : data) {
//        				
//        				ArrayList<String> babo = new ArrayList<String>();
//        				
//        				Elements tmEf = dat.select("tmEf");
//        				Elements wf = dat.select("wf");
//        				Elements tmn = dat.select("tmn");
//        				Elements tmx = dat.select("tmx");
//        				
//        				babo.add(tmEf.text());
//        				babo.add(wf.text());
//        				babo.add(tmn.text());
//        				babo.add(tmx.text());
//        				
//        				result.add(babo);
//        				
//        			}
//    			}
//    		}
//    	} catch (Throwable e) {
//    		e.printStackTrace();
//    	}
//    	
//    	System.out.println(result.size());
//    	return result;
//    }
//    
//    
//    
//    // https://jjluveeecom.tistory.com/50
//}



package kr.co.swh.lecture.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@RestController
@RequestMapping("/api")
public class ForexController {

    @Autowired
    private ExchangeValueRepository repository;
    
    @Autowired
    private Environment environment;
    
//    @Autowired
    private ArrayList<ExchangeValue> Value;

    @GetMapping("/currency-exchange/")
    public List<ExchangeValue> retrieve1() {
        List<ExchangeValue> exchangeValue = repository.findAll();

        return exchangeValue;
    }
    
    @GetMapping("/currency-exchange/{id}")
    public ExchangeValue retrieve(@PathVariable String id) {

    	System.out.println(environment.getProperty("Key1"));
    	System.out.println(environment.getProperty("Key2"));
        ExchangeValue exchangeValue = repository.getById(id);

        return exchangeValue;
    }
    
    @GetMapping("/")
    public List<ExchangeValue> list() {
        return Value;
    }
    
  @GetMapping("/disease/{cityName}/{diseaseName}/{date}")
  public void Disease(@PathVariable String cityName, @PathVariable String diseaseName, @PathVariable String date) {
  	System.out.println("logged");
  	Map<String, Integer> map = new HashMap<String, Integer>();
  	map.put("서울", 11);
  	map.put("부산", 26);
  	map.put("대구", 27);
  	map.put("인천", 28);
  	map.put("광주", 29);
  	map.put("대전", 30);
  	map.put("울산", 31);
  	map.put("경기", 41);
  	map.put("강원", 42);
  	map.put("충북", 43);
  	map.put("충남", 44);
  	map.put("전북", 45);
  	map.put("전남", 46);
  	map.put("경북", 47);
  	map.put("경남", 48);
  	map.put("제주", 49);
  	map.put("전국", 99);
  	
  	Object useless = map.get(cityName);
  	String cityCode = String.valueOf(useless);
  	
  	List<ExchangeValue> exchangeValue = repository.findAll();
  	System.out.println(exchangeValue);
  	
  	try {
  		
  	} catch (Throwable e) {
  		e.printStackTrace();
  	}
  }
    
    
//    @GetMapping("/hello")
//    public List<ExchangeValue> PostTest() {
//    	Document doc = Jsoup.connect("http://example.com/").get();
//    	String title = doc.title();
//    	
//    }
    
    @GetMapping("/city/{cityName}")
    public ArrayList<ArrayList<String>> PostTest(@PathVariable String cityName) {
    	System.out.println(cityName);
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	
    	try {
    		Connection conn = Jsoup.connect("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
    		Document doc = conn.get();
    		Elements eles = doc.select("location");
    		
    		for (Element ele : eles) {
    			Elements city = ele.select("city");
    			
    			if (city.text().equals(cityName)) {
    				
    				Elements data = ele.select("data");
        			
        			for (Element dat : data) {
        				
        				ArrayList<String> babo = new ArrayList<String>();
        				
        				Elements tmEf = dat.select("tmEf");
        				Elements wf = dat.select("wf");
        				Elements tmn = dat.select("tmn");
        				Elements tmx = dat.select("tmx");
        				
        				babo.add(tmEf.text());
        				babo.add(wf.text());
        				babo.add(tmn.text());
        				babo.add(tmx.text());
        				
        				result.add(babo);
        				
        			}
    			}
    		}
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
    	
    	System.out.println(result);
    	return result;
    }
    
    
    
    // https://jjluveeecom.tistory.com/50
}
