import { Injectable } from '@angular/core';
import { Team } from '../models/team.model';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

export const ALL_TEAMS: Team[] = [
  {
    teamName: 'Java Team',
    teamManager: 'JSHA',
    department: {
      deptHead: 'Modi',
      deptName: 'M Commerce'
    },
    employees: [
      {
        emplId: 'E101',
        emplName: 'Danies',
        skill: 'Dot Net'
      },
      {
        emplId: 'E102',
        emplName: 'Trump',
        skill: 'Java'
      },
      {
        emplId: 'E103',
        emplName: 'Smith',
        skill: 'Angular'
      }
    ]
  }
];

export const ALL_SKILL = [
  { name: 'Java', displayName: 'Java' },
  { name: 'Angular', displayName: 'Angular' },
  { name: 'Dot Net', displayName: 'Dot Net' }
];

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  constructor() {}

  getAllSkill(): Observable<any> {
    return of(ALL_SKILL);
  }

  getTeams(): Observable<Team[]> {
    return of(ALL_TEAMS);
  }

  getTeamByName(teamName: string): Observable<Team> {
    return this.getTeams().pipe(
      map(teams => teams.find(team => team.teamName === teamName))
    );
  }

  addNewTeam(team: Team) {
    console.log('------------TEAM------------');
    console.log('Team Name: ' + team.teamName);
    console.log('Team Manager: ' + team.teamManager);
    console.log('Dept Head: ' + team.department.deptHead);
    console.log('Dept Name: ' + team.department.deptName);

    console.log('----- Employee Detail -----');
    for (const emp of team.employees) {
      console.log('Emp Id: ' + emp.emplId);
      console.log('Emp Name: ' + emp.emplName);
      console.log('Emp Skill: ' + emp.skill);
      console.log('-------------------');
    }

    this.getTeams().subscribe(teams => teams.push(team));
  }
}
