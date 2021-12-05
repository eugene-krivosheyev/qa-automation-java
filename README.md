Автоматизация QA 
================

Guidelines
==========

Формат обучения
---------------
- группа до 20 человек
- видео-лекции блоками по 20 мин для самостоятельного просмотра
- объем видео ~3 часа в неделю
- задания для самостоятельной проработки ~3 часа трудоемкости в неделю
- групповая консультация раз в неделю вечером онлайн на 1.5 часа (ПТ)  
- разбор вопросов в slack-чате силами тренера и менторов
- итоговая трудоемкость ~1.5 часа в день + выходные как буфер

Что нужно для начала
--------------------
- [ ] Убедиться, что вы в slack-чате
- [ ] [Если нет] завести аккаунт на GitLab
- [ ] Сделать форк данного репозитория с материалами
- [ ] Добавить в ваш новый репо своих менторов как коллабораторов
- [ ] Установить jdk ≥8 и IntelliJ IDEA Ultimate

Контакты
--------
- slack-чат 
- корпоративная почта: `a.roshchina`


Agenda
======

Java Application Building <sup>3.5 часов видео</sup>
-------------------------

### Local GIT versioning workflow <sup>0.5</sup>
- [ ] Local repo
- [ ] Commit
- [ ] Log
- [ ] Tag
- [ ] Branch

### Remote GIT versioning workflow <sup>0.5</sup>
- [ ] Remote repo
- [ ] Clone
- [ ] Push
- [ ] Pull

### Managing PRs with GitLab <sup>0.5</sup>
- [ ] Forks
- [ ] Pull Request
- [ ] PR workflow

### Java platform overview <sup>0.5</sup>
- [ ] Java Platform definition
- [ ] Basic terms: JVM, JRE, JDK

### Simple app lifecycle <sup>0.5</sup>
- [ ] Sources
- [ ] Compiling
- [ ] Packaging
- [ ] Running 
- [ ] sourcepath and classpath

### Maven build lifecycle <sup>0.5</sup>
- [ ] Directory layout
- [ ] Build lifecycles
- [ ] Lifecycle phases
- [ ] Plugins
- [ ] Managing plugins with pom.xml

### Maven dependency management <sup>0.5</sup>
- [ ] Dependency artifacts: JARed classes, sources, javadocs
- [ ] Artifact repositories
- [ ] Artifact identifying
- [ ] Test dependencies vs Prod dependencies

---

Java Application Development <sup>17</sup>
----------------------------

### IDEA Demo <sup>0.5</sup>
- [ ] Project settings and structure: modules, sourcepath + classpath
- [ ] Workspace
- [ ] Views
- [ ] Running application with run configuration
- [ ] Git workflow
- [ ] Maven build

### Java Source Code Documenting <sup>0.25</sup>
- [ ] Source code layout
- [ ] Single-line comments
- [ ] Multi-line comments
- [ ] Downloading and working JavaDoc comments
- [ ] Downloading and working with sources

### Java Packages <sup>0.25</sup>
- [ ] Package: why?
- [ ] Package declaration
- [ ] Naming convention
- [ ] Import directive
- [ ] Encapsulation: why?
- [ ] Visibility modifiers

### Java Classes for Procedure Style <sup>0.25</sup>
- [ ] Class: why?
- [ ] Class declaration
- [ ] Naming convention
- [ ] Dynamic class loading and `static` initialization section
- [ ] Encapsulation concept: behavior and state

### Method declaration <sup>0.5</sup>
- [ ] Method: why?
- [ ] Method declaration
- [ ] Naming convention
- [ ] Visibility modifiers
- [ ] Method body code block
- [ ] Method arguments
- [ ] Method variables
- [ ] Returning values
- [ ] Methods overloading

### Method call <sup>0.5</sup>
- [ ] Dot notation
- [ ] Static import directive
- [ ] Call stack: why?
- [ ] Formal and factual arguments
- [ ] Parameter passing style `pass by value`

### Class variable declaration <sup>0.5</sup>
- [ ] Method vs Class variables: why?
- [ ] Declaration
- [ ] Visibility modifiers
- [ ] Initialization
- [ ] Default initialization values for class and method variables

