import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PersonComponent } from './person.component';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonDetailComponent } from './person-detail/person-detail.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PersonAddComponent } from './person-add/person-add.component';
import { PersonRoutingModule } from './person-routing.module';
import { PersonService } from 'src/app/services/person.service';
import { PersonEditComponent } from './person-edit/person-edit.component';
import { httpInterceptorProviders } from 'src/app/http-interceptors';
import { CacheMapService } from 'src/app/services/cache-map.service';

@NgModule({
  imports: [CommonModule, ReactiveFormsModule, PersonRoutingModule],
  declarations: [
    PersonComponent,
    PersonAddComponent,
    PersonListComponent,
    PersonDetailComponent,
    PersonEditComponent
  ],
  providers: [
    PersonService,
    httpInterceptorProviders,
    CacheMapService,
    {
      provide: Cache, useClass: CacheMapService
    }
  ]
})
export class PersonModule {}
