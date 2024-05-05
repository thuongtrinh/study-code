import { Component, OnInit, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-my-post',
  templateUrl: './my-post.component.html',
})
export class MyPostComponent implements OnInit {

  constructor(public viewContainerRef: ViewContainerRef) { }

  ngOnInit() {
  }

}
