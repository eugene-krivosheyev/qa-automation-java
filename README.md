Автоматизация QA 
================


Agenda <sup>50 ак.ч.</sup>
======

Java Application Building <sup>6 ак.ч.</sup>
-------------------------

<details>
<summary>вебинар 01 от 02.08.2021</summary>

### Java platform overview
- [ ] Java Platform definition
- [ ] Basic terms: JVM, JRE, JDK
- [ ] Sourcepath and Classpath

### IDEA Demo
- [ ] Project settings and structure: modules, sourcepath + classpath
- [ ] Main and Test sources
- [ ] Workspace
- [ ] Views and hotkey switching
- [ ] Editing sources and foreground compilation
- [ ] Debugging methods
- [ ] Running tests from IDE
- [ ] Running application with run configuration and hotkey shortcut
- [ ] Full application building from Maven view
- [ ] Hotkey shortcuts for git workflow operations
- [ ] Main hotkeys

### Maven build lifecycle
- [ ] Build lifecycles
- [ ] Lifecycle phases
- [ ] Plugins
- [ ] Managing plugins with pom.xml

### Maven dependency management
- [ ] Dependency artifacts: JARed classes, sources, javadocs
- [ ] Artifact repositories
- [ ] Artifact identifying
</details>

<details>
<summary>вебинар 02 от 06.08.2021</summary>

### Local GIT versioning workflow
- [ ] Local repo
- [ ] Commit
- [ ] Log
- [ ] Tag
- [ ] Branch

### Remote GIT versioning workflow
- [ ] Remote repo
- [ ] Clone
- [ ] Push
- [ ] Pull

### Managing PRs
- [ ] Forks
- [ ] Pull Request
- [ ] PR workflow
</details>

Java Application Development <sup>24 ак.ч.</sup>
----------------------------

<details>
<summary>вебинар 03 от 09.08.2021</summary>

### Context
- [ ] Learning through testing

### Java Source Code Documenting
- [ ] Single-line comments
- [ ] Multi-line comments
- [ ] JavaDoc comments demo

### Java Packages
- [ ] Package: why?
- [ ] Package declaration
- [ ] Import directive

### Java Classes
- [ ] Class: why?
- [ ] Class declaration
- [ ] Class variables declaration
- [ ] Static initialization section

### Method declaration
- [ ] Method: why?
- [ ] Method declaration
- [ ] Method body code block
- [ ] Method variables
- [ ] Returning values
- [ ] Methods Overloading

### Method call
- [ ] Dot notation
- [ ] Formal and factual arguments
- [ ] Static import directive
</details>

<details>
<summary>вебинар 04 от 13.08.2021</summary>

### Variable declaration
- [ ] Variable declaration scopes
- [ ] Declaration
- [ ] Initialization
- [ ] Literals
- [ ] Default initialization values for class and method variables

### Primitive types
- [ ] byte
- [ ] int
- [ ] short
- [ ] long
- [ ] float
- [ ] double
- [ ] char
- [ ] boolean

### Wrappers
- [ ] Wrapper types and main features: referenced, constants, string parsing
- [ ] Autoboxing/unboxing and performance issue
</details>

<details>
<summary>вебинар 05 от 16.08.2021</summary>

### Type operators
- [ ] type casting
- [ ] instanceof

### Arithmetics operators
- [ ] `+, -, *, /, %`
- [ ] Typed operators: 1/3 vs 1./3
- [ ] Arithmetic types promotion
- [ ] ArithmeticException
- [ ] Types Overflow and solution with BigInteger
- [ ] FP precision loss and solution with BigDecimal

### Logical operators
- [ ] Type-safe
- [ ] `&, |, !`
- [ ] Lazy and eager form
- [ ] `==, !=, <, <=, >, >=`
- [ ] Reference types issue: absence of `===` and `.equals()`
- [ ] Ternary operator
</details>

<details>
<summary>вебинар 06 от 20.08.2021</summary>

### Switching
- [ ] `if`
- [ ] `switch` and its limitations

### Looping
- [ ] `for`
- [ ] `do` and `while`
- [ ] "foreach"

### Java Array reference type
- [ ] Declaration
- [ ] Initialization
- [ ] API: addressing, length
- [ ] Exceptions
- [ ] "Immutability"
- [ ] "foreach" cycle
</details>

<details>
<summary>вебинар 07 от 23.08.2021</summary>

### Varargs
- [ ] Why?
- [ ] Declaration
- [ ] Passing
- [ ] Using
- [ ] Limitations

