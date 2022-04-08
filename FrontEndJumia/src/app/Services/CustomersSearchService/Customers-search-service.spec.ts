import { TestBed } from '@angular/core/testing';

import { CustomersSearchService } from '../CustomersSearchService/Customers-search-service';

describe('CustomerSearchService', () => {
  let service: CustomersSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomersSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
