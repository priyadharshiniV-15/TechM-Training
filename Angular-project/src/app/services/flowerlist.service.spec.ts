import { TestBed } from '@angular/core/testing';

import { FlowerlistService } from './flowerlist.service';

describe('FlowerlistService', () => {
  let service: FlowerlistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlowerlistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
