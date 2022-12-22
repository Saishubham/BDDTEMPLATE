package resources;

import pojo.book;

public class TestDataBuilder {
	public static book AddBookPayLoad(int id,String title,String description,int pageCount,String excerpt,String publishDate) {
		book b=new book();
		b.setId(id);
		b.setTitle(title);
		b.setDescription(description);
		b.setPageCount(pageCount);
		b.setExcerpt(excerpt);
		b.setPublishDate(publishDate);
		return b;
	}
	
	

}
