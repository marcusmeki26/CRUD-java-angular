import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployees(): any{
    return this.http.get("http://localhost:8080/employee");
  }

  getEmployeeById(id: number): any{
    return this.http.get(`http://localhost:8080/employee/${id}`);
  }

  insertEmployee(employee: any) {
    return this.http.post("http://localhost:8080/employee", employee, { responseType: 'text' });
  }

  updateEmployee(id: number, employee: any) {
    return this.http.put(`http://localhost:8080/employee/${id}`, employee, { responseType: 'text' });
  }

  deleteEmployee(id: number) {
    return this.http.delete(`http://localhost:8080/employee/${id}`, { responseType: 'text' });
  }
}
