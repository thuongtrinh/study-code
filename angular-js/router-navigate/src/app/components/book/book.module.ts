import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookService } from 'src/app/services/book.service';
import { BookAddComponent } from './book-add/book-add.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookUpdateComponent } from './book-update/book-update.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BookRoutingModule } from './book-routing.module';
import { BookComponent } from './book.component';
import { HttpClientModule } from '@angular/common/http';
import { BookListComponent } from './book-list/book-list.component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { BookData } from '../data/book-data';
import { WriterComponent } from './writer/writer.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BookRoutingModule,
    InMemoryWebApiModule.forRoot(BookData)
  ],
  declarations: [
    BookComponent,
    BookAddComponent,
    BookDetailComponent,
    BookUpdateComponent,
    BookListComponent,
    WriterComponent
  ],
  providers: [
    BookService
  ]
})
export class BookModule { }
