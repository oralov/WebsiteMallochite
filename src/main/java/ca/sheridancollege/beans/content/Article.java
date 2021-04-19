package ca.sheridancollege.beans.content;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ca.sheridancollege.beans.users.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private String body;
	private String templateLocation;
	private Optional<User> author;
	
}
