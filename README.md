# Kali Emailing Service
Kali Emailing Service Is a mailing service used, to send emails through http requests.

## Configuration
First, clone the repository on your device:
```bash
git clone https://github.com/Kaliham/kali-emailing-service
```
Then, checkout `release` branch
```bash
git checkout release
```

Now, configure the project by creating `src/resources/application-prod.yml`, then add the following:
```yaml
spring:
  mail:
    username: #your email
    password: #app password
```

After Finishing the configuration, configure the REST controller CORS to accept your domain/ip.
```java
@CrossOrigin(origins = "your_domain_or_ip")
```

### Note [.properties]
> You can use .properties as such `src/resources/application-prod.properties`
> but it's not recommended to use yaml and properties in the same project, so 
> you need to  change the `application.yaml` to `application.properties` and 
> format appropriately.

### Credit
Kaliham - Checkout my website [yourfavoritesde.me](https://yourfavoritesde.com) !




