import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './components/app/app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import { AllUsersComponent } from './components/all-users/all-users.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AllUsersComponent,
    EditUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }