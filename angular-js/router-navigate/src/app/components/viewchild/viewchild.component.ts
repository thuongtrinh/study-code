import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-viewchild',
  templateUrl: './viewchild.component.html',
})
export class ViewchildComponent implements OnInit {

  latestBook = true;
  showAllBook = false;
  homeTown = true;
  showAllCity = false;
  bestFriend = true;
  showAllFriend = false;

  constructor() { }

  ngOnInit() {
  }

  onChangeBook() {
    this.latestBook = (this.latestBook === true) ? false : true;
  }

  onShowAllBooks() {
    this.showAllBook = (this.showAllBook === true) ? false : true;
  }

  onChangeCity() {
    this.homeTown = (this.homeTown === true) ? false : true;
  }

  onShowAllCities() {
    this.showAllCity = (this.showAllCity === true) ? false : true;
  }

  onChangeFriend() {
    this.bestFriend = (this.bestFriend === true) ? false : true;
  }

  onShowAllFriends() {
    this.showAllFriend = (this.showAllFriend === true)? false : true;
  }
}
