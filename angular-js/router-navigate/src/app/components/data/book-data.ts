import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { Observable } from 'rxjs';

export class BookData implements InMemoryDbService {

  createDb(reqInfo?: RequestInfo): {} | Observable<{}> | Promise<{}> {

    let books = [
      { bookId: 1, name: 'English', author: 'Marry', state: 'off' },
      { bookId: 2, name: 'Algorithm', author: 'Johson', state: 'on' },
      { bookId: 3, name: 'AI', author: 'Nick Bostrom', state: 'off' },
      { bookId: 4, name: 'BigData', author: 'Jack', state: 'on' }
    ];

    let bookDetails = [
      { id: '101', name: 'Angular 2 by Krishna', category: 'Angular', year: '2015' },
      { id: '102', name: 'AngularJS by Krishna', category: 'Angular', year: '2015' },
      { id: '103', name: 'Angular 2 by Vishnu', category: 'Angular', year: '2016' },
      { id: '104', name: 'Core Java by Vishnu', category: 'Java', year: '2016' },
      { id: '105', name: 'JSP & Servlet by Vishnu', category: 'Java', year: '2016' },
      { id: '106', name: 'JPA by Vishnu', category: 'Java', year: '2016' },
      { id: '107', name: 'Hibernate by Krishna', category: 'Hibernate', year: '2015' }
    ];

    // JSON data
    let writerDetails = {
        writerId: 11, writerName: 'Mahesh',
        bookDetails: [
          { id: '103', name: 'Angular Tutorial', category: 'Angular', year: '2016' },
          { id: '104', name: 'Core Java Tutorial', category: 'Java', year: '2015' }
        ]
    };

    // Text data
    let welcomeMsg = 'Welcome to the Angular world!';

    return { books, bookDetails, writer: writerDetails, message: welcomeMsg };
  }
}
