package com.example.codingController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("{text}")
	public String dojo(@PathVariable("text") String track) {
		if(track.equals("dojo")) {
			return "The dojo is awesome!";
		}
		
		else if(track.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		
		else if(track.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		
		else {
			return "URL Not Defined!";
		}
	}
	
}
