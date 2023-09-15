package me.erano.com.dto;

//json serialization ve deserialization için dto kullanıcaz
//hibernate mapping tarafında sıkıntı çıkıyor yoksa.
public class BookDto {
	
	private Long id;
    private String name;
    private Long authorId;
    
    public BookDto() {
    	
    }
    
	public BookDto(Long id, String name, Long authorId) {
		super();
		this.id = id;
		this.name = name;
		this.authorId = authorId;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
    
    
    
}
