Автоматизация QA <sup>3.5 мес</sup>
================

Guidelines
==========

Формат обучения
---------------
- группа до 30 человек
- 1 вебинар в неделю по 2 часа (1.5 часа контент + 0.5 обсуждение вопросов)
- reference/выжимка по каждому вебинару
- задания для самостоятельной проработки ~2 часа трудоемкости в неделю
- разбор вопросов в slack-чате силами тренера и менторов
- два уровня самостоятельной практики: по целям и задачам
- отчуждаемые критерии выполнения практики

Что нужно для начала
--------------------
- [ ] Убедиться, что вы в slack-чате
- [ ] [Если нет] завести аккаунт на GitHub
- [ ] Сделать форк данного репозитория с материалами
- [ ] Добавить в ваш новый репо своих менторов как коллабораторов
- [ ] Установить jdk ≥11 и IntelliJ IDEA

Контакты
--------
- slack-чат 
- корпоративная почта: `a.roshchina`


Agenda <sup>14 недель</sup>
======
28 ак.ч.

Java Application Building <sup>1 вебинар, 1 неделя</sup>
-------------------------

### Local GIT versioning workflow <sup>15 мин</sup>
- [ ] Why VCS? cool!!!!!
- [ ] Local repo
- [ ] Commit
- content: files A/M/D
- hash/id
- message
- [ ] Branch
- `git log`

### Remote GIT versioning workflow <sup>15</sup>
- [ ] Remote repo
- alias: `origin`
- [ ] Clone
- mirror branches
- [ ] Push
- [ ] Pull

