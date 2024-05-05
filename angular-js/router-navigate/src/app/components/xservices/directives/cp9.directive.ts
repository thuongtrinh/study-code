import { Directive, Renderer2, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp9]'
})
export class Cp9Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('click')
  performTask() {
    const parent = this.renderer.parentNode(this.elRef.nativeElement);
    this.renderer.setStyle(parent, 'color', 'red');
  }
}
