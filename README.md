Автоматизация QA 
================

Guidelines
==========

Формат обучения
---------------
- вебинары + самостоятельная работа над заданиями
- время 17:30 – 20:30

Вебинары
-----------------------
- ссылка на подключение доступна в приглашении в календарь
- записи вебинаров будут доступны с вечера дня вебинара на 10 дней

Самостоятельная практика
------------------------
- после каждого вебинара будет сформулировано задание на самостоятельную практику
- срок выполнения – до следующего вебинара
- работу будут оценивать инспекторы путем проведения code review
- результаты code review будут приходить в интерфейс github и дублироваться на почту

Что нужно для начала
--------------------
- [ ] Убедиться, что вы в slack-чате `training-qa-automation-java-2021-08`
- [ ] [Если нет] завести аккаунт на github
- [ ] Сделать форк [репозитория с материалами](https://github.com/eugene-krivosheyev/qa-automation-java)
- [ ] Добавить в ваш новый репо своих менторов как коллабораторов
- [ ] Установить jdk ≥8 и IntelliJ IDEA (предпочтительнее Ultimate, но и Community подойдет)

Контакты
--------
В случае вопросов пишите в slack-чат и на корпоративную почту: `a.roshchina`


Agenda <sup>50 ак.ч.</sup>
======

Java Application Building <sup>6 ак.ч.</sup>
-------------------------

<details>
<summary>вебинар 01 от 02.08.2021</summary>

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

Practice quest
--------------
### Given
- [ ] Известна учетка ментора на github
- [ ] Установлен git (stand-alone или как компонент IDEA)
### When
- [ ] Заведен аккаунт на github
- [ ] Сделан fork данного репо
- [ ] Ментор добавлен как коллаборатор

and
- [ ] Создана рабочая ветка `dev` для реализации заданий
- [ ] Внесены тестовые изменения
- [ ] Заведен PR в `master`

and
- [ ] Новые изменения из данного репо перенесены себе в `master` через PR
### Then
- [ ] Ментор принимает PR c тестовыми изменениями
- [ ] Вам приходит нотификация
</details>

<details>
<summary>вебинар 02 от 06.08.2021</summary>

### Java platform overview
- [ ] Java Platform definition
- [ ] Basic terms: JVM, JRE, JDK

### Simple app lifecycle
- [ ] source
- [ ] compiling
- [ ] packaging
- [ ] running 
- [ ] Sourcepath and Classpath
  
Practice quest
--------------
### Given
- [ ] Локальный клон репозитория
- [ ] Исходники двух классов
```
import com.tinkoff.edu.Printer;

public class MyApplication {
	public static void main(String[] args) {
		Printer.print("Hewllo world!");
	}
} 

---
  
package com.tinkoff.edu;

public class Printer {
	public static void print(String message) {
		System.out.println(message);
	}
}
```
### When
- [ ] Папочная структура исходников src/MyApplication.java
- [ ] Компиляция: два .class
- [x] Разделить иcходники и бинарники: `src` и `target` 
- [ ] Запуск приложения
### Then
- [ ] Проект успешно собирается
- [ ] вывод `Hello world!`
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 03 от 09.08.2021</summary>

### Maven build lifecycle
- [ ] Directory layout
- [ ] Build lifecycles
- [ ] Lifecycle phases
- [ ] Plugins
- [ ] Managing plugins with pom.xml

### Maven dependency management
- [ ] Dependency artifacts: JARed classes, sources, javadocs
- [ ] Artifact repositories
- [ ] Artifact identifying
- [ ] Test dependencies vs Prod dependencies

### IDEA Demo
- [ ] Project settings and structure: modules, sourcepath + classpath
- [ ] Workspace
- [ ] Views
- [ ] Running application with run configuration
- [ ] Git workflow
- [ ] Maven build

Practice quest
--------------
### Given
- [ ] Локальный клон репозитория
- [ ] В корне репо:
### When
- [ ] Сгенерирован maven-проект по шаблону `mvn archetype:generate`
- `com.tinkoff.edu:app:1.0.0-SNAPSHOT`
### Then
- [ ] Используется тестовая зависимость JUnit5
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Проект успешно собирается
- [ ] Ментор принимает PR в `master`
</details>

Java Application Development <sup>24 ак.ч.</sup>
----------------------------

<details>
<summary>вебинар 04 от 13.08.2021</summary>

### Context
- [ ] Learning through developing and JIT testing
- [ ] Case: Loan system mock

### Java Source Code Documenting
- [ ] Single-line comments
- [ ] Multi-line comments
- [ ] JavaDoc comments demo

### Java Packages
- [ ] Package: why?
- [ ] Package declaration
- [ ] Import directive
- [ ] Naming convention

### Java Classes
- [ ] Class: why?
- [ ] Class declaration
- [ ] Dynamic class loading
- [ ] Static initialization section
- [ ] Naming convention
- [ ] Encapsulation concept: behavior and state

### Method declaration
- [ ] Method: why?
- [ ] Method declaration
- [ ] Method body code block
- [ ] Method variables
- [ ] Returning values
- [ ] Methods Overloading
- [ ] Naming convention

### Method call
- [ ] Dot notation
- [ ] Call stack

### Variable declaration
- [ ] Declaration
- [ ] Initialization
- [ ] Literals
- [ ] Default initialization values for class and method variables

Practice quest
--------------
### Given
- [ ] Requirements for Loan Scoring application
- `Как клиент банка, я хочу сделать запрос на кредит и получить ответ с уникальным id для дальнейших коммуникаций` 
### When application
- [ ] Application designed for testability and reuse
- Controller
- Service
- Repository
- [ ] Application implemented
- [ ] Self-made tests implemented (with main class)
### Then
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 05 от 16.08.2021</summary>

### Calling methods advanced
- [ ] Static import directive
- [ ] `final` modifier for statics
- [ ] Formal and factual arguments
- [ ] Parameters `Pass by value` 
- [ ] `final` modifier for locals/params

### Encapsulation: Implementing state
- [ ] What is state
- [ ] Variable declaration scope: static/object/local
- [ ] local, global and object state
- [ ] Object creation
- [ ] Object state initialization with constructor
- [ ] Accessors and mutators

### Common state and creational patterns
- [ ] OOP style (rich design)
- [ ] stateful domain objects/DTO + stateless services (anemic design)
- [ ] Immutable
- [ ] Factory
- [ ] DI

### Enums
- [ ] Enumerated type concept: why?
- [ ] API
- [ ] Using with `switch`

### Polymorphism with interfaces and (abstract) classes
- [ ] Polymorphism why's?
- [ ] Java implementation
- [ ] Interface
- [ ] `final` modifier

### Inheritance with (abstract) classes
- [ ] Inheritance why's?
- [ ] Java implementation
- [ ] Abstract class
- [ ] Class

Practice quest
--------------
### Given
- [ ] Requirements for Loan Scoring application
- `Как клиент банка, я хочу сделать запрос на кредит и получить ответ с уникальным id для дальнейших коммуникаций`
### When application
- Application designed for testability and reuse
- [ ] non-static Controller with Service DI
- [ ] non-static Service with Repo DI
- [ ] Service with Interface
- [ ] non-static Repository with Interface
- [ ] non-static Loan Request 
- [ ] non-static Loan Response with encapsulated autogenerated incremental id
- [ ] Loan Response encapsulates Response Type enum: APPROVED, DENIED
- [ ] Self-made tests implemented (with main class)
### Then
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 07 от 23.08.2021</summary>

### Java Syntax for interfaces and abstract classes
- [ ] Interfaces
- [ ] Defender methods
- [ ] Inheritance and constructors

### Test framework overview
- [ ] IoC: Framework vs Library
- [ ] JUnit as a test framework
- [ ] Task flow
- [ ] Test class and methods
- [ ] Annotations
- [ ] Assert methods
- [ ] Coverage

Practice quest
--------------
### Given
- [ ] Requirements for Loan Scoring application
- `Как клиент банка, я хочу сделать запрос на кредит и получить ответ с уникальным id для дальнейших коммуникаций`
### When application
- [ ] Application covered with e2e tests
- shouldGetId1WhenFirstCall
- shouldGetIncrementedIdWhenAnyCall
- [x] Application covered with integration tests
### Then
- [x] Покрытие по веткам ≥ 90%
- [ ] Фикстура максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 08 от 26.08.2021</summary>

### Разбор ДЗ
- [ ] Ценность фикстуры и как она определяет трассу исполнения

### Object type and equality in test assertions
- [ ] `java.lang.Object` class and reference types
- [ ] Equality with `assertEquals`: `==` vs `.equals()`

### Test Coverage
- [ ] Coverage types
- [ ] Coverage tool: JaCoCo

### Java Primitive types and literals
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

### Type operators
- [ ] type casting
- [ ] `instanceof`

### Arithmetics operators
- [ ] `+, -, *, /, %`
- [ ] Typed operators: 1/3 vs 1./3
- [ ] `ArithmeticException`
- [ ] Types Overflow and solution with `BigInteger`
- [ ] FP precision loss and solution with `BigDecimal`

### Logical operators
- [ ] Type-safe
- [ ] `&, |, !`
- [ ] Lazy and eager form: `&&, ||`
- [ ] `==, !=, <, <=, >, >=`
- [ ] Reference types issue: absence of `===` and `.equals()`

Practice quest
--------------
### Given
- [ ] Requirements for Loan Scoring application
- `Как клиент банка, я хочу сделать запрос на кредит и получить ответ с уникальным id и статусом заявки для дальнейших коммуникаций`
- Business rules:

| Loan Type | Amount | Months | Response status
| --------- | ------ | ------ | ---------------
| PERSON | ≤ 10_000.0 | ≤ 12 | APPROVED
| PERSON | > 10_000.0 | > 12 | DECLINED 
| OOO | ≤ 10_000.0 | any | DECLINED
| OOO | > 10_000.0 | < 12 | APPROVED 
| OOO | > 10_000.0 | ≥ 12 | DECLINED
| IP | any | any | DECLINED

### When application
- [ ] Application covered with e2e tests:
- `shouldGetErrorWhenApplyNullRequest` (-1 return value)
- `shouldGetErrorWhenApplyZeroOrNegativeAmountRequest` (-1 return value)
- `shouldGetErrorWhenApplyZeroOrNagativeMonthsRequest` (-1 return value)
- tests covering business rules
- tests covering *corner cases* for business rules

### Then
- [ ] Покрытие по веткам ≥ 90%
- [ ] Фикстура максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 09 от 30.08.2021</summary>

### Wrappers
- [ ] Boxing/unboxing API
- point of static methods
- [ ] *Auto* Boxing/unboxing

### Class Object
- [ ] Все объекты заменяемы и с ними можно работать унифицированно
- [ ] `toString()`
- [ ] `equals()` and `hashCode()` contract

### Switching
- [ ] `if`
- [ ] Ternary operator
- [ ] `switch` and its limitations

### Java Array reference type
- [ ] Declaration
- [ ] Initialization
- empty
- literals
- [ ] "Immutability"
- [ ] API: indexing operator, length
- [ ] Exceptions
- [ ] "foreach" cycle

### Varargs
- [ ] Why?
- [ ] Declaration
- [ ] Using
- [ ] Limitations

### Looping
- [ ] "foreach" loop
- [ ] `for`
- [ ] `do` and `while`
- [ ] `break` and `continue` operators

### Strings
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] "Immutability" vs StringBuffer/StringBuilder
- [ ] Strings equality: `==` vs `.equals()`
- [ ] String API
- [ ] `StringBuffer` and `StringBuilder` 
- [ ] `StringBuffer` and `StringBuilder` API

