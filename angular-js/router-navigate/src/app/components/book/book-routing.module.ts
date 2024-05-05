import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './book.component';
import { BookAddComponent } from './book-add/book-add.component';
import { BookUpdateComponent } from './book-update/book-update.component';
import { BookDetailComponent } from './book-detail/book-detail.component';

const bookRoutes: Routes = [
  {
    path: '',
    component: BookComponent
  },
  {
    path: 'book-add',
    component: BookAddComponent,
    outlet: 'bookPopup'
  },
  {
    path: 'book-detail',
    component: BookDetailComponent,
    outlet: 'bookPopup'
  },
  {
    path: 'book-edit/:book-id',
    component: BookUpdateComponent,
    outlet: 'bookPopup'
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(bookRoutes) ],
  exports: [ RouterModule ],
  providers: []
})
export class BookRoutingModule {}
