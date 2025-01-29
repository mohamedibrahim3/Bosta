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

