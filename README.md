# 📦 Bosta | Android Assessment  

This project is a simple Android application designed to evaluate coding style and the implementation of design patterns. The app features a single screen that lists all cities and their respective districts by fetching data from a provided API endpoint.  

---

## 📸 Screenshots  

| **Cities List**                          | **Districts List**                        |  
|------------------------------------------|-------------------------------------------|  
| ![Cities List](https://drive.google.com/uc?export=view&id=11brugIuNI1bPjdsTSZTiFOTFGJuObDId) | ![Districts List](https://drive.google.com/uc?export=view&id=1IHuCDZKNCA1CwNkW-I6-UlVbPpgwe-qM) |  

---

## 🚀 Features  

- Display a list of cities and their districts dynamically.  
- Modularized project structure for better scalability and maintainability.  
- Onion Architecture for clean separation of concerns between layers.  
- Modern and clean UI with a smooth user experience.  

---

## 🔧 Technologies and Tools Used  

- **Kotlin**: The primary programming language for Android development.  
- **Onion Architecture**: Implements a clean and layered design to separate concerns effectively.  
- **Modules**: Divided into `Data`, `Domain`, and `App` layers for better organization.  
- **MVVM Architecture**: Ensures clear separation between UI and business logic.  
- **RecyclerView**: Efficiently displays the list of cities and districts.  
- **Retrofit 2**: Handles API communication and data fetching.  
- **Dagger 2**: Dependency injection for better code scalability and testability.  
- **Coroutines**: Ensures asynchronous operations and better performance.  

---

## 📊 Project Structure  

The project follows **Onion Architecture** principles and is modularized into three layers:  

1. **Data Module**:  
   - Contains API calls, data models, and repository implementations.  
   - Handles all data-related operations, including fetching from APIs or local databases.  

2. **Domain Module**:  
   - Defines core business logic and use cases.  
   - Acts as an abstraction layer between Data and App modules.  

3. **App Module**:  
   - Contains UI components, ViewModels, and application-level logic.  

### Directory Overview  

```plaintext
├── data
│   ├── api          # Retrofit interfaces and API calls
│   ├── models       # Data models for cities and districts
│   ├── repository   # Repository implementations
├── domain
│   ├── usecases     # Business logic and use case implementations
│   ├── entities     # Core entities shared across layers
├── app
│   ├── ui           # View components and RecyclerView adapters
│   ├── viewmodel    # ViewModel classes for UI interaction
│   ├── di           # Dagger modules for dependency injection
│   └── utils        # Utility classes (e.g., error handling, extensions)
```

---

## 🌐 API Details  

The app uses the following API endpoint to retrieve data:  
- **Cities Endpoint**: Fetches a list of cities along with their districts.  

---

## 🔖 How to Run  

1. Clone the repository:  
   ```bash
   git clone [https://github.com/mohamedibrahim3/Bosta.git]
   ```  

2. Open the project in **Android Studio**.  
3. Build and run the app on an emulator or a physical device.  
4. Explore the list of cities and their districts!  

---

## 🎯 Why Onion Architecture?  

Using Onion Architecture ensures that:  
- **Core business logic (Domain Layer)** is isolated from external dependencies.  
- **Loose coupling** between layers for easier testing and scalability.  
- Each layer has a single responsibility, adhering to SOLID principles.  

---

## 📂 Modules and Layers  

This modularized project consists of:  
- **App Module**: The presentation layer, handling the UI and user interactions.  
- **Domain Module**: Core business logic and abstractions.  
- **Data Module**: Manages data fetching and repository implementations.  

### High-Level Architecture Diagram  

```plaintext
        [ UI / App Module ]
                 |
          [ Domain Module ]
                 |
          [ Data Module ]
```

---
 
