package resources;

public enum APIResources { //Enum is a special class in java which has a collection of constants and methods
	
	PayoutAPI ("/v3/transfers"),
	GetBanksAPI("/v3/banks");
	
	private String resource;
	
	APIResources(String resource)
	{
	  this.resource=resource;	
	}
	
	
	public String getResource()
	{
		return resource;
	}

}
