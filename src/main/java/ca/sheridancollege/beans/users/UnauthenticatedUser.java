package ca.sheridancollege.beans.users;

import lombok.Builder;

@Builder
public class UnauthenticatedUser extends User 
{
	final private static Byte roleValue = 0;
	
	public UnauthenticatedUser() 
	{
		super ( roleValue );
	}
}
