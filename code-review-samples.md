Примеры фидбека по code review
==============================

Пример 01, негативный
---------------------
```java
class my_class 
{
    public void MY_METHOD(int Arg)
    {
        if (Arg!=0)
            System.out.println(Arg);
    }
}
```
1. Несоответствие Java Coding Style Convention [JCSC]

Пример 01, позитивный
---------------------
```java
class MyClass {
    public void myMethod(int arg) {
        if (arg != 0) {
            System.out.println(arg);
        }
    }
}
```

Пример 02, негативный
---------------------
```java
class Test01 {
    private int con;
    
    @Test
    public void test01() {
        
    }

    @Test
    public void test02() {

    }
}
```
1. Code Smell: Uncommunicative name "con" [Fowler, Refactoring]
1. Test naming anti-pattern "Counter" [Test Anti-patterns]

Пример 02, позитивный
---------------------
```java
class AccountControllerTest {
    private int dbConnection;
    
    @Test
    public void shouldGetAllAccountsWhenSomeCreated() {
        
    }

    @Test
    public void shouldGetNoAccountsWhenNoCreated() {

    }
}
```

Пример 03, негативный
---------------------
```java
myObject.staticVariable = someValue;
```
1. Доступ к переменной класса через экземпляр.
У начинающих очень плохо заходит понимание разницы static/instance переменных и методов. Такой код явно симптоматичен – необходимо обсудить и убедиться, что инспектируемый осознает разницу.
   
Пример 03, позитивный
---------------------
```java
MyСlass.staticVariable = someValue;
```

Пример 04, негативный
---------------------
```java
public void someMethod(MutableClass param) {
    param.setState(newState);    
}
```
1. Побочный эффект на параметрах метода. Изменение состояния объекта-параметра – крайне спорная практика, негативно сказывающаяся на читабельности, поддерживаемости и тестопригодности кода.

Пример 04, позитивный
---------------------
```java
public ImmutableClass someMethod(ImmutableClass param) {
    return new ImmutableClass( update(param.getState()) );
}
```

Пример 05, негативный
---------------------
```shell
$ tree
Config.java
AccountController.java
AccountNotFoundException.java
AccountRepository.java
MapBackedAccountRepository.java
Account.java
AccountService.java
```
1. Непонимание и нежелание использовать пакеты. Типовая проблема начинающих – необходимо сразу объяснять ценность и настраивать как на необходимую практику разработки.

Пример 05, позитивный
---------------------
```shell
$ tree
.
└── com
    └── acme
        └── dbo
            ├── config
            │   └── Config.java
            ├── controller
            │   ├── AccountController.java
            │   └── AccountNotFoundException.java
            ├── dao
            │   ├── AccountRepository.java
            │   └── MapBackedAccountRepository.java
            ├── domain
            │   └── Account.java
            └── service
                └── AccountService.java
```
