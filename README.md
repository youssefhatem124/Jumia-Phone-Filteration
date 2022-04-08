# Users Numbers Filteration 
In this application, 
I am building a full stack Angular 13 + Spring Boot .The back-end server uses Spring Boot, Spring Data JPA for interacting with database. The front-end will be built using Angular 13 . 
<img width="1200" src="https://user-images.githubusercontent.com/51910576/162474534-40c42359-8225-4cc3-ada8-404ca94c24d3.png">
-You have the option to filter either by state or Country or Either by both .

# Photo representing architecture of the application
<img width="1200" src="https://user-images.githubusercontent.com/51910576/162489050-c541302c-ad71-41ca-a855-368acdec6739.png">
# Now You Can Access The Application On: <br>
<br>
First use this command in back-end-app path:
<b> mvn package</b> 
this will generate the target file and the jar <br>
then use this command in the same path to create docker image based on docker file: <b>docker build -t spring-boot-jumia-image .</b><br>
now we have an image on our spring boot application, then we need a container to run this image <br>
so run this command :  <b>docker run -d --name spring-boot-container -p 8080:8080 spring-boot-jumia-image</b><br>
Now we have finished dockerizing our spring boot app .<br><br>
Then we go to angular project path front-end-app <br>
first run this command to generate node modules :  <b>npm install</b> <br> 
then run this command to generate dist files:  <b>ng build --prod</b> <br>
then run this command to build an angular image based on the docker file: <b>docker build -t jumia-angular-image .</b> <br>
then run a container of this image : <b>docker run -d --name angular-container -p 9090:80 jumia-angular-image</b> <br>



# Now You Can Access The Application On: <br>
# http://localhost:9090

