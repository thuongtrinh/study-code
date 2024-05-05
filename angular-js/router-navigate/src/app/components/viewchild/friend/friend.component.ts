import { Component, OnInit, ContentChild, ElementRef, AfterContentInit } from '@angular/core';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
})
export class FriendComponent implements OnInit, AfterContentInit {

  @ContentChild('name', {static: false}) nameRef: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  get friendName(): string {
    return this.nameRef.nativeElement.innerHTML;
  }

  ngAfterContentInit() {
    console.log(this.friendName);
 }
}
