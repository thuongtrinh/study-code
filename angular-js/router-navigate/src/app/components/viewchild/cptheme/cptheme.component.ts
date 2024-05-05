import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-cptheme',
  templateUrl: './cptheme.component.html',
})
export class CpthemeComponent implements OnInit {

  @ViewChild('name', {static: true})
  private elName: ElementRef;

  @ViewChild('city', {static: true})
  private elCity: ElementRef;

  constructor() { }

  ngOnInit() {
    this.elName.nativeElement.style.backgroundColor = 'lightblue';
    this.elName.nativeElement.style.color = 'red';
    this.elCity.nativeElement.style.backgroundColor = 'lightblue';
    this.elCity.nativeElement.style.color = 'red';
  }
}
