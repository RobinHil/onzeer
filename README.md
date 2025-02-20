# 🎵 Music Album Manager (ONZEER)

A Java-based desktop application for managing your music album collection with a clean and modern dark interface.

## ✨ Features

- 📚 Complete album management system (Create, Read, Update, Delete)
- 🔍 Real-time search functionality across all album fields
- 📊 Advanced sorting options:
  - By ID (default)
  - By album name
  - By artist name
  - By genre
  - By release date
  - By rating
  - Ascending/Descending order
- 🎨 Modern dark theme using FlatLaf
- 🔄 Real-time database synchronization
- ⭐ Rating system (0-5 stars)
- 📝 Detailed album information tracking

## 🛠️ Technical Stack

- **Language**: Java
- **GUI Framework**: Swing with FlatLaf dark theme
- **Database**: MySQL
- **Architecture**: MVC Pattern
- **Build System**: Maven

## 🗃️ Database Structure

The application uses a MySQL database with three main tables:
- `Album`: Stores album information (ID, title, artist, release date, genre, rating)
- `artist`: Maintains unique artist entries
- `genre`: Maintains unique musical genre entries

## 📋 Requirements

- Java Runtime Environment (JRE) 8 or higher
- MySQL Server
- Maven for building (if compiling from source)

## 🚀 Installation

1. Clone the repository:
```bash
git clone https://github.com/RobinHil/onzeer.git
```

2. Configure the database connection in `Database.java`:
```java
database = new Database(
    "database_url", 
    "database_username",
    "database_password"
);
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Run the application:
```bash
java -jar target/onzeer.jar
```

## 💻 Usage

1. **Adding an Album**:
   - Click the "Ajouter" button
   - Fill in the required information:
     - Album title
     - Artist name
     - Musical genre
     - Release date (format: dd/MM/yyyy)
     - Rating (0-5)

2. **Modifying an Album**:
   - Select an album from the list
   - Update the information in the right panel
   - Click "Modifier" to save changes

3. **Deleting an Album**:
   - Select an album from the list
   - Click "Supprimer"

4. **Searching**:
   - Use the search bar to filter albums in real-time
   - Searches across all fields (title, artist, genre, date, rating)

5. **Sorting**:
   - Use the dropdown menu to select sort criteria
   - Toggle ascending/descending order with the checkbox

## 👥 Authors

- Simon MILLET
- Robin HILAIRE
