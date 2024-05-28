import { TestBed } from '@angular/core/testing';

import { RestaurantsAllService } from './restaurants-all.service';

describe('RestaurantsAllService', () => {
  let service: RestaurantsAllService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantsAllService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
