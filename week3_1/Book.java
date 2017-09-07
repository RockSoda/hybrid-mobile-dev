package week3_1;

import java.util.LinkedList;

public class Book {

    private String name;
    private LinkedList<Author> author = new LinkedList<Author>();
    private int numAuthors;
    private double price;
    private int qtyInStock = 0;


    public Book (String name, double price) {
        this.name = name;
        this.price = price;

    }
    public Book (String name, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName(){
        return name;
    }
    public Author[] getAuthors(){
        int i = 0;
        Author[] authors = new Author[numAuthors];
        while(i < numAuthors){
            authors[i] = author.get(i);
            i++;
        }

        return authors;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getQtyInStock(){
        return qtyInStock;
    }
    public void setQtyInStock(int qtyInStock){
        this.qtyInStock = qtyInStock;
    }
    public String toString(){
        System.out.print(name + "' by ");
        printAuthors();
        return "";
    }
    public void printAuthors(){
        int i = 0;
        while (i < numAuthors){
            System.out.println(author.get(i).toString());
            i++;
        }
    }
    public void addAuthor(Author author){
        this.author.add(author);
        numAuthors++;
    }
    public boolean removeAuthorByName(String authorName){
        int i = 0;
        while(i < numAuthors){
            if(author.get(i).getName().equalsIgnoreCase(authorName)){
                author.remove(i);
                numAuthors--;
                return true;
            }
            i++;
        }
        return false;
    }

}
