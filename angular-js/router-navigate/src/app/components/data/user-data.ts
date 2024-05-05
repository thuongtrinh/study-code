import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { Observable } from 'rxjs';

export class UserData implements InMemoryDbService {

  createDb(reqInfo?: RequestInfo): {} | Observable<{}> | Promise<{}> {
    let userDetails = [
      {id: 1, username: 'trump', email: 'trump@gmail.com', mobileNumber: '0973456989'},
      {id: 2, username: 'karis', email: 'karis@gmail.com', mobileNumber: '0568345597'}
    ];

    let backListedMobileNumbers = [
      {id: 111, mobileNumber: '0888757870'},
      {id: 222, mobileNumber: '0566670329'}
    ];

    return {users: userDetails, backListedMNums: backListedMobileNumbers};
  }
}
