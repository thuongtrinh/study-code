import { Technology } from './technology.model';
import { Profile } from './profile.model';

export class User {
  public userId: number;
  public username: string;
  public password: string;
  public role: string;
  public gender: string;
  public isMarried: boolean;
  public email: string;
  public mobile: string;

  public profile: Profile = null;
  public technologies: Technology[];

  public num1: number;
  public num2: number;
  public num3: number;

  constructor() {
  }

  setValues(userId, username, password, role) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  setProfile(profile: Profile) {
    this.profile = profile;
  }

  setTechnologies(technologies: Technology[]) {
    this.technologies = technologies;
  }

}
