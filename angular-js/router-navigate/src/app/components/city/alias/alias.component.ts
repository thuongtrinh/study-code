import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-alias',
  templateUrl: './alias.component.html',
})
export class AliasComponent implements OnInit {

  @Input('myCity') strCity: string;
  @Output('myCityChange') cityObj = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }

  emitCity() {
    this.cityObj.emit(this.strCity);
  }
}
