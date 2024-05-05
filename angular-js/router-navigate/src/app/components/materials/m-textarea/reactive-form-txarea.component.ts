import { Component, ViewChild, NgZone } from '@angular/core';
import { FormControl, Validators, FormBuilder } from '@angular/forms';
import { CdkTextareaAutosize } from '@angular/cdk/text-field';
import { take } from 'rxjs/operators';
import { PersonM } from '../models/personM';
import { CustomErrorStateMatcher } from './custom-error-state-matcher';

@Component({
  selector: 'app-reactive-form-txarea',
  templateUrl: './reactive-form-txarea.component.html',
})
export class ReactiveFormTxareaComponent {

  constructor(private ngZone: NgZone, private formBuilder: FormBuilder) { }

  // Textarea validation
  commentFC = new FormControl('', [
    Validators.required,
    Validators.maxLength(30)
  ]);

  // Textarea autosize
  @ViewChild('autosize', {static: true})
  txtAreaAutosize: CdkTextareaAutosize;

  descFC = new FormControl('', [
    Validators.required
  ]);

  // resizeToFitContent() and Reset() test
  @ViewChild('cfcAutosize', {static : true})
  contentFCAutosize: CdkTextareaAutosize;

  contentFC = new FormControl();

  // Create a form
  personForm = this.formBuilder.group({
    name: ['', Validators.required],
    address: ['', [Validators.required, Validators.maxLength(100)]],
    favColor: '#e66465',
    dob: '',
    tob: '',
    age: ''
  });

  // Textarea validation
  esMatcher = new CustomErrorStateMatcher();
  personObj = '';

  // Input text validation
  amount = new FormControl('', [
    Validators.required,
    Validators.min(5),
    Validators.max(200)
  ]);

  // Textarea validation
  commentFC2 = new FormControl('', [
    Validators.required,
    Validators.maxLength(10)
  ]);

  onCommentChange() {
    console.log(this.commentFC.value);
  }

  onDescChange() {
    console.log('enabled: ' + this.txtAreaAutosize.enabled);
    console.log('minRows: ' + this.txtAreaAutosize.minRows);
    console.log('maxRows: ' + this.txtAreaAutosize.maxRows);
    console.log('Description: ' + this.descFC.value);
  }

  resetTextAreaSize() {
    this.contentFCAutosize.reset();
  }

  resizeTextArea() {
    this.ngZone.onStable.pipe(take(1)).subscribe(() => this.contentFCAutosize.resizeToFitContent(true));
  }

  onFormSubmit() {
    this.savePerson(this.personForm.value);
  }

  get name() {
    return this.personForm.get('name');
  }

  get address() {
    return this.personForm.get('address');
  }

  savePerson(person) {
    console.log(person);
    this.personObj = 'Name: ' + person.name + ' | Address: ' + person.address
      + ' | Favorite color: ' + person.favColor + ' | Birth: ' + person.dob
      + ' | Time: ' + person.tob + ' | Age: ' + person.age;
  }

  onAmountChange() {
    console.log(this.amount.value);
    console.log(this.amount.valid);
  }
}
