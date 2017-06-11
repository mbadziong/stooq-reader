# Stooq reader

### Setup

requirements:
* java
* maven
* nodejs

Install:
```
mvn clean install
```
```
cd src/main/resources/static/
```
```
npm install
npm run bundle
```
### Run

Inside /src directory type:
```
mvn spring-boot:run
```

Visit http://localhost:3333/

You should see something similiar to this screenshot:
![Alt text](example.png?raw=true "Stooq Reader sample view")