package ca.sheridancollege.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
abstract public class User
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	
	private String username;
	private String encryptedpassword;
	private Byte enabled;
	
	public User( String username, String encryptedpassword , Byte roleValue ) 
	{
		this.username = username;
		this.encryptedpassword = encryptedpassword;
		this.enabled = roleValue;
	}
	
	public User( Byte roleValue ) 
	{
		this.enabled = roleValue;
	}

}
