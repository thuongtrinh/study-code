import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'toggle',
  templateUrl: './toggle.component.html',
  styleUrls: ['./toggle.component.css']
})
export class ToggleComponent implements OnInit {

  @Input() checked: boolean;
  @Output() checkedChange = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

  toggle() {
    this.checkedChange.emit(!this.checked);
  }
}
