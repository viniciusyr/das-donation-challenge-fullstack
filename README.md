[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[ANGULAR_BADGE]: https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[TAILWIND_BADGE]: https://img.shields.io/badge/tailwindcss-%2338B2AC.svg?style=for-the-badge&logo=tailwind-css&logoColor=white

<h1 align="center" style="font-weight: bold;"><a href="https://github.com/viniciusyr/donation-challenge"> DAS - Donation Challenge </a></h1>

![angular][ANGULAR_BADGE]
![spring][SPRING_BADGE]
![java][JAVA_BADGE]
![docker][DOCKER_BADGE]
![tailwindcss][TAILWIND_BADGE]

<p align="center">
 <a href="#features">Features</a> • 
 <a href="#getting-started">Getting Started</a> • 
 <a href="#api-endpoints">API Endpoints</a> •
 <a href="#acknowledgements">API Endpoints</a>
</p>

<p align="center">
  <b>A simple fullstack donation inventory application built with Spring Boot (backend) and Angular (frontend), including RESTful API, Swagger/OpenAPI documentation, and unit/integration testing. This project was made as a Task for an opportunity to work with a amazing and inspiring initiative <a href="https://www.digitalaidseattle.org/" target="_blank">Digital Aid Seattle</a></b>
</p>

<h2 id="features">⚙️ Features</h2>

-  CRUD operations for donations
-  API documentation via Swagger/OpenAPI
-  Unit tests using MockMvc
-  Frontend with Angular and TailwindCSS
-  Fully standalone backend and frontend applications
-  Optional Docker support for production builds

<h2 id="getting-started"> Getting Started</h2>

<h3>Prerequisites</h3>

- [Java 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Node.js 20+](https://nodejs.org/)
- [Angular CLI](https://angular.io/cli)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/) (Optional if you want to run without docker)

<h3>Cloning</h3>

```bash
git clone https://github.com/viniciusyr/donation-challenge.git
cd donation-challenge
```
<h3>Backend Setup</h3>

```bash
cd backend
./mvnw spring-boot:run
```
* API base URL: http://localhost:8080/donations
* Swagger/OpenAPI docs: http://localhost:8080/swagger-ui.html

<h3>Frontend Setup</h3>

```bash
cd frontend
npm install
npm run build
npm start
```

* Note: According to the [TailwindCSS](https://tailwindcss.com/docs/installation/framework-guides/angular) doc, you may use the following code to succesfully instal and run Tailwind with Docker

```bash
npm install tailwindcss @tailwindcss/postcss postcss --force
```

<h2 id="docker">🐳 Docker</h2>

You can run both backend and frontend using Docker Compose:

```bash
docker-compose build --no-cache
docker-compose up -d
```
* Frontend: http://localhost:4200
* Backend API: http://localhost:8080/donations

Notes:
* Dockerfile for frontend installs Node.js (Alpine 20) dependencies and builds Angular app.
* Dockerfile for backend uses Eclipse Temurin JDK 21 + Maven.

<h2 id="api-endpoints"> API Endpoints</h2>

| Method | Endpoint        | Description           |
| ------ | --------------- | --------------------- |
| GET    | /donations      | List all donations    |
| GET    | /donations/{id} | Get donation by ID    |
| POST   | /donations      | Create new donation   |
| PUT    | /donations/{id} | Update donation by ID |
| DELETE | /donations/{id} | Delete donation by ID |

<h3>GET /donations</h3>
<p>Request: None</p>
<pre><code>[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "donorName": "Vinicius",
    "type": "MONEY",
    "quantity": 100.5,
    "date": "2025-08-15",
    "createdAt": "2025-08-15T14:30:00Z",
    "updatedAt": "2025-08-16T10:15:00Z"
  }
]</code></pre>

<h3>GET /donations/{id}</h3>
<p>Request: GET /donations/3fa85f64-5717-4562-b3fc-2c963f66afa6</p>
<pre><code>{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "donorName": "Vinicius",
  "type": "MONEY",
  "quantity": 100.5,
  "date": "2025-08-15",
  "createdAt": "2025-08-15T14:30:00Z",
  "updatedAt": "2025-08-16T10:15:00Z"
}</code></pre>

<h3>POST /donations</h3>
<p>Request:</p>
<pre><code>{
  "donorName": "Vinicius",
  "type": "MONEY",
  "quantity": 10,
  "date": "2025-08-15"
}</code></pre>
<p>Response:</p>
<pre><code>{
  "id": "7bc98d12-3456-7890-abcd-1a2b3c4d5e6f",
  "donorName": "Vinicius",
  "type": "MONEY",
  "quantity": 10,
  "date": "2025-08-15",
  "createdAt": "2025-08-15T15:45:00Z",
  "updatedAt": "2025-08-15T15:45:00Z"
}</code></pre>

<h3>PUT /donations/{id}</h3>
<p>Request:</p>
<pre><code>{
  "donorName": "Vinicius",
  "type": "MONEY",
  "quantity": 50,
  "date": "2025-08-15"
}</code></pre>
<p>Response:</p>
<pre><code>{
  "id": "7bc98d12-3456-7890-abcd-1a2b3c4d5e6f",
  "donorName": "Vinicius",
  "type": "MONEY",
  "quantity": 50,
  "date": "2025-08-15",
  "createdAt": "2025-08-15T15:45:00Z",
  "updatedAt": "2025-08-16T09:30:00Z"
}</code></pre>

<h3>DELETE /donations/{id}</h3>
<p>Request: DELETE /donations/7bc98d12-3456-7890-abcd-1a2b3c4d5e6f</p>
<p>Response:</p>
<pre><code>{
  "message": "Donation with id 7bc98d12-3456-7890-abcd-1a2b3c4d5e6f has been deleted successfully."
}</code></pre>

<h2 id="acknowledgements">🙏 Acknowledgements</h2>
<p>
  I would like to express my gratitude for the opportunity to participate in this challenge, which allowed me to learn even more and contribute, in some way, to a noble and honorable cause.
  This initiative, <a href="https://www.digitalaidseattle.org/" target="_blank">Digital Aid Seattle</a>, does amazing work and is truly inspiring.
</p>
