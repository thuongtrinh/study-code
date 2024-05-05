import { Injectable } from '@angular/core';
import { Book } from '../models/book.model';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { BookDetail } from '../models/bookDetail';
import { Writer } from '../models/writer';

const BOOKS: Book[] = [
  { bookId: 1, name: 'Java', author: 'Mahesh', state: 'off' },
  { bookId: 2, name: 'Angular', author: 'Mahesh', state: 'off' },
  { bookId: 3, name: 'Spring', author: 'Krishna', state: 'off' },
  { bookId: 4, name: 'Hibernate', author: 'Krishna', state: 'off' }
];

let booksPromise = Promise.resolve(BOOKS);

@Injectable({
  providedIn: 'root'
})
export class BookService {

  // url = 'http://localhost:4200/assets/data/bookData.json';
  url = '/api/books';
  urlBookDetails = '/api/bookDetails';
  urlWriter = '/api/writer';
  urlInvalid = '/api/invalid';

  constructor(private http: HttpClient) {}

  getBook(id: string): Promise<Book> {
    const idCover = parseInt(id);
    return booksPromise.then(books =>
      books.find(book => book.bookId === idCover)
    );
  }

  getBooks(): Promise<Book[]> {
    return booksPromise;
  }

  resetBookState(book: Book): Promise<Book[]> {
    return this.getBooks().then(books => {
      books.map(book => (book.state = 'off'));
      book.state = 'on';
      return books;
    });
  }

  addBook(book: Book): Promise<Book> {
    return this.getBooks().then(books => {
      const maxIndex = books.length - 1;
      const bookWithMaxIndex = books[maxIndex];
      book.bookId = bookWithMaxIndex.bookId + 1;
      book.state = 'off';
      books.push(book);
      return book;
    });
  }

  getBooksWithObservable(): Observable<Book[]> {
    return this.http.get<Book[]>(this.url);
  }

  getBooksWithPromise(): Promise<Book[]> {
    return this.http.get<Book[]>(this.url).toPromise();
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    // return Observable.throw(error.message || error);
    return throwError(error.message || error);
  }

  addBookWithObservable(book: Book): Observable<HttpResponse<Book>> {
    const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Book>(this.url, book, { headers: httpHeaders, observe: 'response' });
  }

  getAllBookDetails(): Observable<BookDetail[]> {
    return this.http.get<BookDetail[]>(this.urlBookDetails);
  }

  filterBooks(category: string, year: string) {
    let httpHeaders = new HttpHeaders().set('Accept', 'application/json');
    return this.http.get<BookDetail[]>(this.urlBookDetails + '?category=' + category + '&year=' + year, {
      headers: httpHeaders,
      responseType: 'json'
    });
  }

  getWriterWithFavBooks(): Observable<any> {
    return this.http.get(this.urlWriter, {responseType: 'json'});
  }

  getFavoriteWriter(): Observable<Writer> {
    return this.http.get<Writer>(this.urlWriter, {responseType: 'json'});
  }

  getFullResponseForWriter(): Observable<HttpResponse<any>> {
    return this.http.get(this.urlInvalid, {
      observe: 'response'
    });
  }

  getDataForUrlInvalid(): Observable<any> {
    return this.http.get(this.urlInvalid);
  }

  getFavBookFromStore(id: number): Observable<BookDetail> {
    return this.http.get<BookDetail>(this.urlBookDetails + '/' + id);
  }

  getBooksByCategoryFromStore(category: string): Observable<BookDetail[]> {
    return this.http.get<BookDetail[]>(this.urlBookDetails + '?category=' + category);
  }
}
