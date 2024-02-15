import { Component, OnInit } from '@angular/core';
import { User } from '../user.model';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  saveUser() {
    this.userService.createUser(this.user).subscribe({
      next: (data) => {
        console.log(data);
        this.redirectToUserList();
      },
      error: (e) => {
        console.log(e);
      }
    });
  }

  login() {

    console.log("Login successful");
    alert("Login was successfull");
    /*
    this.userService.createUser(this.user).subscribe({
      next: (data) => {
        console.log(data);
        this.redirectToUserList();
      },
      error: (e) => {
        console.log(e);
      }
    }); */
    //this.redirectToUserList();

  }

  redirectToUserList() {
    this.router.navigate(['/users']);
    
  }

  onSubmit() {
    console.log("Saving user to data store");
    this.login();
  }

}
