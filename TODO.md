# TODO

## Current Status:
- Backend (Spring Boot + Keycloak): Basic CRUD working, authentication enabled.
- Frontend (Angular): Basic UI, API calls working (without Keycloak integration).
- Database: Storing CV data, needs linkage with Keycloak users.

---

## Authentication & User Management
- [x] Set up Keycloak instance
- [x] Configure backend to enforce authentication via Keycloak
- [x] Verify authentication with Postman (via Bearer token)
- [ ] Integrate Angular with Keycloak
  - [ ] Add Keycloak Angular SDK
  - [ ] Implement login/logout functionality
  - [ ] Store & manage user session in frontend
- [ ] Restrict user access in API
  - [ ] Ensure users can only access their own CVs
  - [ ] Extract "keycloakUserId" from token in API requests
  - [ ] Modify database queries to filter CVs by logged-in user
- [ ] Secure API endpoints fully
  - [ ] Set proper roles and permissions in Keycloak
  - [ ] Implement role-based access control (RBAC)

---

## Backend
- [x] Implement basic CRUD operations for CVs
- [ ] Implement linking between Keycloak users and CVs
- [ ] Enable file generation & downloads
  - [ ] Convert CV data into a PDF format
  - [ ] Convert CV data into a DOCX format
- [ ] Add REST endpoints for CV generation
- [ ] Implement email service (send CV as an email attachment)
- [ ] Implement unit & integration tests

---

## Frontend
- [x] Set up Angular project & routing
- [ ] Connect Angular to Keycloak
  - [ ] Implement login & logout UI
  - [ ] Store user session & refresh tokens
- [ ] Improve CV form UI
  - [ ] Build form to input CV data
  - [ ] Validate input fields
  - [ ] Allow users to edit and update their CV
- [ ] Add CV template selection UI
- [ ] Generate & display a live preview of the CV
- [ ] Implement download options (PDF & DOCX)
- [ ] Optimize frontend performance

---

## File Generation
- [ ] Research best approach for document generation
  - [ ] Thymeleaf / HTML-to-PDF
  - [ ] iText / Apache POI for DOCX
- [ ] Implement PDF generation logic
- [ ] Implement DOCX generation logic
- [ ] Ensure template customization (fonts, colors, layouts)

---

## Testing
- [x] Set up GitHub Actions for CI/CD
- [ ] Write unit tests for backend & frontend

---

## Optional Enhancements
- [ ] Implement multi-language support for CVs
- [ ] Add AI-based suggestions for CV content
- [ ] Create an admin panel to manage users and templates
- [ ] Allow custom theme creation for CV templates  

