import { Injectable } from '@angular/core';
import { CountryEditComponent } from '../components/country/country-edit/country-edit.component';
import {
  CanDeactivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import { DialogService } from './dialog.service';

@Injectable({
  providedIn: 'root'
})
export class CountryEditCanDeactiveGuardService implements CanDeactivate<CountryEditComponent> {
  constructor(private dialogService: DialogService) {}

  canDeactivate(
    component: CountryEditComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot): Observable<boolean> | boolean {

      const url = currentState.url;
      console.log('Start canDeactivate, Url: ' + url);
      if (component.isUpdating && component.countryForm.dirty) {
        component.isUpdating = false;
        const returnVal = this.dialogService.confirm('Discard changes for Country?');
        console.log(returnVal);
        return returnVal;
      }

      return true;
  }
}
