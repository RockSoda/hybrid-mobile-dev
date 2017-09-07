package week2_1;

public class TestBook {

    public static void main(String[] args) {
        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
// Use an anonymous instance of Author
        Book anotherBook = new Book("More Java for dummy",
                new Author("Lili", "123@246.com", 'f'),
        29.95, 888);

        System.out.println(aBook.getAuthorName());
        System.out.println(aBook.getAuthorEmail());
        System.out.println(aBook.getAuthorGender());

    }
}