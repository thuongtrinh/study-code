import { Component, OnInit } from '@angular/core';
import { PersonPipe } from 'src/app/models/personPipe.model';
import { CompanyPipe } from 'src/app/models/companyPipe.model';
import { Observable, Subscriber } from 'rxjs';
import { BookPipe } from 'src/app/models/bookPipe.model';

@Component({
  selector: 'app-custom-pipe',
  templateUrl: './custom-pipe.component.html',
})
export class CustomPipeComponent implements OnInit {

  // Pipes: welcome, repeat, myjson
  person: PersonPipe = new PersonPipe(1, 'Vietnam', 28);

  // Pipes: strformat, myuppercaseone, myuppercasetwo
  message = 'My name is ThuongTX';

  // Pipes: division
  dividend = 23;
  divisor = 7;

  // For pure and impure pipe
  compName = 'ABCD LTD';
  compLocation = 'HCMC';
  company = new CompanyPipe(this.compName, this.compLocation);

  // Asyn pipe time
  observableTime: Observable<string>;
  promiseBook: Promise<BookPipe>;

  constructor() { }

  ngOnInit() {
    this.observableTime = this.getCurrentTime();
    this.promiseBook = this.getBookSlowly();
  }

  // Impure change because there is no change in object reference: company
  // Impure pipe will run again and Pure pipe will do nothing.
  updateCompany() {
    this.company.cname = this.compName;
    this.company.location = this.compLocation;
  }

  // Pure change because there is change in object reference: company
  // Impure pipe and Pure pipe both will run again.
  createCompany() {
    this.company = new CompanyPipe(this.compName, this.compLocation);
  }

  getCurrentTime(): Observable<string> {
    return new Observable<string>((observer: Subscriber<string>) => {
      setInterval(() => observer.next(new Date().toString()), 1000);
    });
  }

  getBookSlowly(): Promise<BookPipe> {
    return new Promise(resolve => {
        const book = new BookPipe();
        book.id = 100;
        book.name = 'jQuery Tutorials';

        // Delay by 3 second
        setTimeout(() => resolve(book), 3000);
    });
  }
}
