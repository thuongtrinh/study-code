import { Component, OnInit, ContentChildren, QueryList } from '@angular/core';
import { BookDirective } from '../directives/book.directive';

@Component({
  selector: 'app-favourite-books',
  templateUrl: './favourite-books.component.html',
})
export class FavouriteBooksComponent implements OnInit {

  @ContentChildren(BookDirective) topBooks: QueryList<BookDirective>;
  @ContentChildren(BookDirective, {descendants: true}) allBooks: QueryList<BookDirective>;

  constructor() { }

  ngOnInit() {
  }

}