### Java Primitive types and its literals <sup>0.5</sup>
- [ ] byte
- [ ] int
- [ ] short
- [ ] long
- [ ] float
- [ ] double
- [ ] char
- [ ] boolean

### Variable declaration modifiers <sup>0.25</sup>
- [ ] `final` modifier for variables
- [ ] Local variables type inference with `var`

---

### Type operators <sup>0.25</sup>
- [ ] Auto type casting
- [ ] type casting operator
- [ ] `instanceof`

### Arithmetics operators <sup>0.5</sup>
- [ ] `+, -, *, /, %`
- [ ] Typed operators: 1/3 vs 1./3
- [ ] `ArithmeticException`
- [ ] Types Overflow and solution with `BigInteger`
- [ ] FP precision loss and solution with `BigDecimal`

### Logical operators <sup>0.5</sup>
- [ ] Type-safe
- [ ] `&, |, !`
- [ ] Lazy and eager form: `&&, ||`
- [ ] `==, !=, <, <=, >, >=`
- [ ] Reference types equality issue: absence of `===` and `.equals()`

### Switching <sup>0.5</sup>
- [ ] `if`
- [ ] Ternary operator
- [ ] `switch` and its limitations

### Looping <sup>0.5</sup>
- [ ] `for`
- [ ] `do` and `while`
- [ ] `break` and `continue` operators
- [ ] "foreach" loop for varargs

### Varargs <sup>0.25</sup>
- [ ] Why?
- [ ] Declaration
- [ ] Using
- [ ] Limitations

---

### Reference types <sup>0.5</sup>
- [ ] Reference: why?
- [ ] What types are references?
- [ ] Memory layout
- [ ] Garbage collection
- [ ] `null` literal value
- [ ] Local reference variables and GC
- [ ] `final` issue with reference types
- [ ] Immutable types vs `final`

### Enums <sup>0.25</sup>
- [ ] Enumerated type concept: why?
- [ ] API
- [ ] Using with `switch`

### Arrays <sup>0.5</sup>
- [ ] Declaration
- [ ] Initialization
- empty
- literals
- [ ] "Immutability"
- [ ] API: indexing operator, length
- [ ] Exceptions
- [ ] varargs as arrays
- [ ] iteration loop with `for`
- [ ] `foreach` loop

### Strings <sup>0.5</sup>
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] Strings equality: `==` vs `.equals()`
- [ ] Immutability vs StringBuffer/StringBuilder
- [ ] `String` API
- [ ] `StringBuffer` and `StringBuilder` API

### Wrappers <sup>0.5</sup>
- [ ] Wrapper types: why?
- [ ] Wrapper types: referenced but immutable
- [ ] Wrappers API
- [ ] Autoboxing/unboxing and performance issue

### Custom Type Objects <sup>0.5</sup>
- [ ] Objects: why?
- [ ] Object/instance variable declaration scope
- [ ] Object/instance method declaration scope
- [ ] Encapsulation and visibility modifiers
- [ ] Encapsulated state accessors and mutators
- [ ] Immutable objects

### Common creational patterns <sup>0.5</sup>
- [ ] Object creation with `new`
- [ ] Object state initialization with constructor
- [ ] Constructors overloading
- [ ] Factory method

---

### Polymorphism with interfaces and (abstract) classes <sup>0.5</sup>
- [ ] Polymorphism: why?
- [ ] Java implementation: how it looks in source code
- [ ] Interfaces
- [ ] Implementing interfaces

### `Object` type <sup>0.5</sup>
- [ ] `java.lang.Object` class as reference type
- [ ] Все объекты заменяемы и с ними можно работать унифицированно
- [ ] Equality: `==` vs `.equals()`
- [ ] `equals()` and `hashCode()` contract
- [ ] `toString()`
- [ ] `clone()`

### Inheritance with (abstract) classes <sup>0.5</sup>
- [ ] Inheritance: why?
- [ ] Java implementation: how it looks in source code
- [ ] Abstract classes
- [ ] Classes for code reuse
- [ ] `final` modifier

### Defender methods <sup>0.25</sup>
- [ ] Defender methods: why?

