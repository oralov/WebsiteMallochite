package ca.sheridancollege.repositories;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.content.Article;


public interface ArticleRepository extends CrudRepository<Article , Integer> 
{
	public Article findByTitle( String title );
	public Article findById( int id );
}
