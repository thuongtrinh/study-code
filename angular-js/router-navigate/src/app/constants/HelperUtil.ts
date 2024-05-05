import { User } from "../models/user.model";

let user1 = new User();
let user2 = new User();
user1.setValues(1, 'Smith', '123', 'ADMIN');
user2.setValues(2, 'Danies', '123', 'USER');
const USERS = [ user1, user2 ];

export class HelperUtil {
  allUsers: User[] = USERS;
}

