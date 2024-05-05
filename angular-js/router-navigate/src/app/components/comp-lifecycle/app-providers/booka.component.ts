import { Component, OnInit, InjectionToken, Inject } from '@angular/core';
import { Booka } from './services/booka';

const JAVA_BOOK = new Booka('Learning Java', 'Java');
export const HELLO_MESSAGE = new InjectionToken<string>('Hello!');

@Component({
  selector: 'app-booka',
  providers: [
    { provide: Booka, useValue: JAVA_BOOK },
    { provide: HELLO_MESSAGE, useValue: 'Hello World!' }
  ],
  template: `
    <p>Book Name: <b>{{book.name}}</b> </p>
    <p>Category: <b>{{book.category}}</b></p>
		<p>Message: <b>{{message}}</b> </p>
  `,
})
export class BookaComponent implements OnInit {

  constructor(private book: Booka, @Inject(HELLO_MESSAGE) private message: string) { }

  ngOnInit() {
    this.message = 'ThuongTX';
  }

}
