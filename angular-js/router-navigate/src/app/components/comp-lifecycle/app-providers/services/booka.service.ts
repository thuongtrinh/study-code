import { Injectable } from '@angular/core';
import { Booka } from './booka';

const BOOKS: Booka[] = [
  { name: 'Head First Java', category: 'Java' },
  { name: 'Hibernate in Action', category: 'Hibernate' },
  { name: 'Thinking in Java', category: 'Java' },
  { name: 'Beginning Hibernate', category: 'Hibernate' },
  { name: 'Effective Java', category: 'Java' },
  { name: 'Learning Java', category: 'Java' },
  { name: 'Hibernate Recipes', category: 'Hibernate' }
];

@Injectable()
export class BookaService {

  getAllBooks(): Booka[] {
    return BOOKS;
  }
}
