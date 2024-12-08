# Программа для расчета центростремительного ускорения и круговой скорости

Поскольку задачу было уже трудно развивать до требуемого условия, функционал был расширен, а классы можно сказать "высосаны из пальца".

Для наглядности создал более явный пример с машинами, расположенный в файле `SecondProgramVariant.SecondProgramVariant.java`

## Описание программы

### Класс `MyProgram.PhysicalCalculation`

Этот класс является базовым классом для всех физических расчетов. Может быть использован и для иных вычислений

Он содержит следующие элементы:

- Неизменяемое приватное поле `result` типа double для хранения результата подсчета;
- Конструктор `MyProgram.PhysicalCalculation(double result)`, инициализируещий `result`;
- Метод `calculate()`, возвращающий результат, сохраненный в `result`;
- Переопределенные методы `toString()` и `equals()`.

```java
class MyProgram.PhysicalCalculation {
    private final double result;

    public MyProgram.PhysicalCalculation(double result) {
        this.result = result;
    }

    public double calculate() {
        return result;
    }

    @Override
    public String toString() {
        return "Результат: " + calculate();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        };
        if (object == null || getClass() != object.getClass()) {
            return false;
        };
        MyProgram.PhysicalCalculation currentType = (MyProgram.PhysicalCalculation) object;
        return Double.compare(currentType.calculate(), calculate()) == 0;
    }
}
```

### Класс `MyProgram.CentripetalAcceleration`
(подкласс `MyProgram.PhysicalCalculation`)

Класс для работы с **Центростремительным ускорением**

- Содержит приватные неизменяемые поля `speed`(скорость) и `radius` (радиус) типа double;
- Переопределяет метод `calculate()` для вычисления центростремительного ускорения:
  $$ 𝑎 = v^2 / 𝑅 $$
- Переопределяет метод `toString()` для форматирования результата до тысячных.

```java
class MyProgram.CentripetalAcceleration extends MyProgram.PhysicalCalculation {
    private final double speed;
    private final double radius;

    public MyProgram.CentripetalAcceleration(double speed, double radius) {
        super(Math.pow(speed, 2) / radius);
        this.speed = speed;
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return Math.pow(speed, 2) / radius;
    }

    @Override
    public String toString() {
        return String.format("Центростремительное ускорение a = %.3f м/с^2", calculate());
    }
}
```

### Класс `MyProgram.CircularVelocity `
(подкласс `MyProgram.PhysicalCalculation`)

Класс для работы с **Круговой скоростью**

- Содержит приватные неизменяемые поля `radius` (радиус) и `period` (период) типа double;
- Переопределяет метод `calculate()` для вычисления круговой скорости:
  $$ V = 2𝝅R / T $$
- Переопределяет метод `toString()` для форматирования результата до тысячных.

```java
class MyProgram.CircularVelocity extends MyProgram.PhysicalCalculation {
    private final double radius;
    private final double period;

    public MyProgram.CircularVelocity(double radius, double period) {
        super((2 * Math.PI * radius) / period);
        this.radius = radius;
        this.period = period;
    }

    @Override
    public double calculate() {
        return (2 * Math.PI * radius) / period;
    }

    @Override
    public String toString() {
        return String.format("Круговая скорость V = %.3f м/с", calculate());
    }
}

```

# Программа для работы с разными типами машин


## Описание программы

### Класс `SecondProgramVariant.Car`

Этот класс является базовым и универсальным классом для всех типов машин

Он содержит следующие элементы:

- Приватные неизменяемые поля `makeBy` (производитель), `model` (модель) и `yearOfProduction` (год выпуска);
- Метод `carSound()` выводит сообщение о том, как машина едет;
- Переопределены методы `toString()` и `equals()` для корректного строкового представления и сравнения экземпляров класса.

### Класс `SecondProgramVariant.ElectricCar`

Класс для работы с электромобилями (подкласс SecondProgramVariant.Car)

Он содержит следующие элементы:

- Добавляет приватное неизменяемое поле `batteryCapacity` (емкость батареи);
- Метод `carSound()` переопределен и возвращает информацию о звуке машины;
- Переопределены методы `toString()` и `equals()`.

### Класс `SecondProgramVariant.GasolineCar`

Класс для работы с машинами с ДВС (подкласс SecondProgramVariant.Car)

Он содержит следующие элементы:

- Добавляет приватное неизменяемое поле `fuelTankCapacity` (объем бака);
- Метод `carSound()` переопределен и возвращает информацию о звуке машины;
- Переопределены методы `toString()` и `equals()`.

### Класс `SecondProgramVariant.SecondProgramVariant`

Основной класс для демонстрации работы классов

- Создает массив `SecondProgramVariant.Car[]`, который содержит экземпляры классов SecondProgramVariant.ElectricCar и SecondProgramVariant.GasolineCar;
- Выполняет цикл по массиву и вызывает метод `carSound()`;
- Проверяет эквивалентность объектов с помощью метода `equals()`.

