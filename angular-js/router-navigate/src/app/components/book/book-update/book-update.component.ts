import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/book.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.scss']
})
export class BookUpdateComponent implements OnInit {
  book: Book;

  constructor(
    private bookService: BookService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    console.log('Edit book');
    this.activatedRoute.paramMap
      .pipe(
        map(params => params.get('book-id')),
        switchMap(id => this.bookService.getBook(id))
      )
      .subscribe(book => {
        this.book = book;
      });
  }

  update() {
    this.router.navigate([{ outlets: null }], {relativeTo: this.activatedRoute});
  }
}
