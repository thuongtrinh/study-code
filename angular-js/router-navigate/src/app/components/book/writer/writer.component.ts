import { Component, OnInit } from '@angular/core';
import { Observable, throwError, of, from } from 'rxjs';
import { BookDetail } from 'src/app/models/bookDetail';
import { BookService } from 'src/app/services/book.service';
import { FormBuilder } from '@angular/forms';
import { Writer } from 'src/app/models/writer';
import { HttpErrorResponse } from '@angular/common/http';
import { map, mergeMap, retry, catchError, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-writer',
  templateUrl: './writer.component.html',
  styleUrls: []
})
export class WriterComponent implements OnInit {

  obsBookDetails: Observable<BookDetail[]>;
  bookDetails: BookDetail[];
  favBookDetails: BookDetail[];
  favWriter: Writer;
  writer: Writer;
  myAllfavBooks$: Observable<BookDetail[]>;
  favBookName$: Observable<string>;
  allFavBooks: BookDetail[];
  bookName: string | {};
  bookId: string;
  similarBookDetails$: Observable<BookDetail[]>;

  categories = [
    {category: 'Angular'},
    {category: 'Hibernate'},
    {category: 'Java'}
  ];
  years = [
    {year: '2015'},
    {year: '2016'}
  ];

  constructor(private bookService: BookService, private formBuilder: FormBuilder) { }

  bookDetailForm = this.formBuilder.group({
    category: '',
    year: ''
  });


  ngOnInit() {
    this.initData();
    this.getWriterWithFavBooks();
    this.getFavoriteWriter();
    this.getWriter();
    this.getData();

    this.getAllFavBooks();
    this.getBookName();
  }

  initData() {
    this.obsBookDetails = this.bookService.getAllBookDetails();
  }

  onFormSubmit() {
    const category = this.bookDetailForm.get('category').value;
    const year = this.bookDetailForm.get('year').value;
    this.filterBooks(category, year);
  }

  filterBooks(category: string, year: string) {
    this.bookService.filterBooks(category, year).subscribe(data => this.bookDetails = data);
  }

  getWriterWithFavBooks() {
    this.bookService.getWriterWithFavBooks().subscribe(data => {
      this.favBookDetails = data.bookDetails;
    });
  }

  getFavoriteWriter() {
    this.bookService.getFavoriteWriter().pipe(retry(2))
      .subscribe(
        data => {
          this.favWriter = data;
          console.log(this.favWriter.bookDetails);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
              // A client-side or network error occurred.
              console.log('An error occurred:', err.error.message);
          } else {
              // Backend returns unsuccessful response codes such as 404, 500 etc.
              console.log('Backend returned status code: ', err.status);
              console.log('Response body:', err.error);
          }
        }
      );
  }

  getWriter() {
    this.bookService.getFullResponseForWriter().subscribe(
      res => {
        this.writer = res.body;
        console.log(this.writer);
        console.log(this.writer.bookDetails);
        console.log(res.headers.get('content-Type'));
      },
      err => {
        console.log(err);
      }
    );
  }

  getData() {
    this.bookService.getDataForUrlInvalid().pipe(retry(3))
      .subscribe(
        res => {
          console.log(res);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            // A client-side or network error occurred.
            console.log('An error occurred:', err.error.message);
          } else {
            // Backend returns unsuccessful response codes such as 404, 500 etc.
            console.log('Backend returned status code: ', err.status);
            console.log('Response body:', err.error);
          }
        }
      );
  }

  getAllFavBooks() {
    this.myAllfavBooks$ = this.bookService.getFavBookFromStore(101)
      .pipe(mergeMap(book => this.bookService.getBooksByCategoryFromStore(book.category)));

      // Using subscribe
    this.bookService.getFavBookFromStore(101)
      .pipe(mergeMap(book => this.bookService.getBooksByCategoryFromStore(book.category)))
      .subscribe(books => this.allFavBooks = books);
  }

  getBookName() {
    this.favBookName$ = this.bookService.getFavBookFromStore(101).pipe(map(bookDetail => bookDetail.name));

    // get favorate book name second
    this.bookService.getFavBookFromStore(106)
      .pipe(map(book => {
          if (book.name.length < 15) {
            return book.name;
          } else {
            return throwError('Length less than 15');
          }
        }),
        catchError(error => {
          return throwError(error.message || error);
        })
      ).subscribe(name => {
          console.log('name is OK');
          console.log('name is:' + name);
          this.bookName = name ? name : '';
        },
        err => {
          console.log('name is NOT OK');
          console.log(err);
        }
      );
  }

  searchSimilarBooks(id: number) {
    this.similarBookDetails$ = this.bookService.getFavBookFromStore(id).pipe(
      switchMap(book => {
          const category = book.category;
          return this.bookService.getBooksByCategoryFromStore(category);
      }),
      catchError(err => of([]))
    );
  }
}
