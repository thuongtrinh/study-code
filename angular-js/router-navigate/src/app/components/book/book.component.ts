import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/models/book.model';
import { ON_OFF_ANIMATION } from 'src/app/animations/on-off.animation';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss'],
  animations: [ON_OFF_ANIMATION]
})
export class BookComponent implements OnInit {
  books: Promise<Book[]>;

  constructor(
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.books = this.bookService.getBooksWithPromise();
  }

  edit(book: Book) {
    this.bookService.resetBookState(book).then(() => {
      this.router.navigate(
        [{ outlets: { bookPopup: ['book-edit', book.bookId] } }],
        { relativeTo: this.route }
      );
    });
  }
}
