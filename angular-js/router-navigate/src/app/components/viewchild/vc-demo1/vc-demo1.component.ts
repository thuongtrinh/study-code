import { Component, ViewChildren, QueryList, AfterViewInit, ElementRef, ViewContainerRef, OnInit } from '@angular/core';
import { Writer2Component } from '../writer2/writer2.component';

@Component({
  selector: 'app-vc-demo1',
  templateUrl: './vc-demo1.component.html',
})
export class VcDemo1Component implements AfterViewInit, OnInit {

  @ViewChildren(Writer2Component)
  writers1: QueryList<Writer2Component>;

  @ViewChildren(Writer2Component, { read: ElementRef })
  writers2: QueryList<ElementRef>;

  @ViewChildren(Writer2Component, { read: ViewContainerRef })
  writers3: QueryList<ViewContainerRef>;

  @ViewChildren('bkWriter')
  writers4: QueryList<Writer2Component>;

  allWritersVisible = false;

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    console.log('--- @ViewChildren + Component ---');
    this.writers1.changes.subscribe(list => {
      list.forEach(writer => console.log(writer.writerName + ' - ' + writer.bookName));
    });

    console.log(this.writers1.length);
    console.log('Result with ElementRef:');
    this.writers2.forEach(el => console.log(el));

    console.log('Result with ViewContainerRef:');
    this.writers3.forEach(vref => console.log(vref));

    console.log('--- @ViewChildren + Component Ex2 ---');
    this.writers4.forEach(vref => console.log(vref));
  }

  onShowAllCities() {
    this.allWritersVisible = !this.allWritersVisible;
  }
}
