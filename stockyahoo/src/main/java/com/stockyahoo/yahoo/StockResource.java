package com.stockyahoo.yahoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/view")
    public List<Map<String,Object>> getStock(/*@PathVariable("username") final String userName*/) {

        /*ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:8300/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });


        List<String> quotes = quoteResponse.getBody();*/
    	List<String> quotes = new ArrayList<String>();
    	quotes.add("TATASTEEL");
    	quotes.add("IDBI");
    	quotes.add("SBIN");
    	quotes.add("INFY");
    	quotes.add("ASHOKLEY");
    	List<Map<String,Object>> quoteDetailsList=  quotes
                .stream()
                .map(this::getStockPrice)
                .collect(Collectors.toList());
    	System.out.println(quoteDetailsList);
    	
    	return quoteDetailsList;
    }

    private java.util.Map<String, Object> getStockPrice(String quote) {
        //return YahooFinance.get(quote);
		String apiKey = "NXEAYL4XF4O182HU";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
		 Map<String,Object> data= new HashMap<String,Object>();
		try {
		  IntraDay response = stockTimeSeries.intraDay(quote, Interval.FIFTEEN_MIN);
		  List<StockData> stockData = response.getStockData();
		
		  stockData.forEach(stock -> {
		    data.put("date",stock.getDateTime());
		    data.put("open" ,stock.getOpen());
		    data.put("high" ,stock.getHigh());
		    data.put("low" , stock.getLow());
		    data.put("close" , stock.getClose());
		    data.put("volume" , stock.getVolume());
		  });
		  System.out.println("###"+data);
		  return data;
		} catch (AlphaVantageException e) {
//		  System.err.println(e.getMessage());
		  e.printStackTrace();
			data.put("error" , e.getMessage()+" to API!!!");
		  return  data;
		}
    	
		
    }
}
