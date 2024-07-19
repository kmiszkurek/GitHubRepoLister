# GitHub Repositories API

This application provides an API to list all non-forked repositories for a given GitHub user along with their branches and last commit SHA.

## Technologies Used

- Java
- Spring Boot
- Spring Cloud OpenFeign
- Feign Client

## Setup Instructions

1. Clone the repository
2. Navigate to the project directory
3. Build the project using Maven
    ```sh
    ./mvnw clean install
    ```
4. Run the application
    ```sh
    ./mvnw spring-boot:run
    ```

## API Endpoints

### List User Repositories

**Request**
```http
GET /api/users/{username}/repos
```
**Response**
- 200 OK: Returns a list of repositories with branches and their last commit SHA.
- 404  Not Found: Returns a custom error message when the user does not exist.

**Example request**
```sh
curl -H "Accept: application/json" http://localhost:8080/api/users/{username}/repos
```

**Example response**
```json
[
  {
    "name": "repository1",
    "owner": {
      "login": "username"
    },
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "abcdef1234567890"
      }
    ]
  }
]
```
**Error response**
```json
{
  "status": 404,
  "message": "User not found: nonexistinguser"
}
```
### Testing the application

**Test with non-existing user**

- Request
```sh
curl -H "Accept: application/json" http://localhost:8080/api/users/nonexistinguser/repos
```
- Expected response
```json
{
  "status": 404,
  "message": "User not found: nonexistinguser"
}
```
**Test with existing user**
- Request
```sh
curl -H "Accept: application/json" http://localhost:8080/api/users/existinguser/repos
```
- Expected response
```json
[
    {
        "name": "Repository",
        "owner": {
            "login": "existinguser"
        },
        "branches": [
            {
                "name": "master",
                "commit": {
                    "sha": "3efv62382ed432625060d2g51d1c12s85er87c426"
                }
            }
        ]
    }
]
```
