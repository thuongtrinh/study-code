import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { GlobalErrorComponent } from './components/global-error/global-error.component';
import { DashboardLayoutComponent } from './components/dashboard-layout/dashboard-layout.component';
import { AuthGuardService } from './services/auth-guard.service';
import { CityComponent } from './components/city/city.component';
import { CityListComponent } from './components/city/city-list/city-list.component';
import { TeamComponent } from './components/team/team.component';
import { RequestsComponent } from './http-interceptors/requests/requests.component';
import { CustomDirectivesComponent } from './components/custom-directives/custom-directives.component';
import { ViewchildComponent } from './components/viewchild/viewchild.component';
import { PipesComponent } from './components/pipes/pipes.component';
import { CustomPipeComponent } from './components/pipes/custom-pipe/custom-pipe.component';
import { CompLifecycleComponent } from './components/comp-lifecycle/comp-lifecycle.component';
import { PersonCompComponent } from './components/comp-lifecycle/person-comp/person-comp.component';
import { CompanyCompComponent } from './components/comp-lifecycle/company-comp/company-comp.component';
import { PostBannerComponent } from './components/comp-lifecycle/post-banner/post-banner.component';
import { ChangeSimplechangeComponent } from './components/comp-lifecycle/change-simplechange/change-simplechange.component';
import { LifeCompComponent } from './components/comp-lifecycle/life-comp/life-comp.component';
import { AfterViewInitComponent } from './components/comp-lifecycle/after-view-init/after-view-init.component';
import { KeyvalueDiffersComponent } from './components/comp-lifecycle/keyvalue-differs/keyvalue-differs.component';
import { DoCheckComponent } from './components/comp-lifecycle/do-check/do-check.component';
import { AppProvidersComponent } from './components/comp-lifecycle/app-providers/app-providers.component';
import { XservicesComponent } from './components/xservices/xservices.component';
import { AppRenderer2Component } from './components/xservices/app-renderer2/app-renderer2.component';
import { MetaTagsComponent } from './components/xservices/meta-tags/meta-tags.component';
import { TitleCanonicalComponent } from './components/xservices/title-canonical/title-canonical.component';
import { AppNgRxComponent } from './components/app-ng-rx/app-ng-rx.component';
import { NgrxStoreComponent } from './components/app-ng-rx/ngrx-store/ngrx-store.component';
import { NgrxEffectsComponent } from './components/app-ng-rx/ngrx-effects/ngrx-effects.component';
import { McheckboxComponent } from './components/materials/mcheckbox/mcheckbox.component';
import { MaterialsComponent } from './components/materials/materials.component';
import { MtableComponent } from './components/materials/mtable/mtable.component';
import { MTextareaComponent } from './components/materials/m-textarea/m-textarea.component';
import { MRadioComponent } from './components/materials/m-radio/m-radio.component';
import { MToggleComponent } from './components/materials/m-toggle/m-toggle.component';
import { ArticleSpringComponent } from './components/article-spring/article-spring.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'country',
    loadChildren: './components/country/country.module#CountryModule'
  },
  {
    path: 'person',
    loadChildren: './components/person/person.module#PersonModule'
  },
  {
    path: 'dashboard',
    component: DashboardLayoutComponent,
    canActivate: [ AuthGuardService ],
    children: [
      {
        path: 'address',
        loadChildren: './components/address/address.module#AddressModule',
        canLoad: [ AuthGuardService ]
      },
      {
        path: 'admin',
        loadChildren: './components/admin/admin.module#AdminModule',
        canLoad: [ AuthGuardService ]
      },
      {
        path: 'article',
        loadChildren: './components/article/article.module#ArticleModule',
        canLoad: [ AuthGuardService ]
      }
    ]
  },
  {
    path: 'book',
    loadChildren: './components/book/book.module#BookModule'
  },
  {
    path: 'user',
    loadChildren: './components/user/user.module#UserModule'
  },
  {
    path: 'city-add',
    component: CityComponent
  },
  {
    path: 'city-list',
    component: CityListComponent
  },
  {
    path: 'team',
    component: TeamComponent
  },
  {
    path: 'requests',
    component: RequestsComponent
  },
  {
    path: 'custom-directive',
    component: CustomDirectivesComponent
  },
  {
    path: 'viewchild',
    component: ViewchildComponent
  },
  {
    path: 'error',
    component: GlobalErrorComponent
  },
  {
    path: 'pipes',
    component: PipesComponent
  },
  {
    path: 'pipes/custom-async-pipe',
    component: CustomPipeComponent
  },
  {
    path: 'compLifecycle',
    component: CompLifecycleComponent
  },
  {
    path: 'compLifecycle/person-comp',
    component: PersonCompComponent
  },
  {
    path: 'company-comp',
    component: CompanyCompComponent
  },
  {
    path: 'compLifecycle/post-banner',
    component: PostBannerComponent
  },
  {
    path: 'compLifecycle/change-simplechange',
    component: ChangeSimplechangeComponent
  },
  {
    path: 'compLifecycle/life-comp',
    component: LifeCompComponent
  },
  {
    path: 'compLifecycle/after-view-init',
    component: AfterViewInitComponent
  },
  {
    path: 'compLifecycle/keyvalue-differs',
    component: KeyvalueDiffersComponent
  },
  {
    path: 'compLifecycle/do-check',
    component: DoCheckComponent
  },
  {
    path: 'compLifecycle/app-providers',
    component: AppProvidersComponent
  },
  {
    path: 'app-services',
    component: XservicesComponent
  },
  {
    path: 'app-services/app-renderer2',
    component: AppRenderer2Component
  },
  {
    path: 'app-services/meta-tags',
    component: MetaTagsComponent
  },
  {
    path: 'app-services/title-canonical',
    component: TitleCanonicalComponent
  },
  {
    path: 'app-ngRx',
    component: AppNgRxComponent
  },
  {
    path: 'app-ngRx/ngrx-store',
    component: NgrxStoreComponent
  },
  {
    path: 'app-ngRx/ngrx-efects',
    component: NgrxEffectsComponent
  },
  {
    path: 'app-material',
    component: MaterialsComponent
  },
  {
    path: 'app-material/material-checkbox',
    component: McheckboxComponent
  },
  {
    path: 'app-material/material-table',
    component: MtableComponent
  },
  {
    path: 'app-material/material-textarea',
    component: MTextareaComponent
  },
  {
    path: 'app-material/material-radio',
    component: MRadioComponent
  },
  {
    path: 'app-material/material-toggle',
    component: MToggleComponent
  },
  {
    path: 'angularSpringBoot',
    component: ArticleSpringComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
