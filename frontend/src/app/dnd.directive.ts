import { Directive, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appDnd]'
})
export class DndDirective {

  @HostBinding("class.image-input") fileOver: boolean
  constructor() { }

  @HostListener('dragover', ['$event']) onDragOver(evt: Event){
    
    evt.preventDefault()
    evt.stopPropagation
    console.log(evt)
  }

}
