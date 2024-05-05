import { Component, OnInit, ViewChild } from '@angular/core';
import { MatCheckbox } from '@angular/material/checkbox';

@Component({
  selector: 'app-md-checkbox-demo',
  templateUrl: './md-checkbox-demo.html',
})
export class MdCheckboxDemoComponent implements OnInit {

  @ViewChild('tgchk', {static: false})
  toggleChk: MatCheckbox;

  @ViewChild('fschk', {static: false})
  focusChk: MatCheckbox;

  isChecked = false;
  isIndeterminate = false;
  chkLabelPosition = 'after';

  constructor() { }

  ngOnInit() {
  }

  onChkChange() {
    console.log('Checked value changed.');
    this.isChecked = (this.isChecked) ? false : true;
    this.isIndeterminate = (this.isIndeterminate) ? false : true;
    this.chkLabelPosition = (this.chkLabelPosition === 'after') ? 'before' : 'after';

    this.toggleChk.toggle();
    this.focusChk.focus();
  }
}
