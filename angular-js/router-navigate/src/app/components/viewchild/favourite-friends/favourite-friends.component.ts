import { Component, OnInit, ContentChildren, QueryList, ElementRef, AfterContentInit } from '@angular/core';

@Component({
  selector: 'app-favourite-friends',
  templateUrl: './favourite-friends.component.html',
})
export class FavouriteFriendsComponent implements OnInit, AfterContentInit {

  @ContentChildren('name') allFriendsRef: QueryList<ElementRef>;

  constructor() { }

  ngOnInit() {
  }

  get allFriends(): string {
    return this.allFriendsRef ? this.allFriendsRef.map(k => k.nativeElement.innerHTML).join(', ') : '';
  }

  ngAfterContentInit() {
    console.log(this.allFriends);
 }
}
