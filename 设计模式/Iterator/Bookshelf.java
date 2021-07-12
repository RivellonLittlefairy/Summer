package Iterator;

import java.util.ArrayList;

interface Aggregate{
    Iterator iterator();
}
class Book{
    String name;

    public Book(String name) {
        this.name = name;
    }
}
class BookShelfIterator implements Iterator{
    Bookshelf bs;
    int p;
    public BookShelfIterator(Bookshelf bs) {
        this.bs = bs;
        p=0;
    }

    @Override
    public boolean hasNext() {
        return p<bs.books.size();
    }

    @Override
    public Object next() {
        return bs.books.get(p++);
    }
}
public class Bookshelf implements Aggregate{
    ArrayList<Book> books= new ArrayList<>();
    int booksNum=0;
    public void add(Book book){
        books.add(book);
        booksNum++;
    }
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }
}
