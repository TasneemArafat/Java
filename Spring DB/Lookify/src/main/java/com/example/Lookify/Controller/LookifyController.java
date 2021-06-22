package com.example.Lookify.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Lookify.models.lookify;
import com.example.Lookify.services.lookifyService;

@Controller
public class LookifyController {
	private final lookifyService LookifyService;

	public LookifyController(lookifyService lookifyService) {
		LookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<lookify> listOfSongs = LookifyService.allsongs();
		model.addAttribute("listOfSongs",listOfSongs);
		return "dashboard.jsp";
		
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") lookify song) {
		return "newSong.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String addSong(@Valid @ModelAttribute("song") lookify song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		}
		else {
			LookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		lookify song = LookifyService.findById(id);
		model.addAttribute("song",song);
		return "show.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		LookifyService.destroy(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/search")
	public String findByArtist(@RequestParam(value="search", required=false) String artist, Model model) {
		model.addAttribute("listOfSongsFor",LookifyService.findByArtist(artist));
		model.addAttribute("artist", artist);
		return "artist.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		model.addAttribute("topTen",LookifyService.sortTop10ByRating());
		return "topTen.jsp";
	}
	

}
