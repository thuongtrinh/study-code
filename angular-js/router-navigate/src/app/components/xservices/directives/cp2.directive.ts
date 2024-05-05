import { Directive, Renderer2, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp2]'
})
export class Cp2Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('click')
  performTask() {
    const div = this.renderer.createElement('div');
    const text = this.renderer.createText('Hello world');
    this.renderer.appendChild(div, text);

    const parent = this.elRef.nativeElement.parentNode;
    const refChild = this.elRef.nativeElement;
    this.renderer.insertBefore(parent, div, refChild);
  }
}