### Final keyword
- [ ] Primitives
- [ ] References

### Strings
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] "Immutability" vs StringBuffer/StringBuilder
- [ ] API
- [ ] Strings equality: `==` vs `.equals()`

### Enums
- [ ] Enumerated type concept: why?
- [ ] API
- [ ] Using with `switch`
</details>

<details>
<summary>вебинар 08 от 27.08.2021</summary>

### Exception concept
- [ ] Type information
- [ ] Object data information
- [ ] Methods call stack information

### Throwing and handling exceptions
- [ ] creating exception instance
- [ ] `throw` operator
- [ ] Methods call stack tracing
- [ ] `try` section
- [ ] `catch` section
- [ ] `finally` section

### Syntax sugar
- [ ] multi-catch
- [ ] try-with-resources

### Exceptions type system
- [ ] Built-in types
- [ ] Errors vs Exceptions
- [ ] Checked vs Runtime exceptions
</details>

<details>
<summary>вебинар 09 от 30.08.2021</summary>

### OOAD overview
- [ ] Encapsulation
- [ ] Polymorphism
- [ ] Inheritance

### Lambda syntax
- [ ] Declaring lambdas
- [ ] Compiler types inference
- [ ] Functional interface
- [ ] Method reference
</details>

<details>
<summary>вебинар 10 от 03.09.2021</summary>

### Class Object
- [ ] `toString()`
- [ ] `equals()` and `hashCode()` contract

### Collections API overview
- [ ] `Set` API
- [ ] `List` API
- [ ] `Map` API

### File IO API overview
- [ ] `File` and `Path`
- [ ] File IO with Stream API
- [ ] Simple file operations with utility class `Files`
</details>

Java Automated Testing <sup>6 ак.ч.</sup>
----------------------
<details>
<summary>вебинар 11 от 06.09.2021</summary>

### Архитектура тестового фреймворка
- [ ] Концепция фреймворка
- [ ] Аннотации
- [ ] Подключение JUnit5 в maven
- [ ] Жизненный цикл тестового класса

### Тестирование на примере "общеизвестного класса"
- [ ] Именование тест-кейса/тест-класса и теста/тест-метода
- [ ] Понятие трасс выполнения (flows) и граничные условия
- [ ] Роль фикстуры
- [ ] Тест = фиксированная трасса выполнения
- [ ] Тестовый набор = спецификация компонента

### Возможности JUnit5
- [ ] Типизированные сравнения средствами основного фреймворка
- [ ] Исключения
- [ ] Таймауты
</details>

<details>
<summary>вебинар 12 от 10.09.2021</summary>

### Тестовое покрытие
- [ ] Понятие покрытия
- [ ] Способы расчета покрытия 
- [ ] Анализ отчета JaCoCo

### Реализация фикстуры для обеспечения поддерживаемости тестов
- [ ] Когда и сколько раз создается объект тестового класса?
- [ ] Как максимально реюзать фикстуры?
- [ ] Методы жизненного цикла теста
- [ ] Fixture Builders

### Как группировать тесты в наборы?
- [ ] Зачем нужны test suites?
- [ ] Теги
- [ ] Запуск наборов при сборке
</details>

Java REST API Testing <sup>9 ак.ч.</sup>
---------------------
<details>
<summary>вебинар 13 от 13.09.2021</summary>

### Фреймворки, ориентированные на тестирование REST API
- [ ] Обзор Retrofit
- [ ] Обзор REST Assured
</details>

<details>
<summary>вебинар 14 от 17.09.2021</summary>

### Введение в работу с БД
- [ ] Обзор JDBC
- [ ] Обзор JPA
</details>

<details>
<summary>вебинар 15 от 20.09.2021</summary>

### Тест-дублирование БД
- [ ] На каких уровнях можно замещать БД
- [ ] Утилиты работы с JDBC
- [ ] Управление транзакциями

### Тест-дублирование внешних сервисов
- [ ] На каких уровнях можно замещать внешний сервис
- [ ] Тестовые дублеры для внешних веб- и REST-сервисов: WireMock
</details>

Командный проект <sup>6 ак.ч.</sup>
----------------
<details>
<summary>вебинар 16 от 24.09.2021</summary>

- [ ] Командная работа над проектом 
- [ ] Фидбек от инспекторов
</details>

<details>
<summary>вебинар 17 от 27.09.2021</summary>

- [ ] Командная работа над проектом
- [ ] Фидбек от инспекторов
</details>
