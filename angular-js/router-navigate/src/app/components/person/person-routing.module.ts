import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from './person.component';
import { PersonAddComponent } from './person-add/person-add.component';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonDetailComponent } from './person-detail/person-detail.component';
import { PersonDetailResolver } from './person-detail/person-detail.resolver';
import { PersonEditComponent } from './person-edit/person-edit.component';
import { CanDeactivateGuard } from 'src/app/services/can-deactive-guard.service';

const personRoutes: Routes = [
  {
    path: '',
    component: PersonComponent,
    children: [
      {
        path: 'add',
        component: PersonAddComponent
      },
      {
        path: 'list',
        component: PersonListComponent,
        children: [
          {
            path: ':person-id',
            component: PersonEditComponent,
            canDeactivate: [ CanDeactivateGuard ]
          }
        ]
      },
      {
        path: 'detail/:person-id',
        component: PersonDetailComponent,
        resolve: {
          PersonDetail: PersonDetailResolver
        }
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(personRoutes) ],
  exports: [RouterModule],
  providers: [ PersonDetailResolver ]
})
export class PersonRoutingModule { }
