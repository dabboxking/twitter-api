# twitter-api with Spring Social
<p>Demostrating twitter api usage with Spring Social</p>

## Getting Started
clone this repo

<p>Get yourself a twitter appi key and secret. Follow this guide to do so <a href="https://spring.io/guides/gs/register-twitter-app/">here</a></p>
<p>Add environment variables twitterKey = {your key} and twitterSecret = {your secret}</p>

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
<p>NOTE: When accessing http://localhost:8080 via browser the default twitter username "emmanueljreyme" me of course. Feel free to change it ^_^</p>
