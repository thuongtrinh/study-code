export class Profile {
  public profileId: string;
  public profileName: string;

  constructor() {}

  setProperties(id: string, profileN: string) {
    this.profileId = id;
    this.profileName = profileN;
  }
}
