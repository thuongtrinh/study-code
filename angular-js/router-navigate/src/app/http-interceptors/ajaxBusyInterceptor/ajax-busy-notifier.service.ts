import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AjaxBusyNotifierService {

  busy: BehaviorSubject<boolean>;

  constructor() {
    this.busy = new BehaviorSubject<boolean>(false);
    this.busy.next(false);
  }
}
