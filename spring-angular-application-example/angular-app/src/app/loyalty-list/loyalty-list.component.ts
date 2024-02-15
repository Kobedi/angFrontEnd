import { Component, OnInit } from '@angular/core';
import { Loyalty } from '../model/loyalty';
import { Router } from '@angular/router';
import { LoyaltyServiceService } from '../services/loyalty-service.service';
import { UserService } from '../services/user.service';
import { Society } from '../society.model';
import { User } from '../user.model';

@Component({
  selector: 'app-loyalty-list',
  templateUrl: './loyalty-list.component.html',
  styleUrls: ['./loyalty-list.component.css']
})
export class LoyaltyListComponent implements OnInit {

  users: User[] | undefined;

  societies: Society[] | undefined;

  constructor(private userService: UserService, private router: Router) {

  }

  ngOnInit(): void {
    this.getSocieties();
  }

  private getUsers() {
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });

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
