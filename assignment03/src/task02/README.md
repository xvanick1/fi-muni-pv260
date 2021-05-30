# Task 2

## Run Tests
**For the tests run following commands from task02 root directory.**

1. Run all checks test with:  
`java -cp target/brainmethod.jar:src/checkstyle-8.42-all.jar com.puppycrawl.tools.checkstyle.Main -c src/config.xml src/test/java/AllConstraintsBroken.java`  

2. Run cyclomatic complexity check test with:  
`java -cp target/brainmethod.jar:src/checkstyle-8.42-all.jar com.puppycrawl.tools.checkstyle.Main -c src/config.xml src/test/java/CyclomaticComplexityTwelve.java`  

3. Run LOC check test with:  
`java -cp target/brainmethod.jar:src/checkstyle-8.42-all.jar com.puppycrawl.tools.checkstyle.Main -c src/config.xml src/test/java/MethodLong16LOC.java`  

4. Run nesting check test with:  
`java -cp target/brainmethod.jar:src/checkstyle-8.42-all.jar com.puppycrawl.tools.checkstyle.Main -c src/config.xml src/test/java/NestingFive.java`  

5. Run variables check test with:  
`java -cp target/brainmethod.jar:src/checkstyle-8.42-all.jar com.puppycrawl.tools.checkstyle.Main -c src/config.xml src/test/java/NumberOfVariables10.java`  