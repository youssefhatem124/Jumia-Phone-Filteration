import { Component, OnInit } from '@angular/core';
import { CustomerDto } from '../models/CustomerDto';
import { CustomerDtoPage } from '../models/customerDtoPage';
import { CustomersSearchService } from '../Services/CustomersSearchService/Customers-search-service';
@Component({
  selector: 'app-customer-phonesearch',
  templateUrl:'./customer-phonesearch.component.html',
  styleUrls: ['./customer-phonesearch.component.css']
})
export class CustomerPhonesearchComponent implements OnInit {

  selectedState: any = undefined;
  selectedCountry: any = 'Select All';
  pageNumber: number = 0;
  result: CustomerDto[] = [];
  countries: string[] = [];
  numberOfPages = Array();
  constructor(
    private customerSearchService: CustomersSearchService,
  ) {}

  ngOnInit(): void {
    this.getCustomers(this.pageNumber, undefined, undefined);
    this.getCountries();
  }

  getCountries() {
      this.countries = ["Cameroon","Ethiopia","Morocco","Mozambique","Uganda"];
      this.countries.unshift(this.selectedCountry);
    
  }

  getCustomers(pageNumber: number, state: any, country: any) {
    this.customerSearchService
      .getCustomers(pageNumber, state, country)
      .subscribe((result :any) => {
        this.result = result.customerDtoList as CustomerDto[];
        const s = result.numberOfPages as number;
        this.numberOfPages = Array(s);
      });
  }

  updatePageNumber(pageNumber: number) {
    this.ChangeStatus(pageNumber, this.selectedState, this.selectedCountry);
  }
  ChangeState(state:any)
  {
    this.selectedState=state;
  }
  ChangeStatus(pageNumber: number, state: any, country: any) {

    this.pageNumber = pageNumber;
    this.selectedCountry = country;
    this.selectedState=state
    if (country == 'Select All') this.selectedCountry = undefined;
    if (state == 'undefined')  this.selectedState = undefined;

    this.getCustomers(this.pageNumber, this.selectedState, this.selectedCountry);
  }
}


