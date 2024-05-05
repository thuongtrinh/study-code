import { InMemoryDbService } from 'angular-in-memory-web-api';

export class TestData2 implements InMemoryDbService {
  createDb() {
    let articleDetails = [
      {id: '1', title: 'Core Java Tutorial', category: 'Java'},
      {id: '2', title: 'Angular Tutorial', category: 'Angular'},
      {id: '3', title: 'Hibernate Tutorial', category: 'Hibernate'}
    ];
    return { articles2: articleDetails };
  }
}
