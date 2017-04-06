# Restful APIs using JavaEE7

### Technologies used

1. JAX-RS
2. J2 in memory database & Persistence API
3. Dependency Injection

### Compile
```
mvn clean package
```

### Import in Netbeans

File -> Open Project and clean & build

### Import Wildfly server to Netbeans & Deploy App

1. Download wildfly from [here](http://wildfly.org/downloads/), using the green button.
2. In Netbeans, hit the Services tab, then Servers -> Add Server -> JBOSS App Server  and put as server location the downloaded server, i.e C:\Users\whatever\Downloads\wildfly-10.1.0.Final
3. Back to Projects tab, right click on the project -> Properties -> Run, specify Wildfly. Hit the Run green button and you are ready to test: [http://localhost:8080/JavaEE7RestWF-1.0-SNAPSHOT/user](http://localhost:8080/JavaEE7RestWF-1.0-SNAPSHOT/user)
4. Similarly you can deploy to Glashfish server

### Import Glashfish server to Netbeans
1. Download Glashfish from [here](https://glassfish.java.net/download-archive.html), by choosing glassfish-4.1.zip.
2. In Netbeans, hit the Services tab, then Servers -> Add Server -> Glashfish App Server  and put as server location the downloaded server, i.e C:\Program Files\glashfish\glashfish4

### Deploy to WildFly as war
We assume that you have registered already application users for WildFly server, as described [here](http://www.austincc.edu/rmartin6/coursecontent/inew2338/01-jdk-wildfly-netbeans-setup-local.pdf), pages 8-11.
1. Start wildfly server, using the script: wildfly-10.1.0.Final/bin/standalone
2. Deployment -> Add -> Choose war and you are ready to go

### Known Wildfly Server issues
1. Duplicate resource' if "<app>.war.failed" file is present in deployment folder: [Solution](http://stackoverflow.com/a/17415767/4534055)

### API description
- GET: /user , returns all users
- GET: /user/11 , returns user 11
- DELETE: /user/11 , deletes user 11 and returns 204 no-content
- POST: /user with JSON: adds a new user and returns 204 no-content
```
{
	"name":"aname",
	"surname":"asurname"
}
```
