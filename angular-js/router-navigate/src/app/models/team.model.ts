import { Department } from './department.model';
import { Employee } from './employee.model';

export class Team {

  teamName = '';
  teamManager = '';
  department: Department;
  employees: Employee[];

  constructor() {}
}
