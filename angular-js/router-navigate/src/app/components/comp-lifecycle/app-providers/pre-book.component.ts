import { Component, OnInit, Inject } from '@angular/core';
import { BookaService } from './services/booka.service';
import { Booka } from './services/booka';
import { PREFERRED_BOOK, preferredBooksFactory } from './preferred-book';

const JAVA_BOOK = new Booka('Thinking in Java', 'Java');

@Component({
  selector: 'app-pre-book',
  providers: [
    BookaService,
    { provide: Booka, useValue: JAVA_BOOK },
    {
      provide: PREFERRED_BOOK,
      useFactory: preferredBooksFactory(3),
      deps: [Booka, BookaService]
    }
  ],
  template: `
    <b>Preferred Books</b>
    <p>{{ preferredBooks }}</p>
  `,
})
export class PreBookComponent implements OnInit {

  constructor(@Inject(PREFERRED_BOOK) private preferredBooks: string) {}

  ngOnInit() {
  }

}
