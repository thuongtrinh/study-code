import { Component, OnInit } from '@angular/core';
import { AnimalService } from './services/animal.service';

@Component({
  selector: 'app-any-animal',
  providers: [AnimalService],
  template: `
    <app-animal-details></app-animal-details>
  `,
})
export class AnyAnimalComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
