import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-writer2',
  templateUrl: './writer2.component.html',
})
export class Writer2Component implements OnInit {

  @Input('name') writerName: string;
  @Input('book') bookName: string;

  constructor() { }

  ngOnInit() {
  }

}
