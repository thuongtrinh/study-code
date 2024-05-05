import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp4]'
})
export class Cp4Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('click')
  performTask() {
    const element = this.renderer.selectRootElement('.myclass');
    const text = this.renderer.createText('Namaste!!!');
    this.renderer.appendChild(element, text);
  }
}
