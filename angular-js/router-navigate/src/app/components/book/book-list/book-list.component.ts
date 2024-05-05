import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/book.service';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: []
})
export class BookListComponent implements OnInit {

  promiseBooks: Promise<Book[]>;
  observableBooks: Observable<Book[]>;
  errorMessage: string;

  constructor(private bookService: BookService, private userService: UserService) { }

  ngOnInit() {
    this.initBooksPromise();
    this.initBooksObservable();
  }

  initBooksObservable() {
    this.observableBooks = this.bookService.getBooksWithObservable();
  }

  private initBooksPromise() {
    this.promiseBooks = this.bookService.getBooksWithPromise();
  }
}
