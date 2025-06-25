import { Component } from '@angular/core';
import { EmployeeService } from '../../Service/employee-service.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-display',
  standalone: false,
  templateUrl: './display.component.html',
  styleUrl: './display.component.css'
})
export class DisplayComponent {
  employees$: Observable<any[]> = new Observable();

  constructor(private employeeService: EmployeeService){
    this.employees$ = this.employeeService.getEmployees();
  }

  deleteUser(id: number){
    this.employeeService.deleteEmployee(id).subscribe({
      next: res => {
        window.alert(res);
        this.employees$ = this.employeeService.getEmployees(); // Refresh the list
      },
      error: err => console.error('Error:', err)
    });
  }
}
