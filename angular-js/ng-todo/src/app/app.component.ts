import { Component, ElementRef, OnInit, QueryList, VERSION, ViewChild, ViewChildren } from '@angular/core';
import { ToggleComponent } from './toggle/toggle.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'NgToDo ' + VERSION.major;
  name = 'Angular ' + VERSION.major;
  isChecked = false;
  currentProgress = 60;
  backgColor = "MistyRose";
  progColor = "SpringGreen";
  showLast = false;

  counter = 1;
  navsVal = ['Active', 'Link1', 'Link2'];

  @ViewChild(ToggleComponent, {static: true}) toggleComp: ToggleComponent;
  @ViewChild('nativeButton', {static: true}) toggleButton: ElementRef<HTMLButtonElement>;
  @ViewChild('nameInput', {static: true}) inputName: ElementRef<HTMLInputElement>;
  @ViewChildren(ToggleComponent) toggleComps: QueryList<ToggleComponent>;

  ngOnInit(): void {
    // console.log(this.toggleComp);
    console.log(this.toggleButton);
    console.log(this.inputName.nativeElement);
    setTimeout(() => this.inputName.nativeElement.focus(), 3000);
    // console.log('QueryList ToggleComponent init',this.toggleComps)
  }

  ngAfterViewInit() {
    // console.log(this.toggleComp);
    console.log(this.toggleButton.nativeElement);
    console.log(this.inputName.nativeElement);
    // console.log('QueryList ToggleComponent afterView',this.toggleComps)
    this.toggleComps.changes.subscribe(console.log)
  }

  public increaseProgress(): void {
    this.currentProgress += 1;
  }
}