Practice quest
--------------
### Given
- [ ] Changed requirements for Loan Scoring application
- `Как клиент, я хочу сделать заявку на кредит, чтобы получить ответ с уникальным случайным UUID`
- Заявка включает ФИО
- [ ] Added requirements for Loan Scoring application
- `Как клиент, я хочу запросить статус заявки по ее UUID`
- `Как менеджер, я хочу изменить статус заявки по ее UUID`

### When
- [ ] Made research for `UUID` class API
- [ ] Business rules code switching refactored to `switch`
- [ ] Array used Repository back
- [ ] Application covered with e2e tests
- tests covering *feature scenarios*
- tests covering *corner cases*

### Then
- [ ] Покрытие по веткам ≥ 90%
- [ ] Фикстуры максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 10 от 02.09.2021</summary>

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

### Testing alternate flows within tests
- [ ] How JUnit5 handle exceptions in tests: new test states
- failure
- error
- skipped (+assumes)
- [ ] JUnit5 `assertThrows`

Practice quest
--------------
### Given
- [ ] Changed system NFRs and inner quality model for Loan Scoring application
- Для всех операций всех компонентов добавлены проверки на null и пустоту с исключениями
- Приложение не падает при возможных системных ошибках (арифметика, выход за границы, etc) - опциональная задача
- [ ] Added requirements for Loan Scoring application: *Data Validation Rules* leading to business exceptions. Реализовать хотя бы одну валидацию своим кастомным checked exception:
- ФИО не короче 10 и не длиннее 100 символов
- ФИО содержит только буквы и `-`
- Сумма не менее 0.01 и не более 999 999.99
- Срок не менее 1 и не более 100 месяцев