### Code reuse: inheritance vs delegation <sup>0.5</sup>
- [ ] Delegation: why?
- [ ] Delegation: how?
- [ ] DI pattern
- [ ] Method DI
- [ ] Constructor and setter DI

---

### Exception concept <sup>0.25</sup>
- [ ] Type information
- [ ] Object data information
- [ ] `throw` operator
- [ ] Methods call stack information

### Handling exceptions <sup>0.25</sup>
- [ ] creating exception instance
- [ ] `try` section
- [ ] `catch` section
- [ ] `finally` section

### Syntax sugar <sup>0.25</sup>
- [ ] multi-catch
- [ ] try-with-resources

### Exceptions type system <sup>0.5</sup>
- [ ] Built-in types
- [ ] Errors vs Exceptions
- [ ] Checked vs Runtime exceptions

### Generics <sup>0.5</sup>
- [ ] Generics: why?
- [ ] Generic methods
- [ ] Generic classes and interfaces

### Key Collections API overview <sup>0.5</sup>
- [ ] `Collection` API
- [ ] `Set` API and implementations
- [ ] `List` API  and implementations
- [ ] non-collection `Map` API and implementations
- [ ] `Object`'s methods used: `equals` and `hashCode` contract

### Collections API and iterating <sup>0.25</sup>
- [ ] `Iterator` and `for` loop
- [ ] `foreach`

### Utility classes <sup>0.25</sup>
- [ ] `Collections`
- [ ] `Comparable`, `Comparator`

---

### Lambda syntax <sup>0.5</sup>
- [ ] Declaring lambdas
- [ ] Compiler types inference
- [ ] Functional interface
- [ ] Method reference

### Stream API <sup>0.5</sup>
- [ ] Functions composition
- [ ] Terminal and non-terminal operations

### File IO API overview <sup>0.5</sup>
- [ ] `File` and `Path`
- [ ] `Scanner`
- [ ] Simple file operations with utility class `Files`
- [ ] File IO with Streams API

### Reflection API and Annotations <sup>0.5</sup>
- [ ] Reflection API overview
- [ ] Annotations: why?
- [ ] Compiler annotations
- [ ] Checkers annotations

### Java frameworks overview <sup>0.5</sup>
- [ ] IoC: Framework vs Library
- [ ] Object creation and DI
- [ ] Framework configuration: config files and annotations

---

Developing autotests with JUnit <sup>4</sup>
-------------------------------

### JUnit framework overview <sup>0.5</sup>
- [ ] Task flow
- [ ] Test class and methods
- [ ] Annotations
- [ ] Assertions

### Test design <sup>0.5</sup>
- [ ] Test Case and Test method naming
- [ ] Code path
- [ ] Input and State
- [ ] Fixture
- [ ] Test structure

### Fixture reuse <sup>0.5</sup>
- [ ] How many test instances?
- [ ] How to reuse fixture?
- [ ] JUnit test case lifecycle methods
- [ ] Fixture Builders

### Testing alternate flows within tests <sup>0.5</sup>
- [ ] Test states
- failure
- error
- skipped (+assumes)
- [ ] JUnit5 `assertThrows`

### Test Coverage <sup>0.5</sup>
- [ ] Coverage types
- [ ] Coverage tool: JaCoCo
- [ ] Running from Maven build

### Advanced assertions <sup>0.5</sup>
- [ ] JUnit assertions combinator
- [ ] AssertJ library
- [ ] Hamcrest library

