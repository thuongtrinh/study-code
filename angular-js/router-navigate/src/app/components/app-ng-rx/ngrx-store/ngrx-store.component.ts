import { Component, OnInit } from '@angular/core';
import * as articleRXReducer from './reducers/articleRX.reducer';
import * as fromActions from './actions/articleRX.action';
import { ArticleRX, FAVORITE_ARTICLES_RX } from './modules/articleRX';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { ArticleRXState } from './reducers/app.states';

@Component({
  selector: 'app-ngrx-store',
  templateUrl: './ngrx-store.component.html',
})
export class NgrxStoreComponent implements OnInit {

  articlesRX: Observable<ArticleRX[]>;

  constructor(private store: Store<ArticleRXState>) {
    this.articlesRX = store.select(articleRXReducer.getArticles);
  }

  ngOnInit() {
  }

  showJavaArticlesRX() {
    this.store.dispatch(new fromActions.JavaArticlesRXAction());
  }

  showAngularArticlesRX() {
    this.store.dispatch(new fromActions.AngularArticlesRXAction());
  }

  showFavoriteArticlesRX() {
    this.store.dispatch(new fromActions.FavoriteArticlesRXAction(FAVORITE_ARTICLES_RX));
  }
}
