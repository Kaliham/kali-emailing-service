# Kali Emailing Service
Kali Emailing Service Is a mailing service used, to send emails through http requests.

## Configuration

Create `src/resources/application-prod.yml`, then add the following:
```yaml
spring:
  mail:
    username: #your email
    password: #app password
```

### Note [.properties]
> You can use .properties as such `src/resources/application-prod.properties`
> but it's not recommended to use yaml and properties in the same project, so 
> you need to  change the `application.yaml` to `application.properties` and 
> format appropriately.





