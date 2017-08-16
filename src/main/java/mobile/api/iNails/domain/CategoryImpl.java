package mobile.api.iNails.domain;

public class CategoryImpl implements Category{
    private int categoryID;
    private String name;
	public CategoryImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryImpl(int categoryID, String name) {
		super();
		this.categoryID = categoryID;
		this.name = name;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
