import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-selectbox',
  templateUrl: './selectbox.component.html',
})
export class SelectboxComponent implements OnInit {

  @Input() cdColor: Array<string>;
  myColor = 'GREEN';

  constructor() { }

  ngOnInit() {
  }

}