### Managing PRs with GitHub <sup>10</sup>
- [ ] [PR workflow](https://www.earthdatascience.org/images/earth-analytics/git-version-control/git-fork-emphasis.png)
- [ ] Forks
- [ ] Pull Requests
- one-way
- another-way

### Git reference
- [basic commands cheatsheet](https://www.atlassian.com/ru/git/tutorials/atlassian-git-cheatsheet)
- [tutorial](https://www.atlassian.com/ru/git/tutorials/setting-up-a-repository)

### Java platform overview <sup>10</sup>
- [ ] Java Platform definition
- [ ] Basic terms: JVM, JRE, JDK
- [ ] Installation
- [Oracle website](https://www.oracle.com/java/technologies/downloads/)
- [Adoptium](https://adoptium.net) builds
- your lovely package manager: `openjdk11`

### Simple app lifecycle <sup>10</sup>
- [ ] Sources
- sourcepath
- classpath
- [ ] Compiling
- compile errors
- [ ] Packaging
- jar tool
- [ ] Running
- classpath
- exceptions

### Maven build lifecycle <sup>20</sup>
- [ ] Minimum Directory layout
```shell
├── pom.xml
└── src
  └── main
      └── java
          ├── Application.java
          └── ConsolePrinter.java
```
- [ ] Build lifecycles: 3
- [ ] Lifecycle phases
- [ ] Plugins
- Default plugins
- Managing plugins with pom.xml

### Maven dependency management <sup>10</sup>
- [ ] Dependency artifacts: JARed classes, sources, javadocs
- [ ] Artifact repositories
- [ ] Artifact identifying
- [ ] Test dependencies vs Prod dependencies

### Maven reference
- [maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#lifecycle-reference)
- [maven cheatsheet](https://www.jrebel.com/blog/maven-cheat-sheet)

---

Java Application Development <sup>9</sup>
----------------------------

### IDEA Demo for developing <sup>0.2</sup>
- [ ] Project settings and structure: modules, sourcepath + classpath
- [ ] Workspace
- [ ] Views
- [ ] Running application with run configuration
- [ ] Git workflow
- [ ] Maven build

### Java Source Code Documenting <sup>0.1</sup>
- [ ] Source code layout
- [ ] Single-line comments
- [ ] Multi-line comments
- [ ] Downloading and working JavaDoc comments
- [ ] Downloading and working with sources

### Java Packages <sup>0.1</sup>
- [ ] Package: why?
- [ ] Package declaration
- [ ] Naming convention
- [ ] Import directive
- [ ] Encapsulation: why?
- [ ] Visibility modifiers

### Java Classes for Procedure Style <sup>0.2</sup>
- [ ] Class: why?
- [ ] Class declaration
- [ ] Naming convention
- [x] Dynamic class loading and `static` initialization section
- [ ] Encapsulation concept: behavior and state

### Method declaration <sup>0.4</sup>
- [ ] Method: why?
- [ ] Method declaration
- [ ] Naming convention
- [ ] Visibility modifiers
- [ ] Method body code block
- [ ] Methods overloading

---

### Local variables <sup>0.1</sup>
- [ ] Method arguments
- [ ] Method variables
- [ ] Returning values

### Method call <sup>0.2</sup>
- [ ] Dot notation
- [ ] Static import directive
- [ ] Call stack: why?

### Class variable declaration <sup>0.2</sup>
- [ ] Method vs Class variables: why?
- [ ] Declaration
- [ ] Visibility modifiers
- [ ] Initialization
- [ ] Default initialization values for class and method variables

### Variable declaration modifiers <sup>0.1</sup>
- [ ] `final` modifier for variables
- [ ] Local variables type inference with `var`

### Java Primitive types and its literals <sup>0.4</sup>
- [ ] byte
- [ ] int
- [ ] short
- [ ] long
- [ ] float
- [ ] double
- [ ] char
- [ ] boolean

---

### Type operators <sup>0.1</sup>
- [ ] Auto type casting
- [ ] type casting operator
- [ ] Method overloading recap

### Arithmetics operators <sup>0.1</sup>
- [ ] `+, -, *, /, %`
- [ ] `ArithmeticException` for integer types
- [ ] Typed operators: 1/3 vs 1./3
- [ ] `+` as String concatenation 

### Arithmetics type issues
- [ ] Overflow
- [ ] Precision loss

### Logical operators <sup>0.3</sup>
- [ ] Type-safe
- [ ] `&, |, !`
- [ ] Lazy and eager form: `&&, ||`
- [ ] `==, !=, <, <=, >, >=`
- [ ] Reference types equality issue: absence of `===` and `.equals()` instead

### Switching <sup>0.5</sup>
- [ ] Ternary operator
- [ ] `if`
- [ ] `switch` and its limitations

---

### Enums <sup>0.2</sup>
- [ ] Enumerated type concept: why?
- [ ] API
- [ ] Using with `switch`

### Looping <sup>0.5</sup>
- [ ] `for`
- [ ] `do` and `while`
- [ ] `break` and `continue` operators
- [ ] "foreach" loop for varargs

### Varargs <sup>0.1</sup>
- [ ] Why?
- [ ] Declaration
- [ ] Using
- [ ] Limitations

---

### Reference types <sup>0.4</sup>
- [ ] Custom (non-primitive) types
- Enum
- Interface
- Class
- [ ] Class as structure template
- [ ] Reference anatomy and `new` operator
- [ ] Stack and heap
- [ ] Garbage collection concept
- [ ] `null` literal value and NPE
- [ ] `final` issue with reference types
- [ ] Immutable types vs `final`

### Arrays <sup>0.3</sup>
- [ ] Declaration
- [ ] Initialization
- empty
- literals
- [ ] "Immutability" with size
- [ ] API: indexing operator, length
- [ ] Exceptions
- [ ] `foreach` loop
- [x] iteration loop with `for`

### Strings <sup>0.3</sup>
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] Strings equality: `==` vs `.equals()`
- [ ] `String` API
- [ ] Immutability

### Wrappers <sup>0.2</sup>
- [ ] Wrapper types: why?
- [ ] Wrapper types: referenced but immutable
- [ ] Wrappers API
- [ ] Autoboxing/unboxing and performance issue

### Immutability <sup>0.1</sup>
- [ ] Why immutability?

---

### Custom Type Objects <sup>0.5</sup>
- [ ] Objects: why?
- [ ] Object/instance variable declaration scope
- [ ] Object/instance method declaration scope
- [ ] Encapsulation and visibility modifiers
- [ ] Encapsulated state accessors and mutators
- [ ] Immutable objects

### Creating objects <sup>0.2</sup>
- [ ] Object creation with `new`
- [ ] Object state initialization with constructor
- [ ] Constructors overloading

### Polymorphism with interfaces and (abstract) classes <sup>0.3</sup>
- [ ] Polymorphism: why?
- [ ] Java implementation: how it looks in source code
- [ ] Interfaces
- [ ] Implementing interfaces

---

### Defender methods concept <sup>0.1</sup>
- [ ] Defender methods: why?

### Inheritance with (abstract) classes concept <sup>0.5</sup>
- [ ] Inheritance: why?
- [ ] Java implementation: how it looks in source code
- [ ] Abstract classes
- [ ] Classes for code reuse
- [ ] `final` modifier

### `Object` type <sup>0.4</sup>
- [ ] `java.lang.Object` class as basic reference type
- [ ] All objects are polymophic: why?
- [ ] Equality: `==` vs `.equals()`
- [ ] `equals()` and `hashCode()` contract
- [ ] `toString()`

---

### Exception concept <sup>0.2</sup>
- [ ] Type information
- [ ] Object data information
- [ ] `throw` operator
- [ ] Methods call stack information

### Handling exceptions <sup>0.3</sup>
- [ ] creating exception instance
- [ ] `try` section
- [ ] `catch` section
- [ ] `finally` section

### Syntax sugar <sup>0.2</sup>
- [ ] multi-catch
- [ ] try-with-resources

### Exceptions type system <sup>0.3</sup>
- [ ] Built-in types
- [ ] Errors vs Exceptions
- [ ] Checked vs Runtime exceptions

---

### Generics <sup>0.1</sup>
- [ ] Generics: why?
- [ ] Generic class and method demo
- [x] Generic classes and interfaces
- [x] Generic methods

### Key Collections API overview <sup>0.3</sup>
- [ ] `Collection` API
- [ ] `Set` API and implementations
- [ ] `List` API  and implementations
- [ ] non-collection `Map` API and implementations
- [ ] `Object`'s methods used: `equals` and `hashCode` contract

### Collections API and iterating <sup>0.2</sup>
- [ ] `Iterator` and `for` loop
- [ ] `foreach`

### Lambda syntax overview <sup>0.2</sup>
- [ ] Declaring lambdas
- [ ] Compiler types inference
- [ ] Functional interface
- [ ] Method reference

### Stream API concept <sup>0.2</sup>
- [ ] Functions composition
- [ ] Terminal and non-terminal operations

---

Developing autotests with JUnit <sup>1</sup>
-------------------------------

### JUnit framework overview <sup>0.1</sup>
- [ ] Task flow
- [ ] Test class and methods
- [ ] Annotations
- [ ] Assertions

### Test design <sup>0.4</sup>
- [ ] Test Case and Test method naming
- [ ] Code path
- [ ] Input and State
- [ ] Fixture
- [ ] Test structure

### Fixture reuse <sup>0.1</sup>
- [ ] How many test instances?
- [ ] How to reuse fixture?
- [ ] JUnit test case lifecycle methods
- [x] Fixture Builders

### Testing alternate flows within tests <sup>0.2</sup>
- [ ] Test states
- failure
- error
- skipped (+assumes)
- [ ] JUnit5 `assertThrows`

### Advanced assertions <sup>0.1</sup>
- [ ] JUnit assertions combinator
- [ ] AssertJ library
- [ ] Hamcrest library

### Advanced JUnit <sup>0.1</sup>
- [ ] Parameterized tests
- [ ] Suites
- Nested test classes
- [Test suites](https://junit.org/junit5/docs/current/user-guide/#running-tests-junit-platform-runner-test-suite)
- [Tags](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering) [и отдельный запуск](https://junit.org/junit5/docs/current/user-guide/#running-tests-build-maven-filter-tags)

---

Docker for QA <sup>1</sup>
-------------

### Application overview <sup>0.2</sup>
- [ ] Application architecture
- DB
- backend
- API
- client
- [ ] Configurations used
- [ ] Overview of [demo application](https://github.com/eugene-krivosheyev/agile-practices-application)
- [ ] [How to build](https://github.com/eugene-krivosheyev/agile-practices-application/blob/master/README.md)
- [ ] [Built release](https://github.com/eugene-krivosheyev/agile-practices-application/releases)

### Docker overview <sup>0.2</sup>
- [ ] Docker: why?
- [ ] Image: why?
- [ ] Registry: why?
- [ ] Container: why?
- [ ] Containers vs VMs

### Docker Image <sup>0.2</sup>
- [ ] Images naming and tags
- [ ] `ls`
- [ ] `pull`
- [ ] `rm`, `prune`

### Docker container <sup>0.2</sup>
- [ ] Containers naming
- [ ] `ls`
- [ ] `create`
- [ ] `start`
- [ ] `stop`
- [ ] ports
- [ ] mounts
- [ ] `log`
- [ ] `exec`

### Configuration externalization <sup>0.1</sup>
- [ ] Externalization: why?
- [ ] How to externalize configuration: 3 patterns

### Orchestration <sup>0.1</sup>
- [ ] Orchestration: why?

---

Java REST API Testing <sup>1</sup>
---------------------

### REST API description <sup>0.2</sup>
- [ ] OpenAPI
- [ ] Swagger

### REST Assured <sup>0.4</sup>
- [ ] [Overview](https://rest-assured.io)
- [ ] [Best Practices](https://habr.com/ru/post/421005/)

### Retrofit <sup>0.4</sup>
- [ ] [Overview](https://square.github.io/retrofit/)
- [ ] [CRUD](https://guides.codepath.com/android/consuming-apis-with-retrofit)
- [ ] [Domain objects vs JSON Schema](https://www.jsonschema2pojo.org) 
- [ ] [Error Handling](https://futurestud.io/tutorials/retrofit-2-simple-error-handling)

---

Testing DB applications <sup>1</sup>
-----------------------

### DBMS overview <sup>0.2</sup>
- [ ] Application testing architecture
- [ ] Test scopes
- [ ] Testing stateful applications
- [ ] Test fixture patterns

### SQL overview <sup>0.1</sup>
- [ ] DDL vs DML
- [ ] inserts
- [ ] updates
- [ ] selects
- [ ] joins

### JDBC intro <sup>0.7</sup>
- [ ] Driver
- [ ] Connection
- [ ] Statement
- [ ] ResultSet
- [ ] Resource closing

---

Building CI/CD pipeline with GitLab <sup>1</sup> 
-----------------------------------

### CI/CD overview <sup>0.4</sup>
- [ ] Why CI/CD?
- [ ] Pipeline overview
- [ ] IaaC

### GitLab CI pipeline running and monitoring <sup>0.4</sup>
- [ ] Creating project and pipeline
- [ ] Triggers
- [ ] Pipeline definition overview
- [ ] Running pipeline
- [ ] Run status
- [ ] Logs and troubleshooting

### GitLab CI pipeline developing overview <sup>0.2</sup>
- [ ] Pipeline types
- [ ] Demo for `gitlab-ci.yml`

---

Командный проект <sup>3 часа, 1 неделя</sup>
----------------

### Given GitLab repo
- [ ] Java REST API backend codebase
- [ ] DDL

### When attendees
- [ ] Develop maven build script
- [ ] Make backend application and DB dockerized 
- [ ] Develop GitLab build pipeline
- [ ] Develop REST API autotests with DB fixtures
- [x] Find and fix bugs in backend java code
- [ ] Make PRs for code review

### Then mentors
- [ ] Review and feedback PRs
