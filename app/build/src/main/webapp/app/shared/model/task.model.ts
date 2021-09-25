import { IJob } from 'app/shared/model/job.model';

export interface ITask {
  id?: number;
  title?: string;
  description?: string | null;
  attach?: string | null;
  jobs?: IJob[];
}

export const defaultValue: Readonly<ITask> = {};
