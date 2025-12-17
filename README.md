<img width="1915" height="1000" alt="image" src="https://github.com/user-attachments/assets/0dc57e7c-e0a2-4975-998d-e59625441d5a" /># alpha-project-tool
Projektnavn: Alpha Solutions Project Tool

Et webbaseret projektkalkulationsværktøj til projekt, opgave og tidsstyring. Systemet understøtter rollebaseret adgang, projekter, opgaer, tidsregistrering og rapportering. 

Teknologistak : Java 21, Spring Boot 3+, Spring Data JPA, Thymeleaf, MySQL, Chart.js til rapportgraf, GitHub Actions, Azure App Service.

Softwarekrav: Java 21 eller nyere version, Maven 3.8+, MySQL 8.x, IDE(Intellij anbefalet)

Kørsel lokalt: 
1. Clone repo 
2. Opret MySQL database
3. Kør schema.sql og data.sql
4. Kør applikationenen via ./mvnw spring-boot:run
5. Åbn http://localhost:8080 i browser.

Deployment (Azure)
1. Github actions workflow opretter JAR 
2. Azure app service modtager deployment automatisk
3. Forbindelsesstrenge sættes som miljøvariabler
4. Azure profil aktiveres via spring.profiles.active=azure


Azure url : https://alphasolutions-projecttool-eaa6bde7eweza5c2.norwayeast-01.azurewebsites.net/

