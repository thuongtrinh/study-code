import { createFeatureSelector, createSelector } from '@ngrx/store';
import * as fromActions from '../actions/article2.actions';
import { Article2State } from './app.states2';

export const initialState: Article2State = { articles: [], message: ''};

export function reducer2(state = initialState, action: fromActions.ALL_REDUCER_ACTIONS): Article2State {
  switch (action.type) {
    case fromActions.SHOW_ALL_SUCCESS: {
      return {articles: action.payload, message: 'Success'};
    }
    case fromActions.CREATE_SUCCESS: {
      return {articles: [action.payload], message: 'Article Created.'};
    }
    case fromActions.CREATE_FAILURE: {
      return {articles: [], message: action.payload};
    }
    case fromActions.GET_BY_ID_SUCCESS: {
      console.log(action.payload);
      return {articles: action.payload, message: 'Success'};
    }
    case fromActions.RESET: {
      return { articles: [], message: ''};
    }
    default: {
      return state;
    }
  }
}

export const getArticle2State = createFeatureSelector<Article2State>('article2State');

export const getArticles2 = createSelector(
    getArticle2State,
    (state: Article2State) => state.articles
);

export const getMessage = createSelector(
  getArticle2State,
  (state: Article2State) => state.message
);
