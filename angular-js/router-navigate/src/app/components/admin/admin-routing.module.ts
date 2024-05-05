import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AuthGuardService } from 'src/app/services/auth-guard.service';

const adminRoutes: Routes = [
  {
    path: '',
    component: AdminComponent,
    canActivate: [ AuthGuardService ],
    // children: [
    //   {
    //     path: 'person-list',
    //     component: PersonListComponent,
    //     canActivate: [ AuthGuardService ]
    //   }
    // ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(adminRoutes) ],
  exports: [ RouterModule ]
})
export class AdminRoutingModule { }