### When
- [ ] Made research for `String` and `Character` API
- [ ] Application covered with e2e tests
- tests covering *feature scenarios*
- tests covering *corner cases*

### Then
- [ ] Покрытие по веткам ≥ 95%
- [ ] Фикстуры максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 11 от 06.09.2021</summary>

### Collections and arrays iterating recap
- [ ] `Iterator` and `for` loop
- [ ] `foreach`

### Key Collections API overview
- [ ] `Set` API
- [ ] `List` API
- [ ] `Map` API

### Object's methods used
- [ ] `equals`
- [ ] `hashCode`

### Utility classes
- [ ] `Collections`
- [ ] `Comparable`, `Comparator`

### Lambda syntax
- [ ] Declaring lambdas
- [ ] Compiler types inference
- [ ] Functional interface
- [ ] Method reference

### Stream API
- [ ] Functions composition
- [ ] Terminal and non-terminal operations

Practice quest
--------------
### Given
- Remaining requirements for Loan Scoring application
- [x] `Как клиент, я хочу запросить статус заявки по ее UUID`
- [x] `Как менеджер, я хочу изменить статус заявки по ее UUID`
- Added new requirements for Loan Scoring application
- [ ] _Map-backed_ repository
- [ ] `Как менеджер, я хочу найти все заявки от ООО`
- [x] `Как менеджер, я хочу найти сумму всех заявок от ООО`

