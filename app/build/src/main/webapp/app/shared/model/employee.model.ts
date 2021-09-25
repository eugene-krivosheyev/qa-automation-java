import dayjs from 'dayjs';
import { IJob } from 'app/shared/model/job.model';
import { IDepartment } from 'app/shared/model/department.model';

export interface IEmployee {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phone?: string;
  hireDate?: string;
  salary?: number | null;
  jobs?: IJob[] | null;
  manager?: IEmployee | null;
  department?: IDepartment | null;
}

export const defaultValue: Readonly<IEmployee> = {};
