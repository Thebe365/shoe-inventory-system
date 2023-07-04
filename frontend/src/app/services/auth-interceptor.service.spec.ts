import { TestBed } from '@angular/core/testing';

<<<<<<< HEAD
import { AuthInterceptorService } from './auth-interceptor.service';

describe('AuthInterceptorService', () => {
  let service: AuthInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthInterceptorService);
=======
import { AuthInterceptor } from './auth-interceptor.service';

describe('JwtInterceptorService', () => {
  let service: AuthInterceptor;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthInterceptor);
>>>>>>> eceedcf (fixing cors pref-flight issue)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
