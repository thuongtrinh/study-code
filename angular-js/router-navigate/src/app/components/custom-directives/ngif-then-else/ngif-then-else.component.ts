import { Component, OnInit, TemplateRef, ViewChild, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-ngif-then-else',
  templateUrl: './ngif-then-else.component.html'
})
export class NgifThenElseComponent implements OnInit, AfterViewInit {

  isValid = true;
  age = 12;

  myThenBlock: TemplateRef<any> = null;
  myElseBlock: TemplateRef<any> = null;

  @ViewChild('firstThenBlock', {static: true})
  firstThenBlock: TemplateRef<any> = null;
  @ViewChild('secondThenBlock', {static: true})
  secondThenBlock: TemplateRef<any> = null;

  @ViewChild('firstElseBlock', {static: true})
  firstElseBlock: TemplateRef<any> = null;
  @ViewChild('secondElseBlock', {static: true})
  secondElseBlock: TemplateRef<any> = null;

  @ViewChild('someElement', {static: false}) someElement;

  constructor() {}

  ngOnInit() {
    this.myThenBlock = this.firstThenBlock;
    this.myElseBlock = this.firstElseBlock;
  }

  ngAfterViewInit(): void {
    // this.someElement.
  }

  changeValue(valid: boolean) {
    this.isValid = valid;
  }

  toggleThenBlock() {
    this.myThenBlock = this.myThenBlock === this.firstThenBlock ? this.secondThenBlock : this.firstThenBlock;
  }

  toggleElseBlock() {
    this.myElseBlock = this.myElseBlock === this.firstElseBlock ? this.secondElseBlock : this.firstElseBlock;
  }
}
