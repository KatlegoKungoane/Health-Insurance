# Health-Insurance
BBD Health Insurance admin portal

## Backend

# How to run:
`mvn clean install`
`./mvnw spring-boot:run`

## Frontend

# How to run (local):
`npm install`
`npm run dev`

# How to run (Docker using podman):
`podman build . -t frontend:v1`
`podman run -p 3000:3000 frontend:v1`
