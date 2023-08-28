FROM eclipse-temurin:17-jre-alpine
# Install curl and jq
RUN apk add curl jq
# Workspace
WORKDIR /usr/share/selenium-docker
# Add .jar under target from host into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
# If we have any other dependencies(such as .csv/.json, etc...), add them here as well
# Add suite files as well
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml
# Add healthcheck.sh script
ADD healthcheck.sh healthcheck.sh
# Execute the healthcheck.sh script
ENTRYPOINT sh healthcheck.sh