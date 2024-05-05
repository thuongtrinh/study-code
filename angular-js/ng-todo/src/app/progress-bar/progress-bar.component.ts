import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit, OnChanges {

  @Input() backgroundColor : string = 'DarkGrey';
  @Input() progressColor : string = 'LimeGreen';

  private _progress = 40;
  @Input() set progress(val: number) {
    console.log({val});

    // validation for progress
    if(typeof val !== "number") {
      const progress = Number(val);
      if(Number.isNaN(progress)) {
        this._progress = 0;
      } else {
        this._progress = progress;
      }
    }
    this._progress = val;
  }
  get progress(){
    return this._progress;
  }

  constructor() { }

  ngOnInit(): void {
    console.log('init', {
      progress: this.progress,
      backgroundColor: this.backgroundColor,
      progressColor: this.progressColor
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('changes', {
      progress: this.progress,
      backgroundColor: this.backgroundColor,
      progressColor: this.progressColor
    });
  }
}
