import {Component} from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  LoginOrSignup: String = "";
  loginSignupPrompt: Boolean = true;
  loginComponent: boolean = false;
  signupComponent: boolean = false;
  title = 'DS-Video-Streaming-System';

  onSignupLoginChange(choice: String) {
    if (choice == 'signup') {
      this.signupComponent = true;
      this.loginComponent = false;
    } else if (choice = 'login') {
      this.signupComponent = false;
      this.loginComponent = true;
    }
  }
}
