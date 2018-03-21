# serenity-ui-todomvc

A simple demonstration project using Serenity with Cucumber, running tests against the http://todomvc.com/examples/angularjs/#/ application.

The project runs using JDK 1.8 and Maven. To run the demo, run:

```
mvn clean verify
```

To run a single smoke test:

```
mvn clean verify -Dcucumber.options="--tags @smoke"
```

The Serenity reports will be generated in the `target/site/serenity` directory.


## Headless Chrome

To run in headless mode:

```
mvn clean verify -Dchrome.switches=--headless
```


## Running with Docker

To run the tests locally within a Selenium Docker container:

```
docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
mvn clean verify -Dwebdriver.remote.url=http://localhost:4444/wd/hub
```

