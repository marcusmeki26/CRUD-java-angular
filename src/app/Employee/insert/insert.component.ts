import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../../Service/employee-service.service';
import { DepartmentService } from '../../Service/department.service';
import { Observable } from 'rxjs';
import { ManagerService } from '../../Service/manager.service';
import { AddressService } from '../../Service/address.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert',
  standalone: false,
  templateUrl: './insert.component.html',
  styleUrl: './insert.component.css'
})
export class InsertComponent {
  departments$: Observable<any[]> = new Observable();
  managers$: Observable<any[]> = new Observable();
  addresses$: Observable<any[]> = new Observable();

  constructor(private router: Router,
              private employeeService: EmployeeService, 
              private departmentService: DepartmentService,
              private managerService: ManagerService,
              private addressService: AddressService) {
    this.departments$ = this.departmentService.getDepartments();
    this.managers$ = this.managerService.getManagers();
    this.addresses$ = this.addressService.getAddresses();
  }

  emp = {
    name: '',
    phoneNumber: '',
    salary: null,
    email: '',
    manager: '',
    department: '',
    address: '',
  }

  onSubmit(empForm: NgForm) { 
    this.employeeService.insertEmployee(empForm.value).subscribe({
      next: res => {
        window.alert(res)
        this.router.navigate(['/employee']);
      },
      error: err => console.error('Error:', err)
    });
  }
}
