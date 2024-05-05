import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: []
})
export class LoginComponent implements OnInit {

  invalidCredentialMsg: string;
  constructor(private authService: AuthService, private router: Router) { }

  loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl()
  });

  ngOnInit() {
  }

  onFormSubmit() {
    const user = this.loginForm.get('username').value;
    const pass = this.loginForm.get('password').value;

    this.authService.isUserAuthenticated(user, pass).subscribe(
      authenticated => {
        if (authenticated) {
          sessionStorage.setItem('SessionUsername', user);
          sessionStorage.setItem('SessionPassword', pass);

          let url = this.authService.getRedirectUrl();
          if (url.indexOf('dashboard') === -1) {
            url = 'dashboard/' + url;
          }

          console.log('Redirect url: ' + url);
          this.router.navigate([url]);
        } else {
          this.invalidCredentialMsg = 'Invalid creadentials. Try again!';
        }
      }
    );
  }
}
