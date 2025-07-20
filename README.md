# 💼 AI-Powered Job Recommendation System

![Angular](https://img.shields.io/badge/Frontend-Angular-red)
![Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot-blue)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-green)
![TailwindCSS](https://img.shields.io/badge/UI-TailwindCSS-9cf)
![Status](https://img.shields.io/badge/Status-In_Progress-important)

> 🤖 A smart AI-powered job recommendation system that analyzes candidate resumes and matches them with the best job listings using TF-IDF, Cosine Similarity, and OpenAI's Embedding Models.

---

## 🌟 Features

- 📄 Upload resumes (PDF)
- 🤖 AI-based resume parsing and job matching
- 🔍 Search & filter job postings
- 📈 Analytics dashboard
- 📑 Downloadable job recommendations
- 🔐 Admin authentication (JWT/session)
- 🌙 Light/Dark mode toggle
- 📦 RESTful APIs for frontend-backend communication

---

## 🧰 Tech Stack

| Frontend          | Backend            | Database        | AI/Logic Layer         | Tools              |
|-------------------|--------------------|------------------|-------------------------|--------------------|
| Angular           | Spring Boot        | PostgreSQL       | OpenAI Embeddings       | IntelliJ IDEA      |
| Angular Material  | Spring Web, JPA    | H2 (dev mode)    | TF-IDF + Cosine Matching| Postman / Swagger  |
| Tailwind CSS      | Spring Security    |                  | Python (optional AI)    | Git & GitHub       |

---

## 📁 Project Folder Structure

```
job-recommendation-system/
├── backend/
│   ├── src/
│   │   ├── main/java/com/yourname/jobmatch/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── JobRecommendationSystemApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── pages/
│   │   │   └── services/
│   │   ├── assets/
│   │   └── main.ts
│   ├── tailwind.config.js
│   └── angular.json
```

---

## 🚀 Installation & Setup

### 🔧 Backend (Spring Boot)

1. Open the project in **IntelliJ IDEA**
2. Add PostgreSQL DB connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Build & Run the project:

```bash
mvn clean install
```

Use Swagger UI/Postman to test API endpoints.

---

### 🎨 Frontend (Angular + Tailwind)

1. Navigate to `frontend` folder:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Install Tailwind:

```bash
npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init
```

4. Configure `tailwind.config.js` and add Tailwind to `styles.css`.

5. Run Angular app:

```bash
ng serve
```

Visit: [http://localhost:4200](http://localhost:4200)

---

## 🔐 Authentication (Future)

- Admin login with JWT
- Role-based access

---

## 🧪 Testing Tools

- ✅ Postman / Swagger UI – Test API routes
- ✅ MongoDB Compass / PgAdmin – View data
- ✅ Angular DevTools / Browser DevTools – Debug frontend

---

## 🧠 AI Logic (Bonus)

- Extract keywords from resumes using PDFBox
- Match with job listings using:
  - TF-IDF keyword comparison
  - Cosine Similarity
  - OpenAI Embedding API (for smarter vector-based matching)
- Optional Python ML engine for advanced scoring

---

## 🌱 Learning Outcomes

- 🔄 Integrate Angular and Spring Boot
- 📊 Use TailwindCSS for modern UI
- ⚙️ Secure backend with Spring Security
- 🧠 Enhance recommendations with AI/ML
- 💾 Connect and query PostgreSQL via JPA

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Vinod Maduranga**  
📧 vinodrajapaksha.dev@gmail.com  
🌐 [LinkedIn](https://www.linkedin.com/in/vinod-rajapaksha) | [GitHub](https://github.com/Vinod-Rajapaksha)

---

> _Built with 💻 code, 💡 AI, and ☕ passion._
