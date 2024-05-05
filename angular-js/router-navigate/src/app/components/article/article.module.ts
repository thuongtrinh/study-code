import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ArticleComponent } from './article.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleEditComponent } from './article-edit/article-edit.component';
import { ArticleService } from 'src/app/services/article.service';
import { ArticleRoutingModule } from './article-routing.module';
import { ArticleAddComponent } from './article-add/article-add.component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { TestData } from '../data/test-data';
import { HttpClientModule } from '@angular/common/http';
import { httpInterceptorArtProviders } from 'src/app/http-interceptors';
import { CacheMapService } from 'src/app/services/cache-map.service';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    ArticleRoutingModule,
    InMemoryWebApiModule.forRoot(TestData) // Remember import -> HttpClientModule
  ],
  declarations: [
    ArticleComponent,
    ArticleListComponent,
    ArticleEditComponent,
    ArticleAddComponent
  ],
  providers: [ ArticleService,
    httpInterceptorArtProviders,
    CacheMapService,
    {
      provide: Cache, useClass: CacheMapService
    }
  ]
})
export class ArticleModule { }
