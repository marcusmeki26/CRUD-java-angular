import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { DisplayComponent } from './Employee/display/display.component';
import { InsertComponent } from './Employee/insert/insert.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './employee/update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayComponent,
    InsertComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
