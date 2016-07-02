package Merchandise;

import java.util.LinkedList;
import java.util.List;

class Category {
    private static int number;
    private final int code;
    private String description;
    List<Merchandise> merchandises;
    
    public Category(String description) {
        this.code = number++;
        this.description = description;
        merchandises = new LinkedList<Merchandise>();
    }

    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Merchandise> getMerchandises() {
        return merchandises;
    }
    public void addMerchandises(Merchandise merchandise) {
        this.merchandises.add(merchandise);
    }

}
