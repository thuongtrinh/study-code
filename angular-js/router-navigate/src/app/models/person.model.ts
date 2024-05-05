export class Person {

  public personId: number;
  public gender: string;
  public position: string;
  public houseNumber: number;
  public dob: Date;

  constructor(
    public name: string,
    public age: number,
    public city: string,
    public country: string,
    public mobile: string,
    public married: boolean
  ) {}

  public setPersonId(id: number) {
    this.personId = id;
  }

  public setDob(dobp: Date) {
    this.dob = dobp;
  }
}
