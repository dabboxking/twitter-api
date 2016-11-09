# twitter-api with SpringBoot
<p>Demostrating twitter api usage with Springboot</p>

## Getting Started
clone this repo

```bash
mvn clean install
mvn spring-boot:run
```

## Usage
<p>For twitter profile data</p>

```bash
curl http://localhost:8080/users/{username} 
```
<p>For twitter profile tweets (last 20)</p>

```bash
curl http://localhost:8080/users/{username}/tweets
```
<p>NOTE: When access http://localhost:8080 via browser the default twitter username "emmanueljreyme" me of course. Feel free to change it ^_^</p>
