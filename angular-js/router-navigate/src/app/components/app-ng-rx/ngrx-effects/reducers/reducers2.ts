import { ActionReducerMap, ActionReducer, MetaReducer } from '@ngrx/store';
import { AppState2 } from './app.states2';
import * as fromReducer from './article2.reducer';
import { environment } from 'src/environments/environment';

export const reducers2: ActionReducerMap<AppState2> = {
  article2State: fromReducer.reducer2
};

export function logger2(reducer2: ActionReducer<AppState2>): ActionReducer<AppState2> {
  return (state: AppState2, action: any): AppState2 => {
    console.log('state', state);
    console.log('action', action);
    return reducer2(state, action);
  };
}

export const metaReducers2: MetaReducer<AppState2>[] = !environment.production ? [logger2] : [];
