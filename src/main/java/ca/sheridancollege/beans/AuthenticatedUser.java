package ca.sheridancollege.beans;

import lombok.Builder;

@Builder
public class AuthenticatedUser extends User
{
	final private static Byte roleValue = 1;
	
	public AuthenticatedUser() 
	{
		super ();
	}
	
	public AuthenticatedUser( String username, String encryptedpassword ) 
	{
		super ( username , encryptedpassword , roleValue );
	}
}
