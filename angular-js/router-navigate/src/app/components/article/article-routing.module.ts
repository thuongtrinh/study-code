import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ArticleComponent } from './article.component';
// import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleEditComponent } from './article-edit/article-edit.component';
import { AuthGuardService } from 'src/app/services/auth-guard.service';

const articleRoutes: Routes = [
  {
    path: '',
    component: ArticleComponent,
    canActivate: [ AuthGuardService ],
    children: [
      // {
      //   path: 'list',
      //   component: ArticleListComponent,
      //   canActivateChild: [ AuthGuardService ],
      //   children: [
      //     {
      //       path: ':article-id',
      //       component: ArticleEditComponent
      //     }
      //   ]
      // },
      {
        path: ':article-id',
        component: ArticleEditComponent
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(articleRoutes) ],
  exports: [ RouterModule ],
  providers: []
})
export class ArticleRoutingModule { }
