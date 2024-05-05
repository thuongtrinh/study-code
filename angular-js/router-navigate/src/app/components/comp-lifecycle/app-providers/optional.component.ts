import { Component, OnInit, Optional } from '@angular/core';
import { LionService } from './services/lion.service';

@Component({
  selector: 'app-optional',
  providers: [
    // { provide: LionService }
  ],
  template: `
    <p>The @Optional() decorator makes dependency injection optional.
      It means if service is not available for injection then null will be assigned</p>
  `,
})
export class OptionalComponent implements OnInit {

  constructor(@Optional() private lionService: LionService) { }

  ngOnInit() {
  }

}
