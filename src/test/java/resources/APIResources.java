package resources;

public enum APIResources {
	AddBook("/v1/Books"),
	UpdateBook("/v1/Books/2"),
	DeleteBook("/v1/Books/22")
	;
	private String resource;
	


	APIResources(String resource) {
		this.resource = resource;
		
	}

	public String getResource()
	{
		return resource;
	}
	
}
