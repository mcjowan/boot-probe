# boot-probe
isprobavanje springa sa ostalim tehnologijama

## 06.2017
	- Java 1.8
	- Spring boot (data JPA)
	- Povezan sa Liquibase DB - h2
	- jetty-servlet
	- Ubačen thymeleaf - verovatno ću ga izbaciti, to je samo test
	- Tiles zakomentarisan - videti šta sa tim
	- webjars - bootstrap i jquery
### Da li koristiti sitemesh?
### Elastic
### Angular
#### Ne u ovoj verziji
#### Linkovi:
 - https://www.genuitec.com/creating-first-angular-4-app-using-angular-ide/
 - https://www.genuitec.com/products/angular-ide/ - plugin za eclipse i Angular IDE (imam ga)

# Pokretanje i kompajliranje aplikacije
U application.yml staviti pod spring: profiles: active: dev
	mvn clean package
Aplikaciju pokrenuti iz Eclipse: Debug as Java Application

# Problemi i pitanja
## Static content
 - resources je prirodno za static content. Zašto i kako je hipster stavio u webapp?
 - kako je to povezano ili ja nisam to dobro ukačio - proveriti, jer tamo je ipak angular
*** https://docs.spring.io/spring-boot/docs/current/reference/html/
	boot-features-developing-web-applications.html - 27.1.5 Static Content
	 - ovde ima o stazama i svemu ostalom
  - resursi su na spring.mvc.static-path-pattern=/**
  - /webjars/**
  - src/main/resources/templates - Thymeleaf
  - /error - Error Handling

## Ostavi ovu aplikaciju da bude funkcionalna sa thymeleaf
 - i tako je konfiguriši - bar prezentacioni sloj
 - onda napravi novu, koja će biti za angular

 
# Spring HATEOAS
## If you’re developing a RESTful API that makes use of hypermedia
### hypermedia-based applications 

# CORS support
## Cross-origin resource sharing
 - (CORS) is a W3C specification implemented by most browsers that allows you to specify in a flexible way what kind of cross domain requests are authorized, instead of using some less secure and less powerful approaches like IFRAME or JSONP.
