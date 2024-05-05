import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { Observable } from 'rxjs';

export class TestData implements InMemoryDbService {

  createDb(reqInfo?: RequestInfo): {} | Observable<{}> | Promise<{}> {

    let articles = [
      {id: 1, title: 'Angular Tutorials', category: 'Angular'},
      {id: 2, title: 'Core Java Tutorial', category: 'Java'},
      {id: 3, title: 'Spring Tutorial', category: 'Java'},
      {id: 4, title: 'Hibernate Tutorial', category: 'Hibernate'}
    ];

    return { articles };
  }
}
