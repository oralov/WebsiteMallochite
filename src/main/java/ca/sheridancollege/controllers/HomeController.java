/*
*	Author: 	Andrew Hollands
*	Date:		April 19th 2021
* 	Worked on:	gotToWiki() , addWiki() , getWikiList , goToWikiArticle
*/

package ca.sheridancollege.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.content.Article;
import ca.sheridancollege.repositories.ArticleRepository;

@Controller
public class HomeController 
{
	
	@Autowired ArticleRepository articleRepo;
	
	
	@GetMapping("/")
	public String goHome() 
	{
		return "home.html";
	}
	
	
	@GetMapping("/wiki")
	public String goToWikiList( Model model ) 
	{
		ArrayList<Article> wikiArticles = (ArrayList<Article>) articleRepo.findAll();
		model.addAttribute( "wikiArticles" , wikiArticles );
		
		return "wiki/wikiListDisplay.html";
	}
	
	//	This method takes an article ID as input
	@GetMapping("/wiki/{id}")
	public String goToWikiArticle( @PathVariable int id , Model model , @ModelAttribute Article article ) 
	{
		model.addAttribute( article );
		
		return "wiki/wikiArticleDisplay.html";
	}

	@GetMapping("/wiki/add")
	public String addWiki( Model model ) 
	{
		
		
		return "wiki/addWikiArticle.html";
	}
	
	@PostMapping("/wiki/add")
	public String addWiki( Model model , @ModelAttribute Article article ) 
	{
		
		
		return "wiki/addWikiArticle.html";
	}

}
