// export interface Country {
//   countryId: string;
//   name: string;
//   capital: string;
//   currency: string;
// }

export class Country {
  constructor(
    public countryId: string,
    public name: string,
    public capital: string,
    public currency: string
  ) {}
}
