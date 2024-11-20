
# Keycloak Setup
The Keycloak setup can be done in two parts. The first part describes the setup for Keycloak itself, 
the second part describes the client configuration.

## Keycloak
  - Create new realm (e.g. gremlin-engine)
  - Create client for realm (e.g. gremlin-engine-app)
  - Create two roles for client-realm: admin & user
  - Create two test users: user1& user2 with password 12345

## Spring security and JWT Converter
  - Create test controller endpoints
  - Add Spring Security configuration for the endpoints
  - Update properties file with configuration for Keycloak
  - Create class(es) for JWT Conversion