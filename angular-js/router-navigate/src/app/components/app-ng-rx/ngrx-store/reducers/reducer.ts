import { ActionReducerMap, ActionReducer, MetaReducer } from '@ngrx/store';
import { AppState } from './app.states';
import * as articleRXReducer from './articleRX.reducer';
import { environment } from 'src/environments/environment';

export const reducers: ActionReducerMap<AppState> = {
  articleRXState: articleRXReducer.reducer
};

export function logger(reducer: ActionReducer<AppState>): ActionReducer<AppState> {
  return (state: AppState, action: any): AppState => {
    console.log('state', state);
    console.log('action', action);
    return reducer(state, action);
  };
}

export const metaReducers: MetaReducer<AppState>[] = !environment.production ? [logger] : [];