### When
- [ ] Made research for appropriate assertions from Hamcrest or AssertJ libraries
- [ ] Application covered with e2e tests
- tests covering *feature scenarios*
- tests covering *corner cases*

### Then
- [ ] Покрытие по веткам ≥ 95%
- [ ] Фикстуры максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
</details>

<details>
<summary>вебинар 12 от 09.09.2021</summary>

### File IO API overview
- [ ] `File` and `Path`
- [ ] `Scanner`
- [ ] Simple file operations with utility class `Files`
- [ ] File IO with Streams API

### Расширенные возможности JUnit5
- [ ] Исключения
- [ ] Таймауты
- [ ] Параметризованные тесты
- [ ] Группировка
- [Test suites](https://junit.org/junit5/docs/current/user-guide/#running-tests-junit-platform-runner-test-suite) 
- [Теги](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering) [и отдельный запуск](https://junit.org/junit5/docs/current/user-guide/#running-tests-build-maven-filter-tags)
- Static inner classes

### Реализация фикстуры для обеспечения поддерживаемости тестов
- [ ] Когда и сколько раз создается объект тестового класса?
- [ ] Как максимально реюзать фикстуры?
- [ ] Методы жизненного цикла теста
- [ ] Fixture Builders

### Parallel tests run
- [ ] Concurrency issues!
- [ ] [JUnit5 support](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parallel-execution)
- [ ] [Maven surefire plugin support](https://maven.apache.org/surefire/maven-surefire-plugin/examples/fork-options-and-parallel-execution.html)


Practice quest
--------------
### Given
- Added new requirements for Loan Scoring application
- [ ] _File-backed_ repository

### When
- [x] Made research for appropriate assertions from Hamcrest or AssertJ libraries
- [x] Used parameterization for legacy tests
- [x] Used parallelism for legacy tests
- [x] Used suites for legacy tests
- [ ] Fixture reused at all tests
- [ ] Application covered with e2e tests
- tests covering *feature scenarios*
- tests covering *corner cases*

### Then
- [ ] Покрытие по веткам ≥ 95%
- [ ] Фикстуры максимально реюзается
- [ ] Проект успешно собирается
- [ ] Выдержан стиль кодирования и соглашения
- [ ] Ментор принимает PR в `master`
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
<summary>вебинар 14 от 16.09.2021</summary>

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
<summary>вебинар 16 от 23.09.2021</summary>

- [ ] Командная работа над проектом 
- [ ] Фидбек от инспекторов
</details>

<details>
<summary>вебинар 17 от 27.09.2021</summary>

- [ ] Командная работа над проектом
- [ ] Фидбек от инспекторов
</details>
