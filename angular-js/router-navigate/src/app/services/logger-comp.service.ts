import { Injectable } from '@angular/core';
import { Log } from '../models/log';

@Injectable({
  providedIn: 'root'
})
export class LoggerCompService {

  private cp1Log = new Log('', '');
  private allCP2Logs: Log[] = [];

  constructor() { }

  setCP1Log(logType: string, message: string) {
    this.cp1Log.logType = logType;
    this.cp1Log.message = message;
  }

  getCP1Log() {
    return this.cp1Log;
  }

  createCP2Log(log: Log) {
    this.allCP2Logs.push(log);
  }

  getAllCP2Logs() {
    return this.allCP2Logs;
  }
}
