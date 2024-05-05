import { InjectionToken } from '@angular/core';
import { Booka } from './services/booka';
import { BookaService } from './services/booka.service';

export const PREFERRED_BOOK = new InjectionToken<string>('book name');

export function preferredBooksFactory(count: number) {
  return (myBook: Booka, bookService: BookaService): string => {
    return bookService.getAllBooks()
      .filter(book => book.category === myBook.category)
      .map(book => book.name).slice(0, Math.max(0, count))
      .join(' | ');
  };
}
