import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { AllUsersComponent } from '../components/all-users/all-users.component';
import { LoginGuard } from '../guards/login.guard';
import { EditUserComponent } from '../components/edit-user/edit-user.component';

const routes: Routes = [
{
  path:"",
  component:LoginComponent,
  canActivate:[LoginGuard]

},
{
  path:"editUser/:id",
  component:EditUserComponent,
  

},
{
  path:"allUsers",
  component:AllUsersComponent,

  
}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 


}
