import { IRegion } from 'app/shared/model/region.model';

export interface ICountry {
  id?: number;
  countryName?: string;
  region?: IRegion | null;
}

export const defaultValue: Readonly<ICountry> = {};
