import { Component, OnInit, ContentChild } from '@angular/core';
import { BookDirective } from '../directives/book.directive';

@Component({
  selector: 'app-writer',
  templateUrl: './writer.component.html',
})
export class WriterComponent {

  @ContentChild(BookDirective, {static: false}) book: BookDirective;

  writerName = 'ThuongTX';

  constructor() { }

}
