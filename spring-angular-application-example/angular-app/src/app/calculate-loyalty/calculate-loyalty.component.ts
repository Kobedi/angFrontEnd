import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoyaltyServiceService } from '../services/loyalty-service.service';
import { Loyalty } from '../model/loyalty';

@Component({
  selector: 'app-calculate-loyalty',
  templateUrl: './calculate-loyalty.component.html',
  styleUrls: ['./calculate-loyalty.component.css']
})
export class CalculateLoyaltyComponent implements OnInit {

  
  id!: number;
  //user: User = new User();

  loyalty: Loyalty = new Loyalty(); 

  constructor(private loyaltyService: LoyaltyServiceService,
    private route: ActivatedRoute, private router: Router) { }


    private getLoyaltyById() {
      this.id = this.route.snapshot.params['id'];
      this.loyaltyService.getLoyaltyById(this.id).subscribe({
        next: (data) => {
          this.loyalty = data;
        },
        error: (e) => {
          console.log(e);
        }
      });
    }  

  
  ngOnInit(): void {
    this.getLoyaltyById();
  }

  updateLoyalty() {

    this.loyaltyService.updateLoyalty(this.id, this.loyalty).subscribe({
      next: (data) => {
        console.log(data);
        this.redirectToUserList();
      },
      error: (e) => {
        console.log(e);
      }
    });
  }

  //updateUser() {
   // this.userService.updateUser(this.id, this.user).subscribe({
      //next: (data) => {
      //  console.log(data);
      //  this.redirectToUserList();
      //},
      //error: (e) => {
      //  console.log(e);
      //}
    //})//;
  //}
  redirectToUserList() {
    this.router.navigate(['/users']);
  }
  onSubmit() {
    console.log(this.loyalty);
    this.updateLoyalty();
  }







}
