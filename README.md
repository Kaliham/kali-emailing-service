# Kali Emailing Service
Is a mailing service used, to send emails through http requests.

## Configuration

Inside `src/resources/application-dev.yml` add the following:
```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: #your email
    password: #app password
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

