package ca.sheridancollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.content.Article;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
	
	
	//	Author: Andrew Hollands
	//	Date:	April 19th 2021
	// gotToWiki() , addWiki() , getWikiList
	//	This method takes an article ID as input
	@GetMapping("/wiki/{id}")
	public String goToWikiArticle( @PathVariable int id , Model model ) 
	{
		
		
		return "wikiArticleDisplay.html";
	}
	
	@GetMapping("/wiki/")
	public String goToWikiList( Model model ) 
	{
		
		
		return "wikiArticleDisplay.html";
	}

	@GetMapping("/wiki/add")
	public String addWiki( Model model ) 
	{
		
		
		return "wikiArticleDisplay.html";
	}
	
	@PostMapping("/wiki/add")
	public String addWiki( Model model , @ModelAttribute Article article ) 
	{
		
		
		return "wikiArticleDisplay.html";
	}

}
