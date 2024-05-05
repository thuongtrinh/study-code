import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-textsize',
  templateUrl: './textsize.component.html',
})
export class TextsizeComponent implements OnInit {

  @Input() cdTextSize: number;
  @Output() cdTextSizeChange = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  plus() {
    this.cdTextSize = this.cdTextSize + 1;
    this.emitSize();
  }

  minus() {
      this.cdTextSize = this.cdTextSize - 1;
      this.emitSize();
  }

  emitSize() {
    this.cdTextSizeChange.emit(this.cdTextSize);
  }
}
