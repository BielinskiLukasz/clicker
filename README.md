# Clicker — JavaFX Idle Game  
![Status](https://img.shields.io/badge/status-finished-brightgreen)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-000000?style=for-the-badge)

A simple idle/clicker game built with **JavaFX** using an MVC‑style architecture.  
The player expands a software company by unlocking cities, opening rooms, and hiring programmers who generate income over time.

---

## 📌 Project Status

This project is **finished**.  
No further development is planned, but the code remains available for learning, reference, and experimentation.

---

## 🎮 Gameplay Overview

- Start from a single city and gradually expand your software empire.
- Unlock new **cities**, **rooms**, and **employees** as your income grows.
- Each employee generates passive income.
- Clicking on elements increases earnings and speeds up progression.
- Progression is visualized through multiple JavaFX screens (World → City → Room → Employee).

---

## 🧩 Game Structure

The game is organized into four main layers:

### **World**
- Top‑level view of the entire game world.
- Contains multiple cities.
- Entry point after the main menu.

### **City**
- Represents a single city containing multiple office rooms.
- Unlock rooms as you progress.

### **Room**
- Each room can contain multiple employees.
- Generates income based on assigned employees.

### **Employee**
- Programmers hired by the player.
- Each employee increases passive income.

---

## 🏗️ Architecture

The project follows a lightweight **MVC** structure:

```
src/main/java/menu
 ├── Menu.java                 # Main menu controller
 └── game
      ├── model
      │    ├── WorldModel.java
      │    ├── CityModel.java
      │    ├── RoomModel.java
      │    └── EmployeeModel.java
      └── view
           ├── World.java
           ├── City.java
           ├── Room.java
           └── Employee.java
```

### **Model**
Contains game logic and state:
- income generation  
- unlocking logic  
- employee/room/city data  

### **View**
JavaFX UI components:
- FXML layouts  
- CSS styling  
- UI controllers  

### **Resources**
```
src/main/resources/menu
 ├── menu.fxml
 ├── style.css
 └── game/view
      ├── world.fxml
      ├── city.fxml
      ├── room.fxml
      ├── employee.fxml
      └── gameStyle.css
```

---

## 🖥️ Technologies Used

- **Java 8+**
- **JavaFX**
- **FXML**
- **CSS**

---

## 🚀 Running the Game

This project does **not** use Maven or Gradle.  
It is a plain JavaFX project that you run directly from your IDE.

### Prerequisites
- Java 8 or higher  
- JavaFX SDK (if using Java 11+)  
- IntelliJ IDEA / Eclipse / VS Code with JavaFX support

### Running from IntelliJ IDEA (recommended)

1. Open the project in IntelliJ  
2. Go to **File → Project Structure → Libraries**  
3. Add your **JavaFX SDK** as a library  
4. Open **Run → Edit Configurations**  
5. Add VM options:

For JavaFX 11+:
```
--module-path "PATH_TO_FX/lib" --add-modules javafx.controls,javafx.fxml
```

6. Set **Main class** to:
```
Main
```

7. Click **Run**

### Running from command line (JavaFX 11+)

```
java --module-path "PATH_TO_FX/lib" --add-modules javafx.controls,javafx.fxml -cp src/main/java Main
```

Replace `PATH_TO_FX` with the path to your JavaFX SDK.

---

## 📦 Project Files

- `Main.java` — application entry point  
- `menu.fxml` — main menu layout  
- `world.fxml`, `city.fxml`, `room.fxml`, `employee.fxml` — game screens  
- `style.css`, `gameStyle.css` — UI styling  

---

## 🛠️ Planned Improvements

Although the project is finished, here are ideas that could be implemented in the future:

- Save/load game progress  
- Better balancing of income and upgrades  
- Animations and improved UI  
- Sound effects  
- More cities, rooms, and employee types  

---

## 📄 License

This project is licensed under the MIT License.
