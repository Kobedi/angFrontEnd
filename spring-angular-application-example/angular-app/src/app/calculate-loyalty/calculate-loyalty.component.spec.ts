import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculateLoyaltyComponent } from './calculate-loyalty.component';

describe('CalculateLoyaltyComponent', () => {
  let component: CalculateLoyaltyComponent;
  let fixture: ComponentFixture<CalculateLoyaltyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculateLoyaltyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalculateLoyaltyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
