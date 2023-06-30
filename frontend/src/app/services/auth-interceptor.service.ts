import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
<<<<<<< HEAD

    const token = localStorage.getItem('token'); // you probably want to store it in localStorage or something
=======
    const token = localStorage['token']; // you probably want to store it in localStorage or something
>>>>>>> eceedcf (fixing cors pref-flight issue)

    if (!token) {
      return next.handle(req);
    }

    const req1 = req.clone({
<<<<<<< HEAD
      headers: req.headers.set('Authorization', `Bearer ${token}`),
=======
      headers: req.headers.append('Authorization', `Bearer ${token}`),
>>>>>>> eceedcf (fixing cors pref-flight issue)
    });

    return next.handle(req1);
  }

}