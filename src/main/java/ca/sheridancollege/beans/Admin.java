package ca.sheridancollege.beans;

import java.util.List;

import lombok.Builder;

@Builder
public class Admin extends User
{
	final private static Byte roleValue = 2;
	
	public Admin() 
	{
		super ();
	}
	
	public Admin( String username, String encryptedpassword ) 
	{
		super ( username , encryptedpassword , roleValue );
	}
}
