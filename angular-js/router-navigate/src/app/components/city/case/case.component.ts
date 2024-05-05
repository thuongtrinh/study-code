import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-case',
  templateUrl: './case.component.html',
})
export class CaseComponent implements OnInit {

  @Input() myName: string;
  @Output() myNameChange = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }

  changeCase(val: string) {
    if (val === 'upper') {
      this.myName = this.myName.toUpperCase();
    } else {
      this.myName = this.myName.toLowerCase();
    }

    this.myNameChange.emit(this.myName);
  }
}
