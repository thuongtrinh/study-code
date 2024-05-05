import { Component } from '@angular/core';

@Component({
  selector: 'app-template-driven-form-toggle',
  templateUrl: './template-driven-form-toggle.component.html',
})
export class TemplateDrivenFormToggleComponent {

  constructor() {
  }

  onFormSubmit(form) {
    this.savePerson(form.value);
  }

  savePerson(person) {
    console.log(person);
  }
}
