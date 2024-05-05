import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { Store } from '@ngrx/store';
import * as fromReducer from './reducers/article2.reducer';
import * as fromActions from './actions/article2.actions';
import { Observable } from 'rxjs';
import { Article2 } from './models/article2';
import { Article2State } from './reducers/app.states2';

@Component({
  selector: 'app-ngrx-effects',
  templateUrl: './ngrx-effects.component.html'
})
export class NgrxEffectsComponent {

  articles$: Observable<Article2[]>;
  message$: Observable<any>;
  task = '';

  constructor(
    private formBuilder: FormBuilder,
    private store: Store<Article2State>
  ) {
    this.articles$ = store.select(fromReducer.getArticles2);
    this.message$ = store.select(fromReducer.getMessage);
  }

  articleForm = this.formBuilder.group({
    id: ['', Validators.required],
    title: '',
    category: ''
  });

  get id() {
    return this.articleForm.get('id');
  }

  onFormSubmit() {
    if (this.articleForm.valid) {
      const article = this.articleForm.value;
      this.createArticle(article);
      this.articleForm.reset();
    }
  }

  createArticleView() {
    this.task = 'create';
    this.store.dispatch(new fromActions.ResetAction());
  }

  getArticleByIdView() {
    this.task = 'get';
    this.store.dispatch(new fromActions.ResetAction());
  }

  loadAllArticles() {
    this.task = 'all';
    this.store.dispatch(new fromActions.ShowAllAction());
  }

  createArticle(article: Article2) {
    this.store.dispatch(new fromActions.CreateAction(article));
  }

  searchArticleById(articleId: string) {
    this.store.dispatch(new fromActions.GetByIdAction(articleId));
  }
}
