
import { CustomerDto } from './CustomerDto';


export interface CustomerDtoPage { 
    customerDtoList?: Array<CustomerDto>;
    numberOfPages?: number;
}

