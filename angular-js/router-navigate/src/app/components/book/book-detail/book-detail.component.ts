import { Component, OnInit, HostBinding } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/book.service';
import { FLY_IN_OUT_ANIMATION } from 'src/app/animations/fly-in-out.animation';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styles: [ ':host { position: absolute; top: 20%; left: 5%; border: 3px solid black; }' ],
  animations: [FLY_IN_OUT_ANIMATION]
})
export class BookDetailComponent implements OnInit {

  @HostBinding('@flyInOutTrigger') flyInOutTrigger = 'in';
  books: Promise<Book[]>;

  constructor(private bookService: BookService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    console.log('Book detail start');
    this.books = this.bookService.getBooks();
  }

  close() {
    this.router.navigate( [{ outlets: null  }], { relativeTo: this.route });
  }
}
