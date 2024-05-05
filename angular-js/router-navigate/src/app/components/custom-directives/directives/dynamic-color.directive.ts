import { Directive, ElementRef, Input, HostListener } from '@angular/core';

@Directive({
  selector: '[appDynamicColor]'
})
export class DynamicColorDirective {

  @Input('appDynamicColor') dynamicColor: string;
  @Input() defaultValue: string;

  constructor(private elRef: ElementRef) { }

  @HostListener('mouseover') onMouseOver() {
    this.changeBackgroundColor(this.dynamicColor || this.defaultValue);
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.changeBackgroundColor('green');
  }

  private changeBackgroundColor(color: string) {
    this.elRef.nativeElement.style.backgroundColor = color;
  }
}