### Advanced JUnit <sup>0.5</sup>
- [ ] Timeouts
- [ ] Parameterized tests
- [ ] Suites
- Nested test classes
- [Test suites](https://junit.org/junit5/docs/current/user-guide/#running-tests-junit-platform-runner-test-suite)
- [Tags](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering) [и отдельный запуск](https://junit.org/junit5/docs/current/user-guide/#running-tests-build-maven-filter-tags)

### Unit tests overview <sup>0.5</sup>
- [ ] Test scopes
- [ ] Unit tests with stubs and mocks

---

Docker for QA <sup>3.5</sup>
-------------

### Application overview <sup>0.5</sup>
- [ ] What is DB
- [ ] What is backend
- [ ] What is API
- [ ] What is client
- [ ] Configurations used
- [ ] Overview of [demo application](https://github.com/eugene-krivosheyev/agile-practices-application)
- [ ] [How to build](https://github.com/eugene-krivosheyev/agile-practices-application/blob/master/README.md)
- [ ] [Built release](https://github.com/eugene-krivosheyev/agile-practices-application/releases)

### Docker overview <sup>0.5</sup>
- [ ] Docker: why?
- [ ] Image: why?
- [ ] Registry: why?
- [ ] Container: why?
- [ ] Containers vs VMs

### Docker Image <sup>0.5</sup>
- [ ] Images naming and tags
- [ ] `ls`
- [ ] `pull`
- [ ] `rm`, `prune`
- [ ] immutability and r/w-layer

### Docker container <sup>0.5</sup>
- [ ] Containers naming
- [ ] `ls`
- [ ] `create`
- [ ] `start`
- [ ] `stop`
- [ ] ports
- [ ] mounts

### Configuration externalization <sup>0.25</sup>
- [ ] Externalization: why?
- [ ] How to externalize configuration: 3 patterns

### Troubleshooting <sup>0.25</sup>
- [ ] `log`
- [ ] `exec`

### Dockerizing own application <sup>0.5</sup>
- [ ] `build`
- [ ] Base images
- [ ] Dockerfile structure

## Orchestration <sup>0.25</sup>
- [ ] Orchestration: why?
- [ ] `compose` vs `swarm`
- [ ] `docker-compose.yml`
- [ ] starting and stopping cluster

## Test Containers <sup>0.5</sup>
- [ ] Test Containers: why?
- [ ] Running DB
- [ ] Running generic container

---

Java REST API Testing <sup>3</sup>
---------------------

### HTTP overview <sup>0.5</sup>
- [ ] HTTP: why? 
- [ ] Request: methods, headers
- [ ] Response: codes, content-types

### REST overview <sup>0.5</sup>
- [ ] API principles: why?
- [ ] REST principles
- [ ] OpenAPI and Swagger

### REST Assured <sup>1</sup>
- [ ] [Overview](https://rest-assured.io)
- [ ] [Best Practices](https://habr.com/ru/post/421005/)

### Retrofit <sup>1</sup>
- [ ] [Overview](https://square.github.io/retrofit/)
- [ ] [CRUD](https://guides.codepath.com/android/consuming-apis-with-retrofit)
- [ ] [Domain objects vs JSON Schema](https://www.jsonschema2pojo.org) 
- [ ] [Error Handling](https://futurestud.io/tutorials/retrofit-2-simple-error-handling)

---

Testing DB applications <sup>3</sup>
-----------------------

### DBMS overview <sup>0.5</sup>
- [ ] Application testing architecture
- [ ] Test scopes
- [ ] Testing stateful applications
- [ ] Test fixture patterns

### SQL intro <sup>0.5</sup>
- [ ] DDL vs DML
- [ ] inserts
- [ ] updates
- [ ] selects
- [ ] joins

### JDBC intro <sup>1</sup>
- [ ] Driver
- [ ] Connection
- [ ] Statement
- [ ] ResultSet
- [ ] JDBC Transactions
- [ ] Resource closing

### JPA intro <sup>1</sup>
- [ ] JPA: why?
- [ ] Architecture
- [ ] Providers
- [ ] Configuration
- [ ] Defining Entity
- [ ] Defining Mappings
- [ ] EM API
- [ ] JPA Transactions
- [ ] JPA Queries

---

Building CI/CD pipeline with GitLab <sup>1.5</sup> 
-----------------------------------

### CI/CD overview <sup>0.5</sup>
- [ ] Why CI/CD?
- [ ] Pipeline overview
- [ ] IaaC

### GitLab CI pipeline running and monitoring <sup>0.5</sup>

### GitLab CI pipeline developing <sup>0.5</sup>

---

Командный проект <sup>6</sup>
----------------

### Given GitLab repo
- Java REST API backend codebase
- DDL

### When attendees
- Develop maven build script
- Make backend application and DB dockerized 
- Develop GitLab build pipeline
- Develop REST API autotests with DB fixtures
- Find and fix bugs in backend java code
- Make PRs for code review

### Then mentors
- Review and feedback PRs
