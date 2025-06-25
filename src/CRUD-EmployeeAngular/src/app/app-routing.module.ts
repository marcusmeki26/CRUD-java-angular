import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayComponent } from './Employee/display/display.component';
import { InsertComponent } from './Employee/insert/insert.component';
import { UpdateComponent } from './employee/update/update.component';

const routes: Routes = [
  {
    path: 'employee',
    component: DisplayComponent,
    title: "Display Employee"
  },
  {
    path: 'employee/insert',
    component: InsertComponent,
    title: "Insert Employee"
  },
  {
    path: 'employee/edit/:id',
    component: UpdateComponent,
    title: "Update Employee"
  },
  {
    path: '',
    redirectTo: '/employee',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
