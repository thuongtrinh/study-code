import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { UserReactiveFormComponent } from './user-reactive-form/user-reactive-form.component';

const userRoutes: Routes = [
  {
    path: '',
    component: UserComponent,
  },
  {
    path: 'user-reactive-form',
    component: UserReactiveFormComponent
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(userRoutes) ],
  exports: [ RouterModule ],
  providers: []
})
export class UserRoutingModule { }
