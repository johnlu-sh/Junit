# Introduction
- Using PowerMock and Mockito to mock a constructor.
- Using PowerMock and Mockito to mock a private method.
- Using PowerMock and Mockito to mock a static method.

## Files Modified
	- modified: pom.xml
	- new file: src/main/java/com/demo/powermock/UtilityClass.java
	- new file: src/main/java/com/demo/powermock/SystemUnderTest.java
	- new file: src/test/java/com/demo/powermock/PowerMockitoMockingConstructorTest.java
	- new file: src/test/java/com/demo/powermock/PowerMockitoMockingPrivateMethodTest.java
	- new file: src/test/java/com/demo/powermock/PowerMockitoMockingStaticMethodTest.java

## Libraries Added
-		<dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-module-junit4</artifactId>
            <version>2.0.2</version>
            <scope>test</scope>
        </dependency>	
-		<dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-api-mockito2</artifactId>
            <version>2.0.2</version>
            <scope>test</scope>
        </dependency>		
