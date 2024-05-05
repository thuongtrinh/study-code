import { Component, OnInit, ViewChildren, QueryList, AfterViewInit, ViewChild, TemplateRef, ViewContainerRef } from '@angular/core';
import { MessageDirective } from '../directives/message.directive';

@Component({
  selector: 'app-vc-demo2',
  templateUrl: './vc-demo2.component.html',
})
export class VcDemo2Component implements OnInit, AfterViewInit {

  @ViewChildren(MessageDirective)
  private msgList: QueryList<MessageDirective>;

  @ViewChildren(MessageDirective, {read: ViewContainerRef})
  private msgList1: QueryList<ViewContainerRef>;

  @ViewChild('msgTemp', {static: false})
  private msgTempRef: TemplateRef<any>;

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    console.log('======Viewchildren + Directive======');
    console.log('length: ' + this.msgList.length);

    // Way read 1
    this.msgList.forEach(msgDirective => msgDirective.viewContainerRef.createEmbeddedView(this.msgTempRef));

    // Way read 2: use read metadata to read ViewContainerRef directly from the directive.
    this.msgList1.forEach(msgDirective => msgDirective.createEmbeddedView(this.msgTempRef));
  }
}
