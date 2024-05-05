import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ArticleRXState } from './app.states';
import * as fromActions from '../actions/articleRX.action';
import { JAVA_ARTICLES_RX, ANGULAR_ARTICLES_RX } from '../modules/articleRX';

export const initialState: ArticleRXState = { articlesRX: []};

export function reducer(state = initialState, action: fromActions.All): ArticleRXState {
  switch (action.type) {
    case fromActions.JAVA: {
      return {articlesRX: JAVA_ARTICLES_RX};
    }
    case fromActions.ANGULAR: {
      return {articlesRX: ANGULAR_ARTICLES_RX};
    }
    case fromActions.MY_ARTICLES_RX: {
      return {articlesRX: action.payload};
    }
    default: {
      return state;
    }
  }
}

export const getArticleRXState = createFeatureSelector<ArticleRXState>('articleRXState');

export const getArticles = createSelector(
  getArticleRXState, (state: ArticleRXState) => state.articlesRX
);
