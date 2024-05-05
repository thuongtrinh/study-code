import { Component, OnInit } from '@angular/core';
import { DesktopService } from './services/desktop.service';
import { LaptopService } from './services/laptop.service';

@Component({
  selector: 'app-computer',
  providers: [
    LaptopService,
    { provide: DesktopService, useExisting: LaptopService }
  ],
  template: `
    <p>I work on {{ computerName }}</p>
  `,
})
export class ComputerComponent implements OnInit {

  computerName: string;

  constructor(private computerService: DesktopService) { }

  ngOnInit() {
    this.computerName = this.computerService.getComputerName();
  }
}
