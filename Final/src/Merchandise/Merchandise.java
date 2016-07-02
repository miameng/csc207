package Merchandise;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

class Merchandise {
    private static int number;
	private Image image;
	private final int ID;
	private String discription;
	private List<Category> categories;
    
	public Merchandise(Image image, String discription) {
        this.image = image;
        ID = number++;
        this.discription = discription;
        categories = new LinkedList<Category>();
    }
    
	public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public int getID() {
        return ID;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void addCategory(Category category) {
        this.categories.add(category);
    }
	
	
}
