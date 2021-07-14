import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// Reactive Form
import { ReactiveFormsModule } from "@angular/forms";

// App routing modules
import { AppRoutingModule } from '../app/app-routing.module';

// App components
import { AppComponent } from './app.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignupUserComponent } from './components/signup-user/signup-user.component';
// import { DashboardComponent } from './components/dashboard/dashboard.component';
// import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
// import { VerifyEmailComponent } from './components/verify-email/verify-email.component';

import { environment } from '../environments/environment';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignupUserComponent,
    ForgotPasswordComponent,
    // DashboardComponent,
    // ForgotPasswordComponent,
    // VerifyEmailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }