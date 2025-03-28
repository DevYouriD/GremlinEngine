
# Authentication Flow with Spring Boot, Angular, and Keycloak

### Overview
In the application, the flow works as follows:
1. **User Registration and Authentication** happens through **Keycloak**.
2. **Frontend (Angular)** makes requests to **Spring Boot Backend** with a **JWT (access token)**.
3. When the access token expires (typically after 1 hour), the frontend uses the **refresh token** to obtain a new access token, avoiding the need for the user to log in again.

### Step-by-Step Authentication Flow

1. **User Login (Initial Authentication)**:
    - The user logs in via **Keycloak** (the identity provider).
    - After login, **Keycloak** issues:
        - **Access token**: This is used for authenticated requests (short-lived, typically 1 hour).
        - **Refresh token**: This is used to obtain a new access token when the old one expires (longer-lived).

2. **Frontend (Angular)** Sends Requests:
    - The Angular app sends requests to the Spring Boot backend with the **access token** included in the `Authorization` header:
      ```http
      Authorization: Bearer <access_token>
      ```

3. **Backend (Spring Boot)** Validates the Access Token:
    - Spring Security checks the **JWT access token** sent with the request to verify that it's valid and not expired.
    - If the token is valid, the backend processes the request and returns the response.
    - If the token has expired, the backend returns a **401 Unauthorized** error.

4. **Handling Token Expiration**:
    - The **access token** expires after a set time (e.g., 1 hour).
    - To continue making authenticated requests, the frontend must use the **refresh token** to request a new access token from Keycloak.

5. **Token Refresh**:
    - The frontend sends the **refresh token** to Keycloak’s `/protocol/openid-connect/token` endpoint to get a **new access token**.
    - If the refresh token is valid, Keycloak returns a new **access token** and optionally a new **refresh token**.

6. **What Happens When the Refresh Token Expires**:
    - If the **refresh token** expires (after a longer period, like several days or weeks), the user will need to **log in again**.
    - The login will issue a new **access token** and **refresh token**.

### How the Flow Should Work:
1. **Frontend**:
    - On each request, the Angular app sends the **access token** in the `Authorization` header.
    - If the **access token expires**, the frontend **uses the refresh token** to get a new access token from Keycloak.
    - You can implement an **Angular HTTP interceptor** to handle token expiration and refresh automatically.

2. **Backend**:
    - The backend only validates the **access token** for each request.
    - It doesn't need to handle the refresh process; it just returns a 401 error if the token is invalid or expired.

### Example Angular Interceptor for Token Refresh:
Here’s an example of an **HTTP interceptor** in Angular that handles token expiration and refresh:

```typescript
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, switchMap } from 'rxjs/operators';
import { AuthService } from './auth.service';  // Assume you have an AuthService for token management

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<any> {
    // Add the Authorization header with the current access token if available
    const token = this.authService.getAccessToken(); // Get the current access token
    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`,
        },
      });
    }

    // Continue with the request
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        // If the error is a 401 Unauthorized and the token has expired, try to refresh it
        if (error.status === 401 && error.error.message === 'Token expired') {
          return this.authService.refreshToken().pipe(
            switchMap((newToken: string) => {
              // Retry the original request with the new token
              request = request.clone({
                setHeaders: {
                  Authorization: `Bearer ${newToken}`,
                },
              });
              return next.handle(request);
            })
          );
        }
        return throwError(error);
      })
    );
  }
}
```

### Key Concepts:
- **Access Token**: Short-lived token (typically 1 hour) used to authenticate requests.
- **Refresh Token**: Long-lived token used to get a new access token when the old one expires.
- **JWT**: JSON Web Token that contains user information and is signed by Keycloak for security.
- **Token Expiration**: Access tokens expire after a short time, requiring the frontend to use a refresh token to get a new one.

### What Happens When Tokens Expire:
1. When the **access token expires**, the frontend uses the **refresh token** to obtain a new access token from Keycloak.
2. The **refresh token** typically lasts longer than the access token (e.g., days or weeks).
3. If the **refresh token expires**, the user will be asked to log in again to get a new access token and refresh token.

### Conclusion:
- The **access token** is valid for a short time (typically 1 hour), while the **refresh token** is used to get a new access token when it expires.
- The frontend should handle token expiration automatically by using an HTTP interceptor to request a new access token using the refresh token.
- The backend just validates the **access token** and does not handle the refresh process.

---

# Setup
The Keycloak setup can be done in two parts. The first part describes the setup for Keycloak itself, 
the second part describes the client configuration.

- Create new realm (e.g. gremlin-engine-realm)
- Create client for realm (e.g. gremlin-engine-app)
- Create two roles for client-realm: admin & testuser with passwords root & 1234

#### Curl command to get JWT Token
      
```bash
cURL --location 'http://localhost:8080/realms/gremlin-engine-realm/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=root' \
--data-urlencode 'client_id=gremlin-engine-app'
```

##### If you're using Windows execute this command in Powershell

```bash
curl -Uri "http://localhost:8080/realms/gremlin-engine-realm/protocol/openid-connect/token" `
    -Method POST `
-Headers @{"Content-Type"="application/x-www-form-urlencoded"} `
-Body "grant_type=password&username=admin&password=root&client_id=gremlin-engine-app"
```

## Spring security and JWT Converter
  - Create test controller endpoints
  - Add Spring Security configuration for the endpoints
  - Update properties file with configuration for Keycloak
  - Create class(es) for JWT Conversion