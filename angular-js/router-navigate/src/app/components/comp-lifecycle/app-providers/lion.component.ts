import { Component, OnInit } from '@angular/core';
import { AnimalService } from './services/animal.service';
import { LionService } from './services/lion.service';

@Component({
  selector: 'app-lion',
  providers: [
    { provide: AnimalService, useClass: LionService }
  ],
  template: `
    <app-animal-details></app-animal-details>
  `,
})
export class LionComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
