import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp1]'
})
export class Cp1Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('click')
  performTask1() {
    const li = this.renderer.createElement('li');
    const text = this.renderer.createText('Click here to add li');
    this.renderer.appendChild(li, text);
    this.renderer.appendChild(this.elRef.nativeElement, li);
  }
}
