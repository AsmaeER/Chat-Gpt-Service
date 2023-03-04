This project is a Java microservice that communicates with ChatGPT AI via an exposed endpoint. The microservice updates a "database" in the system with questions sent to ChatGPT and their corresponding answers received through the API. The objective of this project is to create a microservice that queries the ChatGPT API using input strings provided by the user, appends the questions and answers to a CSV file, and responds to the user with the answer provided by ChatGPT.

To run this project, you will need:
-Java: 17 
-Spring Boot: 3
-Docker
-Eclipse for spring boot (u can download it from this https://spring.io/tools)
-Empty file csv 

Step1: Clone project
Cloning the project into your local using this command: git clone https://github.com/AsmaeER/Chat-Gpt-Service.git

Step2: Change the location of the csv file in code 
Go to com.api.services -> ChatGptServiceImp.java , for the two methods getChatAnswer() and getChatQuestion() where we append into csv, change the location with the empty csv file that you created before .

Step3: API key
Api key = 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.
In com.api.configuration -> ChatGptConfiguration.java put this api key in the variable API_KEY.

Step4: Run DockerFile
Open the project in Eclipse, u will find the DockerFile, this file is used to build a Docker image for the project. Here's a breakdown of what each line does:
FROM openjdk:17:  This specifies the base image for the Docker container, which is a pre-built image of the Java Development Kit (JDK) version 17 from the official Docker Hub repository. This means that the container will already have Java 17 installed and configured.
EXPOSE 8888: This tells Docker to expose port 8888 on the container. This is the port that the chatgpt-api application will be listening on, and this command allows other containers or host systems to connect to it.
ADD target/chatgpt-api.jar chatgpt-api.jar: This adds the "chatgpt-api.jar" file from the "target" directory to the root directory of the Docker container. Presumably, this is the compiled Java application that will be run inside the container.
ENTRYPOINT [ “java”, “-jar”, “chatgpt-api.jar”]: This specifies the command to run when the container is started. In this case, it will run the Java executable with the "-jar" option, passing in the name of the "chatgpt-api.jar" file as an argument. This will start the chatgpt-api application inside the container.
Run this file with maven install (Right Click -> Maven install).

Step5: Build the docker image (Using cmd)
Run this command: docker build . -f DockerFile -t chatgpt-api.jar.

Step6: start the docker container
Run this command: docker run -p8888:8090 chatgpt-api.jar:latest
After this you have to find your container is running in docker, then you can access it from the host machine at localhost:8888 /send.
(‘/send): to get a detailed answer.
(‘/SendQuestion): to get just answer.

NOTE:
If it’s not working check the port 8888 and port 8090 in your machine are not used by other applications. 

