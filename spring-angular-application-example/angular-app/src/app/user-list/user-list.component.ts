import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../user.model';
import { Society } from '../society.model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] | undefined;

  societies: Society[] | undefined;

  constructor(private userService: UserService, private router: Router) {

  }

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers() {
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });

    console.log("Now testing society list");
    this.getSocieties();
  }

  private getSocieties() {


    this.userService.getSocietyList().subscribe(data => {
      this.societies = data;
      console.log("Data is " + this.societies);
    });
  }

  updateUser(id: number) {
    this.router.navigate(['update-user', id]);
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id).subscribe(data => {
      console.log(data);
      this.getUsers();
    });
  }

  updateSociety(id: number) {
    //this.router.navigate(['update-user', id]);
    console.log("Updating society")
  }

  deleteSociety(id: number) {
    //this.userService.deleteUser(id).subscribe(data => {
     // console.log(data);
     // this.getUsers();
    //});
    console.log("Deleting a society")
  }


}
