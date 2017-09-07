package week3_1;

public class TestBook {

    public static void main(String[] args) {
        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        Book aBook = new Book("Java for dummy", 19.95, 1000);
        aBook.addAuthor(anAuthor);
// Use an anonymous instance of Author
        Book anotherBook = new Book("More Java for dummy",
        29.95, 888);
        anotherBook.addAuthor(new Author("Lili", "123@246.com", 'f'));
        aBook.addAuthor(new Author("Lili", "123@246.com", 'f'));
        aBook.removeAuthorByName("Tan Ah Teck");

        aBook.printAuthors();
        anotherBook.printAuthors();

    }
}