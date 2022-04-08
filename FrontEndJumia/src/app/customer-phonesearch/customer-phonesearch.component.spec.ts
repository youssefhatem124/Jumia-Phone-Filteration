import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPhonesearchComponent } from './customer-phonesearch.component';

describe('CustomerPhonesearchComponent', () => {
  let component: CustomerPhonesearchComponent;
  let fixture: ComponentFixture<CustomerPhonesearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerPhonesearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerPhonesearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
