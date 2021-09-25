import { ICountry } from 'app/shared/model/country.model';

export interface ILocation {
  id?: number;
  postalCode?: string;
  streetAddress?: string;
  city?: string;
  province?: string | null;
  country?: ICountry | null;
}

export const defaultValue: Readonly<ILocation> = {};
