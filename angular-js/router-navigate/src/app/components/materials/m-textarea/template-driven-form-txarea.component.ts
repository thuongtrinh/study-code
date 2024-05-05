import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomErrorStateMatcher } from './custom-error-state-matcher';

@Component({
  selector: 'app-template-driven-form-txarea',
  templateUrl: './template-driven-form-txarea.component.html',
})
export class TemplateDrivenFormTxareaComponent {

  constructor() {
  }

  esMatcher = new CustomErrorStateMatcher();

  onFormSubmit(form) {
  }
}
