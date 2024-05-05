import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { TeamService } from 'src/app/services/team.service';
import { Observable } from 'rxjs';
import { Department } from 'src/app/models/department.model';
import { Team } from 'src/app/models/team.model';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss']
})
export class TeamComponent implements OnInit {

  isValidFormSubmitted = null;
  isMbottomTN = false;
  isMbottomTM = false;
  teamForm: FormGroup;
  allSkills: Observable<any>;

  constructor(
    private formBuilder: FormBuilder,
    private teamService: TeamService
  ) { }

  ngOnInit() {
    this.allSkills = this.teamService.getAllSkill();
    this.createTeamForm();
    this.handleFormChanges();
  }

  createTeamForm() {
    this.teamForm = this.formBuilder.group({
      teamName: ['', Validators.required],
      teamManager: this.formBuilder.control('', Validators.required),
      department: this.formBuilder.group(new Department()),
      employees: this.formBuilder.array([this.createEmpFormGroup()], [Validators.required])
    });
  }

  createEmpFormGroup() {
    return this.formBuilder.group({
      emplId: ['', [Validators.required]],
      emplName: ['', [Validators.required]],
      skill: ['', [Validators.required]]
    });
  }

  get teamName() {
    return this.teamForm.get('teamName');
  }

  get teamManager() {
    return this.teamForm.get('teamManager');
  }

  get empFormArray(): FormArray {
    return this.teamForm.get('employees') as FormArray;
  }

  addNewEmployee() {
    let fg = this.createEmpFormGroup();
    this.empFormArray.push(fg);
  }

  onFormSubmit() {
    this.isValidFormSubmitted = false;
    if (this.teamForm.invalid) {
      return;
    }
    this.isValidFormSubmitted = true;

    const data = JSON.stringify(this.teamForm.value);
    console.log('-----Team in JSON Format-----');
    console.log(data);
    const team: Team = this.teamForm.value;
    this.teamService.addNewTeam(team);
    this.teamForm.reset();
  }

  resetTeamDefault(teamName: string) {
    this.teamService.getTeamByName(teamName).subscribe(team => {
      this.teamForm.patchValue({
        teamName: team.teamName,
        teamManager: team.teamManager,
        department: team.department
      });

      const employeeFormGroup = team.employees.map(empl => this.formBuilder.group(empl));
      const employeeFormArray = this.formBuilder.array(employeeFormGroup);
      this.teamForm.setControl('employees', employeeFormArray);
    });
  }

  resetTeamForm() {
    this.teamForm.reset();
    this.isMbottomTN = false;
    this.isMbottomTM = false;
  }

  deleteEmployee(index: number) {
    this.empFormArray.removeAt(index);
  }

  handleFormChanges() {
    this.teamName.valueChanges.subscribe(() => {
      this.isMbottomTN = this.teamName.invalid && this.teamName.dirty;
    });

    this.teamManager.valueChanges.subscribe(() => {
      this.isMbottomTM = this.teamManager.invalid && this.teamManager.dirty;
    });
  }
}
