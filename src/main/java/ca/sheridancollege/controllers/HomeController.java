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
import org.springframework.web.servlet.ModelAndView;

import ca.sheridancollege.beans.Article;
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
	
	//	This method finds all articles and stores them as
	//	a list in the model object
	@GetMapping("/goWiki")
	public String goToWikiList( Model model ) 
	{
		ArrayList<Article> wikiArticles = (ArrayList<Article>) articleRepo.findAll();
		model.addAttribute( "wikiArticles" , wikiArticles );
		
		return "wiki/wikiListDisplay.html";
	}
	
	//	This method takes an article ID as input,
	//	finds the article with the matching ID
	//	adds that article to the model to be displayed
	@GetMapping("/wiki/{id}")
	public String goToWikiArticle( @PathVariable int id , Model model , @ModelAttribute Article article ) 
	{
		article = articleRepo.findById( id );
		model.addAttribute( article );
		
		return "wiki/wikiArticleDisplay.html";
	}

	// 	This method creates a model object and fills it 
	//	with the values given in the form.
	//	It then passes this object to the next method with a POST request
	@GetMapping("/wiki/add")
	public String addWiki( Model model ) 
	{
		model.addAttribute( new Article() );
		
		return "wiki/addWikiArticle.html";
	}
	
	// 	This method receives the empty article object from the GET mapping.
	// 	It then stores the article in its respective CRUD repository
	@PostMapping("/wiki/add")
	public String addWiki( Model model , @ModelAttribute Article article ) 
	{
		articleRepo.save( article );
		
		return "wiki/addWikiArticle.html";
	}
	
	//	This method looks up the article associated with the ID given in the URL.
	//  It then adds said article to the model
	@GetMapping("/wiki/edit/{id}")
	public String editWikiArticle( @PathVariable int id , Model model ) 
	{
		Article article = articleRepo.findById( id );
		model.addAttribute( article );
		
		return "wiki/editWikiArticle.html";
	}
	
	//	This method takes the data from the POST request and changes the values stored in the old article with the new values
	//	It then saves the new article in the Article repo
	@PostMapping("/wiki/edit/{id}")
	public ModelAndView  editWikiArticle( @PathVariable int id , Model model , @ModelAttribute Article article ) 
	{
		Article newArticle = new Article();
		newArticle.setTitle( article.getTitle() ); 
		newArticle.setBody( article.getBody() );
		
		articleRepo.deleteById( id );
		articleRepo.save( newArticle );
	
		return new ModelAndView("redirect:/wiki" );
	}
	
	@GetMapping("/about")
	public String goAbout() {
		return "about.html";
	}

}
