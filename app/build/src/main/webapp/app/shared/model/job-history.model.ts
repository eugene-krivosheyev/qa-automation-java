import dayjs from 'dayjs';
import { IJob } from 'app/shared/model/job.model';
import { IDepartment } from 'app/shared/model/department.model';
import { IEmployee } from 'app/shared/model/employee.model';
import { Language } from 'app/shared/model/enumerations/language.model';

export interface IJobHistory {
  id?: number;
  startDate?: string;
  endDate?: string | null;
  language?: Language | null;
  job?: IJob;
  department?: IDepartment;
  employee?: IEmployee;
}

export const defaultValue: Readonly<IJobHistory> = {};
