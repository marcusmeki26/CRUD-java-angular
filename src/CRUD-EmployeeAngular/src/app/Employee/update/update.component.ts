import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../Service/employee-service.service';
import { Observable } from 'rxjs';
import { ManagerService } from '../../Service/manager.service';
import { DepartmentService } from '../../Service/department.service';
import { AddressService } from '../../Service/address.service';

@Component({
  selector: 'app-update',
  standalone: false,
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent{
  departments$: Observable<any[]> = new Observable();
  managers$: Observable<any[]> = new Observable();
  addresses$: Observable<any[]> = new Observable();

  emp = {
    id: 0,
    name: String,
    phoneNumber: String,
    salary: Number,
    email: String,
    manager: Number,
    department: Number,
    address: Number,
  }

  constructor(private activatedRouter: ActivatedRoute, 
              private router: Router,
              private employeeService: EmployeeService,
              private departmentService: DepartmentService,
              private managerService: ManagerService,
              private addressService: AddressService) {
    const id = this.activatedRouter.snapshot.paramMap.get('id');
    this.employeeService.getEmployeeById(Number(id)).subscribe((data: any) => {
      this.emp.id = data.id;  
      this.emp.name = data.name;
      this.emp.phoneNumber = data.phoneNumber;
      this.emp.salary = data.salary;  
      this.emp.email = data.email;
      this.emp.manager = data.manager.id;
      this.emp.department = data.department.id;
      this.emp.address = data.address.id;
    });
    this.departments$ = this.departmentService.getDepartments();
    this.managers$ = this.managerService.getManagers();
    this.addresses$ = this.addressService.getAddresses();
  }

  

  onSubmit(empForm: any) {
    this.employeeService.updateEmployee(this.emp.id, empForm.value).subscribe({
      next: res => {
        window.alert(res)
        this.router.navigate(['/employee']);
      },
      error: err => console.error('Error:', err)
    });
  }
}
