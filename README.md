this project uses [maven](https://maven.apache.org/) to Run

```
$ mvn compile
```

to run Main class

```
mvn exec:java -Dexec.mainClass="com.bodhert.maven.pslMineSweeper.Main"
```

to run Interactive test
```
mvn exec:java -Dexec.mainClass="com.bodhert.maven.pslMineSweeper.InteractiveTest"
```